package com.unitellerAutomation.Keywords;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;

import com.unitellerAutomation.TestInitiator.TestInitiator;




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
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		Reporter.log("User clicked on login button", true);
	}
	
	public void verifyFailedLogInMessage(String errorMessage){
		Assert.assertEquals(driver.findElement(By.xpath("//ul[@class='errorMessage']/li/span")).getText(), 
				errorMessage, 
				"[Assertion Failed]: Error Message is not as expected");
		
		Reporter.log("Assertion passed: Error Message is same as expected",true);
	}
	
	public void getSecurityQuestion(ArrayList<String> securityQuestion_ans){
		for(String s: securityQuestion_ans){
			String[] a = s.split("/");
			System.out.println(a[0]);
			System.out.println(a[1]);
			TestInitiator.hardwait(2);
			if(a[1].contains(driver.findElement(By.xpath("//div[@class='email_box']")).getText().split("[0-9]")[1])){
				TestInitiator.hardwait(2);
				driver.findElement(By.id("firstAnswer")).sendKeys(a[0]);
			}	
		}
	}
	
	public void verifyCompleteProfilePopUp(){
		driver.findElement(By.xpath(".//div[@id='boonton_pop' and @style!='display:none;']")).isDisplayed();
		Reporter.log("Pop up to complete the profile is displayed", true);
		
		driver.findElement(By.xpath(".//img[@id='hide_nav_pop']")).click();
	}
	
}
