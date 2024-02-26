package com.automationexercise.Pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.automationexercise.Base.BaseClass;
import com.automationexercise.utils.utils;

public class HomePage extends BaseClass {
	
	public HomePage() {
		 PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//footer[@id='footer']//div//div[2]//h2")
    private WebElement sub;

    @FindBy(id = "susbscribe_email")
    private WebElement subEmail;

    @FindBy(id = "subscribe")
    private WebElement arrow;

    @FindBy(id = "success-subscribe")
    private WebElement succMsg;

    @FindBy(id = "footer")
    private WebElement footer;

    @FindBy(xpath = "//div[@class='single-widget']/h2")
    private WebElement subCart;

    @FindBy(xpath = "//*[text() = 'recommended items']")
    private WebElement RecommendedItems;

    @FindBy(xpath = "//div[@id='recommended-item-carousel']//a[@data-product-id='1']")
    private WebElement recProd;

    @FindBy(xpath = "//div[@id='cartModal']//a[@href='/view_cart']")
    private WebElement ViewCartbtn;

    @FindBy(xpath = "//a[@href='/product_details/1']")
    private WebElement prodInCart;

    @FindBy(id = "scrollUp")
    private WebElement scrollUP;

    @FindBy(xpath = "//*[text() ='Full-Fledged practice website for Automation Engineers']")
    private WebElement visibleText;
	
    
    
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	JavascriptExecutor js = (JavascriptExecutor) driver;

	public void Subscription() {
		//		JavascriptExecutor js = (JavascriptExecutor) driver;
		//		js.executeScript("window.scrollBy(0,950)", "");
		
		System.out.println(sub.getText());
		Assert.assertEquals(sub.getText(), "SUBSCRIPTION");

		
		subEmail.sendKeys("abc@gmail.com");
		
		arrow.click();
		
		Assert.assertEquals(succMsg.getText(), "You have been successfully subscribed!");
	}

	public void VerifySubscriptionInCartPage() {

		utils.addToCart(driver);

		
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", footer);
		
		Assert.assertEquals(subCart.getText(), "SUBSCRIPTION");
	}

	public void AddToCartfromRecitems() {

		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", RecommendedItems);

		Assert.assertTrue(RecommendedItems.isDisplayed(), "'RECOMMENDED ITEMS' are visible");
		
		utils.waitForElementPresent(driver, recProd, Duration.ofSeconds(10));
		recProd.click();

		ViewCartbtn.click();
		Assert.assertEquals(prodInCart.getText(), "Blue Top");


	}
	
	public void scrollUpWithArrow() {
		js.executeScript("arguments[0].scrollIntoView(true);", sub);
		
		System.out.println(sub.getText());
		Assert.assertEquals(sub.getText(), "SUBSCRIPTION");
		System.out.println("Subscription is visible.");
		scrollUP.click();
		Assert.assertTrue(visibleText.isDisplayed());
	}
	
public void scrollUpWithoutArrow() {
		
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", sub);
		
		System.out.println(sub.getText());
		Assert.assertEquals(sub.getText(), "SUBSCRIPTION");
		System.out.println("Subscription is visible.");
		
		js.executeScript("window.scrollTo(0, 0);");

		
		
		Assert.assertTrue(visibleText.isDisplayed());
	}
}

