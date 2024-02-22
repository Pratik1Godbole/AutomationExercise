package com.automationexercise.test;

import org.testng.annotations.Test;

import com.automationexercise.Base.BaseClass;
import com.automationexercise.Pages.ProductPage;

public class ProductDetails extends BaseClass {
	ProductPage ProdPage;
  @Test
  public void ProdDetails() {
	  ProdPage = new ProductPage();
	  ProdPage.verifyAllProducts();
	  
  }
  
  @Test
  public void searchProduct() {
	  ProdPage = new ProductPage();
	  ProdPage.searchProduct();
  }
}
