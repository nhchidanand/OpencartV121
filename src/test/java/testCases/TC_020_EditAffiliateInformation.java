package testCases;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.*;
import testBase.BaseClass;

public class TC_020_EditAffiliateInformation extends BaseClass{
	
	@Test
	public void editAffiliateInformation()
	{
		logger.info("**Start of the edit affiliate test**");
		try
		{
			logger.info("*Calling home page*");
			HomePage hm= new HomePage(driver);
			hm.clickMyaccount();
			hm.clickLogin();
			
			logger.info("*Calling the login page*");
			LoginPage lp= new LoginPage(driver);
			lp.setEmail(property.getProperty("email"));
			lp.setPassword(property.getProperty("password"));
			lp.clickLogin();
			
			logger.info("*Calling the search page*");
			SearchPage sp= new SearchPage(driver);
			sp.editAffiliateInformation();
			
			logger.info("*Calling the affiliate info page*");
			YourAffiliateInfoPage yaip= new YourAffiliateInfoPage(driver);
			yaip.companyName(randomStringValue_1());
			yaip.webSiteName(randomStringValue_1());
			yaip.taxID(randomNumeric());
			yaip.paymentMethod("cheque");
			yaip.payeeName(randomStringValue_1());
			yaip.clickContinueButton();
			
			logger.info("*Calling method's from search page*");
			Assert.assertEquals(sp.affiliateSuccessfulMessage(), "Success: Your account has been successfully updated.");
			
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
}
