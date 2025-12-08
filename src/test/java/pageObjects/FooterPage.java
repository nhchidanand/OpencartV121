package pageObjects;
import basePage.BasePage;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;

public class FooterPage extends BasePage{
	
	public FooterPage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//a[text()= 'Contact Us']")
	private WebElement lnkContactUs;
	
	public void Contact_Us()
	{
		lnkContactUs.click();
	}
}
