package pageObjects;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import basePage.BasePage;

public class DeskTopsPage extends BasePage{
	
	public DeskTopsPage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//div[@class='product-thumb']//h4//a")
	private List<WebElement> products;
	
	public List<String> listOfProducts()
	{
		List<String> names = new ArrayList<>();
		for(WebElement product: products)
		{
			names.add(product.getText());
		}
		return names;
	}
}
