package testcases_store;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import base.Base;
import pom_store.Dashboard;
import pom_store.First_User_Details;
import pom_store.History_Page;
import pom_store.Login_Page;
import pom_store.New_Page;
import pom_store.SignUP_Page;

@Listeners(listners.Listner_Revords.class)
public class TC_Class5 extends Base {
	public static Logger logger;
	Login_Page loginPage;
	Dashboard dashboard;
	History_Page historyPage;
	SignUP_Page signupPage;
	First_User_Details fdetails;
	New_Page newPage;
	
	
	WebDriverWait wait;
	String phoneNumber;
	String phoneNumber1;
	
	@BeforeClass
	public void startup() throws MalformedURLException, URISyntaxException
	{
		configureAppium();
		logger=Logger.getLogger("Revords");
		PropertyConfigurator.configure("log4j.properties");
		
	}
	
	@Test(priority = 0)
	public void login_StoreTab() throws InterruptedException, IOException
	{
		loginPage=new Login_Page(driver);
		loginPage.enterUserName(Base.propertyFileData("UserNameStore1"));
		loginPage.enterPassword(Base.propertyFileData("Password"));
		loginPage.clickLogin();
		logger.info("Logged in Successfully");
	}
	
	@Test(priority = 1)
	public void get_AlreadySignedIn_User_PhoneNumber_From_Dashboard() throws InterruptedException
	{
		dashboard=new Dashboard(driver);
		dashboard.click_homeTab();
		dashboard.click_dashboardFirstUser();;
		dashboard.click_userprofile();
		logger.info("Clicked first User from Dashboard");
		Thread.sleep(2000);
		fdetails=new First_User_Details(driver);
		phoneNumber=fdetails.getuserPhoneNumber();
		System.out.println(phoneNumber);
		logger.info("Already Signed In User's Mobile Number is :- "+phoneNumber1);
	}
	
	@Test(priority = 2)
	public void process_MobileNumber()
	{
	       phoneNumber1 = phoneNumber.replaceAll("[^0-9]", "");
	       System.out.println("Cleaned: " + phoneNumber1); 
	}
	
	@Test(priority = 3)
	public void enter_MobileNumber_of_AlreadySignedInUser_At_New_Page() throws InterruptedException
	{
		newPage=new New_Page(driver);
		newPage.clickNewTab();
		Thread.sleep(2000);
		
		for(int i=0;i<=phoneNumber1.length()-1;i++)
		{
			char j = phoneNumber1.charAt(i);
			int k = Character.getNumericValue(j);
			switch(k)
			{
			case 0:
				newPage.clickNumber0();
				break;
			case 1:
				newPage.clickNumber1();
				break;
			case 2:
				newPage.clickNumber2();
				break;
			case 3:
				newPage.clickNumber3();
				break;
			case 4:
				newPage.clickNumber4();
				break;
			case 5:
				newPage.clickNumber5();
				break;
			case 6:
				newPage.clickNumber6();
				break;
			case 7:
				newPage.clickNumber7();
				break;
			case 8:
				newPage.clickNumber8();
				break;
			case 9:
				newPage.clickNumber9();
				break;
			}
		}
		
		logger.info("Entered this Number at New Page :- "+phoneNumber1);
		
	}
	
	@Test(priority = 4)
	public void verify_ErrorMessage()
	{
		newPage.clickContinueButton();
		String errMsg=newPage.getErrorMessage();
		System.out.println(errMsg);
		Assert.assertEquals(errMsg,"The member is already signed in.","Error Message is not matched TC Failed!!!!");
		logger.info("This "+phoneNumber1+" is already Signed IN");
		logger.info("Getting this message :- "+errMsg);
	}

}
