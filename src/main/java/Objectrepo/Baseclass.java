package Objectrepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import objectrepos.HomePage;
import objectrepos.loginpage;





public class Baseclass {

	public WebDriver driver;
	Fileutility fileutility = new Fileutility();

	public static WebDriver sdriver;

	@BeforeSuite(groups= {"smoke","regression"})
	public void startConnection()
	{
		System.out.println("Start the Connection with DataBase");
	}

	//@Parameters("browser")
	@BeforeClass(groups= {"smoke","regression"})
	public void launchBrowser() throws Throwable
	{
		String browsername=fileutility.readData("browser");
		if
		(browsername.equalsIgnoreCase("Chrome"))
		{
			driver = new ChromeDriver();
		}
		else if
		(browsername.equalsIgnoreCase("firefox"))
		{
			driver = new FirefoxDriver();
		}
		else if
		(browsername.equalsIgnoreCase("safari"))
		{
			driver = new SafariDriver();
		}

		else
		{
			driver= new ChromeDriver();
		}

		sdriver=driver;
		driver.get(fileutility.readData("URL"));
		driver.manage().window().maximize();
	}

	@BeforeMethod(groups= {"smoke","regression"})
	public void login() throws Throwable
	{
		loginpage lp= new loginpage(driver);
		lp.logintoApp();
	}

	@AfterMethod(groups= {"smoke","regression"})
	public void logout()
	{
		HomePage hp = new HomePage(driver);
		hp.logoutfromApp();
	}

	@AfterClass(groups= {"smoke","regression"})
	public void closeBrowser() throws Throwable
	{
		Thread.sleep(2000);
		driver.close();
	}

	@AfterSuite(groups= {"smoke","regression"})
	public void closeConnection()
	{
		System.out.println("Close the Connection with DataBase");
	}

}