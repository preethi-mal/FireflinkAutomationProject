package ninza.CRMCampaigns;

import java.io.IOException;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import ninza.CRM.CampaignPage;
import ninza.CRM.CreateCampaignPage;
import ninza.CRM.DashboardPage;
import ninzaCRM.genericUtilities.BaseClass;

@Listeners(ninzaCRM.genericUtilities.ListenersImplementation.class)
public class CreateCampaignTest extends BaseClass
{
	@Test(groups ="SmokeSuite")
	public void tc_e2e_01_createCampaign() throws IOException, InterruptedException
	{
		// Read Test data from excel
		
		String campaignName = fu.readDataFromExcelFile("Sheet1", 1, 17);
		String campaignStatus = fu.readDataFromExcelFile("Sheet1", 1, 42);
		String targetSize = fu.readDataFromExcelFile("Sheet1", 1, 43);
		String expectedCloseDate = fu.readDataFromExcelFile("Sheet1", 1, 34);
		String targetAudience = fu.readDataFromExcelFile("Sheet1", 1, 44);
		String description = fu.readDataFromExcelFile("Sheet1", 1, 45);
		
		// Click on Campaigns Link
		
		DashboardPage db = new DashboardPage(driver);
		db.campaignClick();
		Reporter.log("clicked on campaign link" , true);// report 
		
		CampaignPage cp = new CampaignPage(driver);
		cp.clickOnCreateCampaign();
		Reporter.log("clicked on create campaign button" , true);
		
		// Assert.fail();
		
		CreateCampaignPage ccp = new CreateCampaignPage(driver);
		ccp.createCampaign(campaignName, campaignStatus, targetSize, expectedCloseDate, targetAudience, description);
		Reporter.log("Campaign created successfully" , true);
	}
	
	@Test(groups ="RegressionSuite")
	public void testSample()
	{
		System.out.println("Sample");
	}
	
	@Test
	public void sample()
	{
		//Assert.fail();
		System.out.println("Sample Regional Regression");
	}
	
	
	@Test
	public void sample2()
	{
		System.out.println("Sample Regional Regression 2");
	}

}
