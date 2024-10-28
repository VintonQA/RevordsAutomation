package pom_store;
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class Login_Page 
{
	AndroidDriver driver;
	WebDriverWait wait;
	@AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.EditText\").instance(0)") private WebElement userName;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.EditText\").instance(1)")private WebElement password;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Login\")") private WebElement loginButton;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().description(\"Forget password?\")") private WebElement forgetPassword;
	
	public Login_Page(AndroidDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver),this);
	}
	
	public void enterUserName()
	{
		wait=new WebDriverWait(driver,Duration.ofSeconds(90));
		wait.until(ExpectedConditions.elementToBeClickable(userName));
		userName.sendKeys("fortunesstreamwoodstore");
	}
	
	public void enterPassword()
	{
		wait=new WebDriverWait(driver,Duration.ofSeconds(90));
		wait.until(ExpectedConditions.elementToBeClickable(password));
		password.sendKeys("Revords@2024");
	}
	
	public void clickLogin()
	{
		loginButton.click();
	}

	public void clickForgetPassword()
	{
		forgetPassword.click();
	}
}
