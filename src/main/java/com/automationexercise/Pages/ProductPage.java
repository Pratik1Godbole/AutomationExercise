package com.automationexercise.Pages;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.automationexercise.Base.BaseClass;
import com.automationexercise.config.Constants;
import com.automationexercise.utils.utils;





public class ProductPage extends BaseClass{
	Constants con;
	SignInPage signIn;
	
	private List<String> productsAddedBeforeLogin = new ArrayList<String>();




	public void verifyAllProducts() {
		productsBtn();


		utils.scrollBy(driver);
		WebElement viewProduct = driver.findElement(By.xpath("//a[@href=\"/product_details/1\"]"));
		viewProduct.click();
		Assert.assertEquals(driver.getCurrentUrl(), "https://automationexercise.com/product_details/1");

		WebElement productName = driver.findElement(By.xpath("//div[@class=\"product-information\"]//h2"));
		Assert.assertEquals(productName.getText().trim(), con.productName);

		WebElement Category = driver.findElement(By.xpath("//div[@class=\"product-information\"]//p[1]"));	
		String [] cat =Category.getText().split(":");
		Assert.assertEquals(cat[1].trim(), con.category);

		WebElement price = driver.findElement(By.xpath("//div[@class=\"product-information\"]//span/span"));
		String pr =price.getText();
		Assert.assertEquals(pr.trim(), con.price);

		WebElement availability = driver.findElement(By.xpath("//div[@class=\"product-information\"]//p[2]"));
		String [] av =availability.getText().split(":");
		Assert.assertEquals(av[1].trim(), con.availability);

		WebElement condition = driver.findElement(By.xpath("//div[@class=\"product-information\"]//p[3]"));
		String [] cond =condition.getText().split(":");
		Assert.assertEquals(cond[1].trim(), con.condition);

		WebElement brand = driver.findElement(By.xpath("//div[@class=\"product-information\"]//p[4]"));
		String [] br =brand.getText().split(":");
		Assert.assertEquals(br[1].trim(), con.brand);

	}


	public void searchProduct() {
		productsBtn();
		WebElement SearchProduct = driver.findElement(By.id("search_product"));
		String searchText = "Tshirt";
		SearchProduct.sendKeys(searchText);
		WebElement Submit = driver.findElement(By.id("submit_search"));
		Submit.click();
		WebElement SearchedProdT = driver.findElement(By.xpath("//*[text()='Searched Products']"));

		Assert.assertTrue(SearchedProdT.isDisplayed());

		utils.scrollBy(driver);

		List<WebElement> searchResultTitles = driver.findElements(By.xpath("//div[@class='productinfo text-center']//p"));

		for (WebElement result:searchResultTitles ) {
			String title = result.getText();
			Assert.assertTrue(title.toLowerCase().contains(searchText.toLowerCase()) || title.toLowerCase().contains("t-shirt") || title.toLowerCase().contains("t shirt"),
					"Search result title doesn't contain search query: " + title);
		}


	}

