package ninzaCRM.genericUtilities;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.WheelInput.ScrollOrigin;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * This class consists of generic mothods related to WebDriver operations 
 * @author M Preethi
 */
public class WebDriverUtility
{
	/**
	 * This method is used to maximize the window
	 * @param driver
	 */
	public void maximizeWindow(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	
	/**
	 * This method is used to minimize the window
	 * @param driver
	 */
	public void minimizeWindow(WebDriver driver)
	{
		driver.manage().window().minimize();
	}
	
	/**
	 * This method is used to get the fullscreen of the window
	 * @param driver
	 */
	public void fullscreenWindow(WebDriver driver)
	{
		driver.manage().window().fullscreen();
	}
	
	public void switchTo(WebDriver driver , String title)
	{
		driver.switchTo().window(title);
	}
	
	/**
	 * This method is used to add the implicit wait
	 * @param driver
	 */
	public void implicitWait(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	
	/**
	 * This method is used to close the browser
	 * @param driver
	 */
	public void closeBrowser(WebDriver driver)
	{
		driver.quit();
	}
	
	/**
	 * This method is used to add the explicit wait and check the visiblity of the element
	 * @param driver
	 * @param ele
	 */
	public void waitForElementToBeVisible(WebDriver driver , WebElement ele)
	{
		WebDriverWait wd = new WebDriverWait(driver,Duration.ofSeconds(10));
		wd.until(ExpectedConditions.visibilityOf(ele));
	}
	
	/**
	 * This method is used to add the explicit wait and and check whether the element is clickable or not
	 * @param driver
	 * @param ele
	 */
	public void waitForElementToBeClickable(WebDriver driver , WebElement ele)
	{
		WebDriverWait wd = new WebDriverWait(driver,Duration.ofSeconds(10));
		wd.until(ExpectedConditions.elementToBeClickable(ele));
	}
	
	/**
	 * This method is used to get the element  of particular given index
	 * @param ele
	 * @param index
	 */
	public void handleDropdown(WebElement ele, int index)
	{
		Select slt = new Select(ele);
		slt.selectByIndex(index);
	}
	
	/**
	 * This method is used to get the element of particular given value
	 * @param ele
	 * @param value
	 */
	public void handleDropdown(WebElement ele , String value)
	{
		Select slt = new Select(ele);
		slt.selectByValue(value);
	}
	
	/**
	 * This method is used to select the element of the given visible text
	 * @param visibletext
	 * @param ele
	 */
	public void handleDropdown( String visibletext,WebElement ele)
	{
		Select slt = new Select(ele);
		slt.selectByContainsVisibleText(visibletext);
	}
	
	/**
	 * This method is used to perform mouseOveringAction
	 * @param driver
	 * @param ele
	 */
	public void mouseOveringAction(WebDriver driver,WebElement ele)
	{
		Actions act = new Actions(driver);
		act.moveToElement(ele);
	}
	
	/**
	 * This method is used to perform mouseOveringAction
	 * @param driver
	 * @param srcele
	 * @param desele
	 */
	public void draganddropAction(WebDriver driver,WebElement srcele, WebElement desele)
	{
		Actions act = new Actions(driver);
		act.dragAndDrop(srcele, desele);
	}
	
	/**
	 * This method is used to perform mouseOvering Action
	 * @param driver
	 * @param ele
	 */
	public void clickandHoldAction(WebDriver driver,WebElement ele)
	{
		Actions act = new Actions(driver);
		act.clickAndHold(ele);
	}
	
	/**
	 * This method is used to perform release Action
	 * @param driver
	 * @param ele
	 */
	public void releaseAction(WebDriver driver,WebElement ele)
	{
		Actions act = new Actions(driver);
		act.release(ele);
	}
	
	/**
	 * This method is used to perform movebyoffset Action
	 * @param driver
	 * @param x
	 * @param y
	 */
	public void movebyoffsetAction(WebDriver driver,int x , int y)
	{
		Actions act = new Actions(driver);
		act.moveByOffset(x, y);
	}
	
	/**
	 * This method is used to perform doubleclick Action
	 * @param driver
	 * @param ele
	 */
	public void doubleclickAction(WebDriver driver,WebElement ele)
	{
		Actions act = new Actions(driver);
		act.contextClick(ele);
	}
	
	/**
	 * This method is used to perform contextclick Action
	 * @param driver
	 * @param ele
	 */
	public void contextclickAction(WebDriver driver,WebElement ele)
	{
		Actions act = new Actions(driver);
		act.contextClick(ele);
	}
	
	/**
	 * This method is used to scroll the page
	 * @param driver
	 * @param x
	 * @param y
	 */
	public void scrollAction(WebDriver driver , int x, int y)
	{
		Actions act = new Actions(driver);
		act.scrollByAmount(x, y).perform();
	}
	
	/**
	 * This method is used to scroll till the web element
	 * @param driver
	 * @param ele
	 */
	public void scrollAction(WebDriver driver , WebElement ele)
	{
		Actions act = new Actions(driver);
		act.scrollToElement(ele).perform();
		
	}
	
	/**
	 * This method is used to scroll in the inner web page based on the axises
	 * @param driver
	 * @param ele
	 * @param x
	 * @param y
	 */
	public void scrollAction(WebDriver driver , WebElement ele, int x , int y)
	{
		Actions act = new Actions(driver);
		act.scrollFromOrigin(ScrollOrigin.fromElement(ele), x, y).perform();
	}
	
	
	/**
	 * This method is used to switch to the frame based on the index of frame
	 * @param driver
	 * @param index
	 */
	public void handleFrames(WebDriver driver, int index)
	{
		driver.switchTo().frame(index);
	}
	
	/**
	 * This method is used to switch to the frame based on the name of the frame
	 * @param driver
	 * @param name
	 */
	public void handleFrames(WebDriver driver, String name)
	{
		driver.switchTo().frame(name);
	}
	
	/**
	 * This method is used to switch to the frame based on the web element in the frame
	 * @param driver
	 * @param ele
	 */
	public void handleFrames(WebDriver driver, WebElement ele)
	{
		driver.switchTo().frame(ele);
	}
	
	/**
	 * This method is used to switch to the immediate parent frame of current frame
	 * @param driver
	 */
	public void switchToParentFrame(WebDriver driver)
	{
		driver.switchTo().parentFrame();
	}
	
	/**
	 * This method is used to switch to the main page from current frame
	 * @param driver
	 */
	public void switchToMainFrame(WebDriver driver)
	{
		driver.switchTo().defaultContent();
	}
	
	/**
	 * This method is used to accept the alert 
	 * @param driver
	 */
	public void acceptAlert(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
	
	/**
	 * This method is used to dismiss the alert 
	 * @param driver
	 */
	public void dismissAlert(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}
	
	/**
	 * This method is used to send the input to  the alert 
	 * @param driver
	 * @param input
	 */
	public void sendTextToAlert(WebDriver driver, String input)
	{
		driver.switchTo().alert().sendKeys(input);
	}
	
	/**
	 * This method is used to get the text of the alert 
	 * @param driver
	 */
	public String getTextAlert(WebDriver driver)
	{
		return driver.switchTo().alert().getText();
	}
	
	/**
	 * This method is used to switch to the other window based on mainwindow
	 * @param driver
	 */
	public void switchToWindow(WebDriver driver)
	{
		String mainwindow = driver.getWindowHandle();
		
		Set<String> windowhandles = driver.getWindowHandles();
		
		for(String window : windowhandles)
		{
			if(!window.equals(mainwindow))
			{
				driver.switchTo().window(window);
			}
		}
	}
	
	/**
	 * This method is used to switch to the other window based on titles 
	 * @param driver
	 * @param currentwindowtitle
	 */
	public void switchToWindow(WebDriver driver , String currentwindowtitle)
	{
		Set<String> windowhandles = driver.getWindowHandles();
		
		for(String window : windowhandles)
		{
			driver.switchTo().window(window);
			String title = driver.getTitle();
			if(title.contains(currentwindowtitle))
			{
				//driver.switchTo().window(title);
				break;
			}
		}
		
	}
	
	/**
	 * This method is used to captures the screenshot and return the path to caller
	 * @param driver
	 * @param screenshotName
	 * @return
	 * @throws IOException
	 */
	public String captureScreenshot(WebDriver driver , String screenshotName) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dst = new File(".\\Screenshots\\"+screenshotName+".png");
		
		FileHandler.copy(src, dst);
		
		return dst.getAbsolutePath(); // for Extent Reports
	}

}
