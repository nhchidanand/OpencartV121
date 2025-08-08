package testCases;
import testBase.BaseClass;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.*;

public class TC_005_SearchIphoneTest extends BaseClass{
	
	@Test(groups= {"Master", "Regression"})
	public void SearchIphone()
	{
		try 
		{
		logger.info("*****Start of test*****");
		
		logger.info("**invoke of home page**");
		HomePage hm = new HomePage(driver);
		hm.clickMyaccount();
		hm.clickLogin();
		
		logger.info("**invoke of login age**");
		LoginPage lp = new LoginPage(driver);
		lp.setEmail(property.getProperty("email"));
		lp.setPassword(property.getProperty("password"));
		lp.clickLogin();
		
		logger.info("**invoke of logout page where it has search elements**");
		LogoutPage lgo = new LogoutPage(driver);
		lgo.inputSearch(property.getProperty("searchProductName"));
		lgo.clickSearch();
		
		logger.info("**invoke of search page**");
		SearchPage sp = new SearchPage(driver);
		sp.clickIphone();
		
		logger.info("**invoke of add to cart page**");
		AddToCartPage atc = new AddToCartPage(driver);
		atc.addToCart();
		atc.clickItem();
		atc.clickViewCart();
		
		logger.info("**invoke of checkout page**");
		CheckOutPage cop = new CheckOutPage(driver);
		cop.buttonCheckOut();
		cop.failedMessage();
		}
		
		catch(Exception e)
		{
			e.getMessage();
			Assert.fail();
		}
		
		logger.info("****End of test****");
		
	}
}