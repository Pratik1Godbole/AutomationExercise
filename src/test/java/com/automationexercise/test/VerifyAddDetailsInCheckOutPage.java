package com.automationexercise.test;

import org.testng.annotations.Test;

import com.automationexercise.Base.BaseClass;
import com.automationexercise.Pages.CheckOutPage;

public class VerifyAddDetailsInCheckOutPage extends BaseClass{
	CheckOutPage checkOut;
  @Test
  public void VerifyAddDetIncheckOutPage() {
	  checkOut = new CheckOutPage();
	  checkOut.AddDetailsInCheckOutPage();
  }
}
