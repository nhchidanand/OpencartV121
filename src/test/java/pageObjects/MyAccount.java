package pageObjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import basePage.BasePage;

public class MyAccount extends BasePage{
	
	
	public MyAccount(WebDriver driver)
	{
		super(driver);
	}
	
	
	@FindBy(xpath="//h2[normalize-space()='My Account']")
	WebElement txtMyAccount;
	
	@FindBy(xpath="//a[@class='list-group-item'][normalize-space()='Logout']")
	WebElement lnkLogout;
	
	public boolean myAccount()
	{
		try 
		{
			return (txtMyAccount.isDisplayed());
		}
		catch(Exception e)
		{
			return false;
		}
	}
	
	
	public void LogoutLink()
	{
		lnkLogout.click();
	}
	
}
