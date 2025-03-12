package VTIGER.DDT.Product;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import Generic_Utility.BaseClass;
import Generic_Utility.ExcelUtility;
import Generic_Utility.FileUtility;
import Generic_Utility.JavaUtility;
import Generic_Utility.WebDriverUtility;
import POM_REPO.CreateProductPage;
import POM_REPO.HomePage;
import POM_REPO.LoginPage;
import POM_REPO.ProductInfoPage;
import POM_REPO.ProductsPage;





//5].
//Login to vtiger application->
//click on products link->
//click on create product lookup image->
//Enter product name->
//click on save Btn->
//verify whether the product is created in product Information page->
//click on product link->
//navigate to product table page ->
//select the product created checkbox->click on delete->
//Handle the Alert popup and verify product deleted or not and Logout from the application. 


/*
 * doubt : why did we write a longer xpath for list of products
 *       : (//table[@class='lvt small']/tbody/tr/td[3])[position()>1]   --> generalized xapth targetting a table divison of all rows 
 *       : smaller xpath is 
 *       : //a[@title='Products']
 *       
 *              
 *              
 * 
 */

public class ProductCreateDeleteTest extends BaseClass {
		
	
	    @Test
		public void productCreateDelete () throws EncryptedDocumentException, IOException  {
				
//			get test data from excel file productName		
			String PROD_NAME = elib.getExcelData("sheet1", 9, 2) + jlib.getRandomNum(1000) ;
					    
//		    create campaign depends on products module : without creating a product you cant add a product to campaign		    
//		    create product		    
//		    click on Products link
		    HomePage hp = new HomePage(driver);
		    hp.clickProductsLink();
		    
//		    create Product
		    ProductsPage pp = new ProductsPage(driver);
		    pp.clickCreateProductButton();
	    
		    CreateProductPage cpp = new CreateProductPage(driver);
		    cpp.createProduct(PROD_NAME);	    
		    
//		    verify product created
		    ProductInfoPage pip = new ProductInfoPage(driver);
		    String actualProductName = pip.validateProduct();
		    Assert.assertEquals(actualProductName, PROD_NAME);
		    System.out.println("Product name verified: "+actualProductName);
		    
//		    click on Products link to see the list of products	
		    hp.clickProductsLink();
		    
//          delete required product
		    pp.deleteProduct(driver, PROD_NAME);		    
		    
//		    verify if the product is deleted
		    if(pp.isPresent(PROD_NAME)) {
		    	System.out.println("product deleted");
		    }
		    else {
		    	System.out.println("proudct is not deleted and it is present in the productList");
		    }
	}
		
		
}



/*
 public class ProductCreateDelete {
		
		public static void main(String[] args) throws Throwable {
						
//			get common data from property file			
			FileUtility flib = new FileUtility();			
			String BROWSER = flib.getCommonData("browser");
			String URL = flib.getCommonData("url");
			String USERNAME = flib.getCommonData("username");
			String PASSWORD = flib.getCommonData("password");
						
//			get test data from excel file productName
			ExcelUtility elib = new ExcelUtility();			
			JavaUtility jlib = new JavaUtility();			
			String PROD_NAME = elib.getExcelData("sheet1", 9, 2) + jlib.getRandomNum(1000) ;
			
//		    open browser	
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
		    
//		    login		    	    
		    LoginPage lp = new LoginPage(driver);
		    lp.login(USERNAME,PASSWORD);	    
		    
//		    create campaign depends on products module : without creating a product you cant add a product to campaign		    
//		    create product		    
//		    click on Products link
		    HomePage hp = new HomePage(driver);
		    hp.clickProductsLink();
		    
//		    create Product
		    ProductsPage pp = new ProductsPage(driver);
		    pp.clickCreateProductButton();
	    
		    CreateProductPage cpp = new CreateProductPage(driver);
		    cpp.createProduct(PROD_NAME);	    
		    
//		    verify product created
		    ProductInfoPage pip = new ProductInfoPage(driver);
		    pip.validateProduct(PROD_NAME);
		    
//		    click on Products link to see the list of products	
		    hp.clickProductsLink();
		    
//          delete required product
		    pp.deleteProduct(driver, PROD_NAME);		    
		    
//		    verify if the product is deleted
		    if(pp.isPresent(PROD_NAME)) {
		    	System.out.println("product deleted");
		    }
		    else {
		    	System.out.println("proudct is present in the productList");
		    }
 
//          logout	  
		    hp.logout();
		    System.out.println("logged out");
	
	}
}
 */












