package pageObjects;
import basePage.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.openqa.selenium.WebElement;

public class AddToCartPage extends BasePage{
	
	public AddToCartPage(WebDriver driver)
	{
		super(driver);
	}
	
	
	@FindBy(xpath="//button[@id='button-cart']")
	WebElement addCart;
	
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
	WebElement successMsg;
	
	@FindBy(xpath="//button[@class='btn btn-inverse btn-block btn-lg dropdown-toggle']")
	WebElement clkItem;
	
	@FindBy(xpath="//strong[normalize-space()='View Cart']")
	WebElement clkViewCart;
	
	@FindBy(xpath="//button[@type='button']//i[@class='fa fa-heart']")
	WebElement addWishList;
	
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']//a[contains(text(),'iPhone')]")
	WebElement successMsgWL;
	
	
	public void addToCart()
	{
		addCart.click();
	}
	
	
	public void successMessage()
	{
		String txt = successMsg.getText();
		if(txt.contains("Success: You have added "))
		{
			Assert.assertTrue(true);
		}
		else
		{
			
			Assert.assertTrue(false);
		}
	}
	
	
	public void clickItem()
	{
		clkItem.click();
	}
	
	
	public void clickViewCart()
	{
		clkViewCart.click();
	}
	
	
	public void addToWishList()
	{
		addWishList.click();
	}
	
	public String successOfWishLisMessage()
	{
		String msg_wishlist = successMsgWL.getText().trim();
		Assert.assertEquals(msg_wishlist, "iPhone", "Product did not add to wishlist");
		return msg_wishlist;
	}
}
