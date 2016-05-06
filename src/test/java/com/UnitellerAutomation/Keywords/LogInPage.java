package com.UnitellerAutomation.Keywords;
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
	
	
}
