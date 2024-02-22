package com.automationexercise.test;

import org.testng.annotations.Test;

import com.automationexercise.Base.BaseClass;
import com.automationexercise.Pages.CartPage;

public class VerifyPrDisplayedInCartWithExactQuantity extends BaseClass {
	CartPage cp;
  @Test
  public void VerifyprDisplayedWithExactQuantityInCart() {
	  cp = new CartPage();
	  cp.VerifyPqInCart();
	  
  }
  
  
  @Test
  public void PlaceOrderRegWhileCheckout() {
	  cp = new CartPage();
	  cp.RegisterWhileCheckOut();
  }
  
  @Test
  public void RegisterBeforeCheckOut() {
	  cp = new CartPage();
	  cp.RegBeforeCheckOut();
  }
  
  @Test
  public void LoginBeforeCheckout() {
	  cp = new CartPage();
	  cp.LoginBeforeCheckOut();
  }
  
  @Test
  public void RemoveProductsFromCart() {
	  cp = new CartPage();
	  cp.RemoveProductsFromCart();
  }
  
}
