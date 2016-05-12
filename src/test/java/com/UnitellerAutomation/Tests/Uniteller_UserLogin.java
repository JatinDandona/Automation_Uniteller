package com.UnitellerAutomation.Tests;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.unitellerAutomation.TestInitiator.TestInitiator;

public class Uniteller_UserLogin {
	
  TestInitiator test = new TestInitiator();
  Properties properties = new Properties();
  String userId;
  String password;
  String errorMessage;
  InputStream input = null;
  File file = new File("testData.data");
  
  @BeforeClass
  public void loadTestData() throws FileNotFoundException, IOException{
	  input = new FileInputStream(file);
	  properties.load(input);
	  userId = properties.getProperty("userId");
	  password = properties.getProperty("Password");
	  errorMessage = properties.getProperty("signInErrorMessage");
  }
  
	@Test
	public void Step_01_LaunchApplication(){
		test.launchURL("http://unirtest.uniteller.com/");
		test.loginPage.verifyLoginPageTitle();
		test.loginPage.enterUsrname(userId);
		test.loginPage.EnterPassword(password);
		test.loginPage.clickLoginButton();
		test.loginPage.verifyFailedLogInMessage(errorMessage);
	}
	
	@AfterClass
	public void closeBrowser(){
		test.closeBrowser();
	}
	

}
