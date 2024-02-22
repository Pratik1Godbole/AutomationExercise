package com.automationexercise.Pages;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.automationexercise.Base.BaseClass;
import com.automationexercise.config.Constants;

public class SignInPage extends BaseClass{
	SignUpPage delAcc;
	WebElement signup_loginbtn;
	WebElement loginToUrAcc;
	WebElement email;
	WebElement pass;
	WebElement login;
	WebElement err;
	WebElement logoutbtn;
	
	 private Properties configProperties;
	
	Constants con;
	public SignInPage() {
		super();
		
		configProperties = new Properties();
        try {
            FileInputStream configFile = new FileInputStream("C:\\\\Users\\\\prati\\\\OneDrive\\\\Desktop\\\\Java Projects\\\\AutomationExercise\\\\src\\\\main\\\\java\\\\com\\\\automationexercise\\\\config\\\\config.properties");
            configProperties.load(configFile);
            configFile.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
	this.signup_loginbtn = driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[4]/a"));
		
		
	}
	
	public void logIn(String username, String password) {
		signup_loginbtn.click();
		loginToUrAcc = driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/h2"));
		String actualResult = loginToUrAcc.getText();
		Assert.assertEquals(actualResult, "Login to your account");
		
		email = driver.findElement(By.xpath("//input[@data-qa=\"login-email\"]"));
		email.sendKeys(username);
		pass = driver.findElement(By.xpath("//input[@data-qa=\"login-password\"]"));
		pass.sendKeys(password);
		login = driver.findElement(By.xpath("//button[@data-qa=\"login-button\"]"));
		login.click();
		
		WebElement loggedInAsUname = driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[10]/a"));
//		Assert.assertEquals(loggedInAsUname.getText(), " Logged in as " + Name );
		Assert.assertEquals(loggedInAsUname.getText().trim(), "Logged in as " + "pratik");
		System.out.println("Logged in as username' is visible");
		
	}
	
	
	
	public void loginWithValidUP(String usernameKey , String passwordkey) {
		String username = configProperties.getProperty(usernameKey);
        String password = configProperties.getProperty(passwordkey);
        
        logIn(username, password);
	}
	public void loginwithInValidUP() {
		signup_loginbtn.click();
		loginToUrAcc = driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/h2"));
		String actualResult = loginToUrAcc.getText();
		Assert.assertEquals(actualResult, "Login to your account");
		
		email = driver.findElement(By.xpath("//input[@data-qa=\"login-email\"]"));
		email.sendKeys("abassnas@outlook.com");
		pass = driver.findElement(By.xpath("//input[@data-qa=\"login-password\"]"));
		pass.sendKeys("pratik@123");
		login = driver.findElement(By.xpath("//button[@data-qa=\"login-button\"]"));
		login.click();
		err =  driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/form/p"));
		Assert.assertEquals(err.getText(), "Your email or password is incorrect!");
		
	}
	
	public void logOutUser() {
		signup_loginbtn.click();
		loginToUrAcc = driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/h2"));
		String actualResult = loginToUrAcc.getText();
		Assert.assertEquals(actualResult, "Login to your account");
		email = driver.findElement(By.xpath("//input[@data-qa=\"login-email\"]"));
		email.sendKeys("logout@gmail.com");
		pass = driver.findElement(By.xpath("//input[@data-qa=\"login-password\"]"));
		pass.sendKeys("pratik@123");
		login = driver.findElement(By.xpath("//button[@data-qa=\"login-button\"]"));
		login.click();
		WebElement loggedInAsUname = driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[10]/a"));
		Assert.assertEquals(loggedInAsUname.getText().trim(), "Logged in as " + "logout");
		System.out.println("Logged in as username' is visible");
		logoutbtn = driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[4]/a"));
		logoutbtn.click();
		Assert.assertEquals(driver.getCurrentUrl(), "https://automationexercise.com/login");
		System.out.println("user is navigated to login page");
	}
}
