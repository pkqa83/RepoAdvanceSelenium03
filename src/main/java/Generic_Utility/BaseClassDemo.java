package Generic_Utility;

import org.openqa.selenium.WebDriver;


import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class BaseClassDemo {


	public static WebDriver driver;
	public FileUtility flib;
	public WebDriverUtility wlib;
	public JavaUtility jlib;
	public ExcelUtility elib;
	
	@BeforeSuite
	public void BS() {
		System.out.println("DataBase connection");
	}

	@BeforeTest
	public void BT() {
		System.out.println("Parallel execution");
	}

	@BeforeClass
	public void BC() throws Throwable {
		System.out.println("Launching Browser");
	}

	@BeforeMethod
	public void BM() {
		System.out.println("Login to App");
	}

	@AfterMethod
	public void AM() {
		System.out.println("Logout from App");
	}

	@AfterClass
	public void AC() {
		System.out.println("Close the browser");
	}

	@AfterTest
	public void AT() {
		System.out.println("Parallel execution");
	}

	@AfterSuite
	public void AS() {
		System.out.println("DataBase Connection close");
	}

}
