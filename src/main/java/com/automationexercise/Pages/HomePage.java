package com.automationexercise.Pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.automationexercise.Base.BaseClass;
import com.automationexercise.utils.utils;

public class HomePage extends BaseClass {

	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	JavascriptExecutor js = (JavascriptExecutor) driver;

	public void Subscription() {
		//		JavascriptExecutor js = (JavascriptExecutor) driver;
		//		js.executeScript("window.scrollBy(0,950)", "");
		WebElement sub = driver.findElement(By.xpath("//footer[@id=\"footer\"]//div//div[2]//h2"));
		System.out.println(sub.getText());
		Assert.assertEquals(sub.getText(), "SUBSCRIPTION");

		WebElement subEmail = driver.findElement(By.id("susbscribe_email"));
		subEmail.sendKeys("abc@gmail.com");
		WebElement arrow = driver.findElement(By.id("subscribe"));
		arrow.click();
		WebElement succMsg = driver.findElement(By.id("success-subscribe"));
		Assert.assertEquals(succMsg.getText(), "You have been successfully subscribed!");
	}

	public void VerifySubscriptionInCartPage() {

		utils.addToCart(driver);

		WebElement footer = driver.findElement(By.id("footer"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", footer);
		WebElement subCart = driver.findElement(By.xpath("//div[@class=\"single-widget\"]/h2"));
		Assert.assertEquals(subCart.getText(), "SUBSCRIPTION");
	}

	public void AddToCartfromRecitems() {

		WebElement RecommendedItems = driver.findElement(By.xpath("//*[text() = 'recommended items']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", RecommendedItems);

		Assert.assertTrue(RecommendedItems.isDisplayed(), "'RECOMMENDED ITEMS' are visible");

		WebElement recProd = utils.waitForClickableElement(driver, By.xpath("//div[@id='recommended-item-carousel']//a[@data-product-id='1']"),Duration.ofSeconds(10)) ;
		recProd.click();

		//		WebElement contShopping = driver.findElement(By.xpath("//div[@class='modal-footer']//button"));
		//		contShopping.click();
		WebElement ViewCartbtn = driver.findElement(By.xpath("//div[@id='cartModal']//a[@href='/view_cart']"));
		ViewCartbtn.click();

		WebElement prodInCart = driver.findElement(By.xpath("//a[@href='/product_details/1']"));
//		WebElement prodInCart = utils.waitForElementPresent(driver, By.xpath("//tr[@id=\"product-1\"]//td[2]//h4//a]"), Duration.ofSeconds(2));
		

		Assert.assertEquals(prodInCart.getText(), "Blue Top");


	}
	
	public void scrollUpWithArrow() {
		
		WebElement sub = driver.findElement(By.xpath("//footer[@id=\"footer\"]//div//div[2]//h2"));
		
		js.executeScript("arguments[0].scrollIntoView(true);", sub);
		
		System.out.println(sub.getText());
		Assert.assertEquals(sub.getText(), "SUBSCRIPTION");
		System.out.println("Subscription is visible.");
		
		WebElement scrollUP = driver.findElement(By.id("scrollUp"));
		scrollUP.click();
		WebElement visibleText = driver.findElement(By.xpath("//*[text() ='Full-Fledged practice website for Automation Engineers']"));
		Assert.assertTrue(visibleText.isDisplayed());
	}
	
public void scrollUpWithoutArrow() {
		
		WebElement sub = driver.findElement(By.xpath("//footer[@id=\"footer\"]//div//div[2]//h2"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", sub);
		
		System.out.println(sub.getText());
		Assert.assertEquals(sub.getText(), "SUBSCRIPTION");
		System.out.println("Subscription is visible.");
		
		js.executeScript("window.scrollTo(0, 0);");

		
		WebElement visibleText = driver.findElement(By.xpath("//*[text() ='Full-Fledged practice website for Automation Engineers']"));
		Assert.assertTrue(visibleText.isDisplayed());
	}
}

