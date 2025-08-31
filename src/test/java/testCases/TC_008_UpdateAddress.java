package testCases;
import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AddAddressPage;
import pageObjects.AddressPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.SearchPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC_008_UpdateAddress extends BaseClass{
	
	@Test(dataProvider="AddressData2", dataProviderClass = DataProviders.class)
	public void UpdateAddress(HashMap<String, String> input)
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
		aap.FirstName(input.get("fname"));
		aap.LastName(input.get("lname"));
		aap.Company(input.get("company"));
		aap.AddressLine1(input.get("add1"));
		aap.AddressLine2(input.get("add2"));
		aap.City(input.get("city"));
		aap.PostCode(input.get("postcode"));
		aap.selectCountry(input.get("country"));
		aap.selectState(input.get("state"));
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