	public void AddProductInCart() {
		productsBtn();
		utils.scrollBy(driver);
		WebElement firstProduct = driver.findElement(By.xpath("//div[@class=\"single-products\"]//preceding::img[@src=\"/get_product_picture/1\"]"));
		Actions action = new Actions(driver);
		action.moveToElement(firstProduct).perform();
		//		WebElement addtoCartp1 = driver.findElement(By.xpath("//div[@class=\"product-overlay\"]//a[@data-product-id='1']"));
		WebElement addtoCartp1 = utils.waitForClickableElement(driver, By.xpath("//div[@class=\"product-overlay\"]//a[@data-product-id='1']"),Duration.ofSeconds(10));

		addtoCartp1.click();
		WebElement contShopping = driver.findElement(By.xpath("//div[@class='modal-footer']//button"));
		contShopping.click();

		WebElement secondProduct = driver.findElement(By.xpath("//div[@class='single-products']//preceding::img[@src='/get_product_picture/2']"));
		action.moveToElement(secondProduct).perform();
		//		WebElement addtoCartp2 = driver.findElement(By.xpath("//div[@class=\"product-overlay\"]//a[@data-product-id='2']"));
		WebElement addtoCartp2 = utils.waitForClickableElement(driver, By.xpath("//div[@class=\"product-overlay\"]//a[@data-product-id='2']"),Duration.ofSeconds(10));
		addtoCartp2.click();
		utils.waitForElementPresent(driver,By.xpath("//div[@class='modal-footer']//button") , Duration.ofSeconds(5)).click();
		utils.addToCart(driver);
		WebElement title1 =driver.findElement(By.xpath("//a[@href='/product_details/1']"));
		Assert.assertEquals(title1.getText(), con.productName);
		WebElement cat1 = driver.findElement(By.xpath("//tr[@id='product-1']//td[@class='cart_description']//p"));
		Assert.assertEquals(cat1.getText(), con.category);
		WebElement price1 = driver.findElement(By.xpath("//tr[@id='product-1']//td[@class='cart_price']//p"));
		Assert.assertEquals(price1.getText(), con.price);
		WebElement quantity1 = driver.findElement(By.xpath("//tr[@id='product-1']//td//button"));
		Assert.assertEquals(quantity1.getText(), con.quantity);
		WebElement totaL1 = driver.findElement(By.xpath("//tr[@id='product-1']//td//p[@class='cart_total_price']"));
		Assert.assertEquals(totaL1.getText(), con.price);

		WebElement title2 = driver.findElement(By.xpath("//tr[@id='product-2']//a[@href='/product_details/2']"));
		Assert.assertEquals(title2.getText(), con.productName2);
		WebElement cat2 = driver.findElement(By.xpath("//tr[@id='product-2']//td[@class='cart_description']//p"));
		Assert.assertEquals(cat2.getText(), con.category2);
		WebElement price2 = driver.findElement(By.xpath("//tr[@id='product-2']//td[@class='cart_price']//p"));
		Assert.assertEquals(price2.getText(), con.price2);
		WebElement quantity2 = driver.findElement(By.xpath("//tr[@id='product-2']//td//button"));
		Assert.assertEquals(quantity2.getText(), con.quantity2);
		WebElement totaL2 = driver.findElement(By.xpath("//tr[@id='product-2']//td/p[@class='cart_total_price']"));
		Assert.assertEquals(totaL2.getText(), con.price2);





	}

