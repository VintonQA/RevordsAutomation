
package listners;

import java.io.IOException;

import org.testng.ITestListener;
import org.testng.ITestResult;


import base.Base;
import revord_Utility.*;

public class Listner_Revords extends Base implements ITestListener 
{
	@Override
	public void onTestFailure(ITestResult result) 
	{
		try {
			Utlity.takeScreenShot(driver,result.getName());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
//	@Override
//	public void onTestSuccess(ITestResult result) 
//	{
//		try {
//			Utility.takeScreenShot(driver,result.getName());
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
	
}
	
	
	


