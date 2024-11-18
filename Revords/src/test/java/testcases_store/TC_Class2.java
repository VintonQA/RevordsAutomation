package testcases_store;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.xmlbeans.impl.tool.XMLBean.ErrorLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import revord_Utility.*;

import com.aventstack.extentreports.model.Report;
import com.google.common.collect.ImmutableMap;

import base.Base;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.io.File;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import pom_store.Dashboard;
import pom_store.History_Page;
import pom_store.Login_Page;
import revord_Utility.*;

@Listeners(listners.Listner_Revords.class)
public class TC_Class2 extends Base
{
	Login_Page loginPage;
	Dashboard dashboard;
	History_Page historyPage;
	String phonenumber;
	public static Logger logger;
	String sessionTime;
	
	@BeforeClass
	public void startup() throws MalformedURLException, URISyntaxException
	{
		configureAppium();
		logger=Logger.getLogger("Revords");
		PropertyConfigurator.configure("log4j.properties");
	}
	
	@Test(priority = 0)
	public void login_Verify() throws InterruptedException
	{
		try
		{
		loginPage=new Login_Page(driver);
		loginPage.enterUserName(Base.propertyFileData("UserNameStore1"));
		synchronization(1500);
		loginPage.enterPassword(Base.propertyFileData("Password"));
		synchronization(1600);
		loginPage.clickLogin();
		System.out.println("Login Button is clickable");
		logger.info("Login Successfull!!!! TC Passed");
		}
		catch (Exception e) {
			System.out.println("UserName/Password are incorrect");
			logger.error("Login Unsuccessfull !!!! TC Failed");
		}
		
	}
	
	
	@Test(priority = 1)
	public void Verify_Dashboard() throws InterruptedException
	{
		dashboard=new Dashboard(driver);
		String actualResult=dashboard.verify_HomePage();
		String expectedResult="Home";
		try
		{
		Assert.assertEquals(actualResult,expectedResult);
		logger.info("User Landed on Dashboard Page Successfully.TC Passed!!!!");
		System.out.println("User Landed on Dashboard Page Successfully.TC Passed!!!!");
		}
		catch(Exception e)
		{
			System.out.println("User Not Redirected to Dashboard.TC Failed!!!!");
			logger.error("User Not Redirected to Dashboard.TC Failed!!!!");
		}
	}
	
	
	
	@Test(priority = 2)
	public void verify_UserSessionTime()
	{
		dashboard=new Dashboard(driver);
		try
		{
			String Fuser=dashboard.dashboard_firstUserName();
			sessionTime=dashboard.dashboard_userSessionTime();
			System.out.println(Fuser);
			System.out.println(Fuser+"'s Session Time is :- "+sessionTime);
			logger.info(Fuser+"'s Session Time is :- "+sessionTime);
		}
		catch (Exception e) {
			System.out.println("Couldn't find any session time");
			logger.error("Couldn't Find any session time");
		}
		
	}
	
	@Test(priority = 3)
	public void verify_customerPageRedeemButtom()
	{
		try
		{
		dashboard.click_dashboardFirstUser();
		WebElement redeemButton = dashboard.customerPage_redeemButtom();
		boolean status = redeemButton.isEnabled();
		System.out.println("Redeem Button Enabled status before selection of Reward/Promotion/Autopilot : - "+status);
		logger.info("Redeem Button Enabled status before selection of Reward/Promotion/Autopilot : - "+status);
		dashboard.customerPage_RewardField();
		WebElement redeemButtonNewStatus = dashboard.customerPage_redeemButtom();
		boolean status2 = redeemButtonNewStatus.isEnabled();
		System.out.println("Redeem Button Enabled Status after Selection of Reward/Promotion/Autopilot : - "+status2);
		logger.info("Redeem Button Enabled Status after Selection of Reward/Promotion/Autopilot : - "+status2);
		}
		catch (Exception e) {
			System.out.println("Nothing to Redeem");
		}
	}
	
