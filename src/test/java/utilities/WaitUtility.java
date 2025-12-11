package utilities;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtility {
	
	public WebElement waitForElementToBeClickable(WebDriver driver, By locator)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		return wait.until(ExpectedConditions.elementToBeClickable(locator));
	}
	
	public WebElement waitForelementTobeVisible(WebDriver driver, By locator)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement s = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		return s;
	}
}
