package com.unitellerAutomation.TestInitiator;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.UnitellerAutomation.Keywords.LogInPage;


public class TestInitiator {
	
	WebDriver driver;
	
	 public LogInPage loginPage;
	
	
	 public TestInitiator(){
		 
		 Initializefirefoxbrowser();
		 initializePageObjects();
		
	}
	 
	 public void initializePageObjects(){
		 loginPage = new LogInPage(driver);
	 }
	 
	 
	 public  void Initializefirefoxbrowser(){
		 driver = new FirefoxDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
	 }
	
	public void launchURL(String url){
		driver.get(url);
	}
	
	public String getTitle(){
		String url =  driver.getTitle();
		return url;
	}

}
