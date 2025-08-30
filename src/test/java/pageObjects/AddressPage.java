package pageObjects;
import basePage.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebElement;

public class AddressPage extends BasePage{
	
	public AddressPage(WebDriver driver)
	{
		super(driver);
	}
	

	@FindBy(xpath="div.buttons.clearfix > div.pull-right")
	WebElement btnNewAddress;
	
	
	public void newAddressButton()
	{
		btnNewAddress.click();
	}
}