	public void productsBtn() {
		WebElement productsBtn = utils.waitForElementPresent(driver,By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[2]/a") , Duration.ofSeconds(10));
		productsBtn.click();
		Assert.assertEquals(driver.getCurrentUrl(), "https://automationexercise.com/products");
	}


	public void viewCategoryProducts() {

		utils.scrollBy(driver);


		WebElement categories = new WebDriverWait(driver, Duration.ofSeconds(10))
				.until(ExpectedConditions.presenceOfElementLocated(By.id("accordian")));
		Assert.assertTrue(categories.isDisplayed(), "Categories not visible on left sidebar."); 


		// Verify Women category is visible
		WebElement womenCategory = driver.findElement(By.xpath("//a[@href='#Women']"));
		Assert.assertTrue(womenCategory.isDisplayed() , "Women category not visible.");
		womenCategory.click();
		WebElement subWomenCat = driver.findElement(By.xpath("//a[@href='/category_products/1']"));
		subWomenCat.click();
		String expectedText = "WOMEN - DRESS PRODUCTS";
		String actualText = new WebDriverWait(driver, Duration.ofSeconds(10))
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h2[contains(text(), 'Women - Dress Products')]"))).getText();
		Assert.assertEquals( expectedText, actualText);

		WebElement menCategory = driver.findElement(By.xpath("//a[@href='#Men']"));
		Assert.assertTrue(menCategory.isDisplayed(), "Men category is not visible.");




		// Verify Kids category is visible
		WebElement kidsCategory = driver.findElement(By.xpath("//a[@href='#Kids']"));

		Assert.assertTrue(kidsCategory.isDisplayed(), "Kids category is not visible.");

		//click on Women category


		menCategory.click();
		WebElement subMenCat = driver.findElement(By.xpath("//a[@href='/category_products/3']"));
		subMenCat.click();
		Assert.assertEquals(driver.getCurrentUrl(), "https://automationexercise.com/category_products/3");	


	}


	public WebElement getPanelGroup() {
		return driver.findElement(By.id("accordian"));
	}


	public WebElement getCategoryPanel(String categoryName) {
		String categoryPanelXpath = String.format("//h4[@class='panel-title']/a[text()='%s']/ancestor::div[@class='panel panel-default']", categoryName);
		return driver.findElement(By.xpath(categoryPanelXpath));
	}


	public void ViewAndCartBrandProducts() {
		productsBtn();
		utils.scrollBy(driver);
		WebElement Brand = driver.findElement(By.xpath("//*[text()='Brands']"));

		boolean brandsTextDisplayed = Brand.isDisplayed();
		Assert.assertTrue(brandsTextDisplayed);

		WebElement madame = driver.findElement(By.xpath("//a[@href='/brand_products/Madame']"));
		madame.click();

		WebElement MadameProductText = driver.findElement(By.xpath("//*[text()='Brand - Madame Products']"));


		boolean MadameBrandProducts = MadameProductText.isDisplayed();
		Assert.assertTrue(MadameBrandProducts);

		WebElement BibaBrandProducts = driver.findElement(By.xpath("//a[@href='/brand_products/Biba']"));
		BibaBrandProducts.click();

		Assert.assertEquals(driver.getCurrentUrl(), "https://automationexercise.com/brand_products/Biba");

		WebElement BibaProducts = driver.findElement(By.xpath("//*[text()='Brand - Biba Products']"));
		Assert.assertTrue(BibaProducts.isDisplayed());
	}


	public void SeaechProductsAndVerifyAfterCartLogin() {
		searchProduct();

		List<WebElement> addToCartButtons = driver.findElements(By.xpath("//div[@class=\"productinfo text-center\"]//a[@class='btn btn-default add-to-cart']"));
		for (WebElement button :addToCartButtons) {

			button.click();
			WebElement contShopping = driver.findElement(By.xpath("//div[@class='modal-footer']//button"));
			contShopping.click();
		}

		utils.addToCart(driver);

		addtocartbeforeLogin();

		//signing in
		signIn = new SignInPage();
		signIn.loginWithValidUP("uName3","pass");

		utils.addToCart(driver);
		// Add products to the cart before login
		verifyProductsInCartAfterLogin();
		Assert.assertTrue(verifyProductsInCartAfterLogin(), "Products added before login are not visible after login.");
		

	}

	public void addtocartbeforeLogin() {
		//verifying products added into the cart
		List<WebElement> prodInCart =  driver.findElements(By.xpath("//div[@id=\"cart_info\"]//tbody//td//h4//a"));
		String keyword = "tshirt";
		for (WebElement result:prodInCart ) {
			String title = result.getText();
			Assert.assertTrue(title.toLowerCase().contains(keyword.toLowerCase()) || title.toLowerCase().contains("t-shirt") || title.toLowerCase().contains("t shirt"),
					"Search result title doesn't contain search query: " + title);
		}
	}
	
	
	 public boolean verifyProductsInCartAfterLogin() {
	        List<WebElement> prodInCartAfterLogin = driver.findElements(By.xpath("//div[@id=\"cart_info\"]//tbody//td//h4//a"));
	        List<String> titlesAfterLogin = new ArrayList<String>();
	        for (WebElement result : prodInCartAfterLogin) {
	            String title = result.getText();
	            titlesAfterLogin.add(title);
	        }
	        return titlesAfterLogin.containsAll(productsAddedBeforeLogin);
	    }
	 
	 
	 public void AddreviewOnProd() {
		 productsBtn();
		 WebElement prodDetails = driver.findElement(By.xpath("//a[@href='/product_details/1']"));
		 prodDetails.click();
		 utils.scrollBy(driver);
		 
		 WebElement WriteUrReview = driver.findElement(By.xpath("//*[text()='Write Your Review']"));
		 Assert.assertTrue(WriteUrReview.isDisplayed());
		 System.out.println("Write Your Review' is visible");
		 WebElement name=driver.findElement(By.id("name"));
		 name.sendKeys("pratik");
		 WebElement email=driver.findElement(By.id("email"));
		 email.sendKeys("pratik@gmail.com");
		 WebElement review = driver.findElement(By.id("review"));
		 review.sendKeys("Nice Product!");
		 WebElement submit = driver.findElement(By.id("button-review"));
		 submit.click();
		 WebElement submitMsg = driver.findElement(By.xpath("//*[text() ='Thank you for your review.']"));
		 Assert.assertTrue(submitMsg.isDisplayed(), "'Thank you for your review.'"+"is visible");
	 }
	 
	 

}



