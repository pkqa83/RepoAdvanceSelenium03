package POM_REPO;

import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import Generic_Utility.WebDriverUtility;

public class ProductsPage {
	

	WebDriverUtility wlib;
	
	
	public ProductsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public ProductsPage(WebDriver driver, WebDriverUtility wlib) {
		PageFactory.initElements(driver, this);
		this.wlib = wlib;
	}
	
	
	
	
	@FindBy(xpath = "//img[@title='Create Product...']")
	private WebElement createProductButton;
	
	@FindBy(xpath = "//input[@value='Delete']")
	private WebElement deleteProductButton;
	
	@FindBy(xpath = "(//a[text()='Product Name']/ancestor::tbody[1]/tr/td[3])[position()>1]")
	private List<WebElement> productList;
	
	@FindBy(xpath = "//a[@title='Next']")
	private WebElement nextPageButton;
	
	@FindBy(xpath = "//input[@name='search_text']")
	private WebElement productSearchBox;
	
	@FindBy(xpath = "//select[@id='bas_searchfield']")
	private WebElement searchByListBox;
	
	@FindBy(xpath = "//input[@name='submit']")
	private WebElement searchButton;
	
	

	
	public void clickCreateProductButton() {
		createProductButton.click();
	}
	
	
//	public void deleteProduct(WebDriver driver, String productName) {
//	
//		boolean productFound = false;
//		
//		while(!productFound) {
//		try {
//			driver.findElement(By.xpath("//a[text()='" + productName + "']/parent::td/preceding-sibling::td/input[@type='checkbox']")).click();
//			productFound = true;
//		} catch (NoSuchElementException e) {
//			nextPageButton.click();
//		}	
//		}
//		deleteProductButton.click();
//		driver.switchTo().alert().accept();
//	}
//	
	
	public void deleteProduct(WebDriver driver, String productName) {
		
		productSearchBox.sendKeys(productName);	
		
		Select s = new Select(searchByListBox);
	    s.selectByValue("productname");	    
	    
	    searchButton.click();
	    
	    driver.findElement(By.xpath("//a[text()='" + productName + "']/parent::td/preceding-sibling::td/input[@type='checkbox']")).click();
		deleteProductButton.click();
		driver.switchTo().alert().accept();
	}
	
	
	

	
	
	public boolean isPresent(String productName) {
		
		productSearchBox.sendKeys(productName);	
		
		Select s = new Select(searchByListBox);
	    s.selectByValue("productname");	    
	    
	    searchButton.click();
		
		for (WebElement element : productList) {        // if you want to use explicit wait to make sure that the product list has all the elements then you have to make the list inside the isPresent method.
			if(element.getText().equals(productName)) {
				return true;
			}
		}
		return false;		
	}
	
	public boolean isPresentWithExplicitWait(String productName) {
		
		productSearchBox.sendKeys(productName);	
		
		Select s = new Select(searchByListBox);
	    s.deselectByValue(productName);	    
	    
	    searchButton.click();
	    
		List<WebElement> productList = wlib.waitForPresenceOfAllElements(By.xpath("(//a[text()='Product Name']/ancestor::tbody[1]/tr/td[3])[position()>1]"), 5);
		for (WebElement element : productList) {       
			if(element.getText().equals(productName)) {
				return true;
			}
		}
		return false;
		
	}

}
