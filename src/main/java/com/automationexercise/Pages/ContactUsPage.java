package com.automationexercise.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.openqa.selenium.Alert;

import com.automationexercise.Base.BaseClass;

public class ContactUsPage extends BaseClass {
	
	
	public void contactUs() {
		WebElement	conUs =  driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[8]/a"));
		 conUs.click();
		 WebElement GetInTouch = driver.findElement(By.xpath("//*[@id=\"contact-page\"]/div[2]/div[1]/div/h2"));
		 
		 Assert.assertEquals(GetInTouch.getText(), "GET IN TOUCH");
		 
		 WebElement name = driver.findElement(By.xpath("//input[@data-qa=\"name\"]"));
		 name.sendKeys("pratik");
		 WebElement email = driver.findElement(By.xpath("//input[@data-qa=\"email\"]"));
		 email.sendKeys("abc@gmail.com");
		 WebElement sub = driver.findElement(By.xpath("//input[@data-qa=\"subject\"]"));
		 sub.sendKeys("test");
		 WebElement msg = driver.findElement(By.id("message"));
		 msg.sendKeys("This is a test message");
		 WebElement upfile = driver.findElement(By.name("upload_file"));
		 upfile.sendKeys("C:\\Users\\prati\\OneDrive\\Desktop\\Java Projects\\AutomationExercise\\Files\\Selenium-3-webdriver.jpg");
		 WebElement submit = driver.findElement(By.xpath("//input[@data-qa=\"submit-button\"]"));
		 submit.click();
		 Alert alert=driver.switchTo().alert();
		 alert.accept();
		 WebElement successMsg = driver.findElement(By.xpath("//*[@id=\"contact-page\"]/div[2]/div[1]/div/div[2]"));
		 Assert.assertEquals(successMsg.getText(), "Success! Your details have been submitted successfully.");
		 WebElement homeBtn  =  driver.findElement(By.xpath("//*[@id=\"form-section\"]/a"));
		 homeBtn.click();
		 Assert.assertEquals(driver.getCurrentUrl(), "https://automationexercise.com/");
 	}
}
