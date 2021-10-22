package Objectrepo;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class sample {
	@BeforeMethod
	public void before()
	{
		System.out.println("sample");	
		}
	@AfterMethod
	public void after()
	{
		System.out.println("test1");	
	}
	@Test
	public void script() {
		System.out.println("test2");
	}
;
	@Test
	public void test()
	{
		System.out.println("test3");
		Assert.assertEquals(true, false);
	}
	
	
	
	

}
