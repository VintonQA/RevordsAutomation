package pom_store;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class SignUP_Page 
{
	AndroidDriver driver;
	
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
	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Continue\")")private WebElement continueButton;
	@AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.EditText\").instance(0)") private WebElement name;
	@AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.EditText\").instance(2)")private WebElement email;
	@AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.EditText\").instance(3)")private WebElement notes;
	@AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.CheckBox\").instance(1)")private WebElement highrollerRadioButton;
	@AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.CheckBox\").instance(3)")private WebElement freeplayerRadioButton;
	@AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.CheckBox\").instance(5)")private WebElement ageRadioButton;
	
	public SignUP_Page(AndroidDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver),this);
	}
	
	public void click_num0()
	{
		number0.click();
	}
	
	public void click_num1()
	{
		number1.click();
	}
	
	public void click_num2()
	{
		number2.click();
	}
	
	public void click_num3()
	{
		number3.click();
	}
	
	public void click_num4()
	{
		number4.click();
	}
	
	public void click_num5()
	{
		number5.click();
	}
	
	public void click_num6()
	{
		number6.click();
	}
	
	public void click_num7()
	{
		number7.click();
	}
	
	public void click_num8()
	{
		number8.click();
	}
	
	public void click_num9()
	{
		number9.click();
	}
	
	public void click_continueButton()
	{
		continueButton.click();
	}
	
	public void enter_Name()
	{
		name.sendKeys("TestUser12");
	}
	
	public void enter_Email()
	{
		email.sendKeys("test@testmail.com");
	}
	
	public void click_HighRoller()
	{
		highrollerRadioButton.click();
	}
	
	public void click_freePlayer()
	{
		freeplayerRadioButton.click();
	}
	
	public void enter_notes()
	{
		notes.sendKeys("This is the sample note");
	}
	
	public void click_ageradioButton()
	{
		ageRadioButton.click();
	}
}
