package pom_cutomer;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class Customer_Dashboard_Page 
{
	AndroidDriver driver;
	WebDriverWait wait;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"1\")")private WebElement number1;
	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"2\")")private WebElement number2;
	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"3\")")private WebElement number3;
	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"4\")")private WebElement number4;
	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"5\")")private WebElement number5;
	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"6\")")private WebElement number6;
	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"7\")")private WebElement number7;
	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"8\")")private WebElement number8;
	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"9\")")private WebElement number9;
	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"0\")")private WebElement number0;
	@AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.view.View\").instance(9)")private WebElement enterButton;
	@AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.Image\").instance(6)")private WebElement deleteButton;
	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"By signing up, you agree to receive occasional updates and promotions via text message and to our\")") private WebElement termsTextDashboardPage;
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"open-modal\")")private WebElement TermsAndPrivacyPolicy;
	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Terms & Privacy Policy\")")private WebElement privacyPageTitle;
	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"cancel\")")private WebElement closePrivacyPage;
	
	public Customer_Dashboard_Page(AndroidDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver),this);
	}
	
	public void press_number1()
	{
		wait=new WebDriverWait(driver,Duration.ofSeconds(390));
		wait.until(ExpectedConditions.elementToBeClickable(number1)).click();
	}
	
	public boolean number1status()
	{
		boolean status = number1.isDisplayed();
		return status;
	}
	
	public void press_number2()
	{
		wait=new WebDriverWait(driver,Duration.ofSeconds(390));
		wait.until(ExpectedConditions.elementToBeClickable(number2)).click();
	}
	
	public void press_number3()
	{
		wait=new WebDriverWait(driver,Duration.ofSeconds(390));
		wait.until(ExpectedConditions.elementToBeClickable(number3)).click();
	}
	
	public void press_number4()
	{
		wait=new WebDriverWait(driver,Duration.ofSeconds(390));
		wait.until(ExpectedConditions.elementToBeClickable(number4)).click();
	}
	
	public void press_number5()
	{
		wait=new WebDriverWait(driver,Duration.ofSeconds(390));
		wait.until(ExpectedConditions.elementToBeClickable(number5)).click();
	}
	
	public void press_number6()
	{
		wait=new WebDriverWait(driver,Duration.ofSeconds(390));
		wait.until(ExpectedConditions.elementToBeClickable(number6)).click();
	}
	
	public void press_number7()
	{
		wait=new WebDriverWait(driver,Duration.ofSeconds(390));
		wait.until(ExpectedConditions.elementToBeClickable(number7)).click();
	}
	
	public void press_number8()
	{
		wait=new WebDriverWait(driver,Duration.ofSeconds(390));
		wait.until(ExpectedConditions.elementToBeClickable(number8)).click();
	}
	
	public void press_number9()
	{
		wait=new WebDriverWait(driver,Duration.ofSeconds(390));
		wait.until(ExpectedConditions.elementToBeClickable(number9)).click();
	}
	
	public void press_number0()
	{
		wait=new WebDriverWait(driver,Duration.ofSeconds(390));
		wait.until(ExpectedConditions.elementToBeClickable(number0)).click();
	}
	
	public void click_nextButton()
	{
		wait=new WebDriverWait(driver,Duration.ofSeconds(390));
		wait.until(ExpectedConditions.elementToBeClickable(enterButton)).click();
		
	}
	
	public void click_deleteButton()
	{
		wait=new WebDriverWait(driver,Duration.ofSeconds(390));
		wait.until(ExpectedConditions.elementToBeClickable(deleteButton)).click();
		
	}
	
	public boolean verify_dashboardPage()
	{
		wait=new WebDriverWait(driver,Duration.ofSeconds(390));
		wait.until(ExpectedConditions.elementToBeClickable(termsTextDashboardPage));
		boolean visibilitytermsText=termsTextDashboardPage.isDisplayed();
		return visibilitytermsText;
	}
	
	public boolean verify_visibility_of_TermsAndConditions()
	{
		wait=new WebDriverWait(driver,Duration.ofSeconds(390));
		wait.until(ExpectedConditions.elementToBeClickable(TermsAndPrivacyPolicy));
		boolean termsvisibility = TermsAndPrivacyPolicy.isDisplayed();
		return termsvisibility;
	}
	
	public String verify_TermsANDCondition_IsClickable()
	{
		wait=new WebDriverWait(driver,Duration.ofSeconds(390));
		wait.until(ExpectedConditions.elementToBeClickable(TermsAndPrivacyPolicy));
		TermsAndPrivacyPolicy.click();
		String privacyPagetitle=privacyPageTitle.getText();
		return privacyPagetitle;
	}
	
	public void close_privacypage()
	{
		closePrivacyPage.click();
	}
	
}
