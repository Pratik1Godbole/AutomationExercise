package com.automationexercise.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.automationexercise.Base.BaseClass;

public class TestCasePage extends BaseClass {
	
	
	public TestCasePage() {
		 PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//*[@id=\\\"header\\\"]/div/div/div/div[2]/div/ul/li[5]/a")
	WebElement tcBtn;
	
	public void TestCase() {
		tcBtn.click();
		Assert.assertEquals(driver.getCurrentUrl(), "https://automationexercise.com/test_cases");
	}

}
