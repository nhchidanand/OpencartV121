package testCases;
import testBase.BaseClass;
import utilities.DataProviders;
import pageObjects.*;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_003_LoginDDT extends BaseClass{
	
	@Test(dataProvider="loginData", dataProviderClass = DataProviders.class, groups = "DataProvider")
	public void Login_validation(String email, String password, String validation)
	{
		
		logger.info("***Start of the login validation test***");
		
		try
		{
		logger.info("**invoking home page**");
		HomePage hm = new HomePage(driver);
		hm.clickMyaccount();
		hm.clickLogin();
		
		logger.info("**invoking login page**");
		LoginPage lp = new LoginPage(driver);
		lp.setEmail(email);
		lp.setPassword(password);
		lp.clickLogin();
		
		logger.info("**invoking my accont page**");
		MyAccount myacc = new MyAccount(driver);
		boolean targetPage = myacc.myAccount();
		
		
		/*Valid 1) data is valid, login is pass then test pass
				2) data is valid, login fail then test fail
		
		Invalid 1) data is invalid, login is fail then test pass
				2) data is invalid, login is pass then test fails
		
		
		*/
		
		if(validation.equalsIgnoreCase("valid"))
		{
			if(targetPage==true)
			{
				myacc.LogoutLink();
				Assert.assertTrue(true);
			}
			else
			{
				Assert.assertTrue(false);
			}
		}
		
		if(validation.equalsIgnoreCase("invalid"))
		{
			if(targetPage==true)
			{
				myacc.LogoutLink();
				Assert.assertTrue(false);
			}
			else
			{
				Assert.assertTrue(true);
			}
		}
		}
		catch(Exception e)
		{
			Assert.fail();
		}
		finally
		{
		logger.info("***end of the login validation test***");
		}
	}
	
}
