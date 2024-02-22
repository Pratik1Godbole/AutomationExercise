package com.automationexercise.test;

import org.testng.annotations.Test;

import com.automationexercise.Base.BaseClass;
import com.automationexercise.Pages.HomePage;

public class scrollActions extends BaseClass {
	HomePage home;
  @Test
  public void VerifyScrollUpUsingArrow() {
	  home = new HomePage();
	  home.scrollUpWithArrow();
  }
  
  @Test
  public void VerifyscrollUPWithoutArrow() {
	  home = new HomePage();
	  home.scrollUpWithoutArrow();
  }
}
