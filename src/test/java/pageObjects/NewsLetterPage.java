package pageObjects;
import basePage.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NewsLetterPage extends BasePage{
	
	public NewsLetterPage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//label[normalize-space()='Yes']")
	private WebElement rdBtnYes;
	
	@FindBy(xpath="//label[normalize-space()='No']")
	private WebElement rdBtnNo;
	
	@FindBy(css="[value='Continue']")
	private WebElement btnContinue;
	
	@FindBy(xpath="//div[contains(text(), 'newsletter')]")
	private WebElement successNewsLetterMsg;
	
	
	public void RadioButtonYes()
	{
		if(!rdBtnYes.isSelected())
		{
			rdBtnYes.click();
		}
	}
	
	public void RadioButtonNo()
	{
		if(!rdBtnNo.isSelected())
		{
			rdBtnNo.click();
		}
	}
	
	public void ButtonContinue()
	{
		btnContinue.click();
	}
	
	public String SuccessfullNewsletterMessage()
	{
		return successNewsLetterMsg.getText();
	}
}
