package com.Pom;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class tc_02contact
{
	WebDriver driver;

	FileUtils fileutility= new FileUtils();

	public tc_02contact(WebDriver driver)  		
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(name="user_name")				
	private WebElement usernametxtfld;		

	@FindBy(name="user_password")
	private WebElement passwordtxtfld;

	@FindBy(id="submitButton")
	private WebElement loginbtn;

	public WebElement getUsernametxtfld() {  		
		return usernametxtfld;
	}

	public WebElement getPasswordtxtfld() {
		return passwordtxtfld;
	}

	public WebElement getLoginbtn() {
		return loginbtn;
	}

	public void logintoApp() throws IOException 	
	{
		usernametxtfld.sendKeys(fileutility.readDatafromPropfile("username"));
		passwordtxtfld.sendKeys(fileutility.readDatafromPropfile("password"));
		loginbtn.click();
	}

	public void logintoApp(String username,String password) 
	{
		usernametxtfld.sendKeys(username);
		passwordtxtfld.sendKeys(password);
		loginbtn.click();
	}



}
