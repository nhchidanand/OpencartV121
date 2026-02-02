package pageObjects;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import basePage.BasePage;
import utilities.WaitUtility;

public class MacProductsPage extends BasePage{
	
	public MacProductsPage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//div//h4//a")
	List<WebElement> macProducts;
	
	@FindBy(xpath="//h4//a[text()= 'iMac']")
	WebElement imac;
	
	By macproducts= By.xpath("//div//h4//a");
	
	public void clickOnIMac()
	{
		List<WebElement> products= WaitUtility.waitForElementsToBeVisible(driver, macproducts);
		for(WebElement product: products)
		{
			if(product.getText().equalsIgnoreCase("imac"))
			{
				product.click();
				break;
			}
		}
	}
	
	public void clickOnImac2()
	{
		imac.click();
	}
}
