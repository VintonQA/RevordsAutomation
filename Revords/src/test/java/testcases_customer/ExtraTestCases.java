package testcases_customer;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.Base;
import pom_cutomer.Customer_Dashboard_Page;
import pom_cutomer.Customer_Info_Page;
import pom_cutomer.Customer_Login_Page;

public class ExtraTestCases extends Base 
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
	
	
	
@Test(priority = 0)
public void Customer_APP_Login_Different_Location() throws InterruptedException, IOException
{
	custLogin=new Customer_Login_Page(driver);
	custLogin.enter_UserName(Base.propertyFileData("UserNameCustomer2"));
	System.out.println("UserName Entered");
	logger.info("UserName Entered");
	custLogin.enter_Password(Base.propertyFileData("Password"));
	System.out.println("Password Entered");
	logger.info("Password Entered");
	custLogin.click_loginButton();
	System.out.println("Clicked Login Button");
	logger.info("Clicked Login Button");
}

@Test(priority = 1)
public void Verify_Already_Registered_Customer_Signin_Different_Location()
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
	logger.info("Entered Old Registered Number at Different location");
	custDash.click_nextButton();
	logger.info("Clicked Login Button");
}

@Test(priority = 2)
public void Verify_OptIn_POPUP_Message_for_Old_Customer_Different_Location()
{
	String actualoptPOPUP=custDash.getoptinMessagetextDifferentlocation();
	String expectedPOPUP="You agree to receive occasional updates and promotions via text messages.*";
	Assert.assertEquals(actualoptPOPUP,expectedPOPUP,"Old Registered user didn't get Opt-In Message at New Location");
	logger.info("Old Registered User successfully logged in at New Location");
	logger.info("Old Registered user get Opt-In Message at New Location");
}


}