/*
 *
public class ProductCreateDelete {
	

		
		public static void main(String[] args) throws Throwable {
			
			
//			get common data from property file			
			FileUtility flib = new FileUtility();
			
			String BROWSER = flib.getCommonData("browser");
			String URL = flib.getCommonData("url");
			String USERNAME = flib.getCommonData("username");
			String PASSWORD = flib.getCommonData("password");
			
			
//			get test data from excel file productName

			ExcelUtility elib = new ExcelUtility();
			
			JavaUtility jlib = new JavaUtility();							
			int ranNoProduct = jlib.getRandomNum(1000);
			String PROD_NAME = elib.getExcelData("sheet1", 9, 2) + ranNoProduct ;
			
//		    open browser	
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

		    
//		    login
		    driver.get(URL);	    
		    driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		    driver.findElement(By.name("user_password")).sendKeys(PASSWORD, Keys.ENTER);
		    
		    
//		    create campaign depends on products module : without creating a product you cant add a product to campaign
		    
//		    create product
		    driver.findElement(By.linkText("Products")).click();
		    driver.findElement(By.xpath("//img[@title='Create Product...']")).click();
		    driver.findElement(By.xpath("//input[@name='productname']")).sendKeys(PROD_NAME);
		    driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		    
//		    verify product created
		    String product = driver.findElement(By.id("dtlview_Product Name")).getText();
		    if(product.equals(PROD_NAME)) {
		    	System.out.println("product created: " + product);
		    }
		    
		    
//		    click on product
		    driver.findElement(By.linkText("Products")).click();
		    
//		    click on checkbox for the product created
            driver.findElement(By.xpath("//a[text()='"+product+"']/../preceding-sibling::td//input[@type='checkbox']")).click();
//          click on delete
            driver.findElement(By.xpath("//input[@value='Delete']")).click();
            
            
//          handle alert pop up
            driver.switchTo().alert().accept();
           
                  
            
//          verify if the product is deleted
		    driver.findElement(By.linkText("Products")).click();  // to refresh the product list  
		    
            boolean isPresent = wlib.isPresent(By.xpath("//a[@title='Products']"), product);
            if(!isPresent) {
            	System.out.println("product deleted");
            }
            else {
            	System.out.println("product was not deleted");
            }
          
            
//            List<WebElement> productList = driver.findElements(By.xpath("//a[@title='Products']"));   
//            
////          approach1 : using stream()
//            boolean isPresent = productList.stream()
//            		                       .anyMatch(element-> element.getText().equals(product));
//            
//            if(!isPresent)
//            {
//            	System.out.println("product deleted");
//            }
//            else
//            {
//            	System.out.println("product not deleted");
//            }
//  
//          approach2 : using if and for
//            
//            boolean isPresent2 = false;
//            
//            for (WebElement element : productList)
//            {	
//            	if(element.getText().equals(product))
//            	{
//            		System.out.println("element not deleted");
//            		isPresent2 = true;
//            		break;
//            	}
//			}
//            
//            
//            if(!isPresent2)
//            {
//            	System.out.println("element deleted");
//            }
//            else
//            {
//            	System.out.println("element not deleted");
//            }
            
 
            
//          logout	    
    	    driver.findElement(By.xpath("//span[text()=' Administrator']/../following-sibling::td")).click();	    
    	    driver.findElement(By.linkText("Sign Out")).click();	
    	    
	}
}
 */

