package com.automationexercise.test;

import org.testng.annotations.Test;

import com.automationexercise.Base.BaseClass;
import com.automationexercise.Pages.ProductPage;

public class AddReviewOnProduct extends BaseClass {
	ProductPage prod;
  @Test
  public void AddReview() {
	  prod = new ProductPage();
	  prod.AddreviewOnProd();
  }
}
