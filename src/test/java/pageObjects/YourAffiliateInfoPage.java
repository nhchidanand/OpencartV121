package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import basePage.BasePage;
import utilities.WaitUtility;

public class YourAffiliateInfoPage extends BasePage{
	
	public YourAffiliateInfoPage(WebDriver driver)
	{
		super(driver);
	}
	
	private By company= By.xpath("//input[@name= 'company' and @id= 'input-company']");
	
	private By webSite= By.xpath("//input[@name= 'website' and @id= 'input-website']");
	
	private By taxId= By.xpath("//input[@name= 'tax' and @id= 'input-tax']");
	
	private By paymentMethods= By.xpath("//input[@name= 'payment']");
	
	private By chequePayeName= By.xpath("//input[@name= 'cheque' and @id= 'input-cheque']");
	
	private By btnContinue= By.cssSelector("input[value='Continue']");
	
	//Action methods
	public void companyName(String cName)
	{
		type(company, cName);
	}
	
	public void webSiteName(String webName)
	{
		type(webSite, webName);
	}
	
	public void taxID(String taxid)
	{
		type(taxId, taxid);
	}
	
	public void paymentMethod(String paymentName)
	{
		List<WebElement> payMethods= WaitUtility.waitForElementsToBeVisible(driver, paymentMethods);
		
		for(WebElement paymentMethod: payMethods)
		{
			if(paymentMethod.getAttribute("value").equals(paymentName))
			{
				paymentMethod.click();
				break;
			}
		}
	}
	
	public void payeeName(String name)
	{
		type(chequePayeName, name);
	}
	
	public void clickContinueButton()
	{
		click(btnContinue);
	}
}
