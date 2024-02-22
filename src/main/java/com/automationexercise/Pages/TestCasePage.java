package com.automationexercise.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.automationexercise.Base.BaseClass;

public class TestCasePage extends BaseClass {
	
	
	public void TestCase() {
		
		WebElement tcBtn = driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[5]/a")); 
		tcBtn.click();
		Assert.assertEquals(driver.getCurrentUrl(), "https://automationexercise.com/test_cases");
	}

}
