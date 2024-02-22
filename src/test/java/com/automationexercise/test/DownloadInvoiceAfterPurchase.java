package com.automationexercise.test;

import org.testng.annotations.Test;

import com.automationexercise.Base.BaseClass;
import com.automationexercise.Pages.CheckOutPage;

public class DownloadInvoiceAfterPurchase extends BaseClass {
	CheckOutPage check;
	
	
  @Test
  public void downloadInvoiceAfterPurchaseOrder() {
	 check = new CheckOutPage();
	 check.DownloadInvoiceAfterPurchaseOrder();
  }
}
