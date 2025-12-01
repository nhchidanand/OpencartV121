package pageObjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import basePage.BasePage;

public class ChangePasswordPage extends BasePage{
	
	public ChangePasswordPage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(css="[name='password']")
	private WebElement txtPassword;
	
	@FindBy(css="[placeholder='Password Confirm']")
	private WebElement txtCnfPassword;
	
	@FindBy(css="[value='Continue']")
	private WebElement btnContinue;
	
	
	public void Password(String pass)
	{
		txtPassword.sendKeys(pass);
	}
	
	public void ConfirmPassword(String cnf_pass)
	{
		txtCnfPassword.sendKeys(cnf_pass);
	}
	
	public void Continue()
	{
		btnContinue.click();
	}
}
