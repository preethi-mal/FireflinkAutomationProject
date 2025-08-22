package ninza.CRM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class LoginPage
{
	@FindBy(id = "username")
	private WebElement usernameTF;
	
	@FindBy(name = "password")
	private WebElement passwordTF;
	
	@FindBy(xpath = "//button[text()='Sign In']")
	private WebElement signInBtn;
	
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getUsernameTF()
	{
		return usernameTF;
	}

	public WebElement getPasswordTF()
	{
		return passwordTF;
	}

	public WebElement getSignInBtn()
	{
		return signInBtn;
	}
	
	
	// Business Library
	// same as Generic method but they are specific to application
	// reusable inside the application
	// Business logic , we are writing inside a method
	// use the webelements from current pom class only
	
	/**
	 * This method will perform login operation
	 * @param username
	 * @param password
	 */
	public void loginToApplication(String username , String password)
	{
		usernameTF.sendKeys(username);
		passwordTF.sendKeys(password);
		signInBtn.click();;
	}

}
