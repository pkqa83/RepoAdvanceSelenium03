package POM_REPO;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CampaignInfoPage {

	public CampaignInfoPage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="dtlview_Campaign Name")
	private WebElement campaignName;
	
	
	public void validateCampaign(String campName) {
		
		if(campaignName.getText().equals(campName)) {
			System.out.println("Campagin validated, campaign name: "+campaignName.getText());
		}
	}
	
	public String validateCampaign() {
		return campaignName.getText();
	}
	
}

	
	

