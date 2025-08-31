package testCases;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.*;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC_007_UpdateAddress extends BaseClass{
	
	@Test(dataProvider="AddressData", dataProviderClass = DataProviders.class)
	public void UpdateAddress(String Fname, String Lname, String Company, String a1, String a2, String city, String pc, String country, String state)
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
		aap.FirstName(Fname);
		aap.LastName(Lname);
		aap.Company(Company);
		aap.AddressLine1(a1);
		aap.AddressLine2(a2);
		aap.City(city);
		aap.PostCode(pc);
		aap.selectCountry(country);
		aap.selectState(state);
		aap.Yes_No();
		aap.ContinueButton();
		
		logger.info("**Again calling search page for the validation**");
		sp.AddressSuccessfullMessageCheck();
		
		logger.info("**Again calling search page object**");
		sp.Logout();
		}
		catch (Exception e)
		{
			e.getMessage();
			Assert.fail();
		}
		
	}
}
