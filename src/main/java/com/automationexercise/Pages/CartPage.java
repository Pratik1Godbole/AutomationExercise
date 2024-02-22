package com.automationexercise.Pages;

import static org.testng.Assert.assertEquals;


import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.automationexercise.Base.BaseClass;
import com.automationexercise.config.Constants;
import com.automationexercise.utils.utils;

public class CartPage extends BaseClass {


	ProductPage pp;
	Constants con;
	SignUpPage signUP;
	SignInPage signIn;





	private WebElement viewProduct;
	private WebElement  removeproduct;

	public void VerifyPqInCart() {
		pp = new ProductPage();
		pp.productsBtn();
		utils.scrollBy(driver);
		viewProduct = utils.waitForElementPresent(driver, By.xpath("//a[@href='/product_details/1']"), Duration.ofSeconds(5));
		viewProduct.click();
		Assert.assertEquals(driver.getCurrentUrl(), "https://automationexercise.com/product_details/1");

		WebElement quantity = driver.findElement(By.id("quantity"));
		quantity.clear();
		quantity.sendKeys("4");

		WebElement ATCBtn = driver.findElement(By.xpath("//button[@type='button']"));
		ATCBtn.click();

		WebElement viewCart = driver.findElement(By.xpath("//p[@class='text-center']//a"));
		viewCart.click();
		viewProduct = utils.waitForElementPresent(driver, By.xpath("//a[@href='/product_details/1']"), Duration.ofSeconds(5));
		Assert.assertEquals(viewProduct.getText(), con.productName);

		WebElement quan = driver.findElement(By.xpath("//tr[@id='product-1']//td//button"));
		Assert.assertEquals(quan.getText(), "4");
	}


	public void RegisterWhileCheckOut() {
		pp = new ProductPage();
		pp.AddProductInCart();
		ClickOnCheckOut();
		WebElement RegOrLogin = driver.findElement(By.xpath("//p[@class='text-center']//following::a[@href='/login']"));
		RegOrLogin.click();
		signUP = new SignUpPage();
		signUP.signUp();
		utils.addToCart(driver);	
		ClickOnCheckOut();
		VerifyAddAndReviewYourOrder();
		EnterCommentTextAndClickPlaceOrder();
		utils.payment(driver);
		signUP.deleteAcc();
	}

	public void RegBeforeCheckOut() {
		signUP =  new SignUpPage();
		signUP.signUp();
		pp = new ProductPage();
		pp.AddProductInCart();
		utils.addToCart(driver);
		ClickOnCheckOut();
		VerifyAddAndReviewYourOrder();
		EnterCommentTextAndClickPlaceOrder();
		utils.payment(driver);
		signUP.deleteAcc();

	}


	public void ClickOnCheckOut() {
		WebElement checkout = driver.findElement(By.xpath("//section[@id='do_action']//following::div[@class='col-sm-6']//a"));
		checkout.click();

	}

	public void VerifyAddAndReviewYourOrder() {
		VerifyDeliveryAdd();
		VerifyBillingAdd();
		ReviewProducts();
		

	}
	
	public void VerifyDeliveryAdd() {
		WebElement Name = driver.findElement(By.xpath("//ul[@id='address_delivery']//li[2]"));
		Assert.assertEquals(Name.getText(), con.firstNameLastName);
		WebElement comp = driver.findElement(By.xpath("//ul[@id='address_delivery']//li[3]"));
		//		System.out.println(comp.getText());
		Assert.assertEquals(comp.getText(), con.company);
		WebElement add1 = driver.findElement(By.xpath("//ul[@id='address_delivery']//li[4]"));
		Assert.assertEquals(add1.getText(), con.add1);
		WebElement add2 = driver.findElement(By.xpath("//ul[@id='address_delivery']//li[5]"));
		Assert.assertEquals(add2.getText(), con.add2);
		WebElement cityStatePostCode = driver.findElement(By.xpath("//ul[@id='address_delivery']//li[6]"));
		//		System.out.println(cityStatePostCode.getText());
		Assert.assertEquals(cityStatePostCode.getText(), con.cityStatePostcode);

		WebElement country = driver.findElement(By.xpath("//ul[@id='address_delivery']//li[7]"));
		Assert.assertEquals(country.getText(), con.country);
		WebElement mob = driver.findElement(By.xpath("//ul[@id='address_delivery']//li[8]"));
		Assert.assertEquals(mob.getText(), con.mob);
		System.out.println("The delivery address is same address filled at the time registration of account");
	}
	
