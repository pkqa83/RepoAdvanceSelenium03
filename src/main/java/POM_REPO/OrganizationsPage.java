package POM_REPO;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationsPage {
	
	public OrganizationsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//img[@title='Create Organization...']")
	private WebElement createOrgButton;

	
	public void clickCreateOrganizationButton() {
		createOrgButton.click();
	}
}
