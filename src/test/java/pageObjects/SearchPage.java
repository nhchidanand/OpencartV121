package pageObjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebElement;
import basePage.BasePage;

public class SearchPage extends BasePage{
	
	public SearchPage(WebDriver driver)
	{
		super(driver);
	}

	
	@FindBy(xpath="//div[@class='caption']//a[contains(text(),'iPhone')]")
	WebElement clkIphone;
	
	public void clickIphone()
	{
		clkIphone.click();
	}
}
