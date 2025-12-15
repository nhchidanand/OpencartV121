package pageObjects;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import basePage.BasePage;
import utilities.WaitUtility;

public class DeskTopsPage extends BasePage{
	
	public DeskTopsPage(WebDriver driver)
	{
		super(driver);
	}
	
	//Using web element
	@FindBy(xpath="//div[@class='product-thumb']//h4//a")
	private List<WebElement> products;
	
	//Using the By class
	By prdts = By.xpath("//div[@class='product-thumb']//h4//a");
	
	
	//Using web element
	public List<String> listOfProducts()
	{
		List<String> names = new ArrayList<>();
		for(WebElement product: products)
		{
			names.add(product.getText());
		}
		return names;
	}
	
	//Using locator
	public List<String> productsList()
	{
		List<String> names = new ArrayList<>();
		List<WebElement> products = WaitUtility.waitForElementsToBeVisible(driver, prdts);
		for(WebElement product: products)
		{
			names.add(product.getText());
		}
		return names;
	}
}