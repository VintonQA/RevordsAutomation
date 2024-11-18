package pom_cutomer;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class Store_Newpage 
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
	@AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.view.View\").instance(22)")private WebElement deleteButton;
	@AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.view.View\").instance(26)")private WebElement continueButton;
	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Add Guest\")")private WebElement addGuest;
	
	public Store_Newpage(AndroidDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver),this);
	}
	
	public void pressNumber1()
	{
		number1.click();
	}
	
	public void pressnumer2()
	{
		number2.click();
	}
	
	public void pressnumber4()
	{
		number4.click();
	}
	
	public void pressnumber5()
	{
		number5.click();
	}
	
	public void pressnumber6()
	{
		number6.click();
	}
	
	public void pressnumber7()
	{
		number7.click();
	}
	
	public void pressnumber8()
	{
		number8.click();
	}
	
	public void pressnumber9()
	{
		number9.click();
	}
	
	public void pressnumber0()
	{
		number0.click();
	}
	
	public void click_DeleteButton()
	{
		deleteButton.click();
	}
	
	public void click_AddGuestButton()
	{
		addGuest.click();
	}

}
