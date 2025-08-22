package practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.locators.RelativeLocator;

import ninzaCRM.genericUtilities.FileUtility;
import ninzaCRM.genericUtilities.JavaUtility;
import ninzaCRM.genericUtilities.WebDriverUtility;

public class CreateSalesOrderWithMandatoryFields
{

	public static void main(String[] args) throws IOException, InterruptedException
	{
		FileUtility fu = new FileUtility();
		
		JavaUtility ju = new JavaUtility();
		
		WebDriverUtility wdb = new WebDriverUtility();
		
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\Commondata.properties");
		
		Properties pobj = new Properties();
		
		pobj.load(fis);
		
		String browser = fu.readDataFromPropertyFile("browser");
		String url = fu.readDataFromPropertyFile("url");
		String username = fu.readDataFromPropertyFile("username");
		String password = fu.readDataFromPropertyFile("password");
		
		
		
		WebDriver driver = null;
		WebElement element;
		
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
		
		wdb.implicitWait(driver);
		driver.get(url);
		
		wdb.maximizeWindow(driver);
		
		Actions act = new Actions(driver);
		
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys(username);
		driver.findElement(By.xpath("//input[@id='inputPassword']")).sendKeys(password);
		driver.findElement(By.xpath("//button[text()='Sign In']")).click();
		
		driver.findElement(By.xpath("//a[text()='Contacts']")).click();
		driver.findElement(By.xpath("//span[text()='Create Contact']")).click();
		
		
		FileInputStream fis2 = new FileInputStream(".\\src\\test\\resources\\Testdata.xlsx");
		
		Workbook wb = WorkbookFactory.create(fis2);
		
		Sheet sh = wb.getSheet("Sheet1");
		
		String campaignName = sh.getRow(1).getCell(3).toString();
		String title = sh.getRow(1).getCell(5).toString();
		String department = sh.getRow(1).getCell(14).toString();
		String officePhone = sh.getRow(1).getCell(15).toString();
		String contactName = sh.getRow(1).getCell(2).toString();
		String mobile = sh.getRow(1).getCell(4).toString();
		String email = sh.getRow(1).getCell(16).toString();
		String campaign = sh.getRow(1).getCell(17).toString();
		
		driver.findElement(By.xpath("//input[@name='organizationName']")).sendKeys(campaignName);
		driver.findElement(By.xpath("//input[@name='title']")).sendKeys(title);
		driver.findElement(By.xpath("//input[@name='department']")).sendKeys(department);
		driver.findElement(By.xpath("//input[@name='officePhone']")).sendKeys(officePhone);
		driver.findElement(By.xpath("//input[@name='contactName']")).sendKeys(contactName);
		driver.findElement(By.xpath("//input[@name='mobile']")).sendKeys(mobile);
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys(email);
		driver.findElement(By.xpath("//*[local-name()='svg' and @class='svg-inline--fa fa-plus ']")).click();
		
		String mainwindow = driver.getWindowHandle();
//		
//		Set<String> windowHandles = driver.getWindowHandles();
//		
//		for(String window : windowHandles)
//		{
//			if(!window.equals(mainwindow))
//			{
//				driver.switchTo().window(window);
//			}
//		}
		
		wdb.switchToWindow(driver);
		
		driver.findElement(By.xpath("//button[text()='Select']")).click();
		
		driver.switchTo().window(mainwindow);
		
		act.scrollByAmount(0, 500).perform();
		
		driver.findElement(By.xpath("//button[text()='Create Contact']")).click();
		
		Thread.sleep(6000);
		
		driver.findElement(By.xpath("//a[text()='Opportunities']")).click();
		driver.findElement(By.xpath("//span[text()='Create Opportunity']")).click();
		
		String opportunityName = sh.getRow(1).getCell(30).toString();
		String amount = sh.getRow(1).getCell(31).toString();
		String businessType = sh.getRow(1).getCell(32).toString();
		String assignedTo = sh.getRow(1).getCell(33).toString();
		String expectedClosedate = sh.getRow(1).getCell(34).toString();
		String nextStep = sh.getRow(1).getCell(35).toString();
		String salesStage = sh.getRow(1).getCell(36).toString();
		String probability = sh.getRow(1).getCell(37).toString();
		String description = sh.getRow(1).getCell(39).toString();
		
		driver.findElement(By.xpath("//input[@name='nextStep']")).sendKeys(nextStep);
		driver.findElement(By.xpath("//input[@name='opportunityName']")).sendKeys(opportunityName);
		driver.findElement(By.xpath("//input[@name='salesStage']")).sendKeys(salesStage);
		driver.findElement(By.xpath("//input[@name='amount']")).sendKeys(amount);
		driver.findElement(By.xpath("//input[@name='probability']")).sendKeys(probability);
		driver.findElement(By.xpath("//input[@name='businessType']")).sendKeys(businessType);
		driver.findElement(By.xpath("//input[@type='text']/following-sibling::button")).click();
		String mainwindow1 = driver.getWindowHandle();
//		
//		Set<String> windowHandles2 = driver.getWindowHandles();
//		
//		for(String window : windowHandles2)
//		{
//			if(!window.equals(mainwindow1))
//			{
//				driver.switchTo().window(window);
//				driver.manage().window().maximize();
//			}
//		}
		wdb.switchToWindow(driver);
		wdb.maximizeWindow(driver);
		while(true)
		{

			try
			{
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
				driver.findElement(By.xpath("//td[text()='Ratna']/following::button[@class='select-btn']")).click();
					break;
					
			}
			catch(Exception e)
			{
				driver.findElement(By.xpath("//button[@id='next-btn']")).click(); 
			}
		}
		driver.switchTo().window(mainwindow1);
		act.scrollByAmount(0, 400).perform();
		driver.findElement(By.xpath("//input[@name='assignedTo']")).sendKeys(assignedTo);
		driver.findElement(By.xpath("//textarea[@name='description']")).sendKeys(description);
		driver.findElement(By.xpath("//input[@name='expectedCloseDate']")).sendKeys(expectedClosedate);
		driver.findElement(By.xpath("//button[text()='Create Opportunity']")).click();
		
		Thread.sleep(6000);
		
		driver.findElement(By.xpath("//a[text()='Quotes']")).click();
		
		driver.findElement(By.xpath("//span[text()='Create Quote']")).click();
		
		String validTill = sh.getRow(1).getCell(40).toString();
		String quoteStage = sh.getRow(1).getCell(41).toString();
		String subject = sh.getRow(1).getCell(13).toString();
		
		driver.findElement(By.xpath("//input[@name='subject']")).sendKeys(subject);
		driver.findElement(By.xpath("//input[@name='validTill']")).sendKeys(validTill);
		driver.findElement(By.xpath("//input[@name='quoteStage']")).sendKeys(quoteStage);
		
		
		
		
		
		
		
		
		

	}

}
