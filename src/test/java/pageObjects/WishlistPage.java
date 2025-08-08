package pageObjects;
import org.openqa.selenium.WebDriver;
import basePage.BasePage;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.openqa.selenium.WebElement;

public class WishlistPage extends BasePage{
	
	public WishlistPage(WebDriver driver)
	{
		super(driver);
	}
	
	
	@FindBy(xpath="//body[1]/div[2]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[2]/a[1]")
	WebElement pName;
	
	public void productName(String product)
	{
		String product_name = pName.getText();
		Assert.assertEquals(product_name, product, "Product mismatch");
	}
}
