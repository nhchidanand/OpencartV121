package testCases;
import testBase.BaseClass;
import org.testng.annotations.*;

import org.testng.Assert;

import pageObjects.*;
public class TC_017_OrderHistory extends BaseClass{

	@Test
	public void orderHistoryCheck()
	{
		logger.info("***Start of the order history check test***");
		try
		{
			logger.info("**Calling the home page**");
			HomePage hm = new HomePage(driver);
			hm.clickMyaccount();
			hm.clickLogin();
			
			logger.info("**calling the login page**");
			LoginPage lp = new LoginPage(driver);
			lp.setEmail(property.getProperty("email"));
			lp.setPassword(property.getProperty("password"));
			lp.clickLogin();
			
			logger.info("**Calling the search page**");
			SearchPage sp = new SearchPage(driver);
			sp.clickOrderHistory();
			
			logger.info("**Calling the order history page**");
			OrderHistoryPage ohp = new OrderHistoryPage(driver);
			Assert.assertTrue(ohp.orderHistory().toLowerCase().contains("not made"), "Proper messaging is not present!");
			ohp.clickContinueButton();

		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
}