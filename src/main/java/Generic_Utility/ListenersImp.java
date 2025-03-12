package Generic_Utility;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;


public class ListenersImp extends BaseClassForListernersImp implements ITestListener{  // base class extended for to get driver
	
//	Listener : testNG feature used to capture runtime events and perform appropriate action based on event type
	
//	ITestListener : ListnersImp will implement ItestListerner methods
	
	public void onTestFailure(ITestResult result) {
		
		// the driver that takes the screenshot must be the same instance of driver in base class
		// for that we have made driver field static in BaseClassForListenerImp.
		// static field has the same value for any instance hence, the driver instance we use here is same as in BaseClassForListenerImp 
		TakesScreenshot ts = (TakesScreenshot)BaseClassForListernersImp.driver; 
		
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File("./FailedScript.png");
		
		try {
			FileUtils.copyFile(src, dest);
		} catch (IOException e) {			
			e.printStackTrace();
		}
		
	}
	
	

}
 