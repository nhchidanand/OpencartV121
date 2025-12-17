package utilities;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import testBase.BaseClass;

public class ExtentReportUtility implements ITestListener{
	
	public ExtentSparkReporter extentReport;
	public ExtentReports extent;
	public ExtentTest test;
	String repName;
	
	 public void onStart(ITestContext context) 
	 { 
		 String timeStamp =new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		 repName = "test-report-"+timeStamp+".html";
		 
		 extentReport = new ExtentSparkReporter(".\\reports\\"+repName);
		 extentReport.config().setDocumentTitle("OpenCart Automation Report");
		 extentReport.config().setReportName("OpenCart Functional Testing");
		 extentReport.config().setTheme(Theme.DARK);
		 
		 extent = new ExtentReports();
		 extent.attachReporter(extentReport);
		 extent.setSystemInfo("Application", "OpenCart");
		 extent.setSystemInfo("Module", "Admin");
		 extent.setSystemInfo("Sub Module", "Customers");
		 extent.setSystemInfo("User Name", System.getProperty("user.name"));
		 extent.setSystemInfo("Environment", "QA");
		 
		 String os = context.getCurrentXmlTest().getParameter("OS");
		 extent.setSystemInfo("OS", os);
		 
		 String browser = context.getCurrentXmlTest().getParameter("Browser");
		 extent.setSystemInfo("Browser", browser);
		 
		 List<String> includeGroup = context.getCurrentXmlTest().getIncludedGroups();
		 if(!includeGroup.isEmpty())
		 {
			 extent.setSystemInfo("Groups", includeGroup.toString());
		 }
	 }
	 
	 public void onTestSuccess(ITestResult result) 
	 {
		test = extent.createTest(result.getClass().getName()); 
		test.assignCategory(result.getMethod().getGroups());
		test.log(Status.PASS, result.getName() + "passed successfully");
	 }
	 
	 public void onTestFailure(ITestResult result) 
	 {
		test = extent.createTest(result.getClass().getName());
		test.assignCategory(result.getMethod().getGroups());
		test.log(Status.FAIL, result.getName()+"got failed");
		test.log(Status.INFO, result.getThrowable().getMessage());
		try
		{
			String imgPath = ScreenshotUtility.captureScreenshot(BaseClass.driver, result.getName());
			test.addScreenCaptureFromPath(imgPath);
			//ScreenshotUtility.captureScreenshot(BaseClass.driver, By.id("username"), result.getMethod().getMethodName());
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		/*
		try
		{
		String imgpath = new BaseClass().captureScreen(result.getName());
		test.addScreenCaptureFromPath(imgpath);
		}
		catch(Exception e1)
		{
			e1.printStackTrace();
		}
		*/
	 }
	 
	 public void onTestSkipped(ITestResult result) 
	 {
		test = extent.createTest(result.getClass().getName());
		test.assignCategory(result.getMethod().getGroups());
		test.log(Status.SKIP, result.getName()+ "got skipped");
		test.log(Status.INFO, result.getThrowable().getMessage());
	 }

	 public void onFinish(ITestContext context) 
	 {
		 extent.flush();
		 String pathOfTheExtentReport = System.getProperty("user.dir")+"\\reports\\"+repName;
		 File filePath = new File(pathOfTheExtentReport);
		 try {
			Desktop.getDesktop().browse(filePath.toURI());
		} catch (IOException e) {
			e.printStackTrace();
		}
		 		 
		 /*
		 try {
	         URL url = new URL("file://" + System.getProperty("user.dir") + "\\reports\\yourReportFile.html");

	            // Create the email message
	         ImageHtmlEmail email = new ImageHtmlEmail();
	         email.setDataSourceResolver(new org.apache.commons.mail.resolver.DataSourceUrlResolver(url));
	         email.setHostName("smtp.googlemail.com");
	         email.setSmtpPort(465);
	         email.setAuthenticator(new DefaultAuthenticator("pavanoltraining@gmail.com", "password"));
	         email.setSSLOnConnect(true);
	         email.setFrom("pavanoltraining@gmail.com"); // Sender
	         email.setSubject("Test Results");
	         email.setMsg("Please find Attached Report...");
	         email.addTo("pavankumar.busyqa@gmail.com"); // Receiver
	         email.attach(url, "extent report", "please check report...");
	         email.send(); // send the email
	        }
		 catch (Exception e) 
		 {
	         e.printStackTrace();
	     } 
		 */
	 }
}