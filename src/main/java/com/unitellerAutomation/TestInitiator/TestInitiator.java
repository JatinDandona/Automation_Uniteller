package com.unitellerAutomation.TestInitiator;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.UnitellerAutomation.Keywords.AddNewBeneficiaryPage;
import com.UnitellerAutomation.Keywords.HeaderSection;
import com.UnitellerAutomation.Keywords.LogInPage;


public class TestInitiator {
	
	WebDriver driver;
	
	 public LogInPage loginPage;
	 public HeaderSection headerSection;
	 public AddNewBeneficiaryPage addNewBenfeciaryPage;
	
	
	 public TestInitiator(){
		 
		 Initializefirefoxbrowser();
		 initializePageObjects();
		
	}
	 
	 private void initializePageObjects(){
		 loginPage = new LogInPage(driver);
		 headerSection = new HeaderSection(driver);
		 addNewBenfeciaryPage = new AddNewBeneficiaryPage(driver);
	 }
	 
	 
	 private  void Initializefirefoxbrowser(){
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
	
	public void closeBrowser(){
		driver.quit();
	}
	
	public static void hardwait(int sec){
		try {
			Thread.sleep(sec*1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
