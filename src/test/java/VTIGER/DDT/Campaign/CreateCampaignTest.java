package VTIGER.DDT.Campaign;

import org.apache.commons.lang3.Validate;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Generic_Utility.BaseClass;
import Generic_Utility.ExcelUtility;
import Generic_Utility.FileUtility;
import Generic_Utility.JavaUtility;
import Generic_Utility.WebDriverUtility;
import POM_REPO.CampaignInfoPage;
import POM_REPO.CampaignsPage;
import POM_REPO.CreateCampaignPage;
import POM_REPO.HomePage;
import POM_REPO.LoginPage;



/*
 * 3].
 * Login to vtiger application->
 * mouseOverOn more Link->
 * click on campaigns->
 * click on create campaign lookup image->
 * Enter campaignName->click on save Btn->
 * verify whether the campaign is created in campaign Information page and Logout from the application.
 */

@Listeners(Generic_Utility.ExtentReport.class)
public class CreateCampaignTest extends BaseClass {
	// modification
	// 2

	@Test//(retryAnalyzer = Generic_Utility.RetryAnalyserImp.class)
	public void createCampaign() throws Throwable {

//		get test data from excel file : campaignName and productName
		String CAMP_NAME = elib.getExcelData("sheet1", 8, 2) + jlib.getRandomNum(1000);

//	    click on Campaigns link   	    
		HomePage homePageObj = new HomePage(driver);
		homePageObj.clickCampaignsLink();

//	    click on create campagin link
		CampaignsPage campaignsPageObj = new CampaignsPage(driver);
		campaignsPageObj.clickCreateCampaignButton();

//	    create new campaign
		CreateCampaignPage createCampaignPageObj = new CreateCampaignPage(driver);
		createCampaignPageObj.createCampaign(CAMP_NAME);
		
//		Assert Fail to test retry analyzer
//		Assert.fail(" failing the test script");

//      verify campaign created  
		CampaignInfoPage campaignInfoPageObj = new CampaignInfoPage(driver);
		 
		String actualData = campaignInfoPageObj.validateCampaign();
        Assert.assertEquals(actualData,CAMP_NAME);
        System.out.println("Campaign name verified : "+actualData);
        
        
	}
}



//------------------------------------------------------------------------------------------------------------------


/*
 
 
public class CreateCampaign extends BaseClass {

	@Test
	public void createCampaign() throws Throwable {

//		get test data from excel file : campaignName and productName
		String CAMP_NAME = elib.getExcelData("sheet1", 8, 2) + jlib.getRandomNum(1000);

//	    click on Campaigns link   	    
		HomePage homePageObj = new HomePage(driver);
		homePageObj.clickCampaignsLink();

//	    click on create campagin link
		CampaignsPage campaignsPageObj = new CampaignsPage(driver);
		campaignsPageObj.clickCreateCampaignButton();

//	    create new campaign
		CreateCampaignPage createCampaignPageObj = new CreateCampaignPage(driver);
		createCampaignPageObj.createCampaign(CAMP_NAME);

//      verify campaign created  
		CampaignInfoPage campaignInfoPageObj = new CampaignInfoPage(driver);
		 
		String actualData = campaignInfoPageObj.validateCampaign();
        Assert.assertEquals(actualData,CAMP_NAME);
        System.out.println("Campaign name verified : "+actualData);
        
        
	}
}

 
 */


