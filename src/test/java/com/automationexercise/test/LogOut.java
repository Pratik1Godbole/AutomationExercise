package com.automationexercise.test;

import org.testng.annotations.Test;

import com.automationexercise.Base.BaseClass;
import com.automationexercise.Pages.SignInPage;

public class LogOut extends BaseClass{
	SignInPage logout;
  @Test
  public void logOut() {
	  logout = new SignInPage();
	  logout.logOutUser();
  }
}
