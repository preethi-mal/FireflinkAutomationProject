package ninza.CRMContacts;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import ninza.CRM.ContactPage;
import ninza.CRM.CreateContactPage;
import ninza.CRM.DashboardPage;
import ninza.CRM.LoginPage;
import ninzaCRM.genericUtilities.FileUtility;
import ninzaCRM.genericUtilities.JavaUtility;
import ninzaCRM.genericUtilities.WebDriverUtility;

public class CreateContact
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
		
		String campaignName =fu.readDataFromExcelFile("Sheet1", 1, 3);
		String title = fu.readDataFromExcelFile("Sheet1", 1, 5);
		String department = fu.readDataFromExcelFile("Sheet1", 1, 14);
		String officePhone = fu.readDataFromExcelFile("Sheet1", 1, 15);
		String contactName = fu.readDataFromExcelFile("Sheet1", 1, 2);
		String mobile = fu.readDataFromExcelFile("Sheet1", 1, 4);
		String email = fu.readDataFromExcelFile("Sheet1", 1, 16);
		String campaignId = "CAM00001";
		
		DashboardPage db = new DashboardPage(driver);
		db.contactClick();
		
		ContactPage cp = new ContactPage(driver);
		
		cp.clickOnCreateContact();
		
		CreateContactPage cc = new CreateContactPage(driver);
		
		cc.createContact(driver, campaignName, title, department, officePhone, contactName, mobile, email, campaignId);
		
		wdu.closeBrowser(driver);	
		
	}

}
