package pageObjects;
import basePage.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebElement;

public class ContactFormPage extends BasePage{
	
	public ContactFormPage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//input[@id='input-name']")
	WebElement txtName;
	
	@FindBy(xpath="//input[@id='input-email']")
	WebElement txtEmail;
	
	@FindBy(xpath="//textarea[@id='input-enquiry']")
	WebElement txtEnquiry;
	
	@FindBy(xpath="//input[@value='Submit']")
	WebElement btnSubmit;
	
	@FindBy(xpath="//div[contains(text(), 'Enquiry')]")
	WebElement errorMessage;
	
	public void InputName(String name)
	{
		txtName.clear();
		txtName.sendKeys(name);
	}
	
	public void InputEmail(String email)
	{
		txtEmail.clear();
		txtEmail.sendKeys(email);
	}
	
	public void InputEnquiry(String enquiry_msg)
	{
		txtEnquiry.sendKeys(enquiry_msg);
	}
	
	public String EnquiryErrorMessage()
	{
		return errorMessage.getText();
	}
	
	public void ButtonSubmit()
	{
		btnSubmit.click();
	}
}
