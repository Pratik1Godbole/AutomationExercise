package com.automationexercise.test;

import org.testng.annotations.Test;

import com.automationexercise.Base.BaseClass;
import com.automationexercise.Pages.HomePage;

public class AToCFromRecommendedItems extends BaseClass {
	HomePage hp;
  @Test
  public void AToCFrRecItems() {
	  hp = new HomePage();
	  hp.AddToCartfromRecitems();
  }
}
