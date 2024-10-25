package revord_Utility;

import java.io.File;
import com.github.javafaker.Faker;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.logging.FileHandler;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Reporter;


import base.Base;
import io.appium.java_client.android.AndroidDriver;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Reporter;



import java.util.Date;
import java.util.Properties;
import base.Base;

public class Utlity extends Base 
{
	public static void takeScreenShot(AndroidDriver driver,String TCID) throws IOException
	{
		Reporter.log("Taking ScreenShot",true);
		String timeStamp=new SimpleDateFormat("dd.MM.yyyy.HH.mm.ss").format(new Date());
		File src = ((TakesScreenshot)driver).getScreenshotAs(org.openqa.selenium.OutputType.FILE);
		//File dest=new File("D:\\Revords_TestScreenShots\\"+TCID+"_"+timeStamp+".png");
		File dest=new File(System.getProperty("user.dir")+"\\Revords_TestScreenShots\\"+TCID+"_"+timeStamp+".png");
		Reporter.log("Saved ScreenShot at"+dest,true);
		FileUtils.copyFile(src, dest);
		
	}

public static String propertyFileData(String key) throws InterruptedException, IOException
	{
		Properties prop=new Properties();
		Thread.sleep(1000);
		
		FileInputStream myFile=new FileInputStream(System.getProperty("user.dir")+"\\TestData.properties");
		prop.load(myFile);
		Thread.sleep(1000);
		
		String value=prop.getProperty(key);
		return value;
	}

protected WebElement waitForElement(WebElement locator, int timeout) {
    return new WebDriverWait(driver, Duration.ofSeconds(timeout))
            .until(ExpectedConditions.visibilityOfElementLocated((By) locator));

}

//appium --allow-insecure=adb_shell (we need to run adb shell as insecure)

public void disableWifi()
{
    Map<String, Object> params = new HashMap<>();
    params.put("command", "svc wifi disable");
    params.put("args", Collections.emptyList()); 

    driver.executeScript("mobile: shell", params);
}

public void enableWifi()
{
	 Map<String, Object> params = new HashMap<>();
	    params.put("command", "svc wifi enable");
	    params.put("args", Collections.emptyList()); 

	    driver.executeScript("mobile: shell", params);
}


}
