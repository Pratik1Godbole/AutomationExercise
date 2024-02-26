package com.automationexercise.Pages;

import static org.testng.Assert.assertEquals;


import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.automationexercise.Base.BaseClass;
import com.automationexercise.config.Constants;
import com.automationexercise.utils.utils;

public class CartPage extends BaseClass {


	ProductPage pp;
	Constants con;
	SignUpPage signUP;
	SignInPage signIn;

	public CartPage() {
		PageFactory.initElements(driver, this);
	}


	@FindBy(xpath = "//a[@href='/product_details/1']")
	private WebElement viewProduct;

	@FindBy(xpath ="//tbody//td[6]//a")
	private WebElement  removeproduct;



	@FindBy(id ="quantity")
	private WebElement quantity;

	@FindBy(xpath ="//button[@type='button']")
	private	WebElement ATCBtn;
	@FindBy(xpath ="//p[@class='text-center']//a")
	private WebElement viewCart;

	@FindBy(xpath = "//tr[@id='product-1']//td//button")
	private WebElement quan;

	@FindBy(xpath = "//p[@class='text-center']//following::a[@href='/login']")
	private WebElement RegOrLogin;

	@FindBy(xpath = "//section[@id='do_action']//following::div[@class='col-sm-6']//a")
	private WebElement checkout;

	@FindBy(xpath = "//ul[@id='address_delivery']//li[2]")
	private WebElement DelName;

	@FindBy(xpath = "//ul[@id='address_delivery']//li[3]")
	private WebElement Delcomp;

	@FindBy(xpath = "//ul[@id='address_delivery']//li[4]")
	private WebElement Deladd1;

	@FindBy(xpath = "//ul[@id='address_delivery']//li[5]")
	private WebElement Deladd2;

	@FindBy(xpath = "//ul[@id='address_delivery']//li[6]")
	private WebElement DelcityStatePostCode;

	@FindBy(xpath = "//ul[@id='address_delivery']//li[7]")
	private WebElement Delcountry;

	@FindBy(xpath = "//ul[@id='address_delivery']//li[8]")
	private WebElement Delmob;

	@FindBy(xpath = "//ul[@id='address_invoice']//li[2]")
	private WebElement BilName;

	@FindBy(xpath = "//ul[@id='address_invoice']//li[3]")
	private WebElement Bilcomp;

	@FindBy(xpath = "//ul[@id='address_invoice']//li[4]")
	private WebElement Biladd1;

	@FindBy(xpath = "//ul[@id='address_invoice']//li[5]")
	private WebElement Biladd2;

	@FindBy(xpath = "//ul[@id='address_invoice']//li[6]")
	private WebElement BilcityStatePostCode;

	@FindBy(xpath = "//ul[@id='address_invoice']//li[7]")
	private WebElement Bilcountry;

	@FindBy(xpath = "//ul[@id='address_invoice']//li[8]")
	private WebElement Bilmob;

	@FindBy(xpath = "//a[@href=\"/product_details/1\"]")
	private WebElement blueT;

	@FindBy(xpath = "//*[@id=\"product-1\"]/td[2]/p")
	private WebElement bluecat;

	@FindBy(xpath = "//*[@id=\"product-1\"]/td[3]/p")
	private WebElement bluePrice;

	@FindBy(xpath = "//*[@id=\"product-1\"]/td[4]/button")
	private WebElement bluequantity;

	@FindBy(xpath = "//a[@href='/product_details/2']")
	private WebElement tshirtT;

	@FindBy(xpath = "//*[@id='product-2']/td[2]/p")
	private WebElement tshirtcat;

	@FindBy(xpath = "//*[@id='product-2']/td[3]/p")
	private WebElement tshirtPrice;

	@FindBy(xpath = "//*[@id='product-2']/td[4]/button")
	private WebElement tshirtquantity;

	@FindBy(xpath = "//textarea[@name='message']")
	private WebElement msgtext;

	@FindBy(xpath = "//a[@href='/payment']")
	private WebElement placeOrder;

	@FindBy(xpath = "//*[@id='empty_cart']/p/b")
	private WebElement cartemptymsg;

	@FindBy(xpath = "//tr[@id=\\\"product-1\\\"]//td[5]//p")
	private WebElement totalblue ;


	@FindBy(xpath = "//tr[@id='product-2']//td[5]//p")
	private WebElement totaltext;

	@FindBy (xpath = "//tbody//tr[3]//td//p")
	WebElement TotalAmount;





	public WebElement getBlueT() {
		return blueT;
	}

