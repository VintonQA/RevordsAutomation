package pom_cutomer;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.Base;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class Customer_Info_Page extends Base
{
	AndroidDriver driver;
	WebDriverWait wait;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"name\")")private WebElement custName;
	@AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.EditText\").instance(1)")private WebElement cust_EmailID;
	@AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.TextView\").instance(5)")private WebElement cust_birthMonth;
	@AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.TextView\").instance(6)")private WebElement cust_birthDate;
	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Yes (opt-in for SMS)\")")private WebElement cust_optInSMS;
	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"No (opt-out)\")")private WebElement cust_optOutSMS;
	@AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.Image\").instance(1)")private WebElement cust_ageCheckBox;
	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Let's Start\")")private WebElement cust_letstartButton;
	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Enter Your Information\")")private WebElement informationPageBanner;
	@AndroidFindBy(xpath = "(//android.widget.RadioGroup/android.widget.RadioButton)[8]")private WebElement augustMonthfromdropdown;
	@AndroidFindBy(xpath = "(//android.widget.RadioButton)[7]")private WebElement birthdatefromdropdown;
	@AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"alert-3-hdr\"]")private WebElement popUpforOptOut;
	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"OK\")")private WebElement okbuttonMonthSelect;
	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"CANCEL\")")private WebElement popupCancelButton;
	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"YES\")")private WebElement popupYesButton;
	@AndroidFindBy(xpath = "//android.widget.Button[@text=\"OK\"]")private WebElement okbuttonbirthdate;
	@AndroidFindBy(xpath = "//android.widget.RadioButton[@text=\"Yes\"]")private WebElement promotionalPOPUPYESButton;
	@AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.Image\").instance(1)")private WebElement checkboxPromotionalPOPUP;
	@AndroidFindBy(xpath = "//android.widget.Button[@text=\"Let's Start\"]")private WebElement letsStartButtonPromotionalPOPUP;
	@AndroidFindBy(xpath = "//android.widget.Button[@text=\"Continue \"]")private WebElement finalContinueButton;
	
	
	
	public Customer_Info_Page(AndroidDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver),this);
	}
	
	public void enter_CustomerName()
	{
		wait=new WebDriverWait(driver,Duration.ofSeconds(390));
		wait.until(ExpectedConditions.elementToBeClickable(custName)).click();
		custName.sendKeys("piyush");
	}
	
	public void enter_customerEmail()
	{
		wait=new WebDriverWait(driver,Duration.ofSeconds(390));
		wait.until(ExpectedConditions.elementToBeClickable(cust_EmailID)).click();
		cust_EmailID.sendKeys("piyushdantani9195@gmail.com");
	}
	
	public void choose_custBirthMonth()
	{
		wait=new WebDriverWait(driver,Duration.ofSeconds(390));
		wait.until(ExpectedConditions.elementToBeClickable(cust_birthMonth)).click();
		
	}
	
	public void choose_custBirthDate()
	{
		wait=new WebDriverWait(driver,Duration.ofSeconds(390));
		wait.until(ExpectedConditions.elementToBeClickable(cust_birthDate)).click();
		
	}
	
	public void choose_optINSMS()
	{
		wait=new WebDriverWait(driver,Duration.ofSeconds(390));
		wait.until(ExpectedConditions.elementToBeClickable(cust_optInSMS)).click();
		
	}
	
	public void choose_optOutSMS()
	{
		wait=new WebDriverWait(driver,Duration.ofSeconds(390));
		wait.until(ExpectedConditions.elementToBeClickable(cust_optOutSMS)).click();
		
	}
	
	public void check_custAgeCheckBox()
	{
		wait=new WebDriverWait(driver,Duration.ofSeconds(390));
		wait.until(ExpectedConditions.elementToBeClickable(cust_ageCheckBox)).click();
		
	}
	
	public void click_letsStartButton()
	{
		wait=new WebDriverWait(driver,Duration.ofSeconds(390));
		wait.until(ExpectedConditions.elementToBeClickable(cust_letstartButton)).click();
		
	}
	
	public String bannerText()
	{
		String bannerText=informationPageBanner.getText();
		return bannerText;
	}
	
	public void choose_birthMonth()
	{
		wait=new WebDriverWait(driver,Duration.ofSeconds(390));
		wait.until(ExpectedConditions.visibilityOf(augustMonthfromdropdown)).click();
		okbuttonMonthSelect.click();
		
	}
	
	public void choose_birthDate()
	{
		wait=new WebDriverWait(driver,Duration.ofSeconds(390));
		wait.until(ExpectedConditions.elementToBeClickable(birthdatefromdropdown)).click();
		
	}
	
	public String optoutpopup()
	{
		wait=new WebDriverWait(driver,Duration.ofSeconds(390));
		wait.until(ExpectedConditions.visibilityOf(popUpforOptOut));
		String popuptitle=popUpforOptOut.getText();
		return popuptitle;
	}
	
	public void click_letsButton()
	{
		wait=new WebDriverWait(driver,Duration.ofSeconds(390));
		wait.until(ExpectedConditions.elementToBeClickable(cust_letstartButton));
		cust_letstartButton.click();
	}
	
	public void click_POPUP_cancelButton()
	{
		wait=new WebDriverWait(driver,Duration.ofSeconds(390));
		wait.until(ExpectedConditions.visibilityOf(popupCancelButton)).click();
	}
	
	public void click_POPUP_yesButton()
	{
		wait=new WebDriverWait(driver,Duration.ofSeconds(390));
		wait.until(ExpectedConditions.visibilityOf(popupYesButton)).click();
	}

	public void click_OKButton_dateDropDown()
	{
		wait=new WebDriverWait(driver,Duration.ofSeconds(390));
		wait.until(ExpectedConditions.visibilityOf(okbuttonbirthdate)).click();
	}
	
	public void click_yesButtonPromotionalPage()
	{
		wait=new WebDriverWait(driver,Duration.ofSeconds(390));
		wait.until(ExpectedConditions.visibilityOf(promotionalPOPUPYESButton)).click();
	}
	
	public void click_checkBoxPromotionalPage()
	{
		wait=new WebDriverWait(driver,Duration.ofSeconds(390));
		wait.until(ExpectedConditions.visibilityOf(checkboxPromotionalPOPUP)).click();
	}
	
	public void click_letsStartPromotionalPOPUP()
	{
		wait=new WebDriverWait(driver,Duration.ofSeconds(390));
		wait.until(ExpectedConditions.visibilityOf(letsStartButtonPromotionalPOPUP)).click();
	}
	
	public void click_ContinueButton()
	{
		wait=new WebDriverWait(driver,Duration.ofSeconds(390));
		wait.until(ExpectedConditions.visibilityOf(finalContinueButton)).click();
	}
}
