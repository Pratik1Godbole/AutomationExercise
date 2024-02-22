package com.automationexercise.test;

import org.testng.annotations.Test;

import com.automationexercise.Base.BaseClass;
import com.automationexercise.Pages.HomePage;
import com.automationexercise.Pages.ProductPage;

public class viewCategoryProductsTest extends BaseClass {
	HomePage hp;
	ProductPage pp;
  @Test
  public void viewCategoryProducts() {
	  pp = new ProductPage();
	  pp.viewCategoryProducts();
	  
  }
  
  @Test
  public void ViewAndCartBrandProducts() {
	  pp = new ProductPage();
	  pp.ViewAndCartBrandProducts();
  }
}
