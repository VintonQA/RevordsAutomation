package testcases_customer;

import java.net.MalformedURLException;
import java.net.URISyntaxException;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import base.Base;
import pom_cutomer.Customer_Dashboard_Page;
import pom_cutomer.Customer_Info_Page;
import pom_cutomer.Customer_Login_Page;

@Listeners(listners.Listner_Revords.class)
public class TC_Class2 extends Base
{
	Customer_Info_Page custInfo;
	Customer_Dashboard_Page custDash;
	Customer_Login_Page custLogin;
	public static Logger logger;
	
	@BeforeClass
	public void startup() throws MalformedURLException, URISyntaxException
	{
		configureAppium2();
		logger=Logger.getLogger("Revords");
		PropertyConfigurator.configure("log4j.properties");
	}
	
	
	
	@Test(priority = 2)
	public void Customer_Login()
	{
		custLogin=new Customer_Login_Page(driver);
		custLogin.enter_UserName();
		System.out.println("UserName Entered");
		//logger.info("UserName Entered");
		custLogin.enter_Password();
		System.out.println("Password Entered");
		custLogin.click_loginButton();
		System.out.println("Clicked Login Button");
		custDash=new Customer_Dashboard_Page(driver);
		boolean status=custDash.number1status();
		Assert.assertEquals(status,true,"User Has not landed on dashboard");
		System.out.println("Customer logged in successfully & Landed on Dashboard");
		//logger.info("Customer logged in successfully & Landed on Dashboard Page");
	}
	
	
	
	@Test(priority = 6)
	public void Existing_Customer_Entering_MobileNumber()
	{
		custDash=new Customer_Dashboard_Page(driver);
		custDash.press_number8();
		custDash.press_number3();
		custDash.press_number6();
		custDash.press_number5();
		custDash.press_number0();
		custDash.press_number1();
		custDash.press_number8();
		custDash.press_number5();
		custDash.press_number1();
		custDash.press_number1();
		custDash.click_nextButton();
		logger.info("Existing Customer entered Mobile Number");
		System.out.println("Existing Customer entered Mobile Number\"");
	}
	
	@Test(priority = 7)
	public void verify_Already_Signed_in_Message()
	{
		String actualText=custDash.alreadysignedinCustomer();
		String expectedText="You're already signed in!";
		Assert.assertEquals(actualText, expectedText,"Text didnt matched TC Failed");
		logger.info("Customer is already Signed In");
		System.out.println("Customer is already Signed In");
	}
	
	@Test(priority = 8)
	public void verify_NetworkLost_Icon_Customer_Tab() throws InterruptedException
	{
		disablingWifi();
		synchronization(10000);
		logger.info("Disabling Wifi at Dashboard in Customer Tab");
	}
	
	@Test(priority = 9, dependsOnMethods = {"verify_NetworkLost_Icon_Customer_Tab"})
	public void verify_BackButton_NetworkLostScreen_CustomerTab()
	{
		boolean backButtonStatus = custDash.check_networkLost_Backbutton();
		if(backButtonStatus==true)
		{
			custDash.click_networkLost_BackButton();
			System.out.println("Network lost backbutton is clicked");
			logger.info("BackButton is clicked after NetworkLost in Customer Tab");
			
		}
		else
		{
			System.out.println("Network lost back button is not visible");
			logger.error("Backbutton is not visible after Network Lost in Customer Tab");
		}
	}
	
	@Test(priority = 10)
	public void enable_wifi_CustomerTab() throws InterruptedException
	{
		try
		{
		enablingWifi();	
		synchronization(10000);
		System.out.println("Wifi/Network is Enabled");
		logger.info("Wifi/Network is enabled in Customer Tab ");
		}
		catch (Exception e) {
			logger.error("Unable to enable Wifi/Network in Customer Tab");
		}
	}
	
	@Test(priority = 11)
	public void Click_EnterButton_After_ConnectionRestore_CustomerTab()
	{
		try
		{
		custDash.click_nextButton();
		String verifyDashboard=custDash.dashboardElement();
		Assert.assertEquals(verifyDashboard,"Instantly redeem points at the store.","Unable to land on Dashboard");
		System.out.println("Next Button is clicked on dashboard after connection restore");
		logger.info("Next Button is clicked on dashboard after connection restore in Customer Tab");
		}
		catch (Exception e) {
			logger.error("Next Button is not Visible at Dashboard after Connection Restore");
		}
	}
	
}
