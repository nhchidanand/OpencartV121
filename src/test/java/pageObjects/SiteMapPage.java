package pageObjects;
import basePage.BasePage;
import utilities.WaitUtility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SiteMapPage extends BasePage{
	
	public SiteMapPage(WebDriver driver)
	{
		super(driver);
	}
	
	private By lnkDesktop = By.xpath("//div[@id='content']//a[contains(text(), 'Desktops')]");
	
	
	public void clickDesktop()
	{
		WaitUtility.waitForElementToBeClickable(driver, lnkDesktop).click();
	}
}
