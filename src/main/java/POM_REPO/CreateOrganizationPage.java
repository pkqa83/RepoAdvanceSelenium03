package POM_REPO;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateOrganizationPage {

	public CreateOrganizationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	

	@FindBy(xpath="//input[@name='accountname']")
	private WebElement orgNameTextField;
	
	@FindBy(xpath="//input[@id='email1']")
	private WebElement orgEmailTextField;
	
	@FindBy(xpath="//input[@id='phone']")
	private WebElement orgPhoneTextField;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveButton;

	
	public void createOrg(String orgName, String orgEmail, String orgPhone) {
		orgNameTextField.sendKeys(orgName);
		orgEmailTextField.sendKeys(orgEmail);
		orgPhoneTextField.sendKeys(orgPhone);
		saveButton.click();
	}
	
	public void setOrgName(String orgName) {
        orgNameTextField.sendKeys(orgName);
	}
	
	public void setOrgEmial(String orgEmail) {
		orgEmailTextField.sendKeys(orgEmail);
	}
	
	public void setOrgPhone(String orgPhone) {
		orgPhoneTextField.sendKeys(orgPhone);
	}
	
	public void clickSaveButton() {
		saveButton.click();
	}
}
