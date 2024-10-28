package testcases_customer;

import java.net.MalformedURLException;
import java.net.URISyntaxException;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import base.Base;
import pom_cutomer.Customer_Info_Page;
import pom_cutomer.Customer_Dashboard_Page;
import pom_cutomer.Customer_Login_Page;

@Listeners(listners.Listner_Revords.class)
public class TC_Class1 extends Base
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
		logger.info("App Installation status :- "+installStatus);
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
		logger.info("Login Failed!!!! Due to invalid credentials");
		
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
		logger.info("Clicked Login Button");
		custDash=new Customer_Dashboard_Page(driver);
		boolean status=custDash.number1status();
		Assert.assertEquals(status,true,"User Has not landed on dashboard");
		logger.info("Customer logged in successfully");
		System.out.println("Customer logged in successfully & Landed on Dashboard");
		logger.info("Customer logged in successfully & Landed on Dashboard Page");
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
		logger.info("Customer Unable to SignIn with less then 10 digit mobile number");
		
	}
	
	@Test(priority = 4)
	public void visibility_TermsANDConditions()
	{
		boolean status=custDash.verify_visibility_of_TermsAndConditions();
		Assert.assertEquals(status,true);
		System.out.println("Terms And Conditions link is visible  "+status);
		logger.info("Terms And Conditions link is visible  "+status);
	}
	
	@Test(priority = 5)
	public void clickability_TermsANDConditions()
	{
		String TermsPageTitle=custDash.verify_TermsANDCondition_IsClickable();
		Assert.assertEquals(TermsPageTitle,"Terms & Privacy Policy","Customer not landed on Terms AND Conditions Page");
		logger.info("Customer landed on Terms AND Conditions Page");
		custDash.close_privacypage();
		logger.info("Terms and Conditions Page is Closed");
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
		custInfo=new Customer_Info_Page(driver);
		String actualResult=custInfo.bannerText();
		String expectedResult="Enter Your Information";
		Assert.assertEquals(actualResult,expectedResult,"customer Not redirected to Information page");
		logger.info("Customer is logged in Successfully using 10 digit Mobile Number");
		System.out.println("Customer redirected to information page");
		logger.info("Customer is redirected to Enter Information Page");
	}
	
	@Test(priority = 7)
	public void verify_NameTextBox_InformationPage()
	{
		custInfo=new Customer_Info_Page(driver);
		custInfo.enter_CustomerName();
		logger.info("Entered Customer Name on Information Page");
		System.out.println("Entered Customer Name");
	}
	
	@Test(priority = 8)
	public void verify_EmailTextBox_InformationPage()
	{
		custInfo.enter_customerEmail();
		logger.info("Entered Customer Email ID on Information Page");
		System.out.println("Entered Customer Email ID");
	}
	
	@Test(priority = 9)
	public void verify_customer_BirthMonth_dropdown() throws InterruptedException
	{
		custInfo.choose_custBirthMonth();
		System.out.println("Clicked on birth Month");
		logger.info("Customer clicked on Month DropDown");
//		custInfo=new Customer_Info_Page(driver);
//		custInfo.choose_birthMonth();
		
	}
	@Test(priority = 10)
	public void customer_choose_BirthMonth()
	{
		try
		{
		custInfo.choose_birthMonth();
		System.out.println("Customer is able to choose Birth month");
		logger.info("Customer choosed Birth Month");
		
		}
		catch (Exception e) {
			System.out.println("unable to choose birth month");
		}
	}
	
//	@Test(priority = 10)
//	public void verify_Customer_BirthDate()
//	{
//		custInfo.choose_custBirthDate();
////		custInfo.choose_birthDate();
////		System.out.println("Customer is able to choose Birth Date");
//	}
	
	@Test(priority = 11)
	public void customer_choose_BirthDate()
	{
		custInfo.choose_custBirthDate();
		logger.info("Customer clicked on Datedrop Down");
		custInfo.choose_birthDate();
		logger.info("Customer Choosed birth date");
		System.out.println("Customer is able to choose Birth Date");
		custInfo.click_OKButton_dateDropDown();
		System.out.println("Date is selected from Date dropdown");
	}
	
	@Test(priority = 12)
	public void verify_YES_NO_Button_InformationPage()
	{
		custInfo.choose_optINSMS();
		custInfo.choose_optOutSMS();
		System.out.println("Opt-in And Opt-out Radio Buttons are visible and clickable");
		logger.info("Opt-in And Opt-out Radio Buttons are visible and clickable");
	}
	
	@Test(priority = 13)
	public void verify_Age_CheckBox()
	{
		try
		{
			custInfo.check_custAgeCheckBox();
			System.out.println("Customer Age CheckBox checked Successfully");
			//logger.info("Customer Age CheckBox checked Successfully");
		}
		catch (Exception e) 
		{
			System.out.println("Customer Age CheckBox is not visible/checked");
		}
		
		
	}
	
	@Test(priority = 14)
	public void click_letsStartButton()
	{
		custInfo.click_letsStartButton();
		System.out.println("Lets Start Button is Clicked");
		logger.info("Lets Start Button is Clicked");
	}
	
	
//	@Test(priority = 15)
//	public void verify_Optout_POPUP()
//	{
//		
//		String actualText=custInfo.optoutpopup();
//		String expectedText="Are you sure you don't want to opt-in ?";
//		try
//		{
//		Assert.assertEquals(actualText,expectedText,"Unable to see the POP UP");
//		System.out.println("POPUP Appeared for opt-out");
//		//logger.info("POP Appeared for opt-out");
//		}
//		catch (Exception e) {
//			System.out.println("POP Not Appeared for opt-out option");
//			//logger.info("POPUP Not Appeared for opt-out");
//			e.printStackTrace();
//		}
//	}
	
	@Test(priority = 15)
	public void verify_POPUP_Cancel_Button()
	{
		custInfo.click_POPUP_cancelButton();
		System.out.println("Clicked Cancel Button from POPUP");
		logger.info("Clicked Cancel Button from POPUP");
	}
	
	@Test(priority = 16)
	public void verify_POP_yesButton()
	{
		click_letsStartButton();
		custInfo.click_POPUP_yesButton();
		System.out.println("Clicked Yes Button from POPUP");
	}
	
	
	@AfterClass
	public void close() throws InterruptedException
	{
		synchronization(1500000);
		teardown();
	}
	
}


