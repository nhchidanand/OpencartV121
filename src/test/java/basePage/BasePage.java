package basePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.WaitUtility;

public class BasePage {
	
	public WebDriver driver;
	public BasePage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//span[normalize-space()='Wish List (1)']")
	WebElement lnkWishList;
	
	public void clickWishList()
	{
		lnkWishList.click();
	}
	
	//Method to perform click action
	protected void click(By locator)
	{
		WebElement element= WaitUtility.waitForElementToBeVisible(driver, locator);
		element.click();
	}
	
	//Method to type into input field
	protected void type(By locator, String input)
	{
		WebElement element= WaitUtility.waitForElementToBeVisible(driver, locator);
		element.clear();
		element.click();
		element.sendKeys(input);
	}
	
	//Method to get text
	protected String getText(By locator)
	{
		WebElement element= WaitUtility.waitForElementToBeVisible(driver, locator);
		return element.getText();
	}
}