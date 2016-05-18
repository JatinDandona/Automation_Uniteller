package com.unitellerAutomation.Keywords;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

public class HeaderSection {
	WebDriver driver;
	public HeaderSection(WebDriver driver){
		this.driver = driver;
	}
	
	public void clickBeneficiaryTab(){
		driver.findElement(By.xpath("//a[@href='firstBeneficiary.action']")).click();
		Reporter.log("User clicked on beneficiary tab", true);
	}
}
