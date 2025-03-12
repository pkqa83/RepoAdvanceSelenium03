package VTIGER.DDT.Organization;

import java.io.FileInputStream;

import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.deser.Deserializers.Base;

import Generic_Utility.BaseClass;
import Generic_Utility.ExcelUtility;
import Generic_Utility.FileUtility;
import Generic_Utility.JavaUtility;
import Generic_Utility.WebDriverUtility;
import POM_REPO.CreateOrganizationPage;
import POM_REPO.HomePage;
import POM_REPO.LoginPage;
import POM_REPO.OrganizationInfoPage;
import POM_REPO.OrganizationsPage;

//Login to vtiger application->click on organizations link->
//click on create organization lookup image->
//Enter organisation name,phone number and email->
//click on save Btn->verify whether the organization is created in Organization Information page
//and Logout from the application. 



public class CreateOrganizationTest extends BaseClass {
	
	@Test
	public void createOrganization() throws Throwable {
		

  		String ORG_NAME = elib.getExcelData("sheet1", 4, 2) + jlib.getRandomNum(1000) ;

//      format phone cell value to string  		
        String ORG_PHONE = elib.getExcelDataUsingDataFormatter("sheet1", 5, 2);  
		String ORG_EMAIL = elib.getExcelDataUsingDataFormatter("sheet1", 6, 2);       



//	    click on Organizations link
	    HomePage hp = new HomePage(driver);
	    hp.clickOrganizationsLink();
	    
//	    click on create new Organization button
	    OrganizationsPage op = new OrganizationsPage(driver);
	    op.clickCreateOrganizationButton();
	    
//	    set new org details (name,email and phone and click on save)
	    CreateOrganizationPage cop = new CreateOrganizationPage(driver);
	    cop.createOrg(ORG_NAME,ORG_EMAIL,ORG_PHONE);
	    
//      verify org created
	    OrganizationInfoPage oip = new OrganizationInfoPage(driver);
	    String actualOrgName = oip.validateOrg();
	    Assert.assertEquals(actualOrgName, ORG_NAME);
	    System.out.println("Org name verified: "+actualOrgName);

	    
	
	}

}







/*
 public class CreateOrganization {
	
	
	public static void main(String[] args) throws Throwable {
		

		
//		get common data from property file
		
		FileUtility flib = new FileUtility();
		
		String BROWSER = flib.getCommonData("browser");
		String URL = flib.getCommonData("url");
		String USERNAME = flib.getCommonData("username");
		String PASSWORD = flib.getCommonData("password");

//		get test data from excel file : campName, phoneNo, email
		
//		to generate random org name becase the website wont accept duplicate org names
		ExcelUtility elib = new ExcelUtility();		
        JavaUtility jlib = new JavaUtility();
        
        int ranNoCampaign = jlib.getRandomNum(1000);        
  		String ORG_NAME = elib.getExcelData("sheet1", 4, 2) + ranNoCampaign ;

//      format phone cell value to string  		
        String ORG_PHONE = elib.getExcelDataUsingDataFormatter("sheet1", 5, 2);  
		String ORG_EMAIL = elib.getExcelDataUsingDataFormatter("sheet1", 6, 2);       

		
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
	    wlib.implicitlyWait(15);	
	    driver.manage().window().maximize();
	    driver.get(URL);
	    
//      login
	    LoginPage lp = new LoginPage(driver);
	    lp.login(USERNAME, PASSWORD);
	    
//	    click on Organizations link
	    HomePage hp = new HomePage(driver);
	    hp.clickOrganizationsLink();
	    
//	    click on create new Organization button
	    OrganizationsPage op = new OrganizationsPage(driver);
	    op.clickCreateOrganizationButton();
	    
//	    set new org details (name,email and phone and click on save)
	    CreateOrganizationPage cop = new CreateOrganizationPage(driver);
	    cop.createOrg(ORG_NAME,ORG_EMAIL,ORG_PHONE);
	    
//      verify org created
	    OrganizationInfoPage oip = new OrganizationInfoPage(driver);
	    oip.validateOrg(ORG_NAME);
	    
//	    logout
	    hp.logout();
	    
	
	}

}

 */






/*
public class CreateOrganization {
	
	
	public static void main(String[] args) throws Throwable {
		

		
//		get common data from property file
		
		FileUtility flib = new FileUtility();
		
		String BROWSER = flib.getCommonData("browser");
		String URL = flib.getCommonData("url");
		String USERNAME = flib.getCommonData("username");
		String PASSWORD = flib.getCommonData("password");

//		get test data from excel file : campName, phoneNo, email
		
//		to generate random org name becase the website wont accept duplicate org names
		ExcelUtility elib = new ExcelUtility();		
        JavaUtility jlib = new JavaUtility();
        
        int ranNoCampaign = jlib.getRandomNum(1000);        
  		String ORG_NAME = elib.getExcelData("sheet1", 4, 2) + ranNoCampaign ;

//      format phone cell value to string  		
        String ORG_PHONE = elib.getExcelDataUsingDataFormatter("sheet1", 5, 2);  
		String ORG_EMAIL = elib.getExcelDataUsingDataFormatter("sheet1", 6, 2);       

		
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
	    wlib.implicitlyWait(15);	    
	    driver.get(URL);
	    
	    
	    
	    driver.findElement(By.name("user_name")).sendKeys(USERNAME);
	    driver.findElement(By.name("user_password")).sendKeys(PASSWORD, Keys.ENTER);
	    
	    driver.findElement(By.linkText("Organizations")).click();
	    
	    driver.findElement(By.xpath("//img[@title=\"Create Organization...\"]")).click();
	    
	    driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(ORG_NAME);
	    driver.findElement(By.id("phone")).sendKeys(ORG_PHONE);
	    driver.findElement(By.id("email1")).sendKeys(ORG_EMAIL);
	    
	    driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	    
	    
	    WebElement org_info_name = driver.findElement(By.id("dtlview_Organization Name"));
	    if(org_info_name.getText().equals(ORG_NAME)) {
	    	System.out.println("org created");
	    	
	    }
	    
	    
	    Actions a = new Actions(driver);
	    
	    WebElement dropdown = driver.findElement(By.xpath("//span[text()=' Administrator']/../following-sibling::td"));
	    
	    a.moveToElement(dropdown)
	     .pause(Duration.ofSeconds(1))
	     .moveToElement(driver.findElement(By.linkText("Sign Out")))
	     .click()
	     .build()
	     .perform();
	    
	    
	    
	    
	  
	    
	    
	    	
	}

}

 
 */
