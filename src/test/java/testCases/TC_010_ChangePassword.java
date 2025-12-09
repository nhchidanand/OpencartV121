package testCases;
import testBase.*;
import pageObjects.*;
import org.testng.annotations.*;

public class TC_010_ChangePassword extends BaseClass{
	
	@Test(groups="Regression")
	public void changePassword()
	{
		logger.info("**Opening the homepage**");
		HomePage hm = new HomePage(driver);
		hm.clickMyaccount();
		hm.clickLogin();
		
		logger.info("**Opening the Login page**");
		LoginPage lp = new LoginPage(driver);
		lp.setEmail(property.getProperty("email"));
		lp.setPassword(property.getProperty("password"));
		lp.clickLogin();
		
		logger.info("**Opening the Search page**");
		SearchPage sp = new SearchPage(driver);
		sp.ChangePassword();
		
		logger.info("**Opening the ChangePasswordPage**");
		ChangePasswordPage cpp = new ChangePasswordPage(driver);
		cpp.Password(property.getProperty("password"));
		cpp.ConfirmPassword(property.getProperty("password"));
		cpp.Continue();
		
		logger.info("**Again navigating through Search Page**");
		sp.PasswordChangeSuccessfulMessage();
	}
}
