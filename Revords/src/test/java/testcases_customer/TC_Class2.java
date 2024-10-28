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
		logger.info("UserName Entered");
		custLogin.enter_Password();
		System.out.println("Password Entered");
		custLogin.click_loginButton();
		System.out.println("Clicked Login Button");
		custDash=new Customer_Dashboard_Page(driver);
		boolean status=custDash.number1status();
		Assert.assertEquals(status,true,"User Has not landed on dashboard");
		System.out.println("Customer logged in successfully & Landed on Dashboard");
		logger.info("Customer logged in successfully & Landed on Dashboard Page");
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
	}
	
	@Test(priority = 7)
	public void verify_Already_Signed_in_Message()
	{
		String actualText=custDash.alreadysignedinCustomer();
		String expectedText="You're already signed in!";
		Assert.assertEquals(actualText, expectedText,"Text didnt matched TC Failed");
		logger.info("Customer is already Signed In");
	}
	
	
	
}
