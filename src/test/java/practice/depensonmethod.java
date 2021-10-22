package practice;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class depensonmethod {
	@Test
	public void createOrg()
	{
	Reporter.log("true");	
	}
	
	@Test(dependsOnMethods = "CreateOrg")
	public void modifyOrg()
	{
		Reporter.log("true or false");	
	}
	@Test(dependsOnMethods = "modifyOrg")
	public void delOrg() {
		Reporter.log("completed");
	}
	

}
