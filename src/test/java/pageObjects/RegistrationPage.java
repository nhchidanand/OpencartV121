package pageObjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import basePage.BasePage;

public class RegistrationPage extends BasePage{
	
	public RegistrationPage(WebDriver driver)
	{
		super(driver);
	}
	
	
	@FindBy(xpath="//input[@id='input-firstname']")
	WebElement txtFirstName;
	
	@FindBy(xpath="//input[@id='input-lastname']")
	WebElement txtLastName;
	
	@FindBy(xpath="//input[@id='input-email']")
	WebElement txtEmail;
	
	@FindBy(xpath="//input[@id='input-telephone']")
	WebElement txtPhone;
	
	@FindBy(xpath="//input[@id='input-password']")
	WebElement txtPass;
	
	@FindBy(xpath="//input[@id='input-confirm']")
	WebElement txtPassCnf;
	
	@FindBy(xpath="//label[normalize-space()='Yes']")
	WebElement rbtnYes;
	
	@FindBy(xpath="//input[@name='agree']")
	WebElement chkbxkPolicy;
	
	@FindBy(xpath="//input[@value='Continue']")
	WebElement btnConfirm;
	
	@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement msgConfirmation;
	
	
	
	public void firstName(String FName)
	{
		txtFirstName.sendKeys(FName);
	}
	
	
	public void lastName(String LName)
	{
		txtLastName.sendKeys(LName);
	}
	
	
	
	public void email(String email)
	{
		txtEmail.sendKeys(email);
	}
	
	
	
	public void phoneNo(String p_no)
	{
		txtPhone.sendKeys(p_no);
	}
	
	
	
	public void pass(String pass)
	{
		txtPass.sendKeys(pass);
	}
	
	
	
	public void cnfPass(String cnf_pass)
	{
		txtPassCnf.sendKeys(cnf_pass);
	}
	
	
	
	
	public void rdbYes()
	{
		rbtnYes.click();
	}
	
	public void checkbPolicy()
	{
		chkbxkPolicy.click();
	}
	
	
	
	
	public void btnConfirm()
	{
		btnConfirm.click();
	}
	
	
	
	
	public String confirmationMessage()
	{
		try
		{
			 return (msgConfirmation.getText());
		}
		catch (Exception e)
		{
			return (e.getMessage());
		}
	}
	
}
