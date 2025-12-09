package testCases;
import testBase.*;
import pageObjects.*;
import org.testng.annotations.*;

public class TC_014_SubmitContactFormP extends BaseClass{
	
	@Test(groups={"Sanity", "Regression", "Master"})
	public void contactFormPositive()
	{
		logger.info("***Srart of test execution***");
		
		try
		{
		logger.info("**CAlling the home page**");
		HomePage hm = new HomePage(driver);
		hm.clickMyaccount();
		hm.clickLogin();
		
		logger.info("**Calling the login page**");
		LoginPage lp = new LoginPage(driver);
		lp.setEmail(property.getProperty("email"));
		lp.setPassword(property.getProperty("password"));
		lp.clickLogin();
		
		logger.info("**Calling the Footer page**");
		FooterPage fp = new FooterPage(driver);
		fp.Contact_Us();
		
		logger.info("**Calling the contact form page**");
		ContactFormPage cfp = new ContactFormPage(driver);
		cfp.InputName(randomStringValue_1()+"s");
		cfp.InputEmail(randomStringValue_2()+"gmail.com");
		cfp.InputEnquiry(randomAlphaNumeric());
		cfp.ButtonSubmit();
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		logger.info("***End of test execution***");
	}
}
