package POM_REPO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Generic_Utility.WebDriverUtility;

public class CreateCampaignPage {
	
	public CreateCampaignPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(name="campaignname")
	private WebElement campaignNameTextField;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveButton;
	
	@FindBy(id="dtlview_Campaign Name")
	private WebElement campaignName;
	
	@FindBy(xpath = "//input[@name='product_id']/following-sibling::img")
	private WebElement addProductButton;
	
	public void createCampaign(String campName) {	      
		campaignNameTextField.sendKeys(campName);
		saveButton.click();
	}
	
	public void setCampaignName(String campaignName) {
		campaignNameTextField.sendKeys(campaignName);
	}
	
	public void clickAddProductButton() {
		addProductButton.click();
	}
	
	public void clickSaveButton() {
		saveButton.click();
	}
	
		


}

