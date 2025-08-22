package ninza.CRMCampaigns;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import ninza.CRM.CampaignPage;
import ninza.CRM.CreateCampaignPage;
import ninza.CRM.LoginPage;
import ninzaCRM.genericUtilities.FileUtility;
import ninzaCRM.genericUtilities.JavaUtility;
import ninzaCRM.genericUtilities.WebDriverUtility;

public class CreateCampaign 
{

	public static void main(String[] args) throws IOException, InterruptedException
	{
		FileUtility fu = new FileUtility();
		
		JavaUtility ju = new JavaUtility();
		
		WebDriverUtility wdu = new WebDriverUtility();
		
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\Commondata.properties");
		
		Properties pobj = new Properties();
		
		pobj.load(fis);
		
		String browser = fu.readDataFromPropertyFile("browser");
		String url = fu.readDataFromPropertyFile("url");
		String username = fu.readDataFromPropertyFile("username");
		String password = fu.readDataFromPropertyFile("password");
		
		WebDriver driver = null;
		
		if(browser.equals("chrome"))
		{
			driver = new ChromeDriver();
		}
		else if(browser.equals("Edge"))
		{
			driver = new EdgeDriver();
		}
		else if(browser.equals("firefox"))
		{
			driver = new FirefoxDriver();
		}
		else
		{
			driver = new ChromeDriver();
		}
		
		wdu.implicitWait(driver);
		driver.get(url);
		
		wdu.maximizeWindow(driver);
		
		LoginPage lp = new LoginPage(driver);
		lp.loginToApplication(username, password);
		
		
		String campaignName = fu.readDataFromExcelFile("Sheet1", 1, 17);
		String campaignStatus = fu.readDataFromExcelFile("Sheet1", 1, 42);
		String targetSize = fu.readDataFromExcelFile("Sheet1", 1, 43);
		String expectedCloseDate = fu.readDataFromExcelFile("Sheet1", 1, 34);
		String targetAudience = fu.readDataFromExcelFile("Sheet1", 1, 44);
		String description = fu.readDataFromExcelFile("Sheet1", 1, 45);
		
		CampaignPage cp = new CampaignPage(driver);
		
		cp.clickOnCreateCampaign();
		
		CreateCampaignPage cc = new CreateCampaignPage(driver);
		
		cc.createCampaign(campaignName, campaignStatus, targetSize, expectedCloseDate, targetAudience, description);
		
		wdu.closeBrowser(driver);
		
		
	}

}

