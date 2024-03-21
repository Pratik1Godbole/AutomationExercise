	package com.automationexercise.Pages;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.automationexercise.Base.BaseClass;
import com.automationexercise.config.Constants;
import com.automationexercise.utils.utils;





public class ProductPage extends BaseClass{
	Constants con;
	SignInPage signIn;


	@FindBy(xpath = "//a[@href='/product_details/1']")
	private WebElement viewProduct;

	@FindBy(xpath = "//div[@class='product-information']//h2")
	private WebElement productName;

	@FindBy(xpath = "//div[@class='product-information']//p[1]")
	private WebElement category;

	@FindBy(xpath = "//div[@class='product-information']//span/span")
	private WebElement price;

	@FindBy(xpath = "//div[@class='product-information']//p[2]")
	private WebElement availability;

	@FindBy(xpath = "//div[@class='product-information']//p[3]")
	private WebElement condition;

	@FindBy(xpath = "//div[@class='product-information']//p[4]")
	private WebElement brand;

	@FindBy(id = "search_product")
	private WebElement searchProduct;

	@FindBy(id = "submit_search")
	private WebElement submitsearch;

	@FindBy(xpath = "//*[text()='Searched Products']")
	private WebElement searchedProductTitle;

	@FindBy(xpath = "//div[@class='productinfo text-center']//p")
	private List<WebElement> searchResultTitles;

	@FindBy(xpath = "//div[@class='single-products']//preceding::img[@src='/get_product_picture/1']")
	private WebElement firstProduct;

//	@FindBy(xpath = "//div[@class='product-overlay']//a[@data-product-id='1']")
	@FindBy(xpath = "//a[@data-product-id='1']")
	private WebElement addToCartP1;

	@FindBy(xpath = "//div[@class='modal-footer']//button")
	private WebElement continueShopping;

	@FindBy(xpath = "//div[@class='single-products']//preceding::img[@src='/get_product_picture/2']")
	private WebElement secondProduct;

	@FindBy(xpath = "//a[@data-product-id='2']")
	private WebElement addToCartP2;

	@FindBy(xpath = "//a[@href='/product_details/1']")
	private WebElement title1;

	@FindBy(xpath = "//tr[@id='product-1']//td[@class='cart_description']//p")
	private WebElement cat1;

	@FindBy(xpath = "//tr[@id='product-1']//td[@class='cart_price']//p")
	private WebElement price1;

	@FindBy(xpath = "//tr[@id='product-1']//td//button")
	private WebElement quantity1;

	@FindBy(xpath = "//tr[@id='product-1']//td//p[@class='cart_total_price']")
	private WebElement total1;

	@FindBy(xpath = "//tr[@id='product-2']//a[@href='/product_details/2']")
	private WebElement title2;

	@FindBy(xpath = "//tr[@id='product-2']//td[@class='cart_description']//p")
	private WebElement cat2;

	@FindBy(xpath = "//tr[@id='product-2']//td[@class='cart_price']//p")
	private WebElement price2;

	@FindBy(xpath = "//tr[@id='product-2']//td//button")
	private WebElement quantity2;

	@FindBy(xpath = "//tr[@id='product-2']//td/p[@class='cart_total_price']")
	private WebElement total2;


	@FindBy(xpath ="//*[@id='header']/div/div/div/div[2]/div/ul/li[2]/a")
	private WebElement productsBtn ;

	@FindBy(id = "accordian")
	private WebElement panelGroup;

	@FindBy(xpath = "//h4[@class='panel-title']/a[text()='{categoryName}']/ancestor::div[@class='panel panel-default']")
	private WebElement categoryPanel;


	@FindBy(xpath = "//a[@href='#Women']")
	private WebElement womenCategory;

	@FindBy(xpath = "//a[@href='/category_products/1']")
	private WebElement subWomenCat;

	@FindBy(xpath = "//a[@href='#Men']")
	private WebElement menCategory;

