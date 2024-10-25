package pom_store;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.Base;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class History_Page extends Base
{
	AndroidDriver driver;
	WebDriverWait wait;
	
	@AndroidFindBy(xpath = "(//android.view.View)[37]")private WebElement firstUserHistoryList;
	@AndroidFindBy(uiAutomator ="new UiSelector().className(\"android.widget.EditText\").instance(2)") private WebElement userEmailid;
	@AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.EditText\").instance(3)")private WebElement usernotes;
	@AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.CheckBox\").instance(3)")private WebElement freePlayerRadioButton;
	@AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.CheckBox\").instance(1)")private WebElement highRollerRadioButton;
	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Save Changes\")")private WebElement saveChangesButton;
	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"history-P2y\")")private WebElement notesHistoryButton;
	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Close\")")private WebElement noteshistoryCloseButton;
	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Last 7 Days\")")private WebElement last7daysDropdown;
	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"All Activity\")")private WebElement allActivityDropdown;
	
	public History_Page(AndroidDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver),this);
	}
	
	public void click_firstUser()
	{
		wait=new WebDriverWait(driver,Duration.ofSeconds(390));
		wait.until(ExpectedConditions.elementToBeClickable(firstUserHistoryList)).click();
		//firstUserHistoryList.click();
	}
	
	public void enter_emailID()
	{
		wait=new WebDriverWait(driver,Duration.ofSeconds(390));
		wait.until(ExpectedConditions.elementToBeClickable(userEmailid));
		userEmailid.sendKeys("test@gmail.com");
	}
	public void enter_usernotes()
	{
		wait=new WebDriverWait(driver,Duration.ofSeconds(390));
		wait.until(ExpectedConditions.elementToBeClickable(usernotes));
		usernotes.sendKeys("This is the test note");
	}
	public void click_freePlayer()
	{
		wait=new WebDriverWait(driver,Duration.ofSeconds(390));
		wait.until(ExpectedConditions.elementToBeClickable(freePlayerRadioButton));
		freePlayerRadioButton.click();
	}
	
	public void click_highRoller()
	{
		wait=new WebDriverWait(driver,Duration.ofSeconds(390));
		wait.until(ExpectedConditions.elementToBeClickable(highRollerRadioButton));
		highRollerRadioButton.click();
	}
	
	public void click_saveChangeButton()
	{
		wait=new WebDriverWait(driver,Duration.ofSeconds(390));
		wait.until(ExpectedConditions.elementToBeClickable(saveChangesButton));
		saveChangesButton.click();
	}
	
	public void click_notesHistory()
	{
		notesHistoryButton.click();
	}
	
	public void click_notesHistoryCloseButton() 
	{
		noteshistoryCloseButton.click();
	}
	
	public void click_last7daydropdown()
	{
		wait=new WebDriverWait(driver,Duration.ofSeconds(90));
		wait.until(ExpectedConditions.elementToBeClickable(last7daysDropdown));
		last7daysDropdown.click();
		
	}
	
	public void click_allactivityDropdown()
	{
		wait=new WebDriverWait(driver,Duration.ofSeconds(90));
		wait.until(ExpectedConditions.elementToBeClickable(allActivityDropdown));
		allActivityDropdown.click();
	}
	
}
