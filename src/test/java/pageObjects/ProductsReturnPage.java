package pageObjects;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import basePage.BasePage;

public class ProductsReturnPage extends BasePage {

	public ProductsReturnPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(css = "[placeholder='First Name']")
	WebElement txtFirstName;

	@FindBy(css = "[placeholder='Last Name']")
	WebElement txtLastName;

	@FindBy(css = "[placeholder='E-Mail']")
	WebElement txtEmail;

	@FindBy(css = "[placeholder='Telephone']")
	WebElement txtPhone;

	@FindBy(css = "[placeholder='Order ID']")
	WebElement txtOrderid;

	@FindBy(css = "div[class='datepicker-days'] th[class='picker-switch']")
	WebElement month_year;

	@FindBy(css = "div[class='datepicker-months'] th[class='prev']")
	WebElement btnPrev;

	@FindBy(css = "div[class='datepicker-days'] th[class='next']")
	WebElement btnNext;

	@FindBy(xpath = "//td[@class='day']")
	List<WebElement> days;

	@FindBy(xpath="//input[@id='input-product']")
	WebElement txtProductName;
	
	@FindBy(xpath="//input[@id='input-model']")
	WebElement txtProductCode;
	
	@FindBy(xpath="//input[@id='input-quantity']")
	WebElement txtQuantity;
	
	@FindBy(xpath="//div[@class='col-sm-10']//div//input[@type='radio']")
	List<WebElement> rdBtnReasonsForReturn;
	
	@FindBy(xpath="//input[@value='0']")
	WebElement rdBtnProductOpened;
	
	@FindBy(xpath="//textarea[@id='input-comment']")
	WebElement txtOtherDetails;
	
	@FindBy(xpath="//input[@value='Submit']")
	WebElement btnSubmit;
	
	
	public void FirstName(String fname)
	{
		txtFirstName.clear();
		txtFirstName.sendKeys(fname);;
	}
	
	public void LastName(String lname)
	{
		txtLastName.clear();
		txtLastName.sendKeys(lname);
	}
	
	public void email(String email)
	{
		txtEmail.clear();
		txtEmail.sendKeys(email);
	}
	
	public void TelePhone(String phone)
	{
		txtPhone.clear();
		txtPhone.sendKeys(phone);
	}
	
	public void OrderID(String order_id)
	{
		txtOrderid.clear();
		txtOrderid.sendKeys(order_id);
	}
	
	public void SelectDate()
	{
		while(true)
		{
			if(month_year.getText().trim().equalsIgnoreCase("January 2025"))
			{
				break;
			}
			btnPrev.click();
		}
		
		for(WebElement day: days)
		{
			if(day.getText().trim().equalsIgnoreCase("30"))
			{
				day.click();
				break;
			}
		}
	}
	
	public void ProductName(String p_name)
	{
		txtProductName.clear();
		txtProductName.sendKeys(p_name);
	}
	
	public void ProductCode(String p_code)
	{
		txtProductCode.clear();
		txtProductCode.sendKeys(p_code);
	}
	
	public void reasonForReturns()
	{
		for(WebElement reason: rdBtnReasonsForReturn)
		{
			if(reason.getText().trim().equalsIgnoreCase("Order Error"))
			{
				reason.click();
			}
		}
	}
	
	public void productOpened()
	{
		rdBtnProductOpened.click();
	}
	
	public void faultyOrOtherDetails(String details)
	{
		btnSubmit.clear();
		btnSubmit.sendKeys(details);
	}
	
	public void submitButtom()
	{
		btnSubmit.click();
	}
}
