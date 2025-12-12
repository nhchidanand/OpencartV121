package testCases;
import java.util.List;

import org.testng.annotations.Test;

import pageObjects.DeskTopsPage;
import pageObjects.FooterPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.SiteMapPage;
import testBase.BaseClass;

public class TC_018_GetAllDesktops extends BaseClass{
	
	@Test
	public void displayAllDesktops()
	{
		logger.info("***Start of the test***");
		try
		{
			logger.info("**calling the home page**");
			HomePage hm = new HomePage(driver);
			hm.clickMyaccount();
			hm.clickLogin();
			
			logger.info("**calling the login page**");
			LoginPage lp = new LoginPage(driver);
			lp.setEmail(property.getProperty("email"));
			lp.setPassword(property.getProperty("password"));
			lp.clickLogin();
			
			logger.info("calling the footer page");
			FooterPage fp = new FooterPage(driver);
			fp.linkSiteMap();
			
			logger.info("**calling the site map page**");
			SiteMapPage smp = new SiteMapPage(driver);
			smp.clickDesktop();
			
			logger.info("**calling the desktop page**");
			DeskTopsPage dtp = new DeskTopsPage(driver);
			List<String> products = dtp.listOfProducts();
			for(String product: products)
			{
				System.out.println(product);
			}
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		logger.info("**End of test**");
	}
}