	@FindBy(xpath = "//a[@href='#Kids']")
	private WebElement kidsCategory;

	@FindBy(xpath = "//a[@href='/category_products/3']")
	private WebElement subMenCat;

	@FindBy(xpath = "//div[@class='productinfo text-center']//a[@class='btn btn-default add-to-cart']")
	private List<WebElement> addToCartButtons;

	@FindBy(xpath = "//div[@id='cart_info']//tbody//td//h4//a")
	private List<WebElement> prodInCart;

	@FindBy(xpath = "//*[text()='Brands']")
	private WebElement Brand;

	@FindBy(xpath = "//a[@href='/product_details/1']")
	private WebElement prodDetails;

	@FindBy(xpath = "//*[text()='Write Your Review']")
	private WebElement writeUrReview;

	@FindBy(id = "name")
	private WebElement name;

	@FindBy(id = "email")
	private WebElement email;

	@FindBy(id = "review")
	private WebElement review;

	@FindBy(id = "button-review")
	private WebElement submit;

	@FindBy(xpath = "//*[text() ='Thank you for your review.']")
	private WebElement submitMsg;
	
	@FindBy(xpath = "//a[@href='/brand_products/Madame']" )
	private WebElement madame;
	@FindBy(xpath = "//*[text()='Brand - Madame Products']" )
	private WebElement MadameProductText;
	@FindBy(xpath = "//a[@href='/brand_products/Biba']" )
	private WebElement BibaBrandProducts;
	@FindBy(xpath = "//*[text()='Brand - Biba Products']" )
	private WebElement BibaProducts;
	
	
	

	private List<String> productsAddedBeforeLogin = new ArrayList<String>();



	public ProductPage() {
		PageFactory.initElements(driver, this);
	}



	public void verifyAllProducts() {
		productsBtn();
		utils.scrollBy(driver);
		viewProduct.click();
		Assert.assertEquals(driver.getCurrentUrl(), "https://automationexercise.com/product_details/1");
		Assert.assertEquals(productName.getText().trim(), con.productName);
		String [] cat = category.getText().split(":");
		Assert.assertEquals(cat[1].trim(), con.category);
		String pr =price.getText();
		Assert.assertEquals(pr.trim(), con.price);
		String [] av =availability.getText().split(":");
		Assert.assertEquals(av[1].trim(), con.availability);
		String [] cond =condition.getText().split(":");
		Assert.assertEquals(cond[1].trim(), con.condition);
		String [] br =brand.getText().split(":");
		Assert.assertEquals(br[1].trim(), con.brand);

	}


	public void searchProduct() {
		productsBtn();
		String searchText = "Tshirt";
		searchProduct.sendKeys(searchText);
		submitsearch.click();
		Assert.assertTrue(searchProduct.isDisplayed());
		utils.scrollBy(driver);
		for (WebElement result:searchResultTitles ) {
			String title = result.getText();
			Assert.assertTrue(title.toLowerCase().contains(searchText.toLowerCase()) || title.toLowerCase().contains("t-shirt") || title.toLowerCase().contains("t shirt"),
					"Search result title doesn't contain search query: " + title);
		}


	}

	public void AddProductInCart() {
		productsBtn();
		utils.scrollBy(driver);
		Actions action = new Actions(driver);
		action.moveToElement(firstProduct).perform();
		addToCartP1.click();
		continueShopping.click();
		action.moveToElement(secondProduct).perform();
		addToCartP2.click();
		utils.waitForElementPresent(driver,continueShopping , Duration.ofSeconds(5)).click();
		utils.addToCart(driver);
		Assert.assertEquals(title1.getText(), con.productName);
		Assert.assertEquals(cat1.getText(), con.category);
		Assert.assertEquals(price1.getText(), con.price);
		Assert.assertEquals(quantity1.getText(), con.quantity);
		Assert.assertEquals(total1.getText(), con.price);
		Assert.assertEquals(title2.getText(), con.productName2);
		Assert.assertEquals(cat2.getText(), con.category2);
		Assert.assertEquals(price2.getText(), con.price2);
		Assert.assertEquals(quantity2.getText(), con.quantity2);
		Assert.assertEquals(total2.getText(), con.price2);
	}

