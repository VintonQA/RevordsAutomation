package base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.github.javafaker.Faker;
import com.google.common.collect.ImmutableMap;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import pom_store.Dashboard;
import io.appium.java_client.*;

public class Base {

	static protected AndroidDriver driver;
	public AppiumDriverLocalService service;
	public void configureAppium() throws MalformedURLException, URISyntaxException
	{
		 service=new AppiumServiceBuilder()
				.withAppiumJS(new File("C:\\Users\\Unity\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
				.withIPAddress("127.0.0.1").usingPort(4723).withTimeout(Duration.ofSeconds(300)).build();
		//start appium server
		//service.start();
		
		UiAutomator2Options options=new UiAutomator2Options();
		options.setDeviceName("Pixel Tablet API 35");
		options.setApp("C:\\Users\\Unity\\git\\repository\\Revords\\src\\test\\resources\\StoreApp.apk");
		 driver=new AndroidDriver(new URI("http://127.0.0.1:4723").toURL(),options);
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	
	public void configureAppium2() throws MalformedURLException, URISyntaxException
	{
		 service=new AppiumServiceBuilder()
				.withAppiumJS(new File("C:\\Users\\Unity\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
				.withIPAddress("127.0.0.1").usingPort(4723).withTimeout(Duration.ofSeconds(300)).build();
		//service.start();
		
		UiAutomator2Options options=new UiAutomator2Options();
		options.setDeviceName("Pixel Tablet API 35");
		options.setApp("C:\\Users\\Unity\\git\\repository\\Revords\\src\\test\\resources\\CustomerApp.apk");
		//options.setCapability("orientation","LANDSCAPE");
		 driver=new AndroidDriver(new URI("http://127.0.0.1:4723").toURL(),options);
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	
	public void configureAppium3() throws MalformedURLException, URISyntaxException
	{
		 service=new AppiumServiceBuilder()
				.withAppiumJS(new File("C:\\Users\\Unity\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
				.withIPAddress("127.0.0.1").usingPort(4723).withTimeout(Duration.ofSeconds(300)).build();
		
		//service.start();
		UiAutomator2Options options=new UiAutomator2Options();
		options.setDeviceName("Medium Tablet API 35");
		options.setApp("C:\\Users\\Unity\\git\\repository\\Revords\\src\\test\\resources\\StoreApp.apk");
		//options.setCapability("orientation","LANDSCAPE");
		 driver=new AndroidDriver(new URI("http://127.0.0.1:4723").toURL(),options);
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		 //service.stop();
	}
	
	
	public void swipegesture(WebElement ele, String direction)
	{
		((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
			    "elementId",((RemoteWebElement)ele).getId(),
			    "direction", direction,
			    "percent", 0.30));
	}
	
	public double getFormattedAmount(String amount)
	{
		double price = Double.parseDouble(amount.substring(1));
		return price;
	}
	
	public void synchronization(long mili) throws InterruptedException
	{
		Thread.sleep(mili);
	}
	
	public void teardown()
	{
		
		driver.quit();
		//stop service(server)
		
		service.stop();
		
	}
	public static String getMobileNumber()
	{
		Faker faker=new Faker();
		String mobileNumber=faker.number().digits(10);
		return mobileNumber;
	}
	
	public void scrollIntoElement()
	{
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"SOM Vs Glam\"));"));
		
	}
	
	protected WebElement waitForElement(WebElement locator, int timeout) {
	    return new WebDriverWait(driver, Duration.ofSeconds(timeout))
	            .until(ExpectedConditions.visibilityOfElementLocated((By) locator));

	}
	
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
	
	public void disableNetwork() {
        Map<String, Object> params = new HashMap<>();
        params.put("command", "svc data disable");
        params.put("args", Collections.emptyList());
        
        try {
            driver.executeScript("mobile: shell", params);
            System.out.println("Network disabled.");
        } catch (WebDriverException e)
        {
            System.err.println("Error disabling network: " + e.getMessage());
        }
	}
	
	public void enableNetwork() {
        Map<String, Object> params = new HashMap<>();
        params.put("command", "svc data enable");
        params.put("args", Collections.emptyList());
        
        try {
            driver.executeScript("mobile: shell", params);
            System.out.println("Network enable.");
        } catch (WebDriverException e)
        {
            System.err.println("Error disabling network: " + e.getMessage());
        }
	}
	
	 public boolean isAppInstalled(String packageName) {
	        return driver.isAppInstalled(packageName);
	    }

	    public static void main(String[] args) {
	    	Base appVerifier = new Base();
	        
	        try {
	            appVerifier.configureAppium();
	            String appPackage = "com.revordscustomer.app"; // Replace with your app's package name

	            if (appVerifier.isAppInstalled(appPackage)) {
	                System.out.println("The app is installed on the device.");
	            } else {
	                System.out.println("The app is NOT installed on the device.");
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	            if (appVerifier.driver != null) {
	                appVerifier.driver.quit();
	            }
	        }
	    }
	    
	    public void enablingWifi() {
	        try {
	            // Execute the ADB command to enable Wi-Fi
	            Process process = Runtime.getRuntime().exec(new String[]{"adb", "shell", "svc", "wifi", "enable"});
	            int exitCode = process.waitFor(); // Wait for the command to complete
	            if (exitCode == 0) {
	                System.out.println("Wi-Fi has been enabled.");
	            } else {
	                System.err.println("Failed to enable Wi-Fi. Exit code: " + exitCode);
	            }
	        } catch (IOException e) {
	            System.err.println("IO error while enabling Wi-Fi: " + e.getMessage());
	            e.printStackTrace();
	        } catch (InterruptedException e) {
	            System.err.println("Process was interrupted: " + e.getMessage());
	            Thread.currentThread().interrupt(); // Restore interrupted status
	        }
	    }
	    
	    public  void disablingWifi() {
            try {
                // Execute the ADB command to disable WiFi
                Runtime.getRuntime().exec(new String[]{"adb", "shell", "svc wifi disable"});
                System.out.println("WiFi has been disabled.");
            } catch (Exception e) {
                e.printStackTrace();
            }
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

}