	public void VerifyBillingAdd() {
		WebElement Name = driver.findElement(By.xpath("//ul[@id='address_invoice']//li[2]"));
		Assert.assertEquals(Name.getText(), con.firstNameLastName);
		WebElement comp = driver.findElement(By.xpath("//ul[@id='address_invoice']//li[3]"));
		//		System.out.println(comp.getText());
		Assert.assertEquals(comp.getText(), con.company);
		WebElement add1 = driver.findElement(By.xpath("//ul[@id='address_invoice']//li[4]"));
		Assert.assertEquals(add1.getText(), con.add1);
		WebElement add2 = driver.findElement(By.xpath("//ul[@id='address_invoice']//li[5]"));
		Assert.assertEquals(add2.getText(), con.add2);
		WebElement cityStatePostCode = driver.findElement(By.xpath("//ul[@id='address_invoice']//li[6]"));
		//		System.out.println(cityStatePostCode.getText());
		Assert.assertEquals(cityStatePostCode.getText(), con.cityStatePostcode);

		WebElement country = driver.findElement(By.xpath("//ul[@id='address_invoice']//li[7]"));
		Assert.assertEquals(country.getText(), con.country);
		WebElement mob = driver.findElement(By.xpath("//ul[@id='address_invoice']//li[8]"));
		Assert.assertEquals(mob.getText(), con.mob);
		System.out.println("The billing address is same address filled at the time registration of account");
	}
	
	public void ReviewProducts() {
		WebElement Name = driver.findElement(By.xpath("//ul[@id='address_delivery']//li[2]"));
		Assert.assertEquals(Name.getText(), con.firstNameLastName);
		WebElement comp = driver.findElement(By.xpath("//ul[@id='address_delivery']//li[3]"));
		//		System.out.println(comp.getText());
		Assert.assertEquals(comp.getText(), con.company);
		WebElement add1 = driver.findElement(By.xpath("//ul[@id='address_delivery']//li[4]"));
		Assert.assertEquals(add1.getText(), con.add1);
		WebElement add2 = driver.findElement(By.xpath("//ul[@id='address_delivery']//li[5]"));
		Assert.assertEquals(add2.getText(), con.add2);
		WebElement cityStatePostCode = driver.findElement(By.xpath("//ul[@id='address_delivery']//li[6]"));
		//		System.out.println(cityStatePostCode.getText());
		Assert.assertEquals(cityStatePostCode.getText(), con.cityStatePostcode);

		WebElement country = driver.findElement(By.xpath("//ul[@id='address_delivery']//li[7]"));
		Assert.assertEquals(country.getText(), con.country);
		WebElement mob = driver.findElement(By.xpath("//ul[@id='address_delivery']//li[8]"));
		Assert.assertEquals(mob.getText(), con.mob);

		utils.scrollBy(driver);


		WebElement blueT = driver.findElement(By.xpath("//a[@href=\"/product_details/1\"]"));
		Assert.assertEquals(blueT.getText(), con.productName);
		WebElement bluecat = driver.findElement(By.xpath("//*[@id=\"product-1\"]/td[2]/p"));
		Assert.assertEquals(bluecat.getText(), con.category);
		WebElement bluePrice = driver.findElement(By.xpath("//*[@id=\"product-1\"]/td[3]/p"));
		Assert.assertEquals(bluePrice.getText(),con.price);
		WebElement bluequantity = driver.findElement(By.xpath("//*[@id=\"product-1\"]/td[4]/button"));
		Assert.assertEquals(bluequantity.getText(), "1");



		final double TOLERANCE = 0.01; // Adjust this value as needed for your precision requirements


		try {
			// Ensure non-null elements and text before conversion
			if (bluePrice != null && bluequantity != null &&
					!bluePrice.getText().trim().isEmpty() && !bluequantity.getText().trim().isEmpty()) {

				double price = Double.parseDouble(bluePrice.getText().replaceAll("^\\D+", ""));
				double quantity = Double.parseDouble(bluequantity.getText().trim());
				double blueTotal = price * quantity;

				// Do something with blueTotal, e.g., display it or store it in a variable
				System.out.println("Calculated total: " + blueTotal);

				// Find the total element carefully, handling potential exceptions
				try {
					WebElement totalblue = driver.findElement(By.xpath("//tr[@id=\"product-1\"]//td[5]//p"));
					Assert.assertEquals(totalblue.getText(), con.price);

					double blueTotal1 = Double.parseDouble(totalblue.getText().replaceAll("^\\D+", ""));
					Assert.assertEquals(blueTotal, blueTotal1, TOLERANCE); // Use tolerance for floating-point errors
					System.out.println("Test passed! Calculated and displayed totals match.");
				} catch (Exception e) {
					// Log or handle the exception appropriately
					System.err.println("Error finding or comparing total element: " + e.getMessage());
				}
			} else {
				System.err.println("Error: bluePrice or bluequantity is null or has empty text.");
			}
		} catch (NumberFormatException e) {
			// Log or handle the conversion error appropriately
			System.err.println("Error parsing price or quantity: " + e.getMessage());
		}


		//product 2

		WebElement tshirtT = driver.findElement(By.xpath("//a[@href='/product_details/2']"));
		Assert.assertEquals(tshirtT.getText(), con.productName2);
		WebElement tshirtcat = driver.findElement(By.xpath("//*[@id='product-2']/td[2]/p"));
		Assert.assertEquals(tshirtcat.getText(), con.category2);
		WebElement tshirtPrice = driver.findElement(By.xpath("//*[@id='product-2']/td[3]/p"));
		Assert.assertEquals(tshirtPrice.getText(),con.price2);
		WebElement tshirtquantity = driver.findElement(By.xpath("//*[@id='product-2']/td[4]/button"));
		Assert.assertEquals(tshirtquantity.getText(), "1");

		try {
			// Ensure non-null elements and text before conversion
			if (tshirtPrice != null && tshirtquantity != null &&
					!tshirtPrice.getText().trim().isEmpty() && !tshirtquantity.getText().trim().isEmpty()) {

				double price = Double.parseDouble(tshirtPrice.getText().replaceAll("^\\D+", ""));
				double quantity = Double.parseDouble(tshirtquantity.getText().trim());
				double tshirtTotal = price * quantity;

				// Do something with blueTotal, e.g., display it or store it in a variable
				System.out.println("Calculated total: " + tshirtTotal);

				// Find the total element carefully, handling potential exceptions
				try {
					WebElement totaltext = driver.findElement(By.xpath("//tr[@id='product-2']//td[5]//p"));
					Assert.assertEquals(totaltext.getText(), con.price2);

					double tshirtTotal1 = Double.parseDouble(totaltext.getText().replaceAll("^\\D+", ""));
					Assert.assertEquals(tshirtTotal, tshirtTotal1, TOLERANCE); // Use tolerance for floating-point errors
					System.out.println("Test passed! Calculated and displayed totals match.");
				} catch (Exception e) {
					// Log or handle the exception appropriately
					System.err.println("Error finding or comparing total element: " + e.getMessage());
				}
			} else {
				System.err.println("Error: bluePrice or bluequantity is null or has empty text.");
			}
		} catch (NumberFormatException e) {
			// Log or handle the conversion error appropriately
			System.err.println("Error parsing price or quantity: " + e.getMessage());
		}

		WebElement TotalAmount = driver.findElement(By.xpath("//tbody//tr[3]//td//p"));
		Assert.assertEquals(TotalAmount.getText(), "Rs. 900");
	}


