package ninza.CRM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ninzaCRM.genericUtilities.WebDriverUtility;

public class ContactPage extends WebDriverUtility
{
	@FindBy(xpath = "//span[text()='Create Contact']")
	private WebElement createContact;
	
	@FindBy(xpath = "//select[@class='form-control']")
	private WebElement searchDropdown;
	
	@FindBy(xpath = "//div[@class='col-sm-6']/child::input")
	private WebElement searchInputField;
	
	public ContactPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getCreateContact()
	{
		return createContact;
	}

	public WebElement getSearchDropdown()
	{
		return searchDropdown;
	}

	public WebElement getSearchInputField()
	{
		return searchInputField;
	}
	
	// Business Library
		/**
		 * This method is used to click on create contact
		 */
		public void clickOnCreateContact()
		{
			createContact.click();
		}
		
		/**
		 * This method is used to select the required option in the dropdown and send the test in the search input
		 * @param visibletext
		 */
		public void selectOptionInSearchDropdown(String visibletext , String campaignInfo)
		{
			handleDropdown(visibletext,searchDropdown );
			searchInputField.sendKeys(campaignInfo);
			
		}
	
	

}
