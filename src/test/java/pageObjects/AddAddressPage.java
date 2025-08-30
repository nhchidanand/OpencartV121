package pageObjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import basePage.BasePage;

public class AddAddressPage extends BasePage{
	
	 public AddAddressPage(WebDriver driver)
	{
		super(driver);
	}
	
	
	@FindBy(css="input#input-firstname")
	WebElement txtFirstName;
	
	@FindBy(css="input#input-lastname")
	WebElement txtLastName;
	
	@FindBy(css="input#input-company")
	WebElement txtCompany;
	
	@FindBy(css="input#input-address-1")
	WebElement txtAddress1;
	
	@FindBy(css="input#input-address-2")
	WebElement txtAddress2;
	
	@FindBy(css="input#input-city")
	WebElement txtCity;
	
	@FindBy(css="input#input-postcode")
	WebElement txtPostCode;
	
	@FindBy(css="[name=\"country_id\"]")
	WebElement dropdownCountry;
	Select sc = new Select(dropdownCountry);
	
	@FindBy(css="[name=\"zone_id\"]")
	WebElement dropdownState;
	Select sc1=new Select(dropdownState);
	
	@FindBy(xpath="//input[@value='0']")
	WebElement YesorNo;
	
	@FindBy(css="[value=\"Continue\"]")
	WebElement btnContinue;
	
	
	
	public void FirstName(String FName)
	{
		txtFirstName.sendKeys(FName);
	}
	
	public void LastName(String LName)
	{
		txtLastName.sendKeys(LName);
	}
	
	public void Company(String company)
	{
		txtCompany.sendKeys(company);
	}
	
	public void AddressLine1(String address1)
	{
		txtAddress1.sendKeys(address1);
	}
	
	public void AddressLine2(String address2)
	{
		txtAddress2.sendKeys(address2);
	}
	
	public void City(String city)
	{
		txtCity.sendKeys(city);
	}
	
	public void PostCode(String postcode)
	{
		txtPostCode.sendKeys(postcode);
	}
	
	public void selectCountry(String country_name)
	{
		sc.selectByVisibleText(country_name);
	}
	
	public void selectState(String state_name)
	{
		sc1.selectByVisibleText(state_name);
	}
	
	public void Yes_No()
	{
		YesorNo.click();
	}
	
	public void ContinueButton()
	{
		btnContinue.click();
	}
	
}
