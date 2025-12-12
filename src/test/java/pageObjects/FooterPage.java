package pageObjects;
import basePage.BasePage;
import utilities.WaitUtility;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FooterPage extends BasePage{
	
	public FooterPage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//a[text()= 'Contact Us']")
	private WebElement lnkContactUs;
	
	@FindBy(xpath="//li//a[text()= 'Returns']")
	private WebElement lnkReturns;
	
	//@FindBy(partialLinkText="Site Map")
	//private WebElement lnkSiteMap;
	
	By lnkSiteMap = By.partialLinkText("Site Map");
	
	
	public void Contact_Us()
	{
		lnkContactUs.click();
	}
	
	public void Returns()
	{
		lnkReturns.click();
	}
	
	public void linkSiteMap()
	{
		WaitUtility.waitForElementToBeClickable(driver, lnkSiteMap).click();
	}
}
