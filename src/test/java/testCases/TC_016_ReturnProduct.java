package testCases;
import org.testng.Assert;
import org.testng.annotations.*;

import pageObjects.*;
import testBase.*;


public class TC_016_ReturnProduct extends BaseClass{
	
	@Test(groups="Regression")
	public void returnProduct()
	{
		logger.info("***Srart of test execution***");
		
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
		fp.Returns();
		
		logger.info("**Calling the product return page**");
		ProductsReturnPage prp = new ProductsReturnPage(driver);
		prp.FirstName(randomStringValue_1());
		prp.LastName(randomStringValue_2());
		prp.email(randomStringValue_1()+"@gmail.com");
		prp.TelePhone(randomNumeric());
		prp.OrderID(randomNumeric());
		prp.calendarButton();
		prp.buttonMonthAndYear();
		prp.buttonYear();
		prp.selectDesiredYear();
		prp.selectDesiredmonth();
		prp.selectDesiredDay();
		prp.ProductName(randomStringValue_1());
		prp.ProductCode(randomNumeric());
		prp.productQuanity(randoNumeric_2());
		prp.reasonForReturns();
		prp.productOpened();
		prp.faultyOrOtherDetails(randomAlphaNumeric());
		prp.submitButtom();
		Assert.assertTrue(prp.returnResponseMessage().contains("Thank"), "Response is invalid");
	}
}
