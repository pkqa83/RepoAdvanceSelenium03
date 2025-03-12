package Generic_Utility;

import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;










public class ExtentReport implements ITestListener{
		
	
	ExtentReports report;
	ExtentTest test;
	

	@Override
	public void onTestStart(ITestResult result) {
		
		test = report.createTest(result.getMethod().getMethodName());
		
	}
	
	
	
	
	
	@Override
	public void onTestSuccess(ITestResult result) {
		
		test.log(Status.PASS, result.getMethod().getMethodName());
		test.log(Status.PASS, result.getThrowable());
	}
	
	
	
	
	
	
	@Override
	public void onTestFailure(ITestResult result) {
		
		test.log(Status.FAIL, result.getMethod().getMethodName());
		test.log(Status.FAIL, result.getThrowable());
		
		String screenshot = WebDriverUtility.takeScreenshotEx(BaseClass.driver, result.getMethod().getMethodName());
		test.addScreenCaptureFromPath(screenshot);
		
		
		
		/*

	    public void onTestFailure(ITestResult result) {
		test.log(http://Status.FAIL, result.getMethod().getMethodName());
		test.log(http://Status.FAIL, result.getThrowable());

		String screenshot = null;
		try {
			screenshot = WebDriver_Utility.takeScreenShotEx(BaseClass.sdriver, result.getMethod().getMethodName());
		} catch (Throwable e) {
	     e.printStackTrace();
		}
		test.addScreenCaptureFromPath(screenshot);
	    }

		 */

		
	}
	
	
	
	
	
	
	
	public void onTestSkipped(ITestResult result) {
		test.log(Status.SKIP, result.getMethod().getMethodName());
		test.log(Status.SKIP, result.getThrowable());
		
	}

	
	
	
	
	
	


	@Override
	public void onStart(ITestContext context) {
		
		
		String time = new Date().toString().replace("","_").replace(":", "-");
		
		ExtentSparkReporter spark = new ExtentSparkReporter("ExtentReport/report.html" + time);
		spark.config().setTheme(Theme.DARK);
		spark.config().setDocumentTitle("VtigerReport");
		spark.config().setReportName("Viraj");
		
	    // Initialize report before attaching the reporter
	    report = new ExtentReports(); // Add this line

		//System configuration		
		report.attachReporter(spark);
		report.setSystemInfo("platform","windows");
		report.setSystemInfo("executedBy", "Viraj");
		report.setSystemInfo("reviewedBy", "Shobha");
		
		
	}
	
	public void onFinish(ITestContext context) {
		report.flush();
		
	}
	
	
	


	
	

}
















/*
 
 
 
 
public class ExtentReport implements ITestListener
{
	ExtentReports report;
	ExtentTest test;

	public void onTestStart(ITestResult result) {
		test = report.createTest(result.getMethod().getMethodName());
	}

	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, result.getMethod().getMethodName());
		test.log(Status.PASS, result.getThrowable());
	}

	public void onTestFailure(ITestResult result) {
		test.log(http://Status.FAIL, result.getMethod().getMethodName());
		test.log(http://Status.FAIL, result.getThrowable());

		String screenshot = null;
		try {
			screenshot = WebDriver_Utility.takeScreenShotEx(BaseClass.sdriver, result.getMethod().getMethodName());
		} catch (Throwable e) {
	e.printStackTrace();
		}
		test.addScreenCaptureFromPath(screenshot);
	}

	public void onTestSkipped(ITestResult result) {
		test.log(Status.SKIP, result.getMethod().getMethodName());
		test.log(Status.SKIP, result.getThrowable());
	}

	public void onStart(ITestContext context) {
		String time = new Date().toString().replace(" ", "_").replace(":", "_");
		ExtentSparkReporter spark = new ExtentSparkReporter("ExtentReport/Report.html" + time);
		spark.config().setTheme(Theme.DARK);
		spark.config().setDocumentTitle("VtigerReports");
		spark.config().setReportName("Shobha");

		// system configure
		report = new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("platform", "windows");
		report.setSystemInfo("executedBy", "SHOBHA");
		report.setSystemInfo("reviewedBy", "Ram");

	}

	public void onFinish(ITestContext context) {

		report.flush();
	}
}


*/