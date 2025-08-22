package practice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RetryAnalyserPractice
{
	@Test(retryAnalyzer = ninzaCRM.genericUtilities.IRetryAnalyserImplementation.class)
	public void sample()
	{
		Assert.fail();
		System.out.println("Demo");
	}

}
