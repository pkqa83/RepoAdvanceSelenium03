package POM_REPO;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInfoPage {

	public OrganizationInfoPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//span[@id='dtlview_Organization Name']")
	private WebElement orgInfoName;
	
	public void validateOrg(String orgName) {
		if(orgInfoName.getText().equals(orgName)) {
			System.out.println("Organization verified , org name = org name in org info page");
		}
	}
	
	public String validateOrg() {
		return orgInfoName.getText();
	}
}
