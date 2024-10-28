package testcases_store;

import java.net.MalformedURLException;
import java.net.URISyntaxException;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import base.Base;
import pom_store.Dashboard;
import pom_store.History_Page;
import pom_store.Login_Page;
import pom_store.SignUP_Page;

@Listeners(listners.Listner_Revords.class)
public class TC_Class4 extends Base
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
	public void login() throws InterruptedException
	{
		loginPage=new Login_Page(driver);
		logger.info("Entering UserName");
		loginPage.enterUserName();
		synchronization(1500);
		logger.info("Entering Password");
		loginPage.enterPassword();
		logger.info("Clicking Login Button");
		loginPage.clickLogin();
		synchronization(2000);
	}
	
	@Test(priority = 1)
	public void disablewifi() throws InterruptedException
	{
		disablingWifi();
		synchronization(10000);
		logger.info("Disabling Wifi at Home Page");
	}
	
	@Test(priority = 2 , dependsOnMethods = {"disablewifi"})
	 public void pressBackButton_Lostwifi() throws InterruptedException
     {
         dashboard=new Dashboard(driver);
        boolean status=dashboard.check_network_Lost_BackButton();
        if(status==true)
        {
        	dashboard.click_network_Lost_BackButton();
        	System.out.println("Network Lost Backbutton is clicked");
        	logger.info("Clicked BackButton when Wifi is not present");
        	
        }
        else
        {
        	System.out.println("Network Lost backButton is not visible");
        }
     }
	
	@Test(priority = 3)
	public void enablewifi() throws InterruptedException
	{
		enablingWifi();	
		synchronization(10000);
		logger.info("Enabling Wifi...");
	}
	
	@Test(priority = 4)
	public void click_homeTab_After_Connection_Restore()
	{
		dashboard.click_homeTab();
    	System.out.println("HomeTab is Visible and Clicked After Network Restore");
    	logger.info("Clicked Home Tab after Connection Restore");
    	dashboard.clickHistory();
	}
	
	@Test(priority = 5)
	public void disablewifi2() throws InterruptedException
	{
		disablingWifi();
		synchronization(10000);
		logger.info("Disabling Wifi at History Tab");
	}
	
	@Test(priority = 6 , dependsOnMethods = {"disablewifi2"})
	 public void pressBackButton_Lostwifi2() throws InterruptedException
    {
        dashboard=new Dashboard(driver);
       boolean status=dashboard.check_network_Lost_BackButton();
       if(status==true)
       {
       	dashboard.click_network_Lost_BackButton();
       	System.out.println("Network Lost Backbutton is clicked");
       	logger.info("Clicked BackButton when Wifi is not present");
       	
       }
       else
       {
       	System.out.println("Network Lost backButton is not visible");
       }
    }
	
	@Test(priority = 7)
	public void enablewifi2() throws InterruptedException
	{
		enablingWifi();	
		synchronization(10000);
		logger.info("Enabling Wifi...");
	}
	
	@Test(priority = 8)
	public void click_historyTab_After_Connection_Restore()
	{
		dashboard.clickHistory();
    	System.out.println("History Tab is Visible and Clicked After Network Restore");
    	logger.info("History Tab is Visible and Clicked After Network Restore");
    	dashboard.click_NewUserTab();
	}
	
	
	@Test(priority = 9)
	public void disablewifi3() throws InterruptedException
	{
		disablingWifi();
		synchronization(10000);
		logger.info("Disabling Wifi at New Tab");
	}
	
	@Test(priority = 10 , dependsOnMethods = {"disablewifi3"})
	 public void pressBackButton_Lostwifi3() throws InterruptedException
   {
       dashboard=new Dashboard(driver);
      boolean status=dashboard.check_network_Lost_BackButton();
      if(status==true)
      {
      	dashboard.click_network_Lost_BackButton();
      	System.out.println("Network Lost Backbutton is clicked");
      	logger.info("Clicked BackButton when Wifi is not present");
      	
      }
      else
      {
      	System.out.println("Network Lost backButton is not visible");
      }
   }
	
	@Test(priority = 11)
	public void enablewifi3() throws InterruptedException
	{
		enablingWifi();	
		synchronization(10000);
		logger.info("Enabling Wifi...");
	}
	
	@Test(priority = 12)
	public void click_NewTab_After_Connection_Restore()
	{
		dashboard.click_NewUserTab();
    	System.out.println("NewUser Tab is Visible and Clicked After Network Restore");
    	logger.info("NewUser Tab is Visible and Clicked After Network Restore");
    	dashboard.click_settings();
	}
	
	@Test(priority = 13)
	public void disablewifi4() throws InterruptedException
	{
		disablingWifi();
		synchronization(10000);
		logger.info("Disabling Wifi at Setting Tab");
	}
	
	@Test(priority = 14 , dependsOnMethods = {"disablewifi4"})
	 public void pressBackButton_Lostwifi4() throws InterruptedException
  {
      dashboard=new Dashboard(driver);
     boolean status=dashboard.check_network_Lost_BackButton();
     if(status==true)
     {
     	dashboard.click_network_Lost_BackButton();
     	System.out.println("Network Lost Backbutton is clicked");
     	logger.info("Clicked BackButton when Wifi is not present");
     	
     }
     else
     {
     	System.out.println("Network Lost backButton is not visible");
     }
  }
	
	@Test(priority = 15)
	public void enablewifi4() throws InterruptedException
	{
		enablingWifi();	
		synchronization(10000);
		logger.info("Enabling Wifi...");
	}
	
	@Test(priority = 16)
	public void click_SettingTab_After_Connection_Restore()
	{
		dashboard.click_settings();
    	System.out.println("Setting Tab is Visible and Clicked After Network Restore");
    	logger.info("Setting Tab is Visible and Clicked After Network Restore");
    	
	}
	
}
