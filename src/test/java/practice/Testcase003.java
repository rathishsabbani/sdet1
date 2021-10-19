package practice;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Testcase003 {
	
	    WebDriver driver;
	    @Test
	    public void Tc03_TestCase() throws Throwable{
		{
			
	    	 FileInputStream fis = new FileInputStream("..\\SDETHYD_1\\commond.properties");
				Properties prop = new Properties();
				prop.load(fis);

				FileInputStream fs = new FileInputStream("..\\SDETHYD_1\\assign.xlsx");
				Workbook wb = WorkbookFactory.create(fs);
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
			driver.get(prop.getProperty("URL"));

			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.manage().window().maximize();

			driver.findElement(By.name("user_name")).sendKeys(prop.getProperty("username"));
			driver.findElement(By.name("user_password")).sendKeys(prop.getProperty("password"));
			driver.findElement(By.id("submitButton")).click();

			
			//clicking on contact tab
			driver.findElement(By.xpath("//a[text()='Contacts']")).click();

			//click on + button
			driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
			
			
			//selecting first name in dropdown
					String abc1 = wb.getSheet("Sheet1").getRow(0).getCell(4).toString();
					WebElement First = driver.findElement(By.name("salutationtype"));
					Select Firstdd = new Select(First);
					Firstdd.selectByValue(abc1);
					
			//Entering the lastname
					String b1 = wb.getSheet("Sheet1").getRow(3).getCell(0).toString();
					driver.findElement(By.name("lastname")).sendKeys(b1);
					
					//clicking the dropdown of leadsource
					String b2 = wb.getSheet("Sheet1").getRow(3).getCell(1).toString();
					WebElement Leadsource = driver.findElement(By.name("leadsource"));
					Select Lead = new Select(Leadsource);
					Lead.selectByValue(b2);
					
					//Entering data in Home mobile
					String b3 = wb.getSheet("Sheet1").getRow(3).getCell(2).toString();
					driver.findElement(By.id("otherphone")).sendKeys(b3);
					
					//click on Do not call checkbox
					driver.findElement(By.name("donotcall")).click();
		 
					 //scrolldown
					
					WebElement element= driver.findElement(By.name("portal"));
					Point loc= element.getLocation();
					JavascriptExecutor jse= (JavascriptExecutor) driver;
					jse.executeScript("window.scrollBy"+loc);
		
		
					//Selecting Date
					driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Calendar.gif']")).click();
					//Date not inspecting
					
					//clicking on save button
					driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[2]")).click();
		
					
					//clicking on again contacts
					driver.findElement(By.xpath("//a[text()='Contacts']")).click();
					
					driver.findElement(By.xpath("//input[@class='txtBox']")).sendKeys(b1);
				
					String abc3 = wb.getSheet("Sheet1").getRow(0).getCell(6).toString();
					
					WebElement Indropdown = driver.findElement(By.id("bas_searchfield"));
					Select Indd = new Select(Indropdown);
					Indd.selectByVisibleText(abc3);
					driver.findElement(By.xpath("//input[@name='submit']")).click();

				WebElement contactname = driver.findElement(By.xpath("//a[@title='Contacts' and text()='" + b1+ "']"));

				if (contactname.isDisplayed()) 
				{
					Assert.assertTrue(true);
					}	
			driver.close();
		}
	    }
}
		
		

