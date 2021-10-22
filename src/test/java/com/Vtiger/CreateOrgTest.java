package com.Vtiger;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import Objectrepo.Baseclass;
import objectrepos.HomePage;


	public class CreateOrgTest extends Baseclass
	{
		//WebDriver driver ;
		@Test(groups="smoke")
	public void createorgnaization() throws Throwable {
		
	    

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		HomePage hp = new HomePage(driver);
		hp.getOrglink().click();
		
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		driver.findElement(By.name("accountname")).sendKeys("SRS");
		WebElement industryDropDown = driver.findElement(By.name("industry"));
		Select industryDD = new Select(industryDropDown);
		industryDD.selectByVisibleText("Construction");
		
		WebElement ratingDropDown = driver.findElement(By.name("rating"));
		Select ratingDD = new Select(ratingDropDown);
		ratingDD.selectByValue("Market Failed");
		
		WebElement accounttypeDropDown = driver.findElement(By.name("accounttype"));
		Select accounttypeDD = new Select(accounttypeDropDown);
		accounttypeDD.selectByIndex(3);
		
		driver.findElement(By.xpath("//a[text()='Organizations']")).click();
		driver.findElement(By.xpath("//input[@class='txtBox']")).sendKeys("SRS");

		WebElement searchfldDropdown=driver.findElement(By.name("search_field"));
		Select searchfldyDD = new Select(searchfldDropdown);
		searchfldyDD.selectByVisibleText("Organization Name");
		driver.findElement(By.name("submit")).click();
		WebElement actulelement=driver.findElement(By.xpath("//a[@title='Organizations' and text()='SRS']"));
		System.out.println(actulelement.isDisplayed());
         Assert.assertEquals(actulelement.isDisplayed(), true);
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"))).build().perform();

		
		
		}
	}
