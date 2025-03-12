package VTIGER.DDT.Campaign;



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
import POM_REPO.AddProductWindowPopUp;
import POM_REPO.CampaignInfoPage;
import POM_REPO.CampaignsPage;
import POM_REPO.CreateCampaignPage;
import POM_REPO.CreateProductPage;
import POM_REPO.HomePage;
import POM_REPO.LoginPage;
import POM_REPO.ProductInfoPage;
import POM_REPO.ProductsPage;


//Login to vtiger application->mouseOverOn more Link->
//click on campaigns->
//click on create campaign lookup image->
//Enter campaignName->
//Click on Product plus img->
//Handle the PopUp->
//Product name should be added to campaign createpage->
//click on save Btn->
//verify whether the campaign name is created in campaign Information page
//and Logout from the application. 

//create campaign with product added to it : this is an example of integration testing 
//campaingn creation module depends on products module : without creating a product you cant add a product to campaign



/*
 * Generic Utilities Used
 * 
 * 
 * FileUtility flib = new FileUtility();
 * flib.getCommonData()
 * 
 * ExcelUtility elib = new ExcelUtility();
 * elib.getExcelData(), elib.getExcelDataUsingDataForamatter()
 * 
 * JavaUtility jlib = new JavaUtility();
 * jlib.getRandomNum()
 * 
 * WebDriverUtility() wlib = new WebDriverUtility();
 * wlib.maximizeWindow(),  wlib.implicitlyWait();
 * 
 * 
 * 
 */
public class CreateCampaignAddProductInCampaignTest extends BaseClass{

	@Test
	public void createCampaignAddProductInCampaign() throws Throwable {

		
//		get test data from excel file : campaignName and productName		
    
  		String CAMP_NAME = elib.getExcelData("sheet1", 8, 2) + jlib.getRandomNum(1000) ;		
		String PROD_NAME = elib.getExcelData("sheet1", 9, 2) + jlib.getRandomNum(1000) ;

//	    clik on Product link
	    HomePage hp = new HomePage(driver);
	    hp.clickProductsLink();
	    
//	    click on create new Product button
	    ProductsPage pp = new ProductsPage(driver);
	    pp.clickCreateProductButton();
	    
//	    set new Product details
	    CreateProductPage cpp = new CreateProductPage(driver);
	    cpp.createProduct(PROD_NAME);    
	    
//	    verify product created	    
	    ProductInfoPage pip = new ProductInfoPage(driver);
	    String actualProductName = pip.validateProduct();
	    Assert.assertEquals(actualProductName, PROD_NAME);
	    System.out.println("Product name verified: "+actualProductName);
	    
//	    create campaign    
//      click on CampaignsLink
	    hp.clickCampaignsLink();
	    
//	    click on create campaign button
	    CampaignsPage cp = new CampaignsPage(driver);
	    cp.clickCreateCampaignButton();
	    
//	    fill new campagin details: set campagin name, add product
	    CreateCampaignPage ccp = new CreateCampaignPage(driver);
	    ccp.setCampaignName(CAMP_NAME);
	    ccp.clickAddProductButton();
	    	    
//	    switch focus to window popup : add product window pop up	    
	    wlib.switchWindowUsingUrl("Products&action=Popup&html");
	    
//	    select required product from product list displayed on window pop up 	    	    
	    AddProductWindowPopUp apwp = new AddProductWindowPopUp(driver);
	    apwp.selectProduct(driver,PROD_NAME);	    
        
//      switch to parent window   	    
	    wlib.switchWindow("Administrator");	
	    
//	    click on save button
	    ccp.clickSaveButton();
                 
//      verify campaign created
		CampaignInfoPage campaignInfoPageObj = new CampaignInfoPage(driver);
		 
		String actualData = campaignInfoPageObj.validateCampaign();
        Assert.assertEquals(actualData,CAMP_NAME);
        System.out.println("Campaign name verified : "+actualData);

	    

	}
}



//-------------------

