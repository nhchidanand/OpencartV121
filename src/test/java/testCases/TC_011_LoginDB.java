package testCases;
import java.sql.SQLException;
import java.util.HashMap;

import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBase.BaseClass;

public class TC_011_LoginDB extends BaseClass{
	
	@Test(groups="DataBase")
	void loginDataBase() throws SQLException, InterruptedException
	{
		logger.info("**Calling the home page object**");
		
		HomePage hm = new HomePage(driver);
		hm.clickMyaccount();
		hm.clickLogin();
		
		logger.info("**Calling the database method from base class**");
		HashMap<String, String> data = DataBaseConnection();
		String email = data.get("email");
		String password = data.get("password");
		
		logger.info("**Calling the login in page object**");
		LoginPage lp = new LoginPage(driver);
		lp.setEmail(email);
		lp.setPassword(password);
		lp.clickLogin();
	}
}