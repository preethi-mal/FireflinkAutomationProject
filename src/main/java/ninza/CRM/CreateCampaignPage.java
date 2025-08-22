package ninza.CRM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateCampaignPage
{
	
	@FindBy(xpath = "//input[@name='campaignName']")
	private WebElement campaignName;
	
	@FindBy(xpath = "//input[@name='campaignStatus']")
	private WebElement campaignStatus;
	
	@FindBy(xpath = "//input[@name='targetSize']")
	private WebElement targetSize;
	
	@FindBy(xpath = "//input[@name='expectedCloseDate']")
	private WebElement expectedCloseDate;
	
	@FindBy(xpath = "//input[@name='targetAudience']")
	private WebElement targetAudience;
	
	@FindBy(xpath = "//textarea[@name='description']")
	private WebElement description;
	
	@FindBy(xpath = "//button[text()='Create Campaign']")
	private WebElement createCampaign;
	
	public CreateCampaignPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getCampaignName()
	{
		return campaignName;
	}

	public WebElement getCampaignStatus()
	{
		return campaignStatus;
	}

	public WebElement getTargetSize()
	{
		return targetSize;
	}

	public WebElement getExpectedCloseDate()
	{
		return expectedCloseDate;
	}

	public WebElement getTargetAudience()
	{
		return targetAudience;
	}

	public WebElement getDescription()
	{
		return description;
	}

	public WebElement getCreateCampaign()
	{
		return createCampaign;
	}
	
	// Business Library
	/**
	 * This method is used to create a campaign by using the user inputs 
	 * @param cmpgnName
	 * @param cmpgnStatus
	 * @param targetsze
	 * @param expCloseDate
	 * @param tarAudience
	 * @param desc
	 * @throws InterruptedException 
	 */
	public void createCampaign(String cmpgnName,String cmpgnStatus, String targetsze , String expCloseDate , String tarAudience , String desc ) throws InterruptedException
	{
		campaignName.sendKeys(cmpgnName);
		campaignStatus.sendKeys(cmpgnStatus);
		targetSize.clear();
		targetSize.sendKeys(targetsze);
		expectedCloseDate.sendKeys(expCloseDate);
		targetAudience.sendKeys(tarAudience);
		description.sendKeys(desc);
		createCampaign.click();
		Thread.sleep(6000);
	}
	

}
