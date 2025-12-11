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
	private WebElement clkIphone;
	
	@FindBy(xpath="//a[contains(text(), \"Modify your address\")]")
	private WebElement addressModify;
	
	@FindBy(xpath="//div[contains(text(), 'successfully')]")
	private WebElement addressSuccessfullmsg;
	
	@FindBy(xpath="//a[@class='list-group-item'][normalize-space()='Logout']")
	private WebElement clkLogout;
	
	@FindBy(xpath="//a[text()='Edit Account']")
	private WebElement editAccount;
	
	@FindBy(xpath="//div[text()='Success: Your account has been successfully updated.']")
	private WebElement accountUpdateSuccessfulmsg;
	
	@FindBy(xpath="//a[text()='Password']")
	private WebElement password;
	
	@FindBy(xpath="//div[text()='Success: Your password has been successfully updated.']")
	WebElement passwordChangeSuccessfulmsg;
	
	@FindBy(xpath="//a[@class='list-group-item'][normalize-space()='Newsletter']")
	WebElement newsLetter;
	
	@FindBy(xpath="//div[@class='list-group']//a[contains(text(), 'Order History')]")
	WebElement orderHistory;
	
	
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
	
	
	public void EditAccount()
	{
		editAccount.click();
	}
	
	
	public void Logout()
	{
		clkLogout.click();
	}
	
	public void AccountSuccessfullMessageCheck()
	{
		Assert.assertEquals(accountUpdateSuccessfulmsg.getText(), "Success: Your account has been successfully updated.");
	}
	
	public void ChangePassword()
	{
		password.click();
	}
	
	
	public void PasswordChangeSuccessfulMessage()
	{
		Assert.assertEquals(passwordChangeSuccessfulmsg.getText(), "Success: Your password has been successfully updated.");
	}
	
	
	public void clickNewsLetter()
	{
		newsLetter.click();
	}
	
	public void clickOrderHistory()
	{
		orderHistory.click();
	}
}
