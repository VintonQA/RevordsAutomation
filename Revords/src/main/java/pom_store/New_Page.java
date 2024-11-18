package pom_store;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.Base;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class New_Page extends Base
{
	AndroidDriver driver;
	WebDriverWait wait;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"New\")")private WebElement newTab;
	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"1\")")private WebElement numberone;
	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"2\")")private WebElement numbertwo;
	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"3\")")private WebElement numberthree;
	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"4\")")private WebElement numberfour;
	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"5\")")private WebElement numberfive;
	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"6\")")private WebElement numbersix;
	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"7\")")private WebElement numberseven;
	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"8\")")private WebElement numbereight;
	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"9\")")private WebElement numbernine;
	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"0\")")private WebElement numberzero;
	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Continue\")")private WebElement contiueButton;
	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"The member is already signed in.\")")private WebElement errorMessage;
	
	public New_Page(AndroidDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver),this);
	}
	
	public void clickNewTab()
	{
		newTab.click();
	}
	
	public void clickNumber1()
	{
		numberone.click();
	}
	
	public void clickNumber2()
	{
		numbertwo.click();
	}
	
	public void clickNumber3()
	{
		numberthree.click();
	}
	
	public void clickNumber4()
	{
		numberfour.click();
	}
	
	public void clickNumber5()
	{
		numberfive.click();
	}
	
	public void clickNumber6()
	{
		numbersix.click();
	}
	
	public void clickNumber7()
	{
		numberseven.click();
	}
	
	public void clickNumber8()
	{
		numbereight.click();
	}
	
	public void clickNumber9()
	{
		numbernine.click();
	}
	
	public void clickNumber0()
	{
		numberzero.click();
	}
	
	public void clickContinueButton()
	{
		contiueButton.click();
	}
	
	public String getErrorMessage()
	{
		String errormsg=errorMessage.getText();
		return errormsg;
	}

}