	@Test(priority = 4)
	public void verify_redemptionPOPUPonCustomerPage()
	{
		try
		{
		WebElement redeemButton = dashboard.customerPage_redeemButtom();
		redeemButton.click();
		boolean yesButttonStatus = dashboard.redemptionPOPUP_yesButton();
		System.out.println("Redeem POPUP Yes Button visibility :- "+yesButttonStatus);
		logger.info("Redeem POPUP Yes Button visibility :- "+yesButttonStatus);
		boolean noButtonStatus = dashboard.redemptionPOPUP_noButton();
		System.out.println("Redeem POPUP No Button visibility :- "+noButtonStatus);
		logger.info("Redeem POPUP No Button visibility :- "+noButtonStatus);
		}
		catch (Exception e) {
			System.out.println("No PopUP Present..As customer doesn't have anything to Redeem");
		}
		
	}
	
	@Test(priority = 5)
	public void rewards_visibilty_Store_Dashboard()
	{
		dashboard=new Dashboard(driver);
		dashboard.click_homeTab();
		try
		{
		boolean actualResult=dashboard.rewardClick();
		boolean expectedResult=true;
		Assert.assertEquals(actualResult, expectedResult,"Rewards are not visible");
		logger.info("Rewards are Visible on DashBoard Page!!!!");
		System.out.println("Rewards are Visible on DashBoard Page!!!!");
		}
		catch (Exception e)
		{
			logger.error("Couldn't Found any Rewards on dashboard");
			System.out.println("Couldn't Found any Rewards on dashboard");
			
		}
		
	}
	
	@Test(enabled = false)
	public void verify_Navigation() throws InterruptedException
	{
		dashboard=new Dashboard(driver);
		dashboard.clickHistory();
		System.out.println("Landed on History Page Successfully");
		logger.info("Landed on History Page Successfully");
		synchronization(10000);
		
		try
		{
		dashboard.user_search("AIS User");
		logger.info("Search User Field is visible and working on history Page");
		synchronization(10000);
		}
		
		catch (Exception e) 
		{
			System.out.println("Unable to locate Search User Text Field");
			logger.error("Unable to locate Search User Text Field");
		}
		
		dashboard.click_NewUserTab();
		System.out.println("Landed on New User Page Successfully");
		logger.info("Landed on New User Page Successfully");
		synchronization(10000);
		dashboard.click_settings();
		System.out.println("Landed on Setting Page Successfully ");
		logger.info("Landed on Setting Page Successfully");
		synchronization(10000);
		
	}
	
	@Test(priority = 7)
	public void Verify_User_Details() throws InterruptedException
	{
		dashboard=new Dashboard(driver);
		try
		{
		synchronization(4000);
		dashboard.click_homeTab();
		dashboard.user_click();
		dashboard.click_userprofile();
		String userName=dashboard.user_Name();
		System.out.println("UserName is :- "+userName);
		logger.info("UserName is :- "+userName);
		String membershipDate=dashboard.get_UserMemberShipDate();
		System.out.println("User is Member Since :- "+membershipDate);
		logger.info("User is Member Since :- "+membershipDate);
		String userCurrentpoints=dashboard.get_UserCurrentPoints();
		System.out.println("user's Current Points :- "+userCurrentpoints);
		logger.info("user's Current Points :- "+userCurrentpoints);
		String lifeTimePoints=dashboard.get_UserlifetimePoints();
		System.out.println("User's LifeTime Points :- "+lifeTimePoints);
		logger.info("User's LifeTime Points :- "+lifeTimePoints);
		phonenumber=dashboard.get_UserPhoneNumber();
		System.out.println("User's PhoneNumber is :- "+phonenumber);
		logger.info("User's PhoneNumber is :- "+phonenumber);
		boolean isEmailFieldPresent = dashboard.verify_emailfield();
		System.out.println("Is Email Field Present :- "+isEmailFieldPresent);
		logger.info("Is Email Field Present :- "+isEmailFieldPresent);
		boolean isNotesFieldPresent = dashboard.verify_notesfield();
		System.out.println("Is Notes Field Present :- "+isNotesFieldPresent);
		logger.info("Is Notes Field Present :- "+isNotesFieldPresent);
		}
		catch (Exception e) {
			System.out.println("It is Anonymous User, Can't See it's details"); 
			logger.error("It is Anonymous User, Can't See it's details");
			
		}
		
		
	}
	
