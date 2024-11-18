package testcases_store;

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
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import base.Base;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.io.File;
import java.io.IOException;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import pom_store.Dashboard;
import pom_store.Login_Page;

public class TC_Class1 extends Base
{
	
	Login_Page loginPage;
	Dashboard dashboard;
	
	@BeforeMethod
	public void startProcess() throws MalformedURLException, URISyntaxException, InterruptedException
	{
		configureAppium();
		
//		Thread.sleep(2000);
//		loginPage=new Login_Page(driver);
//		loginPage.enterUserName();
//		Thread.sleep(1500);
//		loginPage.enterPassword();
//		Thread.sleep(1500);
//		loginPage.clickLogin();
//		Thread.sleep(10000);
//		dashboard=new Dashboard(driver);
	}
	
	
	
	
	@Test(priority = 1)
	public void loginTest() throws InterruptedException, IOException
	{
		loginPage=new Login_Page(driver);
		loginPage.enterUserName(Base.propertyFileData("UserNameStore1"));
		Thread.sleep(1500);
		loginPage.enterPassword(Base.propertyFileData("Password"));
		Thread.sleep(1500);
		loginPage.clickLogin();
		Thread.sleep(10000);
		Reporter.log("Login Success!!!! TC Passed");
		System.out.println("Login Button is clickable");
		driver.quit();
	}
	
	@Test(enabled = false)
	public void forgetPassword()
	{
		loginPage.clickForgetPassword();
		
	}
	
	@Test(priority = 2)
	public void HomePageVerify() throws InterruptedException, IOException
	{
		loginPage=new Login_Page(driver);
		loginPage.enterUserName(Base.propertyFileData("UserNameStore1"));
		Thread.sleep(1500);
		loginPage.enterPassword(Base.propertyFileData("Password"));
		Thread.sleep(1500);
		loginPage.clickLogin();
		Thread.sleep(10000);
		System.out.println("Logged in succcessfully");
		
//		try
//		{
//		Assert.assertEquals(actualResult,expectedResult);
//		System.out.println("User Landed on Home Page Successfully.TC Passed!!!!");
//		}
//		catch(Exception e)
//		{
//			System.out.println("Result not matched.TC Failed!!!!");
//		}
		
		
	}
	
	@Test(enabled = false)
	public void Verify_Home_Page_Rewards_Visibilty() throws InterruptedException
	{
		String actualResult=dashboard.rewardsText();
		String expectedResult="Reward";
		try
		{
		Assert.assertEquals(actualResult,expectedResult);
		System.out.println("Results Matched,Rewards are visibile on page.TC Passed");
		}
		catch(Exception e)
		{
			System.out.println("Results are not matched.TC failed");
		}
		
		boolean buttonStatus=dashboard.rewardClick();
		Assert.assertEquals(buttonStatus,true);
		System.out.println("Rewards are present and visible");
	}
	
	@Test()
	public void verify_Pramotions()
	{
		dashboard=new Dashboard(driver);
	String actualResult=dashboard.verify_HomePage();
	String expectedResult="Home";
	System.out.println(actualResult);
	}
	
		
	
	
	
	@AfterClass
	public void endProcess() throws InterruptedException
	{
		Thread.sleep(9000);
		teardown();
	}

}
