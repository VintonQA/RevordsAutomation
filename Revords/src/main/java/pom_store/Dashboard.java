package pom_store;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.collect.ImmutableMap;
import revord_Utility.*;
import base.Base;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AndroidFindBys;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class Dashboard extends Base
{
	AndroidDriver driver;
	WebDriverWait wait;
	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"defaultUser1\").instance(0)") private WebElement firstUser;
	@AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Home\"]")private WebElement homeTab;
	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"History\")")private WebElement historyTab;
	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Reward\").instance(0)") private WebElement reward;
	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"New\")")private WebElement newuser;
	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Settings\")")private WebElement settings;
	@AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.EditText\")")private WebElement searchUser;
	@AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.view.View\").instance(21)")private WebElement userClick;
	@AndroidFindBy(uiAutomator = "new UiSelector().description(\"home outline Home\")")private WebElement hometab;
	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"defaultUser1\")")private WebElement userprofile;
	@AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.view.View\").instance(75)")private WebElement userHistory;
	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Close\")")private WebElement userHistoryClose;
	@AndroidFindBy(xpath = "(//android.widget.EditText)[1]")private WebElement userName;
	@AndroidFindBy(xpath = "(//android.widget.TextView)[10]")private WebElement user_PhoneNumber;
	@AndroidFindBy(xpath = "(//android.widget.TextView)[11]")private WebElement user_membershipDetails;
	@AndroidFindBy(xpath = "(//android.widget.TextView)[12]")private WebElement user_currentpoints;
	@AndroidFindBy(xpath = "(//android.widget.TextView)[13]")private WebElement user_lifetimePointBalance;
	@AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.EditText\").instance(2)")private WebElement userEmailField;
	@AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.EditText\").instance(3)")private WebElement notesField;
	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"guestUser\")")private WebElement addGuestUser;
	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Continue\")")private WebElement addNewUserContinuebutton;
	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Yes\")")private WebElement yesButton;
	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"New guest added.\")")private WebElement guestAddStatus;
	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"SIGN OUT\")")private WebElement signoutButton;
	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"CONFIRM\")")private WebElement signoutConfirmButton;
	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Yes\")")private WebElement signoutConfirmYesButton;
	@AndroidFindBy(xpath = "(//android.view.View)[37]")public WebElement firstUserHistoryList;
	@AndroidFindBy(xpath = "(//android.widget.TextView)[9]")private WebElement settingPageFirstvalue;
	@AndroidFindBy(xpath = "(//android.widget.TextView)[10]")private WebElement settingPageSecondvalue;
	@AndroidFindBy(xpath = "(//android.widget.TextView)[11]")private WebElement settingPageThirdvalue;
	@AndroidFindBy(xpath = "(//android.widget.TextView)[18]")private WebElement userSummaryReward;
	@AndroidFindBy(xpath = "(//android.widget.TextView)[20]")private WebElement userSummaryEarnedPoints;
	@AndroidFindBy(xpath = "(//android.widget.TextView)[22]")private WebElement userSummaryNewTotal;
	@AndroidFindBy(xpath = "(//android.widget.TextView)[9]")private WebElement userSummaryusername;
	@AndroidFindBy(xpath = "//android.webkit.WebView[@text=\"Revords Store\"]/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]")private WebElement dashboardfirstuserafterclickonit;
	
	
	public Dashboard(AndroidDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver),this);
	}
	
	public void firstUser()
	{
		firstUser.click();
	}
	
	public void clickHistory()
	{
		historyTab.click();
	}
	
	public String verify_HomePage()
	{
		String homeTabText=homeTab.getText();
		return homeTabText;
	}
	
	public String rewardsText()
	{
		String texOfRewards=reward.getText();
		return texOfRewards;
	}
	
	public boolean rewardClick()
	{
		boolean result=reward.isDisplayed() && reward.isEnabled();
		return result;
	}
	
	public void click_NewUserTab()
	{
		newuser.click();
	}
	
	public void click_settings()
	{
		wait=new WebDriverWait(driver,Duration.ofSeconds(290));
		wait.until(ExpectedConditions.elementToBeClickable(settings));
		settings.click();
	}
	
	public void user_search(String name)
	{
		searchUser.sendKeys(name);
		
	}
	
	public void user_click()
	{
		wait=new WebDriverWait(driver,Duration.ofSeconds(90));
		wait.until(ExpectedConditions.elementToBeClickable(userClick));
		userClick.click();
	}
	
	public void click_homeTab()
	{
		wait=new WebDriverWait(driver,Duration.ofSeconds(90));
		wait.until(ExpectedConditions.visibilityOf(homeTab));
		hometab.click();
	}
	
	public void click_userprofile()
	{
		wait=new WebDriverWait(driver,Duration.ofSeconds(90));
		wait.until(ExpectedConditions.elementToBeClickable(userprofile));
		userprofile.click();
	}
	
	public void click_userHistory()
	{
		wait=new WebDriverWait(driver,Duration.ofSeconds(90));
		wait.until(ExpectedConditions.elementToBeClickable(userHistory));
		userHistory.click();
	}
	
	public void click_closeHistory()
	{
		wait=new WebDriverWait(driver,Duration.ofSeconds(90));
		wait.until(ExpectedConditions.elementToBeClickable(userHistoryClose));
		userHistoryClose.click();
	}
	
	public String user_Name()
	{
		String username=userName.getText();
		return username;
	}
	
	public String get_UserMemberShipDate()
	{
		String membershipDate=user_membershipDetails.getText();
		return membershipDate;
	}
	
	public String get_UserCurrentPoints()
	{
		String currentPoints=user_currentpoints.getText();
		return currentPoints;
	}
	public String get_UserlifetimePoints()
	{
		String lifetimepoints=user_lifetimePointBalance.getText();
		return lifetimepoints;
	}
	
	public String get_UserPhoneNumber()
	{
		String phoneNumber=user_PhoneNumber.getText();
		return phoneNumber;
	}
	
	public boolean verify_emailfield()
	{
		boolean emailFieldvisibilityStatus = userEmailField.isDisplayed();
		return emailFieldvisibilityStatus;
	}
	
	public boolean verify_notesfield()
	{
		boolean notesfieldVisibility = notesField.isDisplayed();
		return notesfieldVisibility;
	}
	
	public void Click_AddGuest()
	{
		addGuestUser.click();
	}
	
	public void add_NewUserContinueButton()
	{
		addNewUserContinuebutton.click();
	}
	
	public void click_yesButton()
	{
		yesButton.click();
	}
	
	public String getGuestAddStatus()
	{
		String guestStatus=guestAddStatus.getText();
		return guestStatus;
	}
	
	public void click_UserSignout()
	{
		signoutButton.click();
	}
	
	public void Click_SignOutConfirmButton()
	{
		signoutConfirmButton.click();
	}
	
	public void Click_SignoutConfirmYes()
	{
		signoutConfirmYesButton.click();
	}
	
	public void click_firstUser()
	{
		wait=new WebDriverWait(driver,Duration.ofSeconds(390));
		wait.until(ExpectedConditions.elementToBeClickable(searchUser));
		firstUserHistoryList.click();
		
	}
	
	
	public String settingPage_FirstAttriute()
	{
		wait=new WebDriverWait(driver,Duration.ofSeconds(390));
		wait.until(ExpectedConditions.elementToBeClickable(settingPageFirstvalue));
		String Fvalue=settingPageFirstvalue.getText();
		return Fvalue;
	}
	
	public String settingPage_SecondAttriute()
	{
		wait=new WebDriverWait(driver,Duration.ofSeconds(390));
		wait.until(ExpectedConditions.elementToBeClickable(settingPageSecondvalue));
		String Svalue=settingPageSecondvalue.getText();
		return Svalue;
	}
	
	public String settingPage_ThirdAttriute()
	{
		wait=new WebDriverWait(driver,Duration.ofSeconds(390));
		wait.until(ExpectedConditions.elementToBeClickable(settingPageThirdvalue));
		String Tvalue=settingPageThirdvalue.getText();
		return Tvalue;
	}
	
	public String get_UserSummaryReward()
	{
		String reward=userSummaryReward.getText();
		return reward;
	}
	
	public String get_UserSummaryEarnedPoints()
	{
		String earnedPoint=userSummaryEarnedPoints.getText();
		return earnedPoint;
	}
	
	public String get_UserSummaryNewTotal()
	{
		String newTotal=userSummaryNewTotal.getText();
		return newTotal;
	}
	
	public String get_UserSummaryUserName()
	{
		String userName=userSummaryusername.getText();
		return userName;
	}
	
	public void click_dashboardfirstuserafterfirstclick()
	{
		wait=new WebDriverWait(driver,Duration.ofSeconds(390));
		wait.until(ExpectedConditions.elementToBeClickable(dashboardfirstuserafterclickonit));
		dashboardfirstuserafterclickonit.click();
	}
	
}
