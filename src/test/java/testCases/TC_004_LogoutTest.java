package testCases;
import testBase.BaseClass;
import org.testng.annotations.Test;
import pageObjects.*;

public class TC_004_LogoutTest extends BaseClass{
	
	
	@Test
	public void logoutTest()
	{
		logger.info("Srart of the test!");
		try
		{
		
		logger.info("Calling home page");	
		HomePage hm = new HomePage(driver);
		hm.clickMyaccount();
		hm.clickLogin();
		
		logger.info("calling login page");
		LoginPage lp = new LoginPage(driver);
		lp.setEmail(property.getProperty("email"));
		lp.setPassword(property.getProperty("password"));
		lp.clickLogin();
		
		logger.info("calling logout page");
		LogoutPage logout = new LogoutPage(driver);
		logout.logout_list();
		}
		catch(Exception e)
		{
			e.getMessage();
		}
		
		logger.info("Ending the test!");
	}
}
