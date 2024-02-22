package com.automationexercise.Pages;

import java.io.File;

import org.openqa.selenium.By;

import com.automationexercise.Base.BaseClass;
import com.automationexercise.utils.utils;

public class CheckOutPage extends BaseClass{

	SignUpPage signup;
	ProductPage prod;
	CartPage cart;



	By proceedToCheckOutbtn = By.xpath("//a[@class='btn btn-default check_out']");
	By ContinueToCart =By.xpath("//div[@id='checkoutModal']//button"); 
	By downloadInvoice = By.xpath("//a[@class='btn btn-default check_out']");
	By continueBtn = By.xpath("//a[@data-qa='continue-button']");

	public void AddDetailsInCheckOutPage() {
		signup = new SignUpPage();
		signup.signUp();
		prod = new ProductPage();
		prod.AddProductInCart();
		driver.findElement(proceedToCheckOutbtn).click();

		cart = new CartPage();

		cart.VerifyDeliveryAdd();
		cart.VerifyBillingAdd();
		signup.deleteAcc();
	}

	public void DownloadInvoiceAfterPurchaseOrder() {
		signup =  new SignUpPage();
		signup.signUp();
		prod = new ProductPage();
		prod.AddProductInCart();
		utils.addToCart(driver);
		cart = new CartPage();
		cart.ClickOnCheckOut();
		cart.VerifyAddAndReviewYourOrder();
		cart.EnterCommentTextAndClickPlaceOrder();
		utils.payment(driver);
		driver.navigate().forward();
		driver.findElement(downloadInvoice);

		try {
			Thread.sleep(2000); 
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// Specify the path to the downloaded invoice file
		String filePath = "C:\\Users\\prati\\Downloads\\invoice.txt"; 

		// Create a File object with the specified file path
		File file = new File(filePath);

		// Check if the file exists
		if (file.exists()) {
			System.out.println("Invoice downloaded successfully at: " + filePath);
		} else {
			System.out.println("Invoice download failed.");
		}

		try {
			Thread.sleep(2000); 
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		driver.findElement(continueBtn);
		signup.deleteAcc();
	}

}

