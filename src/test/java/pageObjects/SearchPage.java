package pageObjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.openqa.selenium.WebElement;
import basePage.BasePage;

public class SearchPage extends BasePage{
	
	public SearchPage(WebDriver driver)
	{
		super(driver);
	}

	
	@FindBy(xpath="//div[@class='caption']//a[contains(text(),'iPhone')]")
	WebElement clkIphone;
	
	@FindBy(xpath="//a[contains(text(), \"Modify your address\")]")
	WebElement addressModify;
	
	@FindBy(xpath="//div[contains(text(), 'successfully')]")
	WebElement addressSuccessfullmsg;
	
	@FindBy(xpath="//a[@class='list-group-item'][normalize-space()='Logout']")
	WebElement clkLogout;
	
	
	public void clickIphone()
	{
		clkIphone.click();
	}
	
	public void clickAddreddModify()
	{
		addressModify.click();
	}
	
	public void AddressSuccessfullMessageCheck()
	{
		Assert.assertEquals(addressSuccessfullmsg.getText(), "Your address has been successfully added", "Address updated successfully");
	}
	
	public void Logout()
	{
		clkLogout.click();
	}
}
