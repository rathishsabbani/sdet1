package com.Vtiger;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateOrg {
	public class TestCase_001_CreateOrgtmodule
	{
		WebDriver driver ;
		@Test
	public void createorgnaization() throws Throwable {
		
	    FileInputStream fis = new FileInputStream ("..\\SDETHYD_1\\commond.properties");
	    Properties prop = new Properties ();
	    prop.load(fis);
	    
	    if
	    (prop.getProperty("browser").equalsIgnoreCase("Chrome"))
	    {
	    	driver = new ChromeDriver();
	    }
	    else if
	    (prop.getProperty("broswer").equalsIgnoreCase("ff"))
	    {
	    	driver = new FirefoxDriver();
	    }
		// WebDriver driver = new ChromeDriver();
	    driver.get(prop.getProperty("URL"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
		driver.findElement(By.name("user_name")).sendKeys(prop.getProperty("username"));
		driver.findElement(By.name("user_password")).sendKeys(prop.getProperty("password"));
		driver.findElement(By.id("submitButton")).click();
		
		driver.findElement(By.xpath("//a[text()='Organizations']")).click();
		
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

		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		Thread.sleep(4000);
		driver.close();
		}
	}
}
