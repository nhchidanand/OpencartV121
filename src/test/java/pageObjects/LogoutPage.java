package pageObjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import basePage.BasePage;

import org.openqa.selenium.WebElement;

public class LogoutPage extends BasePage{

	public LogoutPage(WebDriver driver)
	{
		super(driver);
	}
	
	
	
	@FindBy(xpath="//span[normalize-space()='My Account']")
	WebElement lnk_MyAccont;
	
	@FindBy(xpath="//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Logout']")
	WebElement lnk_logout_header;
	
	@FindBy(xpath="//a[@class='list-group-item'][normalize-space()='Logout']")
	WebElement lnk_logout_list;
	
	@FindBy(xpath="//input[@name='search']")
	WebElement ipSearch;
	
	@FindBy(xpath="//button[contains(@class, 'btn btn-default btn')]")
	WebElement clkSearch;
	
	
	public void myAccount_link()
	{
		lnk_MyAccont.click();
	}
	
	public void logout_header()
	{
		lnk_logout_header.click();
	}
	
	
	public void logout_list()
	{
		lnk_logout_list.click();
	}
	
	public void inputSearch(String phone)
	{
		ipSearch.sendKeys(phone);
	}
	
	public void clickSearch()
	{
		clkSearch.click();
	}
	
}
