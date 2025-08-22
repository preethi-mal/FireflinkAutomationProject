package ninza.CRM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ninzaCRM.genericUtilities.WebDriverUtility;

public class LeadsPage extends WebDriverUtility
{
	@FindBy(xpath = "//span[text()='Create Lead']")
	private WebElement createLead;
	
	@FindBy(xpath = "//select[@class='form-control']")
	private WebElement selectDropdown;

	@FindBy(xpath = "//div[@class='col-sm-6']/child::input")
	private WebElement searchInputField;
	
	public LeadsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getCreateLead()
	{
		return createLead;
	}

	public WebElement getSelectDropdown()
	{
		return selectDropdown;
	}
	
	public WebElement getSearchInputField()
	{
		return searchInputField;
	}

	// Business Library
	
	/**
	 * This method uis used to click on create lead
	 */
	public void createLeadClick()
	{
		createLead.click();
	}
	
	/**
	 * This method is used to select the required option in the dropdown and send the test in the search input
	 * @param visibletext
	 */
	public void selectOptionInSearchDropdown(String visibletext , String campaignInfo)
	{
		handleDropdown(visibletext,selectDropdown );
		searchInputField.sendKeys(campaignInfo);
		
	}
	
	
	

}
