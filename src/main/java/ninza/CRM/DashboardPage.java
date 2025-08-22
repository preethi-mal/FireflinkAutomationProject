package ninza.CRM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage
{
	
	@FindBy(xpath = "//a[text()='Campaigns']")
	private WebElement campaignsLink;
	
	@FindBy(xpath = "//a[text()='Contacts']")
	private WebElement contactsLink;
	
	@FindBy(xpath = "//a[text()='Leads']")
	private WebElement leadsLink;
	
	@FindBy(xpath = "//a[text()='Opportunities']")
	private WebElement opportunitiesLink;
	
	@FindBy(xpath = "//a[text()='Products']")
	private WebElement productsLink;
	
	@FindBy(xpath = "//a[text()='Quotes']")
	private WebElement quotesLink;
	
	@FindBy(xpath = "//a[text()='Purchase Order']")
	private WebElement purchaseOrderLink;
	
	@FindBy(xpath = "//a[text()='Sales Order']")
	private WebElement salesOrderLink;
	
	@FindBy(xpath = "//a[text()='Invoice']")
	private WebElement invoice;
	
	@FindBy(xpath = "//li[text()='Admin Console']")
	private WebElement adminConsole;
	
	@FindBy(xpath = "//div[@class='user-icon']")
	private WebElement userIcon;
	
	@FindBy(xpath = "//div[text()='Logout ']")
	private WebElement logoutBtn;
	
	public DashboardPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getCampaignsLink()
	{
		return campaignsLink;
	}

	public WebElement getContactsLink()
	{
		return contactsLink;
	}

	public WebElement getLeadsLink()
	{
		return leadsLink;
	}

	public WebElement getOpportunitiesLink()
	{
		return opportunitiesLink;
	}

	public WebElement getProductsLink()
	{
		return productsLink;
	}

	public WebElement getQuotesLink()
	{
		return quotesLink;
	}

	public WebElement getPurchaseOrderLink()

	{
		return purchaseOrderLink;
	}

	public WebElement getSalesOrderLink()
	{
		return salesOrderLink;
	}

	public WebElement getInvoice()
	{
		return invoice;
	}

	public WebElement getAdminConsole()
	{
		return adminConsole;
	}

	public WebElement getUserIcon()
	{
		return userIcon;
	}

	public WebElement getLogoutBtn()
	{
		return logoutBtn;
	}
	
	// Business Library
	
	/**
	 * This method is used to click on campaign
	 */
	public void campaignClick()
	{
		campaignsLink.click();
	}
	
	/**
	 * This method is used to click on contacts
	 */
	public void contactClick()
	{
		contactsLink.click();
	}
	
	/**
	 * This method is used to click on leads
	 */
	public void leadClick()
	{
		leadsLink.click();
	}
	
	/**
	 * This method is used to click on opportunities
	 */
	public void opportunitiesClick()
	{
		opportunitiesLink.click();
	}
	
	/**
	 * This method is used to click on campaign
	 */
	public void productsClick()
	{
		productsLink.click();
	}
	
	/**
	 * This method is used to click on quotes
	 */
	public void quotesClick()
	{
		quotesLink.click();
	}
	
	/**
	 * This method is used to click on purchaseOrder
	 */
	public void purchaseOrderClick()
	{
		purchaseOrderLink.click();
	}
	
	/**
	 * This method is used to click on salesOrder
	 */
	public void salesOrderClick()
	{
		salesOrderLink.click();
	}
	
	/**
	 * This method is used to click on invoice
	 */
	public void invoiceClick()
	{
		invoice.click();
	}
	
	/**
	 * This method is used to click on adminConsole
	 */
	public void adminConsoleClick()
	{
		adminConsole.click();
	}
	
	/**
	 * This method is used to click on userIcon
	 */
	public void userIconClick()
	{
		userIcon.click();
	}
	
	/**
	 * This method is used to click on logoutBtn
	 */
	public void logoutBtnClick()
	{
		logoutBtn.click();
	}
	
	

}
