package ninza.CRMContacts;

import java.io.IOException;

import org.testng.annotations.Test;

import ninza.CRM.CampaignPage;
import ninza.CRM.ContactPage;
import ninza.CRM.CreateCampaignPage;
import ninza.CRM.CreateContactPage;
import ninza.CRM.DashboardPage;
import ninzaCRM.genericUtilities.BaseClass;

public class CreateContactTest extends BaseClass
{
	@Test(groups ="SmokeSuite")
	public void tc_e2e_01_createContact() throws IOException, InterruptedException
	{
		// Read Test data from excel
		
		String campaignName =fu.readDataFromExcelFile("Sheet1", 1, 3);
		String title = fu.readDataFromExcelFile("Sheet1", 1, 5);
		String department = fu.readDataFromExcelFile("Sheet1", 1, 14);
		String officePhone = fu.readDataFromExcelFile("Sheet1", 1, 15);
		String contactName = fu.readDataFromExcelFile("Sheet1", 1, 2);
		String mobile = fu.readDataFromExcelFile("Sheet1", 1, 4);
		String email = fu.readDataFromExcelFile("Sheet1", 1, 16);
		String campaignId = "CAM00001";
		
		// Click on Campaigns Link
		
		DashboardPage db = new DashboardPage(driver);
		db.contactClick();
		
		ContactPage cp = new ContactPage(driver);
		cp.clickOnCreateContact();
		
		CreateContactPage ccp = new CreateContactPage(driver);
		ccp.createContact(driver, campaignName, title, department, officePhone, contactName, mobile, email, campaignId);
		
	}

}
