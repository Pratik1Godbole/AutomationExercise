package com.automationexercise.test;

import org.testng.annotations.Test;

import com.automationexercise.Base.BaseClass;
import com.automationexercise.Pages.SignInPage;
import com.automationexercise.Pages.SignUpPage;

public class LoginTest extends BaseClass {
	
	SignInPage signIn;
	SignUpPage delAcc;
	
  @Test
  public void VLogin() {
	  signIn = new SignInPage();
	  signIn.loginWithValidUP("uName1","pass");
	  delAcc = new SignUpPage();
	  delAcc.deleteAcc();
	  
  }
  
  
  @Test
  public void IvLogin() {
	  signIn = new SignInPage();
	  signIn.loginwithInValidUP();
  }
}
