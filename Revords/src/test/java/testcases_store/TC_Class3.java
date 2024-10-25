package testcases_store;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.time.Duration;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import java.io.FileInputStream;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.model.Report;

import base.Base;
import pom_store.Dashboard;
import pom_store.History_Page;
import pom_store.Login_Page;
import pom_store.SignUP_Page;
import revord_Utility.Utlity;


@Listeners(listners.Listner_Revords.class)
public class TC_Class3 extends Base
{
	public static Logger logger;
	Login_Page loginPage;
	Dashboard dashboard;
	History_Page historyPage;
	SignUP_Page signupPage;
	
	WebDriverWait wait;
	
	@BeforeClass
	public void startup() throws MalformedURLException, URISyntaxException
	{
		configureAppium();
		logger=Logger.getLogger("Revords");
		PropertyConfigurator.configure("log4j.properties");
		
	}
	

	
	@Test(priority = 0)
	public void verify_userDetailsEdit() throws InterruptedException
	{
		try
		{
		loginPage=new Login_Page(driver);
		logger.info("Entering UserName");
		loginPage.enterUserName();
		synchronization(1500);
		logger.info("Entering Password");
		loginPage.enterPassword();
		logger.info("Clicking Login Button");
		loginPage.clickLogin();
		dashboard=new Dashboard(driver);
		dashboard.clickHistory();
		System.out.println("Clicked History Tab");
		dashboard.click_firstUser();
		System.out.println("Clicked First User in the list");
		}
		catch (Exception e) {
			System.out.println("Something Went Wrong");
			e.printStackTrace();
		}
	}
	
	@Test()
	public void verify_UserEditFromHistoryList() throws InterruptedException
	{
		dashboard=new Dashboard(driver);
		try
		{
			dashboard.clickHistory();
			dashboard.click_firstUser();
			historyPage=new History_Page(driver);
			historyPage.enter_emailID();
			System.out.println("Entered User Email ID");
			historyPage.click_highRoller();
			System.out.println("Choosed HighRoller");
			historyPage.click_freePlayer();
			System.out.println("Choosed FreePlayer");
			historyPage.enter_usernotes();
			System.out.println("Entered User Notes");
			historyPage.click_notesHistory();
			System.out.println("Clicked notes History Button");
			historyPage.click_notesHistoryCloseButton();
			System.out.println("Clicked Notes History Close Button");
			historyPage.click_saveChangeButton();
			System.out.println("Clicked save Change Button");
			logger.info("User is editable from Histroy List");
		
		}
		catch (NoSuchElementException e) 
		{
			System.out.println("Unable to find the element !!! please try again");
			logger.info("User is not editable from History list");
		}
		catch (ElementNotInteractableException e) 
		{
			System.out.println("Element is not interectable !!! please try again");
			logger.info("User is not editable from History list");
		}
		catch (Exception e) {
			System.out.println("This is Anonymous User!! Can't Update him");
			logger.info("User is not editable from History list");
		}
	}
	
	@Test(priority = 2)
	public void Verify_SignupNewUserwith_MobileNumber() throws InterruptedException
	{
		dashboard=new Dashboard(driver);
		synchronization(30000);
		dashboard.click_NewUserTab();
		synchronization(10000);
		try
		{
		signupPage=new SignUP_Page(driver);
		signupPage.click_num9();
		signupPage.click_num5();
		signupPage.click_num6();
		signupPage.click_num1();
		signupPage.click_num1();
		signupPage.click_num7();
		signupPage.click_num8();
		signupPage.click_num0();
		signupPage.click_num9();
		signupPage.click_num8();
		System.out.println("Number Entered SuccessFully");
		logger.info("Mobile Number Entered Successfully");
		}
		catch (Exception e) {
			System.out.println("Unable to enter Mobile Number/ Fields are not visible");
			logger.info("Unable to enter Mobile Number/ Fields are not visible");
		}
		signupPage.click_continueButton();
		System.out.println("Clicked Continue Button");
		signupPage.enter_Name();
		System.out.println("Entered Name");
		signupPage.enter_Email();
		System.out.println("Entered Email");
		signupPage.click_HighRoller();
		System.out.println("Clicked HighRoller");
		signupPage.click_freePlayer();
		System.out.println("Clicked FreePlayer");
		signupPage.enter_notes();
		System.out.println("Entered Notes");
		signupPage.click_ageradioButton();
		System.out.println("Clicked Age Radio Button");
		logger.info("New User Created successfully using mobile number");
	}
	
	@Test(priority = 3)
	public void verify_NetworkLostIcon() throws InterruptedException
	{
		dashboard=new Dashboard(driver);
		disableWifi();
		System.out.println("disabling wifi");
		logger.info("Wifi Disabled");
		disableNetwork();
		System.out.println("disabling Cellular Data");
		logger.info("Cellular Data Disabled");
		synchronization(6000);
		dashboard.click_homeTab();
		logger.info("Connection Lost/No Network Available");
		
	}
	
	@Test(priority = 4)
	public void verify_RestoreNetwork() throws InterruptedException
	{
		dashboard=new Dashboard(driver);
		synchronization(2000);
		enableWifi();
		System.out.println("Enabling Wifi");
		logger.info("Wifi Enabled");
		synchronization(5000);
		enableNetwork();
		System.out.println("Enabling Cellular Data");
		logger.info("cellure data enabled");
		synchronization(6000);
		dashboard.click_homeTab();
		logger.info("Connection Restored");
	}
	
	
	@AfterClass
	public void close() throws InterruptedException
	{
		synchronization(15000);
		teardown();
	}
	
	
	
	
	

}