package com.automationexercise.test;

import org.testng.annotations.Test;

import com.automationexercise.Base.BaseClass;
import com.automationexercise.Pages.SignUpPage;
//import com.automationexercise.utils.utils;

public class SignUpTest extends BaseClass {
	SignUpPage signUP;
	
	public SignUpTest() {
		
	}
	
  @Test
  	public void SignUp() throws InterruptedException {
//	  utils.refresh();
	  signUP = new SignUpPage();
	  signUP.clickOnsignup_loginbtn();
	  signUP.signUp();
	  signUP.deleteAcc();
	  signUP.clickOncont();
	  Thread.sleep(1000);
	  
  }
  
  @Test
  public void signUpWithExistingUser() {
	  signUP = new SignUpPage();
	  signUP.regWthExistingUser();
  }
}
