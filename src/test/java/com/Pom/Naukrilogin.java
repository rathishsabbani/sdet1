package com.Pom;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Naukrilogin {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.naukri.com");
		String parenttitle = driver.getTitle();
		
		Set<String> windowId = driver.getWindowHandles();
			Iterator<String> iterator=windowId.iterator();

			while(iterator.hasNext()) 
			{
				String currentwindow=iterator.next();
				String currenttitle=driver.switchTo().window(currentwindow).getTitle();
				if(currenttitle.contains("Cognizant")) {
					break;
				}
			}
		}

		

	}

