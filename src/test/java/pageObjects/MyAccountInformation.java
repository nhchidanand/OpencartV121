package pageObjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import basePage.BasePage;


public class MyAccountInformation extends BasePage{
	
	public MyAccountInformation(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(css="[name='firstname']")
	WebElement txtFirstName;
	
	@FindBy(css="[name='lastname']")
	WebElement txtLastName;
	
	@FindBy(css="[name='email']")
	WebElement txtEmail;
	
	@FindBy(css="[name='telephone']")
	WebElement txtPhone;
	
	@FindBy(css="[value='Continue']")
	WebElement btnContinue;
	
	
	public void FirstName(String firstname)
	{
		txtFirstName.clear();
		txtFirstName.sendKeys(firstname);
	}
	
	public void LastName(String lastmane)
	{
		txtLastName.clear();
		txtLastName.sendKeys(lastmane);
	}
	
	public void Email(String email)
	{
		txtEmail.clear();
		txtEmail.sendKeys(email);
	}
	
	public void PhoneNumber(String phone)
	{
		txtPhone.clear();
		txtPhone.sendKeys(phone);
	}
	
	public void Continue()
	{
		btnContinue.click();
	}
}
