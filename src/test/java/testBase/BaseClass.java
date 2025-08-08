package testBase;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {
	
public static WebDriver driver;
public Logger logger;
public Properties property;
	
	@BeforeClass(groups={"Sanity", "Regression", "Master", "DataProvider"})
	@Parameters ({"OS", "Browser"})
	public void setUp(String os, String br) throws IOException
	{	
		logger = LogManager.getLogger(this.getClass());
		
		property = new Properties();
		FileInputStream file = new FileInputStream("./src//test//resources//config.properties");
		property.load(file);
		
		//Running on remote machine
		DesiredCapabilities capability = new DesiredCapabilities();
		//Operating system
		if(property.getProperty("execution_env").equalsIgnoreCase("remote"))
		{
			if(os.equalsIgnoreCase("Windows"))
			{
				capability.setPlatform(Platform.WIN11);
			}
			else if(os.equalsIgnoreCase("Mac"))
			{
				capability.setPlatform(Platform.MAC);
			}
			else if(os.equalsIgnoreCase("Linux"))
			{
				capability.setPlatform(Platform.LINUX);
			}
			else
			{
				System.out.println("Operating System not found");
				return;
			}
			
			//browser
			switch(br.toLowerCase())
			{
			case "chrome": capability.setBrowserName("chrome"); break;
			case "edge": capability.setBrowserName("MicrosoftEdge"); break;
			case "firefox": capability.setBrowserName("FireFox"); break;
			default: System.out.println("Browser not found"); return;
			}
			
			driver = new RemoteWebDriver(new URL("http://192.168.43.237:4444/wd/hub/"), capability);
		}
		
		
		//Running on local machine
		if(property.getProperty("execution_env").equalsIgnoreCase("local"))
		{
			switch(br.toLowerCase())
			{
			case "chrome": driver = new ChromeDriver(); break;
			case "edge": driver = new EdgeDriver(); break;
			case "firefox": driver = new FirefoxDriver(); break;
			default: System.out.println("Invalid browser:"); return;
			}
		}
		
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get(property.getProperty("pageURL"));
		
		driver.manage().window().maximize();
	}
	
	
	@AfterClass(groups = {"Sanity", "Regression", "Master", "DataProvider"})
	public void tearDown()
	{
		driver.quit();
	}
	
	
	
	public String randomStringValue_1()
	{
		return (RandomStringUtils.randomAlphabetic(5));
	}
	
	public String randomStringValue_2()
	{
		return (RandomStringUtils.randomAlphabetic(2));
	}
	
	public String randomNumeric()
	{
		return (RandomStringUtils.randomNumeric(10));
	}
	
	public String randomAlphaNumeric()
	{
		return (RandomStringUtils.randomAlphanumeric(8));
	}
	
	
	public String captureScreen(String tname)
	{
		String timeStamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
		TakesScreenshot ts = (TakesScreenshot) driver;
		File sourceFile = ts.getScreenshotAs(OutputType.FILE);
		String targetFilePath = System.getProperty("user.dir")+"\\screenshots\\"+tname+"_"+timeStamp+".png";
		File targetFile = new File(targetFilePath);
		sourceFile.renameTo(targetFile);
		return targetFilePath;
	}
}
