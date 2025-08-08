package pageObjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import basePage.BasePage;

public class LoginPage extends BasePage{

	
	public LoginPage(WebDriver driver)
	{
		super(driver);
	}
	
	
	@FindBy(xpath="//input[@id='input-email']")
	WebElement txtEmail;
	
	@FindBy(xpath="//input[@id='input-password']")
	WebElement txtEmPass;
	
	@FindBy(xpath="//input[@value='Login']")
	WebElement btnLogin;
	
	
	public void setEmail(String mailID)
	{
		txtEmail.sendKeys(mailID);
	}
	
	public void setPassword(String password)
	{
		txtEmPass.sendKeys(password);
	}
	
	public void clickLogin()
	{
		btnLogin.click();
	}
	
}