//-------------------------------------------------------------------------------------------------------------------
/*
 
 	
	public static void main(String[] args) throws Throwable {
		
//		get common data from property file		
		FileUtility flib = new FileUtility();
		
		String BROWSER = flib.getCommonData("browser");
		String URL = flib.getCommonData("url");
		String USERNAME = flib.getCommonData("username");
		String PASSWORD = flib.getCommonData("password");
		
		
//		get test data from excel file : campaignName and productName		
		ExcelUtility elib = new ExcelUtility();
			
        JavaUtility jlib = new JavaUtility();
        int ranNoCampaign = jlib.getRandomNum(1000);      
  		String CAMP_NAME = elib.getExcelData("sheet1", 8, 2) + ranNoCampaign ;
		

		

//	    open browser	
	    WebDriver driver ;
	    if(BROWSER.equalsIgnoreCase("Edge"))
	    {
	    	driver = new EdgeDriver();
	    	
	    }
	    else
	    {
	    	driver = new ChromeDriver();
	    }
	    
	    WebDriverUtility wlib = new WebDriverUtility(driver);
	    wlib.implicitlyWait(20);	    
	    wlib.maximizeWindow();
	    
	    driver.get(URL);

//	    login	    
	    LoginPage loginPageObj = new LoginPage(driver);
	    loginPageObj.login(USERNAME,PASSWORD);
	    
//	    click on Campaigns link   	    
	    HomePage homePageObj = new HomePage(driver);
	    homePageObj.clickCampaignsLink();
	    
//	    click on create campagin link
	    CampaignsPage campaignsPageObj = new CampaignsPage(driver);
	    campaignsPageObj.clickCreateCampaignButton();

//	    create new campaign
	    CreateCampaignPage createCampaignPageObj = new CreateCampaignPage(driver);
	    createCampaignPageObj.createCampaign(CAMP_NAME);
	    
//      verify campaign created  
	    CampaignInfoPage campaignInfoPageObj = new CampaignInfoPage(driver);
	    campaignInfoPageObj.validateCampaign(CAMP_NAME);
	    
//	    logout
        homePageObj.logout();
 */









/*
 * 
 * 
public class CreateCampaign {
	
	public static void main(String[] args) throws Throwable {
		
//		get common data from property file
		
		FileUtility flib = new FileUtility();
		
		String BROWSER = flib.getCommonData("browser");
		String URL = flib.getCommonData("url");
		String USERNAME = flib.getCommonData("username");
		String PASSWORD = flib.getCommonData("password");
		
		
//		get test data from excel file : campaignName and productName		
		ExcelUtility elib = new ExcelUtility();
			
        JavaUtility jlib = new JavaUtility();
        int ranNoCampaign = jlib.getRandomNum(1000);      
  		String CAMP_NAME = elib.getExcelData("sheet1", 8, 2) + ranNoCampaign ;
		

		

//	    open browser	
	    WebDriver driver ;
	    if(BROWSER.equalsIgnoreCase("Edge"))
	    {
	    	driver = new EdgeDriver();
	    	
	    }
	    else
	    {
	    	driver = new ChromeDriver();
	    }
	    
	    driver.get(URL);
	    WebDriverUtility wlib = new WebDriverUtility(driver);
	    wlib.implicitlyWait(20);	    
	    wlib.maximizeWindow();

	    
//	    login
	    
	    //using normal approach
//	    driver.get(URL);	    
//	    driver.findElement(By.name("user_name")).sendKeys(USERNAME);
//	    driver.findElement(By.name("user_password")).sendKeys(PASSWORD, Keys.ENTER);
 


//	    create campaign    
//	    driver.findElement(By.linkText("More")).click();
//	    driver.findElement(By.linkText("Campaigns")).click();	    
//	    driver.findElement(By.xpath("//img[@title='Create Campaign...']")).click();	 
//	    
//	    driver.findElement(By.name("campaignname")).sendKeys(CAMP_NAME);
//        driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

        
//      verify campaign created
//		WebElement CampaignName = driver.findElement(By.id("dtlview_Campaign Name"));
//		if (CampaignName.getText().equalsIgnoreCase(CAMP_NAME)) {
//			System.out.println("Campaing created : " + CAMP_NAME);
//		}
	    
	    
//      logout	    
//		driver.findElement(By.xpath("//span[text()=' Administrator']/../following-sibling::td")).click();
//		driver.findElement(By.linkText("Sign Out")).click();
	    
	    

	}

}




 * 
 * 
 * 
 * 
 * 
 * 
 * 
 */ 
