package utilities;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
public class ScreenshotUtility {
	
	private static String getTimeStamp()
	{
		return new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
	}
	
	public static String captureScreenshot(WebDriver driver, String testName) throws IOException
	{
		//String timeStamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
		TakesScreenshot ts = (TakesScreenshot) driver;
		File sourceFile = ts.getScreenshotAs(OutputType.FILE);
		String targetFilePath = System.getProperty("user.dir")+"\\screenshots\\"+testName+"_"+getTimeStamp()+".png";
		File destinationFile = new File(targetFilePath);
		FileUtils.copyFile(sourceFile, destinationFile);
		return targetFilePath;
	}
	
	public static String captureScreenshot(WebDriver driver, By locator, String testName) throws IOException
	{
		WebElement element = driver.findElement(locator);
		File sourceFile = element.getScreenshotAs(OutputType.FILE);
		String targetFilePath = System.getProperty("user.dir")+"\\screenshots\\"+testName+"_"+getTimeStamp()+".png";
		File destinationFile = new File(targetFilePath);
		FileUtils.copyFile(sourceFile, destinationFile);
		return targetFilePath;
	}
}
