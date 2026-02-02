package testCases;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.*;
import testBase.BaseClass;

public class TC_021_MacTest extends BaseClass{
	
	@Test
	public void macProduct()
	{
		try
		{
			logger.info("*Start of the test*");
			logger.info("**Calling home page**");
			HomePage hp= new HomePage(driver);
			hp.clickMyaccount();
			hp.clickLogin();
			logger.info("**Calling the login page**");
			LoginPage lp= new LoginPage(driver);
			logger.info("**Calling the database connection page**");
			HashMap<String, String> data= DataBaseConnection();
			lp.setEmail(data.get("email"));
			lp.setPassword(data.get("password"));
			lp.clickLogin();
			logger.info("**calling the search page**");
			SearchPage sp= new SearchPage(driver);
			logger.info("**Calling the product data method**");
			HashMap<String, String> pData= productDataBaseData();
			sp.searchProduct(pData.get("productName"));
			sp.clickSearchButton();
			logger.info("**calling mac products page**");
			MacProductsPage mpp= new MacProductsPage(driver);
			//mpp.clickOnIMac();
			mpp.clickOnIMac();
			logger.info("**Calling add to cart page**");
			AddToCartPage atcp= new AddToCartPage(driver);
			atcp.addToCart();
			atcp.successMessage();
			atcp.clickItem();
			atcp.clickViewCart();
			logger.info("**Calling view cart page**");
			ViewCartPage vcp= new ViewCartPage(driver);
			Assert.assertEquals(vcp.cartProductNameVerify(), "iMac", "Product name mismatch!");
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
}
