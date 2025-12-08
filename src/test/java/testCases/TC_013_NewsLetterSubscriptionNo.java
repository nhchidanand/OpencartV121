package testCases;
import testBase.BaseClass;
import pageObjects.*;

import org.testng.Assert;
import org.testng.annotations.*;

public class TC_013_NewsLetterSubscriptionNo extends BaseClass{
	
	@Test
	public void NewsletterNo()
	{
		logger.info("**Calling the home page object**");
		HomePage hm = new HomePage(driver);
		hm.clickMyaccount();
		hm.clickLogin();
		
		logger.info("**Calling the login page object**");
		LoginPage lp = new LoginPage(driver);
		lp.setEmail(property.getProperty("email"));
		lp.setPassword(property.getProperty("password"));
		lp.clickLogin();
		
		logger.info("**CAlling the search page object**");
		SearchPage sp = new SearchPage(driver);
		sp.clickNewsLetter();
		
		logger.info("**Calling the newsletter page object**");
		NewsLetterPage nlp = new NewsLetterPage(driver);
		nlp.RadioButtonNo();
		nlp.ButtonContinue();
		String success_message = nlp.SuccessfullNewsletterMessage();
		Assert.assertTrue(success_message.toLowerCase().contains("success"), "Expected message contains Success");
		
	}
}
