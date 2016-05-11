package com.UnitellerAutomation.Keywords;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;




public class LogInPage{
	WebDriver driver;
	public LogInPage(WebDriver driver){
		this.driver = driver;
	}
	public void verifyLoginPageTitle(){
		
		
		Assert.assertEquals(driver.getTitle().trim(), "Login | Uniteller", 
				"[Assertion Failed]: lOGIN Page title is not as expected");
		
		Reporter.log("Assertion passed: LOGIN Page title is same as expected",true);
	}
	
	public void enterUsrname(String userId){
		driver.findElement(By.id("email")).sendKeys(userId);
		Reporter.log("user entered user id as "+userId, true);
	}
	
	public void EnterPassword(String pass){
		driver.findElement(By.id("password")).sendKeys(pass);
		Reporter.log("user enterd password", true);
	}
	
	public void clickLoginButton(){
		driver.findElement(By.id("proceed")).click();
		Reporter.log("User clicked on login button", true);
	}
	
	public void verifyFailedLogInMessage(String errorMessage){
		Assert.assertEquals(driver.findElement(By.xpath("//ul[@class='errorMessage']/li/span")).getText(), 
				errorMessage, 
				"[Assertion Failed]: Error Message is not as expected");
		
		Reporter.log("Assertion passed: Error Message is same as expected",true);
	}
}
