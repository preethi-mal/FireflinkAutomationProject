package practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.testng.annotations.Test;

import ninza.CRM.LoginPage;
import ninzaCRM.genericUtilities.FileUtility;
import ninzaCRM.genericUtilities.JavaUtility;
import ninzaCRM.genericUtilities.WebDriverUtility;

public class CreatePurchaseOrderWithProductAndContactTest
{

	@Test
	public  void createPurchaseOrder() throws IOException, InterruptedException
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
		
//		driver.findElement(By.xpath("//input[@id='username']")).sendKeys(username);
//		driver.findElement(By.xpath("//input[@id='inputPassword']")).sendKeys(password);
//		driver.findElement(By.xpath("//button[text()='Sign In']")).click();
		
		LoginPage lp = new LoginPage(driver);
		lp.loginToApplication(username, password);
		
//		lp.getUsernameTF().sendKeys(username);
//		lp.getPasswordTF().sendKeys(password);
//		lp.getSignInBtn().click();
		
		driver.findElement(By.xpath("//a[text()='Contacts']")).click();
		driver.findElement(By.xpath("//span[text()='Create Contact']")).click();
		
		
		FileInputStream fis2 = new FileInputStream(".\\src\\test\\resources\\Testdata.xlsx");
		
		Workbook wb = WorkbookFactory.create(fis2);
		
		Sheet sh = wb.getSheet("Sheet1");
		
		String campaignName =fu.readDataFromExcelFile("Sheet1", 1, 3);
		String title = fu.readDataFromExcelFile("Sheet1", 1, 5);
		String department = fu.readDataFromExcelFile("Sheet1", 1, 14);
		String officePhone = fu.readDataFromExcelFile("Sheet1", 1, 15);
		String contactName = fu.readDataFromExcelFile("Sheet1", 1, 2);
		String mobile = fu.readDataFromExcelFile("Sheet1", 1, 4);
		String email = fu.readDataFromExcelFile("Sheet1", 1, 16);
		String campaign = fu.readDataFromExcelFile("Sheet1", 1, 17);
		
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
		
		
		
		driver.findElement(By.xpath("//a[text()='Products']")).click();
	
		driver.findElement(By.xpath("//span[text()='Add Product']")).click();
		
		String productName = sh.getRow(1).getCell(8).toString();
		String quantity = sh.getRow(1).getCell(7).toString();

		
		driver.findElement(By.xpath("//input[@name='productName']")).sendKeys(productName);
		driver.findElement(By.xpath("//input[@name='quantity']")).sendKeys(quantity);
		driver.findElement(By.xpath("//input[@name='price']")).click();
		
		act.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).keyDown(Keys.BACK_SPACE).keyUp(Keys.BACK_SPACE).sendKeys("80000").perform();
		
		
		driver.findElement(By.xpath("//select[@name='productCategory']")).click();
		driver.findElement(By.xpath("//option[@value='Electronics']")).click();
		driver.findElement(By.xpath("//select[@name='vendorId']")).click();
		driver.findElement(By.xpath("//option[@value='VID_001']")).click();
		driver.findElement(By.xpath("//button[text()='Add']")).click();
		
		Thread.sleep(6000); 
		
		driver.findElement(By.xpath("//a[text()='Purchase Order']")).click();
		driver.findElement(By.xpath("//span[text()='Create Order']")).click();
		
		String subject = sh.getRow(1).getCell(13).toString();
		String billingAddress=sh.getRow(1).getCell(18).toString();
		String shippingAddress=sh.getRow(1).getCell(19).toString();
		String billingPoBox=sh.getRow(1).getCell(20).toString();
		String shippingPoBox=sh.getRow(1).getCell(21).toString();
		String billingCity=sh.getRow(1).getCell(22).toString();
		String billingState=sh.getRow(1).getCell(23).toString();
		String billingPC=sh.getRow(1).getCell(24).toString();
		String billingCountry=sh.getRow(1).getCell(25).toString();
		String shippingCity=sh.getRow(1).getCell(26).toString();
		String shippingState=sh.getRow(1).getCell(27).toString();
		String shippingPC=sh.getRow(1).getCell(28).toString();
		String shippingCountry=sh.getRow(1).getCell(29).toString();
		
		
		driver.findElement(By.xpath("//input[@name='subject']")).sendKeys(subject);
		driver.findElement(By.xpath("//input[@name='dueDate']")).sendKeys("16-08-2025");
		driver.findElement(By.xpath("//input[@name='status']")).sendKeys("Ordered");
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
					WebElement ele = driver.findElement(By.xpath("//td[text()='sumit@gmail.com']"));
					driver.findElement(RelativeLocator.with(By.tagName("button")).toRightOf(ele)).click();
					break;
					
			}
			catch(Exception e)
			{
				driver.findElement(By.xpath("//button[@id='next-btn']")).click(); 
			}
		}
		
		driver.switchTo().window(mainwindow1);
		
		act.scrollByAmount(0, 480).perform();
		driver.findElement(By.xpath("//label[text()='Billing Address']/following-sibling::textarea")).sendKeys(billingAddress);
		driver.findElement(By.xpath("//label[text()='Shipping Address']/following-sibling::textarea")).sendKeys(shippingAddress);
		driver.findElement(By.xpath("//label[text()='Billing PO Box']/following-sibling::input")).sendKeys(billingPoBox);
		driver.findElement(By.xpath("//label[text()='Shipping PO Box']/following-sibling::input")).sendKeys(shippingPoBox);
		driver.findElement(By.xpath("//label[text()='Billing City']/following-sibling::input")).sendKeys(billingCity);
		driver.findElement(By.xpath("//label[text()='City']/following-sibling::input")).sendKeys(shippingCity);
		driver.findElement(By.xpath("//label[text()='Billing State']/following-sibling::input")).sendKeys(billingState);
		driver.findElement(By.xpath("//label[text()='State']/following-sibling::input")).sendKeys(shippingState);
		driver.findElement(By.xpath("//label[text()='Billing Postal Code']/following-sibling::input")).sendKeys(billingPC);
		driver.findElement(By.xpath("//label[text()='Postal Code']/following-sibling::input")).sendKeys(shippingPC);
		act.scrollByAmount(0, 150).perform();
		driver.findElement(By.xpath("//label[text()='Billing Country']/following-sibling::input")).sendKeys(billingCountry);
		driver.findElement(By.xpath("//label[text()='Country']/following-sibling::input")).sendKeys(shippingCountry);
		act.scrollByAmount(0, 600).perform();
		driver.findElement(By.xpath("//div[@style='margin-top: 20px;']//button[@type='button']")).click();

		String mainwindow2 = driver.getWindowHandle();
//		Set<String> windowHandles3 = driver.getWindowHandles();
//		
//		for(String window : windowHandles3)
//		{
//			if(!window.equals(mainwindow2))
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
					driver.findElement(By.xpath("//td[text()='VivoBook14']/following::button[@class='select-btn']")).click();
					break;
					
			}
			catch(Exception e)
			{
				driver.findElement(By.xpath("//button[@id='next-btn']")).click();
			}
		}
		
		driver.switchTo().window(mainwindow2);
		
		driver.findElement(By.xpath("//button[text()='Create Purchase Order']")).click();
		
		Thread.sleep(6000);
		
		WebElement icon = driver.findElement(By.xpath("//div[@class='user-icon']"));
		
		act.moveToElement(icon).perform();
		
		driver.findElement(By.xpath("//div[@class='dropdown-item logout']")).click();
		
		
		wb.close();
	
		
		
				
	}

}
