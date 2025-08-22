package ninza.CRM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ninzaCRM.genericUtilities.WebDriverUtility;

public class CreateContactPage extends WebDriverUtility
{
	
	@FindBy(xpath = "//input[@name='organizationName']")
	private WebElement organisationName;
	
	@FindBy(xpath = "//input[@name='title']")
	private WebElement title;
	
	@FindBy(xpath = "//input[@name='department']")
	private WebElement department;
	
	@FindBy(xpath = "//input[@name='officePhone']")
	private WebElement officePhone;
	
	@FindBy(xpath = "//input[@name='contactName']")
	private WebElement contactName;
	
	@FindBy(xpath = "//input[@name='mobile']")
	private WebElement mobile;
	
	@FindBy(xpath = "//input[@name='email']")
	private WebElement email;
	
	@FindBy(xpath = "//*[local-name()='svg' and @class='svg-inline--fa fa-plus ']")
	private WebElement plus;
	
	@FindBy(xpath = "//button[text()='Create Contact']")
	private WebElement createContact;
	
	@FindBy(xpath = "//h3[text()='Select a Campaign']")
	private WebElement selectCampaignText;
	
	@FindBy(xpath = "//select[@id='search-criteria']")
	private WebElement searchBar;
	
	@FindBy(xpath = "//input[@id='search-input']")
	private WebElement searchTF;
	
	@FindBy(xpath = "//button[text()='Next']")
	private WebElement nextBtn;
	
	public CreateContactPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getOrganisationName()
	{
		return organisationName;
	}

	public WebElement getTitle()
	{
		return title;
	}

	public WebElement getDepartment()
	{
		return department;
	}

	public WebElement getOfficePhone()
	{
		return officePhone;
	}

	public WebElement getContactName()
	{
		return contactName;
	}

	public WebElement getMobile()
	{
		return mobile;
	}

	public WebElement getEmail()
	{
		return email;
	}

	public WebElement getPlus()
	{
		return plus;
	}

	public WebElement getCreateContact()
	{
		return createContact;
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
	
	
	// Business Logic
	
	/**
	 * This method is used to create a contact
	 * @param driver
	 * @param orgName
	 * @param titl
	 * @param dept
	 * @param ofcPhone
	 * @param cntcName
	 * @param mbile
	 * @param emil
	 * @param cmpgId
	 * @throws InterruptedException
	 */
	public void createContact(WebDriver driver , String orgName , String titl , String dept , String ofcPhone , String cntcName , String mbile , String emil , String cmpgId) throws InterruptedException
	{
		organisationName.sendKeys(orgName);
		title.sendKeys(titl);
		department.sendKeys(dept);
		officePhone.sendKeys(ofcPhone);
		contactName.sendKeys(cntcName);
		mobile.sendKeys(mbile);
		email.sendKeys(emil);
		plus.click();
		
		switchToWindow(driver);
		Thread.sleep(4000);
		searchTF.sendKeys(cmpgId);
		driver.findElement(By.xpath("//td[text()='"+cmpgId+"']/following-sibling::td//following-sibling::td//following-sibling::td//following-sibling::td//following-sibling::td/following-sibling::td/child::button")).click();
		switchToWindow(driver, "Ninza CRM");
		Thread.sleep(4000);
		scrollAction(driver, 0, 500);
		createContact.click();
		Thread.sleep(6000);	
	}
	
	
	
	
	


}
