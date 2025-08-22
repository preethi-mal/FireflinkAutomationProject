package ninza.CRM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import ninzaCRM.genericUtilities.WebDriverUtility;

public class CampaignPage extends WebDriverUtility
{
	@FindBy(xpath = "//span[text()='Create Campaign']")
	private WebElement createCampaign;
	
	
	@FindBy(xpath = "//select[@class='form-control']")
	private WebElement searchDropdown;
	
	@FindBy(xpath = "//div[@class='col-sm-6']/child::input")
	private WebElement searchTextField;	
	
	@FindBy(xpath = "//div[text()='Campaign tyfgcv Successfully Added']")
	private WebElement succesfulMsg;
	
	public CampaignPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getCreateCampaign()
	{
		return createCampaign;
	}

	public WebElement getSearchDropdown()
	{
		return searchDropdown;
	}

	
	public WebElement getSearchTextField()
	{
		return searchTextField;
	}

	public WebElement getSuccesfulMsg()
	{
		return succesfulMsg;
	}

	
	// Business Library
	/**
	 * This method is used to click on create campaign
	 */
	public void clickOnCreateCampaign()
	{
		createCampaign.click();
	}
	
	/**
	 * This method is used to select the required option in the dropdown and send the test in the search input
	 * @param visibletext
	 */
	public void selectOptionInSearchDropdown(String visibletext , String campaignInfo)
	{
		handleDropdown(visibletext,searchDropdown );
		searchTextField.sendKeys(campaignInfo);
		
	}
	
	/**
	 * This method is used to get the successfull msg after creating a campaign
	 * @return
	 */
	public String getSuccessfullMsg()
	{
		return succesfulMsg.getText();
	}
	

	
}
