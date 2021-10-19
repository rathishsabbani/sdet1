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
import org.testng.annotations.Test;

public class Testcase005{

   WebDriver driver;
   
	@Test
	public void Tc01_TestCase() throws Throwable{
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

		driver.findElement(By.xpath("//a[text()='Contacts']")).click();

		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		
				String d1 = wb.getSheet("Sheet1").getRow(5).getCell(0).toString();
				WebElement First = driver.findElement(By.name("salutationtype"));
				Select Firstdd = new Select(First);
				Firstdd.selectByValue(d1);
				String d2 = wb.getSheet("Sheet1").getRow(5).getCell(1).toString();
				driver.findElement(By.name("firstname")).sendKeys(d2);
					
		
	}	
}
	}

