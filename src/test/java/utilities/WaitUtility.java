package utilities;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtility {
	
	private static final int DEFAULT_TIMEOUT = 10;
	
	private static WebDriverWait getWait(WebDriver driver)
	{
		return new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_TIMEOUT));
	}
	
	public static WebElement waitForElementToBeClickable(WebDriver driver, By locator)
	{
		return getWait(driver).until(ExpectedConditions.elementToBeClickable(locator));
	}
	
	public static WebElement waitForElementToBeClickable(WebDriver driver, WebElement element)
	{
		return getWait(driver).until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public static WebElement waitForElementToBeVisible(WebDriver driver, By locator)
	{
		return getWait(driver).until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	
	public static Boolean waitForElementToBeInvisible(WebDriver driver, By locator)
	{
		return getWait(driver).until(ExpectedConditions.invisibilityOfElementLocated(locator));
	}
	
	public static WebElement waitForPresenceOfElement(WebDriver driver, By locator)
	{
		return getWait(driver).until(ExpectedConditions.presenceOfElementLocated(locator));
	}
	
	public static List<WebElement> waitForElementsToBeVisible(WebDriver driver, By locator)
	{
		return getWait(driver).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
	}
	
	public static Boolean waitForElementsToBeInvisible(WebDriver driver, WebElement element)
	{
		return getWait(driver).until(ExpectedConditions.invisibilityOfAllElements(element));
	}
}