	public void productsBtn() {
		utils.waitForElementPresent(driver,productsBtn , Duration.ofSeconds(10));
		productsBtn.click();
		Assert.assertEquals(driver.getCurrentUrl(), "https://automationexercise.com/products");
	}


	public void viewCategoryProducts() {
		utils.scrollBy(driver);
		WebElement categories = new WebDriverWait(driver, Duration.ofSeconds(10))
				.until(ExpectedConditions.presenceOfElementLocated(By.id("accordian")));
		Assert.assertTrue(categories.isDisplayed(), "Categories not visible on left sidebar."); 


		// Verify Women category is visible

		Assert.assertTrue(womenCategory.isDisplayed() , "Women category not visible.");
		womenCategory.click();
		subWomenCat.click();
		String expectedText = "WOMEN - DRESS PRODUCTS";
		String actualText = new WebDriverWait(driver, Duration.ofSeconds(10))
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h2[contains(text(), 'Women - Dress Products')]"))).getText();
		Assert.assertEquals( expectedText, actualText);
		Assert.assertTrue(menCategory.isDisplayed(), "Men category is not visible.");

		// Verify Kids category is visible
		Assert.assertTrue(kidsCategory.isDisplayed(), "Kids category is not visible.");


		menCategory.click();
		subMenCat.click();
		Assert.assertEquals(driver.getCurrentUrl(), "https://automationexercise.com/category_products/3");	
	}


	public WebElement getPanelGroup() {
		return panelGroup;
	}



	public WebElement getCategoryPanel(String categoryName) {
		categoryPanel = driver.findElement(By.xpath(String.format(categoryPanel.toString(), categoryName)));
		return categoryPanel;
	}
	

	
	
	public void ViewAndCartBrandProducts() {
		productsBtn();
		utils.scrollBy(driver);
		boolean brandsTextDisplayed = Brand.isDisplayed();
		Assert.assertTrue(brandsTextDisplayed);
		madame.click();
		boolean MadameBrandProducts = MadameProductText.isDisplayed();
		Assert.assertTrue(MadameBrandProducts);
		BibaBrandProducts.click();
		Assert.assertEquals(driver.getCurrentUrl(), "https://automationexercise.com/brand_products/Biba");
		Assert.assertTrue(BibaProducts.isDisplayed());
	}


	public void SeaechProductsAndVerifyAfterCartLogin() {
		searchProduct();
		for (WebElement button :addToCartButtons) {
			button.click();
			continueShopping.click();
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
		String keyword = "tshirt";
		for (WebElement result:prodInCart ) {
			String title = result.getText();
			Assert.assertTrue(title.toLowerCase().contains(keyword.toLowerCase()) || title.toLowerCase().contains("t-shirt") || title.toLowerCase().contains("t shirt"),
					"Search result title doesn't contain search query: " + title);
		}
	}


	public boolean verifyProductsInCartAfterLogin() {

		List<String> titlesAfterLogin = new ArrayList<String>();
		for (WebElement result : prodInCart) {
			String title = result.getText();
			titlesAfterLogin.add(title);
		}
		return titlesAfterLogin.containsAll(productsAddedBeforeLogin);
	}


	public void AddreviewOnProd() {
		productsBtn();

		prodDetails.click();
		utils.scrollBy(driver);


		Assert.assertTrue(writeUrReview.isDisplayed());
		System.out.println("Write Your Review' is visible");

		name.sendKeys("pratik");

		email.sendKeys("pratik@gmail.com");

		review.sendKeys("Nice Product!");

		submit.click();

		Assert.assertTrue(submitMsg.isDisplayed(), "'Thank you for your review.'"+"is visible");
	}



}



