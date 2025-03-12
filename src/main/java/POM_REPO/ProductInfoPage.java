package POM_REPO;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductInfoPage {

	public ProductInfoPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "dtlview_Product Name")
	private WebElement productName;
	
	
	
	public void validateProduct(String prodName) {
		if(productName.getText().equals(prodName)) {
			System.out.println("prodcut validated, product name: "+prodName);
		}
	}
	
	public String  validateProduct() {
		return productName.getText();
	}
	
	
}
