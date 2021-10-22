package com.Vtiger;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import Objectrepo.Baseclass;
import objectrepos.HomePage;


public class ContactmoduleTest extends Baseclass{
	@Test(groups="smoke")
	public void createcontact() throws InterruptedException 
	{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		HomePage hp = new HomePage(driver);
		hp.getContactslink().click();
		
		//step 3 click on org link
		driver.findElement(By.xpath("//a[text()='Contacts']")).click();

		//step 4 clcik on + btn
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();

		//step 5
		WebElement intialsDD=driver.findElement(By.name("salutationtype"));

		Select intialsDropdown= new Select(intialsDD);
		intialsDropdown.selectByVisibleText("Mr.");

		driver.findElement(By.name("firstname")).sendKeys("SHAM");

		driver.findElement(By.name("lastname")).sendKeys("QSP");

		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

		Thread.sleep(3000);

		driver.findElement(By.xpath("//a[text()='Contacts']")).click();

		// Check contact is created or not
		driver.findElement(By.xpath("//input[@class='txtBox']")).sendKeys("SHAM");

		WebElement searchfldDropdown=driver.findElement(By.name("search_field"));
		Select searchfldyDD = new Select(searchfldDropdown);
		searchfldyDD.selectByVisibleText("First Name");
        //Assert .assertFalse(false);
		driver.findElement(By.name("submit")).click();

		// Validate with Assert
		WebElement actulelement=driver.findElement(By.xpath("//a[@title='Contacts' and text()='SHAM']"));

		System.out.println(actulelement.isDisplayed());

		Assert.assertEquals(actulelement.isDisplayed(), true);

		//Logout from App
//		Actions action = new Actions(driver);
//		action.moveToElement(driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"))).build().perform();
//
//		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
//		
//		//Close the browser
//		Thread.sleep(5000);
//		driver.close();
	}
}
