package testCases;

import org.testng.Assert;
import org.testng.annotations.*;
import testBase.BaseClass;
import utilities.DataProviders;
import pageObjects.*;

public class TC_019_LoginTestValidAndInvalidCred extends BaseClass {

	@Test(dataProvider = "LoginTestDataValidAndInvalid", dataProviderClass=DataProviders.class, priority = 1)
	public void ValidLoginTest(String email, String pass, String result) {
		if (result.equalsIgnoreCase("Valid")) {

			logger.info("*Start of the valida validation test*");
			logger.info("**Calling the home page**");
			HomePage hm = new HomePage(driver);
			hm.clickMyaccount();
			hm.clickLogin();

			logger.info("*Calling the login page*");
			LoginPage lp = new LoginPage(driver);
			lp.setEmail(email);
			lp.setPassword(pass);
			lp.clickLogin();

			logger.info("**Calling my account page**");
			MyAccount ma = new MyAccount(driver);
			ma.LogoutLink();
			
			Assert.assertEquals(result, "Valid");
		}

	}

	@Test(dataProvider = "LoginTestDataValidAndInvalid", dataProviderClass=DataProviders.class, priority = 2)
	public void InvalidLoginTest(String email, String pass, String result) {
		if (result.equalsIgnoreCase("Invalid")) {
			logger.info("*Start of the invalid validation test*");
			logger.info("**Calling the home page**");
			HomePage hm = new HomePage(driver);
			hm.clickMyaccount();
			hm.clickLogin();

			logger.info("*Calling the login page*");
			LoginPage lp = new LoginPage(driver);
			lp.setEmail(email);
			lp.setPassword(pass);
			lp.clickLogin();
			Assert.assertTrue(lp.warningMessageValidation().contains("Warning"), "Validation failed");
		}

	}
}
