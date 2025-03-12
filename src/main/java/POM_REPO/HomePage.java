package POM_REPO;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {


	public HomePage(WebDriver driver) {
          
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[text()='More']")
	private WebElement moreLink;
	
	@FindBy(xpath="//a[text()='Organizations']")
	private WebElement organizationsLink;
	
	@FindBy(xpath="//a[text()='Campaigns']")
	private WebElement campaignsLink;
	
	@FindBy(xpath="//a[text()='Products']")
	private WebElement productsLink;
	
	@FindBy(xpath="//span[@class='userName']/parent::td/following-sibling::td[1]")
	private WebElement profileDropdown;
	
	@FindBy(xpath="//a[text()='Sign Out']")
	private WebElement signOutLink;
	
	
	public void clickOrganizationsLink() {
		organizationsLink.click();
	}
	
	public void clickCampaignsLink() {
		moreLink.click();
		campaignsLink.click();
	}
		
	public void clickProductsLink() {
		productsLink.click();	
	}
	
	public void logout() {
		profileDropdown.click();
		signOutLink.click();
	}
	

	
}
