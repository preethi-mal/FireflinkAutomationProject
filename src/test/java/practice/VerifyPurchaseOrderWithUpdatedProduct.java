package practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Set;

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
import org.openqa.selenium.support.ui.Select;

import ninzaCRM.genericUtilities.FileUtility;
import ninzaCRM.genericUtilities.JavaUtility;
import ninzaCRM.genericUtilities.WebDriverUtility;

public class VerifyPurchaseOrderWithUpdatedProduct 
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
		
		FileInputStream fis2 = new FileInputStream(".\\src\\test\\resources\\Testdata.xlsx");
		
		Workbook wb = WorkbookFactory.create(fis2);
		
		Sheet sh = wb.getSheet("Sheet1");
		
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
		String productName = sh.getRow(1).getCell(8).toString();
		
		
		driver.findElement(By.xpath("//input[@name='subject']")).sendKeys(subject);
		driver.findElement(By.xpath("//input[@name='dueDate']")).sendKeys("16-08-2025");
		driver.findElement(By.xpath("//input[@name='status']")).sendKeys("Vivobook Ordered");
		driver.findElement(By.xpath("//input[@type='text']/following-sibling::button")).click();
		String mainwindow1 = driver.getWindowHandle();
		
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
		driver.manage().window().maximize();
		
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
		driver.manage().window().maximize();
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
		
		driver.findElement(By.xpath("//a[text()='Products']")).click();
		
		WebElement ele = driver.findElement(By.xpath("//select[@class='form-control']"));
		
		Select slt = new Select(ele);
		
		slt.selectByVisibleText("Search by Product Name");
		
		driver.findElement(By.xpath("//input[@placeholder='Search by product Name']")).sendKeys(productName);
		Thread.sleep(4000);
		driver.findElement(By.xpath("//td[text()='IM_PROD_4179']/following-sibling::td[text()='VivoBook14']/following-sibling::td[text()='VID_001']/following-sibling::td[text()='11/08/2025']/following-sibling::td[text()='Not Modified']/following-sibling::td[text()='Electronics']/following-sibling::td//a[@class='edit']")).click();
		driver.findElement(By.xpath("//input[@name='price']")).click();
		act.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).keyDown(Keys.BACK_SPACE).keyUp(Keys.BACK_SPACE).sendKeys("85000").perform();
		Thread.sleep(6000);
		driver.findElement(By.xpath("//a[text()='Purchase Order']")).click();
		WebElement ele2 = driver.findElement(By.xpath("//select[@class='form-control']"));
		Select sltt = new Select(ele2);
		sltt.selectByVisibleText("Search by Subject");
		driver.findElement(By.xpath("//input[@placeholder='Search by Subject']")).sendKeys("SubjectVB");
		
		Thread.sleep(4000);
		
		driver.findElement(By.xpath("//td[text()='PO00340']/following-sibling::td[text()='SubjectVB']/following-sibling::td[text()='CON00939']/following-sibling::td[text()='Vivobook Ordered']/following-sibling::td[text()='2025-08-16']/following-sibling::td[text()='80000']/following-sibling::td//a[@class='edit']")).click();
		driver.findElement(By.xpath("//button[text()='Update Purchase Order']")).click();
		Thread.sleep(6000);
		
		WebElement icon = driver.findElement(By.xpath("//div[@class='user-icon']"));
		
		act.moveToElement(icon).perform();
		
		driver.findElement(By.xpath("//div[@class='dropdown-item logout']")).click();
		
		
		wb.close();

	}

}
