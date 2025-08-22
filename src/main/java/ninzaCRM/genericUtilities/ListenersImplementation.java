package ninzaCRM.genericUtilities;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

/**
 * 
 */
public class ListenersImplementation implements ITestListener 
{
	ExtentReports report;
	ExtentTest test ;

	@Override
	public void onTestStart(ITestResult result)
	{
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName +"-----test execution started");
		
		// 	Intimate extent reports for @Test start
		
		test = report.createTest(methodName);
		
	}

	@Override
	public void onTestSuccess(ITestResult result)
	{
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName +"-----Test execution PASS");
		
		// log the status of @Test as PASS in the extent report
		test.log(Status.PASS, methodName +"-----Test execution PASS");
		
	}

	@Override
	public void onTestFailure(ITestResult result)
	{
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName +"-----Test execution FAIL");
		
		// log the status as FAIL in extent reports
		test.log(Status.FAIL,methodName +"-----Test execution FAIL");
		
		// Capture the exception
		System.out.println(result.getThrowable());
		
		// log the exception in extent reports
		test.log(Status.WARNING, result.getThrowable());
		
		// Capture the Screenshot
		JavaUtility ju = new JavaUtility();
		WebDriverUtility wu = new WebDriverUtility();
		
		// ScreenshotName  = method name + date and time
		String screenshotName = methodName+ju.getSystemDate(); 
		
		try
		{
			
			String path = wu.captureScreenshot(BaseClass.sdriver, screenshotName);
			
			// attach screenshot to report
			test.addScreenCaptureFromPath(path);
			
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result)
	{
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName +"-----Test execution SKIP");
		
		// log the SKIP status to extent report
		test.log(Status.SKIP, methodName +"-----Test execution SKIP");
		
		// Capture the exception
		System.out.println(result.getThrowable());
		
		// log the exception to extent report
		test.log(Status.WARNING, result.getThrowable());	
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result)
	{
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result)
	{
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedWithTimeout(result);
	}

	@Override
	public void onStart(ITestContext context)
	{
		System.out.println("-----------Suite Exceution started----------------");
		
		//Extent Report Configuration
		ExtentSparkReporter esr = new ExtentSparkReporter(".\\ExtentReports\\Extent-Report-"+new JavaUtility().getSystemDate()+".html");
		esr.config().setDocumentTitle("Ninza CRM Automation Report");
		esr.config().setTheme(Theme.DARK);
		esr.config().setReportName("Web Automation Execution Report");
		
		report = new ExtentReports();
		report.attachReporter(esr);
		report.setSystemInfo("Base Browser", "Microsoft Edge");
		report.setSystemInfo("Base Platform", "Windows");
		report.setSystemInfo("Base URL", "Test Env");
		report.setSystemInfo("Reporter Name", "Preethi");
		
		
	}

	@Override
	public void onFinish(ITestContext context)
	{
		System.out.println("-----Suite Exceution finished----");
		
		//Report generation
		report.flush();
	}
	
}
