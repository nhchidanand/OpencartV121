package testCases;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.RegistrationPage;
import testBase.BaseClass;

public class TC_001_AccountRegistrationTest extends BaseClass{
	
	
	@Test(groups={"Sanity", "Master"})
	public void accountCreation()
	{
		logger.info("*** This is the start of the test execution ***");
		
		try
		{
		logger.info("This is the execution of the home page");
		HomePage hm = new HomePage(driver);
		
		hm.clickMyaccount();
		logger.info("Clicked on my account link");
		
		hm.clickRegister();
		logger.info("Clicked on registration link");
		
		logger.info("This is the execution of registration page");
		RegistrationPage rp = new RegistrationPage(driver);
		rp.firstName(randomStringValue_1().toUpperCase());
		rp.lastName(randomStringValue_2().toUpperCase());
		rp.email(randomStringValue_1()+"@mail.com");
		rp.phoneNo(randomNumeric());
		
		String password = randomAlphaNumeric();
				
		rp.pass(password);
		rp.cnfPass(password);
		rp.rdbYes();
		rp.checkbPolicy();
		rp.btnConfirm();
		
		logger.info("this is the validation of the registration message");
		
		//Assert.assertEquals((rp.confirmationMessage()), "Your Account Has Been Created!");
		
		if((rp.confirmationMessage().equals("Your Account Has Been Created!")))
		{
			Assert.assertTrue(true);
		}
		else
		{
			logger.warn("This is a warning message!");
			logger.debug("This is a debug message!");
			logger.error("This is a error message!");
			logger.trace("This is a trace message!");
			logger.fatal("This is a fatal message!");
			logger.info("This is a info message!");
			Assert.assertFalse(true);
		}
		}
		
		catch(Exception e)
		{
			logger.info("this is the execution of exception!!");
			Assert.fail();
		}
		
		logger.info("*** This is the completion of the test execution ***");
	}

}
