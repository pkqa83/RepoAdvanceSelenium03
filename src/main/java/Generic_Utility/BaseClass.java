package Generic_Utility;

import java.io.IOException;
import org.testng.annotations.*;

import POM_REPO.HomePage;
import POM_REPO.LoginPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseClass {

//	public static WebDriver driver;
	public static WebDriver driver;
	
	
	
	public WebDriverUtility wlib;
	public JavaUtility jlib = new JavaUtility();
	public ExcelUtility elib = new ExcelUtility();
	
	
	
	@BeforeSuite
	public void BS() {
		System.out.println("DataBase connection");
	}

	@BeforeTest 
	public void BT() {
		System.out.println("Parallel execution");
	}

	
//	@Parameters("BROWSER")                                // takes parameters from xml file 
	@BeforeClass
	public void BC() throws IOException {   // parameter passsed to method
		
		FileUtility flib = new FileUtility();
		
		//String BROWSER = flib.getCommonData("browser"); 
		String BROWSER = System.getProperty("browser");
        if (BROWSER.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (BROWSER.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		} else if (BROWSER.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else {
			driver = new ChromeDriver();
		}
        
		     
//        if (BROWSER.equalsIgnoreCase("chrome")) {
//			driver = new ChromeDriver();
//		} else if (BROWSER.equalsIgnoreCase("edge")) {
//			driver = new EdgeDriver();
//		} else if (BROWSER.equalsIgnoreCase("firefox")) {
//			driver = new FirefoxDriver();
//		} else {
//			driver = new ChromeDriver();
//		}
//        
        wlib = new WebDriverUtility(driver);
        
		wlib.implicitlyWait(10);
		wlib.maximizeWindow();
		System.out.println("Launching Browser");
	}

	@BeforeMethod
	public void BM() throws IOException  {
		
//		navigate to website
		FileUtility flib = new FileUtility();
		String URL = flib.getCommonData("url");		
		driver.get(URL);	
		
		String USERNAME = flib.getCommonData("username");
		String PASSWORD = flib.getCommonData("password");
		
//	    login	    
	    LoginPage loginPageObj = new LoginPage(driver);
	    loginPageObj.login(USERNAME,PASSWORD);
	}

	@AfterMethod
	public void AM() {
		HomePage hp = new HomePage(driver);
		hp.logout();
	}

	@AfterClass
	public void AC() {
		driver.quit();
	
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
