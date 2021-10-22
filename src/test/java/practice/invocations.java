package practice;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class invocations {
	@Test(invocationCount=2)
	public void CreateOrg()
	{
		Reporter.log("starting");
	}
	
	

}
