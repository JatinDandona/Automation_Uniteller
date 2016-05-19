package com.unitellerAutomation.TestInitiator;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


import com.unitellerAutomation.Keywords.AddNewBeneficiaryPage;
import com.unitellerAutomation.Keywords.HeaderSection;
import com.unitellerAutomation.Keywords.LogInPage;


public class TestInitiator {
	
	Properties properties = new Properties();
	
	public static WebDriver driver;
	
	 public LogInPage loginPage;
	 public HeaderSection headerSection;
	 public AddNewBeneficiaryPage addNewBenfeciaryPage;
	
	
	 public TestInitiator(){
		 try {
			properties.load(new FileInputStream(new File("config.properties")));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 if(properties.getProperty("browser").equalsIgnoreCase("firefox")){
			 Initializefirefoxbrowser();
		 }
		 else{
			 initializeChromeBrowser();
		 }
		 
		 
		 
		 initializePageObjects();
		
		
	}
	 
	 
	 
	 
	 private  void Initializefirefoxbrowser(){
		 driver = new FirefoxDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
	 }
	 
	 
	 public void initializeChromeBrowser(){
		/* DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		 ChromeOptions options = new ChromeOptions();*/
		 System.setProperty("webdriver.chrome.driver","Drivers\\chromedriver.exe");
		 //options.addExtensions(new File("C:\\Users\\Jatin\\workspace\\QA\\Automation_Uniteller\\Drivers\\chromedriver.exe"));
		 //capabilities.setCapability(ChromeOptions.CAPABILITY, options);
		  driver = new ChromeDriver();
		  driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
	 }
	 
	 private void initializePageObjects(){
		 loginPage = new LogInPage(driver);
		 headerSection = new HeaderSection(driver);
		 addNewBenfeciaryPage = new AddNewBeneficiaryPage(driver);
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
