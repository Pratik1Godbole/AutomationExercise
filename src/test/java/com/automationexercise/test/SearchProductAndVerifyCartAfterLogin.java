package com.automationexercise.test;

import org.testng.annotations.Test;

import com.automationexercise.Base.BaseClass;
import com.automationexercise.Pages.ProductPage;

public class SearchProductAndVerifyCartAfterLogin extends BaseClass {
	
	ProductPage pp;
  @Test
  public void SearchProdAndVerifyCartAftrLogin() {
	 pp = new ProductPage();
	  pp.SeaechProductsAndVerifyAfterCartLogin();
	  
  }
}
