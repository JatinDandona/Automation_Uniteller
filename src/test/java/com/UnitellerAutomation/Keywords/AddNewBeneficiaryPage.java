package com.UnitellerAutomation.Keywords;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;

import com.unitellerAutomation.TestInitiator.TestInitiator;

public class AddNewBeneficiaryPage {

	WebDriver driver;
	Select selectByValue ;
	public AddNewBeneficiaryPage(WebDriver driver){
		this.driver = driver;
	}
	
	public void addNewBeneficiaryLink(){
		driver.findElement(By.xpath("//div[@class='add_new_ben_button']//a")).click();
		Reporter.log("user clicked on add new beneficiary link");
	}
	
	public void verifyAddNewBeneficiaryHeading(String heading){
		TestInitiator.hardwait(2);
		Assert.assertEquals(driver.findElement(By.xpath("//div[@id='container']/h1")).getText().trim(),heading,"Assertion failed");
		Reporter.log("assertion passed", true);
	}
	
	public void clickDestinationCountryDropDown(){
	 selectByValue = new Select(driver.findElement(By.xpath("//select[@id='quoteCountry']")));
		              selectByValue.selectByValue("Philippines");
		 Reporter.log("user clicked on destination country drop down", true);
	}
	
	public void selctPaymentCurrency(){
		 selectByValue = new Select(driver.findElement(By.id("currencyId")));
         selectByValue.selectByValue("Philippine Pesos");
         Reporter.log("user selected on preffered currency ", true);
	}
	
	
	public void selectReceptionMethod(){
		TestInitiator.hardwait(1);
		selectByValue = new Select(driver.findElement(By.id("PMId")));
        selectByValue.selectByValue("Cash Pickup");
        Reporter.log("user selected on reception method as cashpickup ", true);
	}
	
	public void enterBenficiaryDetails(){
		driver.findElement(By.id("firstName")).sendKeys("abcd");
		Reporter.log(" ", true);
		
		driver.findElement(By.id("lastName")).sendKeys("abcd");
		Reporter.log(" ", true);
		
		driver.findElement(By.id("genderM")).click();
		Reporter.log(" ", true);
		
		driver.findElement(By.id("address1")).sendKeys("delhi");
		Reporter.log(" ", true);
		
		driver.findElement(By.id("modifyDobdatepicker")).sendKeys("03/15/1985");
		Reporter.log(" ", true);
		
		driver.findElement(By.id("city")).sendKeys("new delhi");
		Reporter.log(" ", true);
		
		driver.findElement(By.id("zipCode")).sendKeys("589654");
		Reporter.log(" ", true);
		
		driver.findElement(By.id("cellPhone")).sendKeys("5897463521");
		Reporter.log(" ", true);
		
	}
	
	public void selectState(){
		
			selectByValue = new Select(driver.findElement(By.id("state")));
	        selectByValue.selectByValue("Manila Metropolitan");
	        Reporter.log("user selected state ", true);
	        
	        driver.findElement(By.id("proceed")).click();
		}
	
	
	public void verifyBeninfoURL(){
		Assert.assertTrue(driver.getCurrentUrl().contains("BeneInfoAction"), "Assertion failed");
		Reporter.log("assertion passed",true);
	}
	public void addPayerInfo(){
		driver.findElement(By.xpath("//img[contains(@src,'BancoDeOroUniversalBank')]//following-sibling::span")).click();
		Reporter.log("addded payer info",true);
	}
	
	public void verifyBenAdded(){
		TestInitiator.hardwait(2);
		driver.findElement(By.xpath("//div[@class='beneficiary_container']")).isDisplayed();
	}
	
	
	
	
	
}



