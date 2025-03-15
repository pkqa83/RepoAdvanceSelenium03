package POM_REPO;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {



	// initialization
	public LoginPage(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	
	// declaration
	@FindBy(name = "user_name")
	private WebElement usernameTextField;
	
	@FindBy(name = "user_password")
	private WebElement passwordTextField;
	
	@FindBy(id = "submitButton")
	private WebElement loginButton;
	
	
	
	//getter methods


	public WebElement getUsernameTextField() {
		return usernameTextField;
	}


	public WebElement getPasswordTextField() {
		return passwordTextField;
	}
	

	public WebElement getLoginButton() {
		return loginButton;
	}
	
	
	
	//business logic (methods to interact with webElements:
	
	
	/**
	 * This method is used to login the application
	 * @param username
	 * @param password
	 */
	public void login(String username, String password) {
		usernameTextField.sendKeys(username);
		passwordTextField.sendKeys(password);
		loginButton.click();
	}


}
