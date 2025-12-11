package pageObjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import basePage.BasePage;
import utilities.*;

public class OrderHistoryPage extends BasePage{
	
	
	WaitUtility util = new WaitUtility();
	public OrderHistoryPage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//p[contains(text(), 'previous orders')]")
	private WebElement orderHistoryMessage;
	
	private By btnContinue = By.partialLinkText("Continue");

	
	public String orderHistory()
	{
		return orderHistoryMessage.getText();
	}
	
	public void clickContinueButton()
	{

		WebElement btnclk = util.waitForElementToBeClickable(driver, btnContinue);
		btnclk.click();
	}
}