	public void EnterCommentTextAndClickPlaceOrder() {

		//Enter description in comment text area and click 'Place Order'

		WebElement msgtext =  driver.findElement(By.xpath("//textarea[@name='message']"));
		msgtext.sendKeys(con.comment);
		WebElement placeOrder = driver.findElement(By.xpath("//a[@href='/payment']"));
		placeOrder.click();

	}

	public void LoginBeforeCheckOut() {
		signIn = new SignInPage();
		signIn.loginWithValidUP("uName2", "pass");;
		pp = new ProductPage();
		pp.AddProductInCart();
		utils.addToCart(driver);
		ClickOnCheckOut();
		VerifyAddAndReviewYourOrder();
		EnterCommentTextAndClickPlaceOrder();
		utils.payment(driver);
		signUP = new SignUpPage();
		signUP.deleteAcc();
	}

	public void RemoveProductsFromCart() {
		pp = new ProductPage();
		pp.AddProductInCart();
		utils.addToCart(driver);
		removeAllProducts();
		WebElement cartemptymsg = driver.findElement(By.xpath("//*[@id='empty_cart']/p/b"));
		System.out.println(cartemptymsg.getText());
		Assert.assertEquals(cartemptymsg.getText(), "Cart is empty!");
	}

	private boolean isRemoveButtonDisplayed() {
		try {
			removeproduct = driver.findElement(By.xpath("//tbody//td[6]//a"));
			return removeproduct.isDisplayed();
		}
		catch (org.openqa.selenium.NoSuchElementException e) {
			return false;
		}
	}

	public void removeAllProducts() {
		while (isRemoveButtonDisplayed()) {
			try {
			removeproduct = driver.findElement(By.xpath("//tbody//td[6]//a"));
			removeproduct.click();
			}catch (NoSuchElementException e) {
	            // Element might have disappeared, break out of the loop
	            break;
	        } catch (StaleElementReferenceException e) {
	            // Element might have become stale, find it again
	            continue;
	        }
		}


	}
}





