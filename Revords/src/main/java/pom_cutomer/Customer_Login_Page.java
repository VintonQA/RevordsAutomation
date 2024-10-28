package pom_cutomer;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class Customer_Login_Page
{
	AndroidDriver driver;
	WebDriverWait wait;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.EditText\").instance(0)")private WebElement userName;
	@AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.EditText\").instance(1)")private WebElement password;
	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Login\")")private WebElement loginButton;
	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Please enter valid credentials.\")")private WebElement loginPageErrorMessage;
	
	public Customer_Login_Page(AndroidDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver),this);
	}
	
	public void enter_UserName()
	{
		wait=new WebDriverWait(driver,Duration.ofSeconds(90));
		wait.until(ExpectedConditions.elementToBeClickable(userName));
		userName.sendKeys("fortunesstreamwoodstore");
	}
	
	public void enter_Password()
	{
		wait=new WebDriverWait(driver,Duration.ofSeconds(90));
		wait.until(ExpectedConditions.elementToBeClickable(password));
		password.sendKeys("Revords@2024");	
	}
	
	public void click_loginButton()
	{
		wait=new WebDriverWait(driver,Duration.ofSeconds(90));
		wait.until(ExpectedConditions.elementToBeClickable(loginButton));
		loginButton.click();
	}
	
	public void enter_wrongUserName()
	{
		wait=new WebDriverWait(driver,Duration.ofSeconds(90));
		wait.until(ExpectedConditions.elementToBeClickable(userName));
		userName.sendKeys("fortunesstreamwoodtest");
	}
	
	public String loginPageErrorMessage()
	{
		wait=new WebDriverWait(driver,Duration.ofSeconds(90));
		wait.until(ExpectedConditions.elementToBeClickable(loginPageErrorMessage));
		String errorMessage=loginPageErrorMessage.getText();
		return errorMessage;
	}
}
