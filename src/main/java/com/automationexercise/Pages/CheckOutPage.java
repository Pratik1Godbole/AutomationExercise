package com.automationexercise.Pages;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automationexercise.Base.BaseClass;
import com.automationexercise.utils.utils;

public class CheckOutPage extends BaseClass{

	SignUpPage signup;
	ProductPage prod;
	CartPage cart;
	
	
	public  CheckOutPage() {
		 PageFactory.initElements(driver, this);
	}



	@FindBy(xpath = "//a[@class='btn btn-default check_out']")
    private WebElement proceedToCheckOutbtn;

    @FindBy(xpath = "//div[@id='checkoutModal']//button")
    private WebElement ContinueToCart;

    @FindBy(xpath = "//a[@class='btn btn-default check_out']")
    private WebElement downloadInvoice;

    @FindBy(xpath = "//a[@data-qa='continue-button']")
    private WebElement continueBtn;


	public void AddDetailsInCheckOutPage() {
		signup = new SignUpPage();
		signup.signUp();
		prod = new ProductPage();
		prod.AddProductInCart();
		proceedToCheckOutbtn.click();

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
		


		
//		downloadInvoice.click();
		utils.waitForClickableElement(driver, downloadInvoice, Duration.ofSeconds(20)).click();
		
		
//		try {
//			Thread.sleep(2000); 
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}

		// Specify the path to the downloaded invoice file
		String filePath = "C:\\Users\\prati\\Downloads\\invoice.txt"; 
		BufferedReader br = null;
		
		
		 try {
	            br = new BufferedReader(new FileReader(filePath));
	            String line;
	            while ((line = br.readLine()) != null) {
	                System.out.println(line);
	            }
	        } catch (IOException e) {
	            System.err.println("Error reading the file: " + e.getMessage());
	        } finally {
	            try {
	                if (br != null) {
	                    br.close();
	                }
	            } catch (IOException e) {
	                System.err.println("Error closing the BufferedReader: " + e.getMessage());
	            }
	        }
		
		

//		// Create a File object with the specified file path
//		File file = new File(filePath);
//		
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
//
//		// Check if the file exists
//		if (file.exists()) {
//			System.out.println("Invoice downloaded successfully at: " + filePath);
//		} else {
//			System.out.println("Invoice download failed.");
//		}

//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

		
		signup.deleteAcc();
	}

}

