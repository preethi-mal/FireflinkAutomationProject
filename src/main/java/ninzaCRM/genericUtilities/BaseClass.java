package ninzaCRM.genericUtilities;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import io.github.bonigarcia.wdm.WebDriverManager;
import ninza.CRM.DashboardPage;
import ninza.CRM.LoginPage;

public class BaseClass
{
	public FileUtility fu = new FileUtility();
	public JavaUtility ju = new JavaUtility();
	public WebDriverUtility wu = new WebDriverUtility();
	
	public WebDriver driver ;
	
	public static WebDriver sdriver ;
	
	@BeforeSuite(alwaysRun=true)
	public void bsConfig()
	{
		System.out.println("Database connection established");
	}
	
	// @Parameters("browser")
	// @BeforeTest
	@BeforeClass(alwaysRun=true)
	public void bcConfig(/*String BROWSER*/) throws IOException
	{
		String BROWSER = fu.readDataFromPropertyFile("browser");
		String URL = fu.readDataFromPropertyFile("url");
		
		if(BROWSER.equals("chrome"))
		{
			driver = new ChromeDriver();
		}
		else if(BROWSER.equals("Edge"))
		{
			driver = new EdgeDriver();
		}
		else if(BROWSER.equals("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		else
		{
			driver = new ChromeDriver();
		}
		
		// driver reference for the ListenersImplemententation class
		
		sdriver = driver;
		
		wu.implicitWait(driver);
		wu.maximizeWindow(driver);
		driver.get(URL);
		
		System.out.println("Browser launch successfull");	
		
	}
	
	@BeforeMethod(alwaysRun=true)
	public void bmConfig() throws IOException
	{
		String USERNAME = fu.readDataFromPropertyFile("username");
		String PASSWORD = fu.readDataFromPropertyFile("password");
		
		LoginPage lp = new LoginPage(driver);
		lp.loginToApplication(USERNAME, PASSWORD);
		
		System.out.println("Login to App Successfull");
		
	}
	
	@AfterMethod(alwaysRun=true)
	public void amConfig()
	{
		DashboardPage db = new DashboardPage(driver);
		db.userIconClick();
		db.logoutBtnClick();
	}
	
	// @AfterTest
	@AfterClass(alwaysRun=true)
	public void acConfig()
	{
		driver.quit();
		System.out.println("Browser closed successfully");	
	}
	
	@AfterSuite(alwaysRun=true)
	public void asConfig()
	{
		System.out.println("Database connection closed");
	}

}
