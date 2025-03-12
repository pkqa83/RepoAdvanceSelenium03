package POM_REPO;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class AddProductWindowPopUp {


	
	public AddProductWindowPopUp(WebDriver driver) {		
		PageFactory.initElements(driver, this);		
	}
	
	@FindBy(xpath = "(//a[contains(text(),'Product Name')]/ancestor::tbody[1]/tr/td[1])[position()>1]")
	private List<WebElement> productList;
	
	@FindBy(xpath = "//input[@id='search_txt']")
	private WebElement productSearchBox;
	
	@FindBy(xpath = "//input[@name='search']")
	private WebElement searchButton;
	




//	public void selectProduct(String productName) {						
//        for (WebElement element : productList) {			
//			if(element.getText().contains(productName)) {					
//				System.out.println("Clicked on: " + element.getText());
//				element.click();				
//				return;                                                   // terminates the whole method 
//			}
//		}
//		throw new RuntimeException("product name: "+productName+ "not found in the list"); // if the productList doesnot have productName the loop will complete and throw Runtime Exception.
//
//	}
	
	
	
	  public void selectProduct(WebDriver driver, String productName){
		  
		  productSearchBox.sendKeys(productName);
		  searchButton.click();
	      driver.findElement(By.xpath("//a[text()='"+productName+"']")).click();	  
	  }

}