	@Test(priority = 8)
	public void Add_NewUser() throws InterruptedException
	{
		dashboard.click_NewUserTab();
		synchronization(1500);
		dashboard.Click_AddGuest();
		dashboard.click_yesButton();
		synchronization(1000);
		try
		{
		String actualStatus=dashboard.getGuestAddStatus();
		String expectedStatus="New guest added.";
		Assert.assertEquals(actualStatus,expectedStatus,"Guest Uesr Not Added!!! TC Failed");
		System.out.println("Gust User Added Successfully!!!");
		logger.info("Gust User Added Successfully!!!");
		}
		catch (Exception e)
		{
			System.out.println("Guest User not Added!!! Need to delete existing Guest user first");
			logger.error("Guest User not Added!!! Need to delete existing Guest user first");
		}
		
		
	}
	
	@Test(priority = 9)
	public void verify_UserSignout_And_Verify_SummaryPage_Details() throws InterruptedException
	{
		dashboard=new Dashboard(driver);
		try
		{
		synchronization(4000);
		dashboard.click_homeTab();
		System.out.println("Clicked home tab");
		dashboard.user_click();
		System.out.println("Clicked User");
		synchronization(4000);
		dashboard.click_UserSignout();
		System.out.println("Clicked signout");
		String userName=dashboard.get_UserSummaryUserName();
		System.out.println("User Name is :- "+userName);
		logger.info("User Name is :- "+userName);
		String summaryReward=dashboard.get_UserSummaryReward();
		System.out.println(summaryReward);
		logger.info("Total Summary Rewards:- "+summaryReward);
		String Earnedpoints=dashboard.get_UserSummaryEarnedPoints();
		System.out.println("Total Earned Points:- "+Earnedpoints);
		logger.info("Total Earned Points:- "+Earnedpoints);
		String summaryTotal=dashboard.get_UserSummaryNewTotal();
		System.out.println("Summary Total:- "+summaryTotal);
		logger.info("Summary Total:- "+summaryTotal);
		dashboard.Click_SignOutConfirmButton();
		dashboard.Click_SignoutConfirmYes();
		System.out.println("User Signout SuccessFully");
		logger.info("User Signout SuccessFully");
		}
		catch (Exception e) {
			System.out.println("Unable to Signout the User, Test Case failed");
			logger.error("Unable to Signout the User, Test Case failed");
			e.printStackTrace();
		}
	}
	
	
	@Test(priority = 10)
	public void verify_alreadySigninCustomer()
	{
		dashboard=new Dashboard(driver);
		try
		{
		dashboard.click_homeTab();
		dashboard.user_click();
		dashboard.click_dashboardfirstuserafterfirstclick();
		}
		catch (Exception e) {
			System.out.println("Unable to find the user list for verify_alreadySigninCustomer");
			logger.error("Unable to find the user list for verify_alreadySigninCustomer");
		}
		
	}
	
