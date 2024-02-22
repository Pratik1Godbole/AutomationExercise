package com.automationexercise.test;

import org.testng.annotations.Test;

import com.automationexercise.Base.BaseClass;
import com.automationexercise.Pages.HomePage;

public class VerifySubInCartPage extends BaseClass{
	HomePage hp;
  @Test
  public void VeriySubscriptionInCartPage() {
	  hp = new HomePage();
	  hp.VerifySubscriptionInCartPage();
  }
}
