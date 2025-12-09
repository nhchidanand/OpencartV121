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
	
	@FindBy(xpath="//i[@class='fa fa-calendar']")
	WebElement btnCalendar;

	@FindBy(xpath="//div[@class='datepicker-days']//th[@class='picker-switch']")
	WebElement btnMonth_Year;
	
	@FindBy(xpath="//div[@class='datepicker-months']//th[@class='picker-switch']")
	WebElement btnYear;
	
	@FindBy(xpath="//span[@class='year']")
	List<WebElement> yearSelect;
	
	@FindBy(xpath="//div[@class='datepicker-years']//th[@class='prev'][contains(text(),'‹')]")
	WebElement btnPrev;
	
	@FindBy(css = "div[class='datepicker-days'] th[class='next']")
	WebElement btnNext;
	
	@FindBy(xpath="//span[@class='month']")
	List<WebElement> monthSelect;
	
	@FindBy(xpath = "//td[@class='day']")
	List<WebElement> days;

	@FindBy(xpath="//input[@id='input-product']")
	WebElement txtProductName;
	
	@FindBy(xpath="//input[@id='input-model']")
	WebElement txtProductCode;
	
	@FindBy(xpath="//input[@id='input-quantity']")
	WebElement txtQuantity;
	
	@FindBy(xpath="//div[@class='radio']//label")
	List<WebElement> rdBtnReasonsForReturn;
	
	@FindBy(xpath="//input[@value='0']")
	WebElement rdBtnProductOpened;
	
	@FindBy(xpath="//textarea[@id='input-comment']")
	WebElement txtOtherDetails;
	
	@FindBy(xpath="//input[@value='Submit']")
	WebElement btnSubmit;
	
	@FindBy(xpath="//p[contains(text(), 'Thank you for submitting your return request')]")
	WebElement responseMessage;
	
	
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
	
	public void calendarButton()
	{
		btnCalendar.click();
	}
	
	public void buttonMonthAndYear()
	{
		btnMonth_Year.click();
	}
	
	public void buttonYear()
	{
		btnYear.click();
	}
	
	public void selectDesiredYear()
	{
		while(true)
		{
			for(WebElement year: yearSelect)
			{
				if(year.getText().trim().equalsIgnoreCase("2022"))
				{
					year.click();
					return;
				}
			}
			btnPrev.click();
		}
	}
	
	public void selectDesiredmonth()
	{
		for(WebElement month: monthSelect)
		{
			if(month.getText().trim().equalsIgnoreCase("Feb"))
			{
				month.click();
				break;
			}
		}
	}
	
	public void selectDesiredDay()
	{
		for(WebElement day: days)
		{
			if(day.getText().trim().equalsIgnoreCase("15"))
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
	
	public void productQuanity(String qty)
	{
		txtQuantity.clear();
		txtQuantity.sendKeys(qty);
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
		txtOtherDetails.clear();
		txtOtherDetails.sendKeys(details);
	}
	
	public void submitButtom()
	{
		btnSubmit.click();
	}
	
	public String returnResponseMessage()
	{
		return responseMessage.getText();
	}
}
