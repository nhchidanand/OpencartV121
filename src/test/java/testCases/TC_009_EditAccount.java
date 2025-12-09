package testCases;
import pageObjects.*;
import testBase.*;
import org.testng.annotations.*;

public class TC_009_EditAccount extends BaseClass{
	
	@Test(groups="Sanity")
	public void editAccount()
	{
		
		logger.info("**Navigating to Home Page**");
		HomePage hm = new HomePage(driver);
		hm.clickMyaccount();
		hm.clickLogin();
		
		logger.info("**Navigating to Login Page**");
		LoginPage lp = new LoginPage(driver);
		lp.setEmail(property.getProperty("email"));
		lp.setPassword(property.getProperty("password"));
		lp.clickLogin();
		
		logger.info("**Navigatting to Search Page**");
		SearchPage sp = new SearchPage(driver);
		sp.EditAccount();
		
		logger.info("**Navigating through My Account Information page**");
		MyAccountInformation mi = new MyAccountInformation(driver);
		mi.FirstName(property.getProperty("firstname"));
		mi.LastName(property.getProperty("lastname"));
		mi.Email(property.getProperty("email"));
		mi.PhoneNumber(property.getProperty("telephone"));
		mi.Continue();
		
		logger.info("**Again looping through Search Page**");
		sp.AccountSuccessfullMessageCheck();
		
	}
}
