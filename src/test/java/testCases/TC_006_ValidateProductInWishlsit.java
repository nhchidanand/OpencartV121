package testCases;
import testBase.BaseClass;
import pageObjects.*;

import org.testng.Assert;
import org.testng.annotations.Test;

import basePage.BasePage;

public class TC_006_ValidateProductInWishlsit extends BaseClass{
	
	@Test(groups= {"Regression", "Master"})
	public void wishListValidation()
	{
		try {
		logger.info("**Start of the test**");
		
		logger.info("*Invoke of homepage*");
		HomePage hm = new HomePage(driver);
		hm.clickMyaccount();
		hm.clickLogin();
		
		logger.info("*Invoke of login page*");
		LoginPage lp = new LoginPage(driver);
		lp.setEmail(property.getProperty("email"));
		lp.setPassword(property.getProperty("password"));
		lp.clickLogin();
		
		logger.info("invoke of logout page where it has element for entering for the search");
		LogoutPage lgp = new LogoutPage(driver);
		lgp.inputSearch(property.getProperty("searchProductName"));
		lgp.clickSearch();
		
		logger.info("*Invoke of searchpage*");
		SearchPage sp = new SearchPage(driver);
		sp.clickIphone();
		
		logger.info("*Invoke of Add to cart page*");
		AddToCartPage atp = new AddToCartPage(driver);
		atp.addToWishList();
		String success_message = atp.successOfWishLisMessage();
		
		logger.info("*calling the method which is present inside the base page*");
		BasePage bp = new BasePage(driver);
		bp.clickWishList();
		
		logger.info("*Invoke of wish list page*");
		WishlistPage wlp = new WishlistPage(driver);
		wlp.productName(success_message);
		}
		catch(Exception e)
		{
			e.getMessage();
			Assert.fail();
		}
	}
}