/*
 public class CreateCampaignAddProductInCampaign {

	
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
		
		int ranNoProduct = jlib.getRandomNum(1000);
		String PROD_NAME = elib.getExcelData("sheet1", 9, 2) + ranNoProduct ;
		

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
	    LoginPage lp = new LoginPage(driver);
	    lp.login(USERNAME,PASSWORD);	    

//	    clik on Product link
	    HomePage hp = new HomePage(driver);
	    hp.clickProductsLink();
	    
//	    click on create new Product button
	    ProductsPage pp = new ProductsPage(driver);
	    pp.clickCreateProductButton();
	    
//	    set new Product details
	    CreateProductPage cpp = new CreateProductPage(driver);
	    cpp.createProduct(PROD_NAME);    
	    
//	    verify product created	    
	    ProductInfoPage pip = new ProductInfoPage(driver);
	    pip.validateProduct(PROD_NAME);
	    
//	    create campaign    
//      click on CampaignsLink
	    hp.clickCampaignsLink();
	    
//	    click on create campaign button
	    CampaignsPage cp = new CampaignsPage(driver);
	    cp.clickCreateCampaignButton();
	    
//	    fill new campagin details: set campagin name, add product
	    CreateCampaignPage ccp = new CreateCampaignPage(driver);
	    ccp.setCampaignName(CAMP_NAME);
	    ccp.clickAddProductButton();
	    	    
//	    switch focus to window popup : add product window pop up	    
	    wlib.switchWindowUsingUrl("Products&action=Popup&html");
	    
//	    select required product from product list displayed on window pop up 	    	    
	    AddProductWindowPopUp apwp = new AddProductWindowPopUp(driver);
	    apwp.selectProduct(driver,PROD_NAME);	    
        
//      switch to parent window   	    
	    wlib.switchWindow("Administrator");	
	    
//	    click on save button
	    ccp.clickSaveButton();
                 
//      verify campaign created
	    CampaignInfoPage cip = new CampaignInfoPage(driver);
	    cip.validateCampaign(CAMP_NAME);
       	           
//      logout	    
	    hp.logout();
	    

	}
}
 */



//------------------------------------------------------------------------------------------------------------------

/*
 * 
public class CreateCampaignAddProductInCampaign {

	
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
		
		int ranNoProduct = jlib.getRandomNum(1000);
		String PROD_NAME = elib.getExcelData("sheet1", 9, 2) + ranNoProduct ;
		

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

//	    login
	    driver.get(URL);	
	    
	    //using business logic (POM Methods)	    
	    LoginPage lp = new LoginPage(driver);
	    lp.login(USERNAME,PASSWORD);	    
	    
//	    create campaign depends on products module : without creating a product you cant add a product to campaign		    
//	    create product
//	    driver.findElement(By.linkText("Products")).click();
//	    driver.findElement(By.xpath("//img[@title='Create Product...']")).click();
//	    driver.findElement(By.xpath("//input[@name='productname']")).sendKeys(PROD_NAME);
//	    driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();	
	    
	    HomePage hp = new HomePage(driver);
	    hp.clickProducts();
	    
	    ProductsPage pp = new ProductsPage(driver);
	    pp.clickCreateProductButton();
	    
	    CreateProductPage cpp = new CreateProductPage(driver);
	    cpp.createProduct(PROD_NAME);
	    
	    
	    
//	    verify product created
//	    String productName = driver.findElement(By.id("dtlview_Product Name")).getText();
//	    if(productName.equals(PROD_NAME)) {
//	    	System.out.println("product created: " + productName);
//	    } 
	    
	    ProductInfoPage pip = new ProductInfoPage(driver);
	    pip.verifyProduct(PROD_NAME);
	    
//	    create campaign    
//	    driver.findElement(By.linkText("More")).click();
//	    driver.findElement(By.linkText("Campaigns")).click();
//	    
//	    driver.findElement(By.xpath("//img[@title='Create Campaign...']")).click();
//	    
//	    driver.findElement(By.name("campaignname")).sendKeys(CAMP_NAME);
//	    driver.findElement(By.xpath("//input[@name='product_name']/following-sibling::img")).click();
	    
	    hp.clickCampaigns();
	    CampaignsPage cp = new CampaignsPage(driver);
	    cp.clickCreateCampaignButton();
	    
	    CreateCampaignPage ccp = new CreateCampaignPage(driver);
	    ccp.createCampaignWithProduct(CAMP_NAME);
	    
	    
//	    switch focus to window popup : add product window pop up	    
	    wlib.switchWindowUsingUrl("Products&action=Popup&html");
//	    wlib.switchWindow("Products&action=Popup&html");
	    
	   

	    
//	    search for product	 	    
//	    driver.findElement(By.xpath("//input[@id='search_txt']")).sendKeys(product);
//      driver.findElement(By.xpath("//input[@name='search']")).click();	    
//	    driver.findElement(By.xpath("//a[text()='"+product+"']")).click();
	    
	    AddProductWindowPopUp apwp = new AddProductWindowPopUp(driver);
	    apwp.selectProduct(PROD_NAME);
	    
        
//      switch to parent window   	    
	    wlib.switchWindow("Administrator");	    
        
          
//      verify campaign created
//        WebElement CampaignName = driver.findElement(By.id("dtlview_Campaign Name"));
//        if(CampaignName.getText().equalsIgnoreCase(CAMP_NAME)) {
//        	System.out.println("Campaing created : "+ CAMP_NAME);
//        }
	    CampaignInfoPage cip = new CampaignInfoPage(driver);
	    cip.verifyCampaign(CAMP_NAME);
       	    
        
//      logout	    
	    driver.findElement(By.xpath("//span[text()=' Administrator']/../following-sibling::td")).click();	    
	    driver.findElement(By.linkText("Sign Out")).click();
	    
	    
	    
		
		
		
	}
}

 * 
 * 
 */
