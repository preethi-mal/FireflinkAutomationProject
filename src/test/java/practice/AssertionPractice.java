package practice;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertionPractice
{
	@Test
	public void sampleTest()
	{
		System.out.println("Step 1");
		System.out.println("Step 2");
		System.out.println("Step 3");
		
		Assert.assertEquals(1, 1); // match
		
		System.out.println("Step 4");
		
		Assert.assertEquals("a", "b");
		
		System.out.println("Step 5");
	}
	
	@Test
	public void sampleTestSoft()
	{
		SoftAssert sa = new SoftAssert();
		System.out.println("Step 1");
		System.out.println("Step 2");
		
		Assert.assertEquals(1, 0); 
		
		System.out.println("Step 3");
		
		sa.assertEquals(0, 1);
		
		System.out.println("Step 4");
		
		sa.assertEquals("a", "a");
		
		System.out.println("Step 5");
		
		sa.assertAll();
		
		
	}

}
