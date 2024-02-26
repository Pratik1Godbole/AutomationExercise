package com.automationexercise.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.openqa.selenium.Alert;

import com.automationexercise.Base.BaseClass;

public class ContactUsPage extends BaseClass {
	
	
	@FindBy(xpath= "//*[@id=\\\"header\\\"]/div/div/div/div[2]/div/ul/li[8]/a")
	private WebElement	conUs;
	
	@FindBy(xpath= "//*[@id=\\\"contact-page\\\"]/div[2]/div[1]/div/h2")
	private WebElement GetInTouch;
	
	@FindBy(xpath= "//input[@data-qa='name']")
	private WebElement name;
	
	@FindBy(xpath= "//input[@data-qa='email']")
	private WebElement email;
	
	@FindBy(xpath= "//input[@data-qa='subject']")
	private WebElement sub;
	
	@FindBy(id= "message")
	private WebElement msg;
	
	@FindBy(name= "upload_file")
	private WebElement upfile;
	
	@FindBy(xpath= "//input[@data-qa='submit-button']")
	private WebElement submit;
	
	@FindBy(xpath= "//*[@id='contact-page']/div[2]/div[1]/div/div[2]")
	private WebElement successMsg ;
	
	@FindBy(xpath= "//*[@id='form-section']/a")
	private WebElement homeBtn;
	
	
	public ContactUsPage() {
		 PageFactory.initElements(driver, this);
	}
	
	public void contactUs() {
		
		 conUs.click();
		
		 
		 Assert.assertEquals(GetInTouch.getText(), "GET IN TOUCH");
		 name.sendKeys("pratik");
		 email.sendKeys("abc@gmail.com");
		 sub.sendKeys("test");
		 msg.sendKeys("This is a test message");
		 upfile.sendKeys("C:\\Users\\prati\\OneDrive\\Desktop\\Java Projects\\AutomationExercise\\Files\\Selenium-3-webdriver.jpg");
		
		 submit.click();
		 Alert alert=driver.switchTo().alert();
		 alert.accept();
		
		 Assert.assertEquals(successMsg.getText(), "Success! Your details have been submitted successfully.");
		 
		 homeBtn.click();
		 Assert.assertEquals(driver.getCurrentUrl(), "https://automationexercise.com/");
 	}
}
