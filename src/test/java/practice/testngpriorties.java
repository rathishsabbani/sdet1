package practice;

import org.testng.annotations.Test;

public class testngpriorties {
	@Test(priority =1)
public void CreateOrg() {
		System.out.println("00");
	}
	@Test(priority =2)
	public void modifyOrg() {
		System.out.println("01");
		}
	@Test (priority = 3)
	public void delOrg(){
		System.out.println("02");
}
}
