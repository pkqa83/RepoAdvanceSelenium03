package VTIGER.DDT.Product;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
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


/*
 * 2].
 * Login to vtiger application->
 * click on products link->
 * click on create product lookup image->
 * Enter product name->click on save Btn->
 * verify whether the product is created in product Information page
 * and Logout from the application.
 *
 * 
 */
public class CreateProductTest extends BaseClass{
	
		@Test
		public void createProduct() throws Throwable {
					
//			get test data from excel file productName
			String PROD_NAME = elib.getExcelData("sheet1", 9, 2) + jlib.getRandomNum(1000) ;
			
//          click on Products link
            HomePage hp = new HomePage(driver);
            hp.clickProductsLink();
		    
//		    click on create new product button
            ProductsPage pp = new ProductsPage(driver);
            pp.clickCreateProductButton();
            
//          set new product details like product name etc and save
            CreateProductPage cpp = new CreateProductPage(driver);
            cpp.createProduct(PROD_NAME);
  
//		    verify product created
            ProductInfoPage pip = new ProductInfoPage(driver);
            String actualProductName = pip.validateProduct();
            Assert.assertEquals(actualProductName, PROD_NAME);
            System.out.println("Product Name verified: "+actualProductName);
    
	}
}





/*
 public class CreateProduct {
	
		
		
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
		    driver.get(URL);	    
		    
//		    login
            LoginPage lp = new LoginPage(driver);
            lp.login(USERNAME, PASSWORD);
            
//          click on Products link
            HomePage hp = new HomePage(driver);
            hp.clickProductsLink();
		    
//		    click on create new product button
            ProductsPage pp = new ProductsPage(driver);
            pp.clickCreateProductButton();
            
//          set new product details like product name etc and save
            CreateProductPage cpp = new CreateProductPage(driver);
            cpp.createProduct(PROD_NAME);
  
//		    verify product created
            ProductInfoPage pip = new ProductInfoPage(driver);
            pip.validateProduct(PROD_NAME);
		    
//		    logout
            hp.logout();
    
	}
}
 */











/*

public class CreateProduct {
	
		
		
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
		    
		    
//		    logout
    	    driver.findElement(By.xpath("//span[text()=' Administrator']/../following-sibling::td")).click();	    
    	    driver.findElement(By.linkText("Sign Out")).click();
		    
		    
		    
	}

}


 */
