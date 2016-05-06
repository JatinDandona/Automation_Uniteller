package com.UnitellerAutomation.Tests;
import org.testng.annotations.Test;

import com.unitellerAutomation.TestInitiator.TestInitiator;

public class Uniteller_UserLogin {
	
  TestInitiator test = new TestInitiator();

	
	
	@Test
	public void Step_01_LaunchApplication(){
		test.launchURL("http://unirtest.uniteller.com/");
		test.loginPage.verifyLoginPageTitle();
		
		
		
	}
	

}
