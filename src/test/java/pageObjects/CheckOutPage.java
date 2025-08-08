package pageObjects;
import basePage.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.openqa.selenium.WebElement;

public class CheckOutPage extends BasePage{
	
	public CheckOutPage(WebDriver driver)
	{
		super(driver);
	}
	
	
	@FindBy(xpath="//a[@class='btn btn-primary']")
	WebElement btncheckOut;
	
	@FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']")
	WebElement failMsg;
	
	
	public void buttonCheckOut()
	{
		btncheckOut.click();
	}
	
	
	public void failedMessage()
	{
		String fail_msg = failMsg.getText();
		if(fail_msg.contains("Products marked with *** are not available in the desired quantity or not in stock!"))
		{
			Assert.assertTrue(true);
		}
		else
		{
			Assert.assertTrue(false);
		}
	}
}