	public WebElement getBluePrice() {
		return bluePrice;
	}

	public WebElement getBluequantity() {
		return bluequantity;
	}



	public double calculateTotal() {
		double price = Double.parseDouble(getBluePrice().getText().replaceAll("^\\D+", ""));
		double quantity = Double.parseDouble(getBluequantity().getText().trim());
		return price * quantity;
	}

	public WebElement findTotalElement() {
		return driver.findElement(By.xpath("//tr[@id=\"product-1\"]//td[5]//p"));
	}


	public void VerifyPqInCart() {
		pp = new ProductPage();
		pp.productsBtn();
		utils.scrollBy(driver);
		utils.waitForElementPresent(driver,viewProduct , Duration.ofSeconds(5));
		viewProduct.click();
		Assert.assertEquals(driver.getCurrentUrl(), "https://automationexercise.com/product_details/1");


		quantity.clear();
		quantity.sendKeys("4");


		ATCBtn.click();


		viewCart.click();
		utils.waitForElementPresent(driver, viewProduct, Duration.ofSeconds(5));
		Assert.assertEquals(viewProduct.getText(), con.productName);


		Assert.assertEquals(quan.getText(), "4");
	}


	public void RegisterWhileCheckOut() {
		pp = new ProductPage();
		pp.AddProductInCart();
		ClickOnCheckOut();

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

		checkout.click();

	}

	public void VerifyAddAndReviewYourOrder() {
		VerifyDeliveryAdd();
		VerifyBillingAdd();
		ReviewProducts();


	}

	public void VerifyDeliveryAdd() {

		Assert.assertEquals(DelName.getText(), con.firstNameLastName);
		Assert.assertEquals(Delcomp.getText(), con.company);
		Assert.assertEquals(Deladd1.getText(), con.add1);
		Assert.assertEquals(Deladd2.getText(), con.add2);
		Assert.assertEquals(DelcityStatePostCode.getText(), con.cityStatePostcode);
		Assert.assertEquals(Delcountry.getText(), con.country);
		Assert.assertEquals(Delmob.getText(), con.mob);
		System.out.println("The delivery address is same address filled at the time registration of account");
	}

	public void VerifyBillingAdd() {
		Assert.assertEquals(BilName.getText(), con.firstNameLastName);
		Assert.assertEquals(Bilcomp.getText(), con.company);
		Assert.assertEquals(Biladd1.getText(), con.add1);
		Assert.assertEquals(Biladd2.getText(), con.add2);
		Assert.assertEquals(BilcityStatePostCode.getText(), con.cityStatePostcode);
		Assert.assertEquals(Bilcountry.getText(), con.country);
		Assert.assertEquals(Bilmob.getText(), con.mob);
		System.out.println("The billing address is same address filled at the time registration of account");
	}

	public void ReviewProducts() {
		Assert.assertEquals(DelName.getText(), con.firstNameLastName);
		Assert.assertEquals(Delcomp.getText(), con.company);
		Assert.assertEquals(Deladd1.getText(), con.add1);
		Assert.assertEquals(Deladd2.getText(), con.add2);
		Assert.assertEquals(DelcityStatePostCode.getText(), con.cityStatePostcode);
		Assert.assertEquals(Delcountry.getText(), con.country);
		Assert.assertEquals(Delmob.getText(), con.mob);
		utils.scrollBy(driver);

		// product 1
		Assert.assertEquals(blueT.getText(), con.productName);
		Assert.assertEquals(bluecat.getText(), con.category);
		Assert.assertEquals(bluePrice.getText(),con.price);
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
		Assert.assertEquals(tshirtT.getText(), con.productName2);
		Assert.assertEquals(tshirtcat.getText(), con.category2);
		Assert.assertEquals(tshirtPrice.getText(),con.price2);
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


		Assert.assertEquals(TotalAmount.getText(), "Rs. 900");
	}


	public void EnterCommentTextAndClickPlaceOrder() {

		//Enter description in comment text area and click 'Place Order'


		msgtext.sendKeys(con.comment);

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

		System.out.println(cartemptymsg.getText());
		Assert.assertEquals(cartemptymsg.getText(), "Cart is empty!");
	}

	private boolean isRemoveButtonDisplayed() {
		try {
			return removeproduct.isDisplayed();
		}
		catch (org.openqa.selenium.NoSuchElementException e) {
			return false;
		}
	}

	public void removeAllProducts() {
		while (isRemoveButtonDisplayed()) {
			try {
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




