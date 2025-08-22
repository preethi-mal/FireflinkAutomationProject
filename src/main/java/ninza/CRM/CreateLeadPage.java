package ninza.CRM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ninzaCRM.genericUtilities.WebDriverUtility;

public class CreateLeadPage extends WebDriverUtility
{
	@FindBy(xpath = "//input[@name='name']")
	private WebElement leadName;
	
	@FindBy(xpath = "//input[@name='company']")
	private WebElement company;
	
	@FindBy(xpath = "//input[@name='leadSource']")
	private WebElement leadSource;
	
	@FindBy(xpath = "//input[@name='industry']")
	private WebElement industry;
	
	@FindBy(xpath = "//input[@name='annualRevenue']")
	private WebElement annualRevenue;
	
	@FindBy(xpath = "//input[@name='noOfEmployees']")
	private WebElement noOfEmployees;
	
	@FindBy(xpath = "//input[@name='phone']")
	private WebElement phone;
	
	@FindBy(xpath = "//input[@name='email']")
	private WebElement email;
	
	@FindBy(xpath = "//input[@name='secondaryEmail']")
	private WebElement secondaryEmail;
	
	@FindBy(xpath = "//input[@name='leadStatus']")
	private WebElement leadStatus;
	
	@FindBy(xpath = "//input[@name='rating']")
	private WebElement rating;
	
	@FindBy(xpath = "//input[@name='assignedTo']")
	private WebElement assignedTo;
	
	@FindBy(xpath = "//textarea[@name='address']")
	private WebElement address;
	
	@FindBy(xpath = "//input[@name='city']")
	private WebElement city;
	
	@FindBy(xpath = "//input[@name='country']")
	private WebElement country;
	
	@FindBy(xpath = "//input[@name='postalCode']")
	private WebElement postalCode;
	
	@FindBy(xpath = "//input[@name='website']")
	private WebElement website;
	
	@FindBy(xpath = "//textarea[@name='description']")
	private WebElement description;
	
	@FindBy(xpath = "//*[local-name()='svg' and @data-icon='plus']")
	private WebElement plusIcon;
	
	@FindBy(xpath = "//button[text()='Create Lead']")
	private WebElement createLead;
	
	@FindBy(xpath = "//h3[text()='Select a Campaign']")
	private WebElement selectCampaignText;
	
	@FindBy(xpath = "//select[@id='search-criteria']")
	private WebElement searchBar;

	
	@FindBy(xpath = "//input[@id='search-input']")
	private WebElement searchTF;
	
	@FindBy(xpath = "//button[text()='Next']")
	private WebElement nextBtn;
	
	
	public CreateLeadPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getLeadName()
	{
		return leadName;
	}

	public WebElement getCompany()
	{
		return company;
	}

	public WebElement getLeadSource()
	{
		return leadSource;
	}

	public WebElement getIndustry()
	{
		return industry;
	}

	public WebElement getAnnualRevenue()
	{
		return annualRevenue;
	}

	public WebElement getNoOfEmployees()
	{
		return noOfEmployees;
	}

	public WebElement getPhone()
	{
		return phone;
	}

	public WebElement getEmail()
	{
		return email;
	}

	public WebElement getSecondaryEmail()
	{
		return secondaryEmail;
	}

	public WebElement getLeadStatus()
	{
		return leadStatus;
	}

	public WebElement getRating()
	{
		return rating;
	}

	public WebElement getAssignedTo()
	{
		return assignedTo;
	}

	public WebElement getAddress()
	{
		return address;
	}

	public WebElement getCity()
	{
		return city;
	}

	public WebElement getCountry()
	{
		return country;
	}

	public WebElement getPostalCode()
	{
		return postalCode;
	}

	public WebElement getWebsite()
	{
		return website;
	}

	public WebElement getDescription()
	{
		return description;
	}

	public WebElement getPlusIcon()
	{
		return plusIcon;
	}

	public WebElement getSelectCampaignText()
	{
		return selectCampaignText;
	}

	public WebElement getSearchBar()
	{
		return searchBar;
	}

	public WebElement getSearchTF()
	{
		return searchTF;
	}

	public WebElement getNextBtn()
	{
		return nextBtn;
	}
	
	
	// Business Library
	
	public WebElement getCreateLead()
	{
		return createLead;
	}

	/**
	 * This method is used to create the lead
	 * @param driver
	 * @param ledName
	 * @param cmpny
	 * @param ldSource
	 * @param indstry
	 * @param annRevenue
	 * @param nOfEmployees
	 * @param phn
	 * @param emil
	 * @param secEmail
	 * @param ldStatus
	 * @param rting
	 * @param assTo
	 * @param addrss
	 * @param cty
	 * @param cntry
	 * @param postalCd
	 * @param webste
	 * @param cmpgId
	 * @param descri
	 * @throws InterruptedException
	 */
	public void createLead(WebDriver driver , String ledName , String cmpny , String ldSource , String indstry , String annRevenue , String nOfEmployees , String phn , String emil , String secEmail , String ldStatus , String rting , String assTo , String addrss , String cty , String cntry , String postalCd , String webste ,String cmpgId , String descri) throws InterruptedException
	{
		leadName.sendKeys(ledName);
		company.sendKeys(cmpny);
		leadSource.sendKeys(ldSource);
		industry.sendKeys(indstry);
		annualRevenue.clear();
		annualRevenue.sendKeys(annRevenue);
		noOfEmployees.clear();
		noOfEmployees.sendKeys(nOfEmployees);
		phone.sendKeys(phn);
		email.sendKeys(emil);
		secondaryEmail.sendKeys(secEmail);
		leadStatus.sendKeys(ldStatus);
		rating.clear();
		rating.sendKeys(rting);
		assignedTo.sendKeys(assTo);
		address.sendKeys(addrss);
		city.sendKeys(cty);
		country.sendKeys(cntry);
		postalCode.sendKeys(postalCd);
		website.sendKeys(webste);
		plusIcon.click();
		switchToWindow(driver, "Campaign");
		Thread.sleep(4000);
		searchTF.sendKeys(cmpgId);
		driver.findElement(By.xpath("//td[text()='"+cmpgId+"']/following-sibling::td//following-sibling::td//following-sibling::td//following-sibling::td//following-sibling::td/following-sibling::td/child::button")).click();
		description.sendKeys(descri);
		switchToWindow(driver, "Ninza");
		Thread.sleep(4000);
		createLead.click();
		
	}
	
	

}
