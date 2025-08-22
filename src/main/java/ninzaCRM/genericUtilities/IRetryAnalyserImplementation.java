package ninzaCRM.genericUtilities;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

/**
 * 
 */
public class IRetryAnalyserImplementation implements IRetryAnalyzer
{
	int count = 0;
	int retrycount = 3; // Manual Analysis // FAIL
	
	public boolean retry(ITestResult result)
	{
		// 0-T , 1-T , 2-T , 3-F
		while(count<retrycount) // recounts = 3
		{
			count++; // 1 2 3
			return true; // retry retry retry
		}
		
		return false; // stop retry
	}
}
