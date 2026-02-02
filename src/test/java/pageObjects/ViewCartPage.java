package pageObjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import basePage.BasePage;

public class ViewCartPage extends BasePage{
	
	public ViewCartPage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//div[@class='table-responsive']//tbody//tr[1]//td[2]/a")
	WebElement cartProduct;
	
	@FindBy(xpath="//input[@id='input-coupon']")
	WebElement couponText;
	
	@FindBy(xpath="//a[text()= 'Use Coupon Code ']//i")
	WebElement couponCode;
	
	////need to add the select locator and create method for the same
	
	@FindBy(xpath="//a[text()= 'Estimate Shipping & Taxes ']//i")
	WebElement shippingAndTaxes;
	
	@FindBy(xpath="//a[text()= 'Use Gift Certificate ']//i")
	WebElement giftCertificate;
	
	
	public String cartProductNameVerify()
	{
		return cartProduct.getText();
	}
	
	public void enterCouponText(String coupon)
	{
		couponText.sendKeys(coupon);
	}
	
	public void useCouponCode()
	{
		couponCode.click();
	}
	
	public void estimateShippingAndTaxes()
	{
		shippingAndTaxes.click();
	}
	
	public void useGiftCertificate()
	{
		giftCertificate.click();
	}
}