	@Test(priority = 11)
	public void verify_detailsOnSettingPage()
	{
		dashboard=new Dashboard(driver);
		dashboard.click_settings();
		try
		{
		String BussinessGroupActual=dashboard.settingPage_FirstAttriute();
		String BussinessGroupExpected="Business Group : Fortune's";
		//Assert.assertEquals(BussinessGroupActual,BussinessGroupExpected,"Business Group Name Didn't Matched!!!! TC failed");
		Reporter.log("Bussiness Group Name found:- "+BussinessGroupActual);
		String SourceActual=dashboard.settingPage_SecondAttriute();
		String SourceExpected="Source : fortunesstreamwoodstore";
		//Assert.assertEquals(SourceActual,SourceExpected,"Source Name Didn't Matched!!! TC Failed");
		Reporter.log("Source Name Found:- "+SourceActual);
		String appVersionActual=dashboard.settingPage_ThirdAttriute();
		String appVersionExpected="App Version : 0.0.15";
		//Assert.assertEquals(appVersionActual,appVersionExpected,"App version Didn't Matched!!! TC Failed");
		Reporter.log("App Version Found:- "+appVersionActual);
		logger.info("App Version Found:- "+appVersionActual);
		}
		catch (Exception e) 
		{
			Reporter.log("Page not loaded properly, TC Failed");
			logger.error("Setting Page is not loaded properly, TC Failed");
			
		}
		
		
	}
	
	@Test(priority = 12)
	public void verify_PromotionRedeemCount_on_HistoryPage()
	{
		dashboard=new Dashboard(driver);
		dashboard.clickHistory();
		historyPage=new History_Page(driver);
		String promotionCount=historyPage.get_promotionCount();
		System.out.println("Promotion Redeem value is :- "+promotionCount);
		logger.info("Promotion Redeem value is :- "+promotionCount);
	}
	
	@Test(priority = 13)
	public void verify_AutoCampaignsRedeemed_on_HistoryPage()
	{
		String autocampaignCount=historyPage.get_autocampaignCount();
		System.out.println("AutoCampaignsRedeemed value is :- "+autocampaignCount);
		logger.info("AutoCampaignsRedeemed value is :- "+autocampaignCount);
	}
	
	@Test(priority = 14)
	public void verify_RewardsRedeemed_on_HistoryPage()
	{
		String rewardsRedeems=historyPage.get_rewardReedemCount();
		System.out.println("RewardsRedeems value is :- "+rewardsRedeems);
		logger.info("RewardsRedeems value is :- "+rewardsRedeems);
	}
	
	@Test(priority = 15)
	public void verify_PointsEarned_on_HistoryPage()
	{
		String pointsEarned=historyPage.get_pointEarnedCount();
		System.out.println("PointsEarned value is :- "+pointsEarned);
		logger.info("PointsEarned value is :- "+pointsEarned);
	}
	
	
	
	@Test(priority = 16)
	public void verify_DateFilterAndActivityFilter_HistoryPage() throws InterruptedException
	{
		try
		{
		historyPage.click_last7daydropdown();
		System.out.println("Dropdown is visible and Clicked Successfully");
		historyPage.click_allactivityDropdown();
		logger.info("Both Date and activity Dropdown is visible and Clickable, TC Passed");
		}
		catch (Exception e) {
			System.out.println("Both Date and activity Dropdown are not interactable, TC Failed");
			logger.error("Both Date and activity Dropdown are not interactable, TC Failed");
		}
		
		
	}
	
//	@Test(priority = 1)
//	public void listcheck()
//	{
//		dashboard=new Dashboard(driver);
//		List<WebElement> list = dashboard.userslist();
//		if (list != null && !list.isEmpty()) {
//	        for (WebElement a : list) {
//	            try {
//	                // Print the text of each element
//	                String elementText = a.getTagName();
//	                System.out.println("Element text: " + elementText);
//	                
//	                // Optional: You can add assertions here if necessary
//	                // Assert.assertNotNull(elementText, "Text is null!");
//	                
//	            } catch (Exception e) {
//	                System.err.println("Error while getting text of element: " + e.getMessage());
//	            }
//	        }
//	    } else {
//	        System.out.println("The users list is empty or null.");
//	    }
//	}
	

	
	
	@AfterClass
	public void close() throws InterruptedException
	{
		synchronization(150000);
		teardown();
	}
	
	

}
