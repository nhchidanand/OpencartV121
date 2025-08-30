package testCases;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.*;
import testBase.BaseClass;

public class TC_007_UpdateAddress extends BaseClass{
	
	@Test
	public void UpdateAddress()
	{
		logger.info("***Start of the test***");
		
		try
		{
		logger.info("**Start of the home page**");
		HomePage hm = new HomePage(driver);
		hm.clickMyaccount();
		hm.clickLogin();
		
		logger.info("**Start of the login page**");
		LoginPage lp = new LoginPage(driver);
		lp.setEmail(property.getProperty("email"));
		lp.setPassword(property.getProperty("password"));
		lp.clickLogin();
		
		logger.info("**Start of the search page**");
		SearchPage sp = new SearchPage(driver);
		sp.clickAddreddModify();
		
		logger.info("**Start of the address page**");
		AddressPage ap = new AddressPage(driver);
		ap.newAddressButton();
		
		logger.info("**Start of the add address page**");
		AddAddressPage aap = new AddAddressPage(driver);
		aap.FirstName("Chidanand");
		aap.LastName("Hadimani");
		aap.Company("Acc");
		aap.AddressLine1("Indi");
		aap.AddressLine2("Rodagi");
		aap.City("Vijayapura");
		aap.PostCode("123456");
		aap.selectCountry("India");
		aap.selectState("Karnataka");
		aap.Yes_No();
		aap.ContinueButton();
		
		logger.info("**Again calling search page for the validation**");
		sp.AddressSuccessfullMessageCheck();
		}
		catch (Exception e)
		{
			e.getMessage();
			Assert.fail();
		}
		
	}
}
