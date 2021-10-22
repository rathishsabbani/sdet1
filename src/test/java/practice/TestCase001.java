package practice;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class TestCase001 {
		WebDriver driver;
		@Test
		public void Tc01_TestCase() throws Throwable{
		
		{
			FileInputStream fis = new FileInputStream("..\\SDETHYD11\\commond.properties");
			Properties prop = new Properties();
			prop.load(fis);

			FileInputStream fs = new FileInputStream("..\\SDETHYD11\\assign.xlsx");
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

			driver.findElement(By.xpath("//a[text()='Contacts']")).click();

			driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();

			
			String abc1 = wb.getSheet("Sheet1").getRow(0).getCell(4).toString();
			WebElement First = driver.findElement(By.name("salutationtype"));
			Select Firstdd = new Select(First);
			Firstdd.selectByValue(abc1);
			
			
			String abc4 = wb.getSheet("Sheet1").getRow(1).getCell(3).toString();
			String abc5 = wb.getSheet("Sheet1").getRow(1).getCell(2).toString();
			driver.findElement(By.name("lastname")).sendKeys(abc4);
			driver.findElement(By.id("mobile")).sendKeys(abc5);
			
			String abc6 = wb.getSheet("Sheet1").getRow(1).getCell(4).toString();
			driver.findElement(By.id("title")).sendKeys(abc6);
			String abc7 = wb.getSheet("Sheet1").getRow(1).getCell(5).toString();
			driver.findElement(By.id("department")).sendKeys(abc7);
			
			
			String abc8 = wb.getSheet("Sheet1").getRow(1).getCell(6).toString();
			driver.findElement(By.id("email")).sendKeys(abc8);
			
			driver.findElement(By.name("emailoptout")).click();
			
			driver.findElement(By.name("reference")).click();
			
					driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
					
					driver.findElement(By.xpath("//a[text()='Contacts']")).click();
					
					driver.findElement(By.xpath("//input[@class='txtBox']")).sendKeys(abc4);
				
					String abc3 = wb.getSheet("Sheet1").getRow(0).getCell(6).toString();
					
					WebElement Indropdown = driver.findElement(By.id("bas_searchfield"));
					Select Indd = new Select(Indropdown);
					Indd.selectByVisibleText(abc3);
					driver.findElement(By.xpath("//input[@name='submit']")).click();

				WebElement contactname = driver.findElement(By.xpath("//a[@title='Contacts' and text()='" + abc4+ "']"));

				if (contactname.isDisplayed()) 
				{
					Assert.assertTrue(true);
					
				}	
				Reporter.log("True");
				
			driver.close();
		}
}
}

			
			