package testCases;
import testBase.BaseClass;
import org.testng.annotations.Test;
import pageObjects.*;
import org.testng.Assert;

public class TC_002_LoginTest extends BaseClass {
	
	@Test(groups = {"Regression", "Master"})
	public void Login_test() 
	{
		logger.info("*** Start of the Login test ***");
		
		logger.info("**Navigating to home page**");
		HomePage hm = new HomePage(driver);
		
		logger.info("**Clicking on my account link**");
		hm.clickMyaccount();
		
		logger.info("**Clicking on my login link**");
		hm.clickLogin();
		
		
		logger.info("**Navigating to email login page**");
		LoginPage login = new LoginPage(driver);
		
		login.setEmail(property.getProperty("email"));
		login.setPassword(property.getProperty("password"));
		login.clickLogin();
		
		
		logger.info("**Navigating to My Account page**");
		MyAccount myacc = new MyAccount(driver);
		Assert.assertTrue(myacc.myAccount());
		
		//Assert.assertEquals(true, myacc.myAccount(), "Email login failed!");
		
	}
}
