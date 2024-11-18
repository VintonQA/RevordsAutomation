package pom_store;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.Base;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class First_User_Details extends Base 
{
	AndroidDriver driver;
	WebDriverWait wait;
	
	//@AndroidFindBy(xpath = "(//android.widget.TextView)[10]")private WebElement user_PhoneNumber;
	@AndroidFindBy(className = "android.widget.TextView")private List<WebElement> list;
	
	public First_User_Details(AndroidDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver),this);
	}
	
	public String getuserPhoneNumber()
	{
		String phoneNumber=list.get(9).getText();
		return phoneNumber;
	}

}
