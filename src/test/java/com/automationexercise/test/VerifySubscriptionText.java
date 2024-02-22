package com.automationexercise.test;

import org.testng.annotations.Test;

import com.automationexercise.Base.BaseClass;
import com.automationexercise.Pages.HomePage;

public class VerifySubscriptionText extends BaseClass {
	
	HomePage hp;
	
  @Test
  public void VerifySubscriptionT() {
	  hp = new HomePage();
	  hp.Subscription();
  }
}
