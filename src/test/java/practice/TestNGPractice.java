package practice;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestNGPractice
{
	
	@Test(priority = 1 , dataProvider = "CustomerInfo")
	public void create(String name , int id) // cust - name , id
	{
		// Assert.fail();
		System.out.println(name+ " and " +id+" created");
	}
	
	@Test(priority = -1 , invocationCount = 2 , dependsOnMethods = "create")
	public void modify()
	{
		System.out.println("modify");
	}
	
	@Test(enabled = false , dependsOnMethods = {"create" , "modify"})
	public void delete()
	{
		System.out.println("delete");
	}
	
	@DataProvider(name = "CustomerInfo")
	public Object[][] getData()
	{
		// 4 rows and 2 columns -> 4 data sets with 2 info each
		
		Object[][] data = new Object[4][2];
		
		data[0][0] = "Preethi";
		data[0][1] = 1;
		
		data[1][0] = "Harika";
		data[1][1] = 2;
		
		data[2][0] = "Ram";
		data[2][1] = 3;
		
		data[3][0] = "Krishn";
		data[3][1] = 4;
		
		return data;
	}

}
