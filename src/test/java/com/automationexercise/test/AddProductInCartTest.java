package com.automationexercise.test;

import org.testng.annotations.Test;

import com.automationexercise.Base.BaseClass;
import com.automationexercise.Pages.ProductPage;


public class AddProductInCartTest extends BaseClass {
	ProductPage Pp;
  @Test
  public void addProductInCart() {
	  Pp = new ProductPage();
	  Pp.AddProductInCart();
  }
}
