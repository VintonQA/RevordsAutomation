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
	
	
	@Test(priority=0)
	public void verify_APP_is_Installed()
	{
		boolean installStatus=isAppInstalled("com.revordscustomer.app");
		System.out.println("App Installation status :- "+installStatus);
		//logger.info("App Installation status :- "+installStatus);
	}
	
	@Test(priority = 1)
	public void verify_CustoerAppLogin_with_Wrong_Credentials()
	{
		custLogin=new Customer_Login_Page(driver);
		custLogin.enter_wrongUserName();
		System.out.println("WrongUserName Entered");
		custLogin.enter_Password();
		System.out.println("WrongPassword Entered");
		custLogin.click_loginButton();
		System.out.println("Clicked Login Button");
		String actualMessage=custLogin.loginPageErrorMessage();
		String expectedMessage="Please enter valid credentials.";
		Assert.assertEquals(actualMessage,expectedMessage,"Error Message didn't Matched/Found");
		System.out.println("Login Failed!!!! Due to invalid credentials");
		//logger.info("Login Failed!!!! Due to invalid credentials");
		
	}
	
	@Test(priority = 2)
	public void verify_CustomerAppLogin_with_Valid_Credentials()
	{
		custLogin=new Customer_Login_Page(driver);
		custLogin.enter_UserName();
		System.out.println("UserName Entered");
		//logger.info("UserName Entered");
		custLogin.enter_Password();
		System.out.println("Password Entered");
		//logger.info("Password Entered");
		custLogin.click_loginButton();
		System.out.println("Clicked Login Button");
		//logger.info("Clicked Login Button");
		custDash=new Customer_Dashboard_Page(driver);
		boolean status=custDash.number1status();
		Assert.assertEquals(status,true,"User Has not landed on dashboard");
		//logger.info("Customer logged in successfully");
		System.out.println("Customer logged in successfully & Landed on Dashboard");
		//logger.info("Customer logged in successfully & Landed on Dashboard Page");
	}
	
	@Test(priority = 3)
	public void verify_Customer_SignIn_with_9_Digit_MobileNumber()
	{
		custDash=new Customer_Dashboard_Page(driver);
		custDash.press_number8();
		custDash.press_number3();
		custDash.press_number6();
		custDash.press_number5();
		custDash.press_number0();
		custDash.press_number1();
		custDash.press_number8();
		custDash.press_number4();
		custDash.press_number1();
		custDash.click_nextButton();
		boolean status=custDash.verify_dashboardPage();
		Assert.assertEquals(status,true,"User redirected to Enter Information Page");
		System.out.println("Customer Unable to SignIn with less then 10 digit mobile number");
		//logger.info("Customer Unable to SignIn with less then 10 digit mobile number");
		
	}
	
	@Test(priority = 4)
	public void visibility_TermsANDConditions()
	{
		boolean status=custDash.verify_visibility_of_TermsAndConditions();
		Assert.assertEquals(status,true);
		System.out.println("Terms And Conditions link is visible  "+status);
		//logger.info("Terms And Conditions link is visible  "+status);
	}
	
	@Test(priority = 5)
	public void clickability_TermsANDConditions()
	{
		String TermsPageTitle=custDash.verify_TermsANDCondition_IsClickable();
		Assert.assertEquals(TermsPageTitle,"Terms & Privacy Policy","Customer not landed on Terms AND Conditions Page");
		//logger.info("Customer landed on Terms AND Conditions Page");
		custDash.close_privacypage();
		//logger.info("Terms and Conditions Page is Closed");
	}
	
	
	@Test(priority = 6)
	public void verify_Cust_SignIn_with_New_MobileNumber_10_Digit()
	{
		custDash=new Customer_Dashboard_Page(driver);
		custDash.press_number8();
		custDash.press_number3();
		custDash.press_number6();
		custDash.press_number5();
		custDash.press_number0();
		custDash.press_number1();
		custDash.press_number8();
		custDash.press_number4();
		custDash.press_number1();
		custDash.press_number0();
		custDash.click_nextButton();
	}
	
	@Test(priority = 7)
	public void verify_promotionalMessage_POPUP()
	{
		custInfo=new Customer_Info_Page(driver);
		custInfo.click_yesButtonPromotionalPage();
		custInfo.click_checkBoxPromotionalPage();
		custInfo.click_letsStartPromotionalPOPUP();
	}
	
}
