package com.unitellerAutomation.Tests;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Properties;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.unitellerAutomation.TestInitiator.TestInitiator;

public class Uniteller_AddBeneficiary_cashPickup {
	
  TestInitiator test = new TestInitiator();
  Properties properties = new Properties();
  String userId;
  String password;
  InputStream input = null;
  ArrayList<String> securityQuestion_ans;
  File file = new File("testData.data");
  
  @BeforeClass
  public void loadTestData() throws FileNotFoundException, IOException{
	  input = new FileInputStream(file);
	  properties.load(input);
	  userId = properties.getProperty("userId_addBen_cashPichUp");
	  password = properties.getProperty("userId_addBen_Password");
	  securityQuestion_ans = new ArrayList<String>(
			    Arrays.asList(properties.getProperty("securityQuestion_ans1"),
			    		properties.getProperty("securityQuestion_ans2"),properties.getProperty("securityQuestion_ans3")));
  }
  
	
	
	@Test
	public void Step_01_LaunchApplication(){
		test.launchURL("http://orapitest.uniteller.com/");
		test.loginPage.verifyLoginPageTitle();
		test.loginPage.enterUsrname(userId);
		test.loginPage.clickLoginButton();
		test.loginPage.EnterPassword(password);
		test.loginPage.clickLoginButton();
		test.loginPage.getSecurityQuestion(securityQuestion_ans);
		test.loginPage.clickLoginButton();
		test.loginPage.verifyCompleteProfilePopUp();
		test.headerSection.clickBeneficiaryTab();
		test.addNewBenfeciaryPage.addNewBeneficiaryLink();
		test.addNewBenfeciaryPage.verifyAddNewBeneficiaryHeading("Add New Beneficiary");
		test.addNewBenfeciaryPage.clickDestinationCountryDropDown();
		test.addNewBenfeciaryPage.selctPaymentCurrency();
		test.addNewBenfeciaryPage.selectReceptionMethod();
		test.addNewBenfeciaryPage.enterBenficiaryDetails();
		test.addNewBenfeciaryPage.selectState();
		test.addNewBenfeciaryPage.verifyBeninfoURL();
		test.addNewBenfeciaryPage.addPayerInfo();
		test.loginPage.clickLoginButton();
		test.addNewBenfeciaryPage.verifyBenAdded();
		
	}
	

}
