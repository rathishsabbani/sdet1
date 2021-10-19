package com.Pom;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
public class webdriverutility {
	

	public void pageloadtimeout(WebDriver driver) 
	{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	public void maximisewindow(WebDriver driver) 
	{
		driver.manage().window().maximize();
	}
	
	public void waitforelementtovisible(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public void waitandclick(WebDriver driver, WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(element));

	}
	
	public void slectelementfromDropdown(WebElement element, String text) 
	{
		Select select = new Select(element);
		select.selectByVisibleText(text);
	}
	public void selectelementfromDropdown(WebElement element,int index)
	{
		Select select = new Select(element);
		select.selectByIndex(index);
	}
	
	public void selectelementfromDropdown(WebElement element,String value)
	{
		Select select = new Select(element);
		select.selectByValue(value);
	}

	
	public void switchframebyindex(WebDriver driver,int index) 
	{
		driver.switchTo().frame(index);
	}

	public void switchframebyElement(WebDriver driver,WebElement element) 
	{
		driver.switchTo().frame(element);
	}
	
	public void switchframebyElement(WebDriver driver,String nameOrId ) 
	{
		driver.switchTo().frame(nameOrId);
	}
	
	public void movetoelement(WebDriver driver,WebElement element) 
	{
		Actions action = new Actions(driver);
		action.moveToElement(element).build().perform();
	}
	
	public void rightClick(WebDriver driver,WebElement element) 
	{
		Actions action = new Actions(driver);
		action.contextClick(element);
	}
	public void acceptAlert(WebDriver driver) {
		driver.switchTo().alert().accept();
	}

	public void switchTowindow(WebDriver driver, String title) 
	{
		Set<String> windowId = driver.getWindowHandles();
		Iterator<String> iterator=windowId.iterator();

		while(iterator.hasNext()) 
		{
			String currentwindow=iterator.next();
			String currenttitle=driver.switchTo().window(currentwindow).getTitle();
			if(currenttitle.contains(title)) {
				break;
			}
		}
	}


}
