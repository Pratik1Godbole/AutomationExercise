package com.automationexercise.Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.automationexercise.Base.BaseClass;
import com.automationexercise.utils.utils;

public class SignUpPage extends BaseClass {
	Select sel;
	WebElement signup_loginbtn;
	WebElement newUserSignUp;
	WebElement name;
	WebElement Email;
	WebElement Signup;
	WebElement enterAccInfo;
	WebElement title;
	WebElement pass;
	WebElement day;
	WebElement month;
	WebElement year;
	WebElement newsLetter;
	WebElement optns;
	WebElement fName;
	WebElement lName;
	WebElement company;
	WebElement Add;
	WebElement Add2;
	WebElement country; 
	WebElement state;
	WebElement city;
	WebElement zipcode;
	WebElement mobNo;
	WebElement createAcc;
	WebElement accCreated;
	WebElement cont;
	WebElement errMsg;





	public SignUpPage() {
		

	}

	public void signUp() {
		clickOnsignup_loginbtn(); 
		clickOnsignup_loginbtn();
		newUserSignUp = driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/h2"));
		String actualResult = newUserSignUp.getText();
		Assert.assertEquals(actualResult, "New User Signup!");
		System.out.println(" 'New User Signup!' is visible");
		name = driver.findElement(By.xpath("//input[@data-qa=\"signup-name\"]"));
		String Name = "pratik";
		name.sendKeys(Name);
		Email = driver.findElement(By.xpath("//input[@data-qa='signup-email']"));
		Email.sendKeys("abcdefz@gmail.com");
		Signup = driver.findElement(By.xpath("//div[@class=\"signup-form\"]//form//button"));
		Signup.click();
		enterAccInfo = driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div/div/h2"));
		Assert.assertEquals(enterAccInfo.getText(), "ENTER ACCOUNT INFORMATION");
		System.out.println("'ENTER ACCOUNT INFORMATION' is visible.");
		title =  driver.findElement(By.id("uniform-id_gender1"));
		title.click();
		pass = driver.findElement(By.id("password"));
		pass.sendKeys("pratik@123");
		day = driver.findElement(By.id("days"));
		sel = new Select(day);
		sel.selectByVisibleText("21");

		month = driver.findElement(By.id("months"));
		sel = new Select(month);
		sel.selectByVisibleText("June");

		year = driver.findElement(By.id("years"));
		sel = new Select(year);
		sel.selectByVisibleText("1965");

		newsLetter =driver.findElement(By.id("newsletter"));
		newsLetter.click();

		optns = driver.findElement(By.id("optin"));
		optns.click();

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,450)", "");

		fName = utils.waitForElementPresent(driver, By.id("first_name"), Duration.ofSeconds(1));
		fName.sendKeys("Pratik");
		lName= utils.waitForElementPresent(driver, By.id("last_name"), Duration.ofSeconds(1));
		lName.sendKeys("Godbole");
		company = utils.waitForElementPresent(driver, By.id("company"), Duration.ofSeconds(1));
		company.sendKeys("excelr");

		js.executeScript("window.scrollBy(0,450)", "");

		Add = utils.waitForElementPresent(driver, By.id("address1"), Duration.ofSeconds(1));
		Add.sendKeys("teen petrol pump");
		Add2 = utils.waitForElementPresent(driver, By.id("address2"), Duration.ofSeconds(1));
		Add2.sendKeys("Thane");

		js.executeScript("window.scrollBy(0,450)", "");

		country = utils.waitForElementPresent(driver, By.id("country"), Duration.ofSeconds(1));
		sel = new Select(country);
		sel.selectByVisibleText("India");
		state = utils.waitForElementPresent(driver, By.id("state"), Duration.ofSeconds(1));
		state.sendKeys("Maharashtra");

		city = utils.waitForElementPresent(driver, By.id("city"), Duration.ofSeconds(1));
		city.sendKeys("Vasind");
		js.executeScript("window.scrollBy(0,450)", "");
		
		zipcode = utils.waitForElementPresent(driver, By.id("zipcode"), Duration.ofSeconds(1));
		zipcode.sendKeys("421601");
		mobNo = utils.waitForElementPresent(driver, By.id("mobile_number"), Duration.ofSeconds(1));
		mobNo.sendKeys("9999999999");
		createAcc = utils.waitForElementPresent(driver,By.xpath("//*[@id=\"form\"]/div/div/div/div/form/button") , Duration.ofSeconds(10));
		createAcc.click();
		accCreated = driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div/h2/b"));
		Assert.assertEquals(accCreated.getText(), "ACCOUNT CREATED!");
		System.out.println("Account created is visible");
		cont= driver.findElement(By.xpath("//a[@data-qa=\"continue-button\"]"));
		cont.click();
		WebElement loggedInAsUname = driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[10]/a"));
//		Assert.assertEquals(loggedInAsUname.getText(), " Logged in as " + Name );
		Assert.assertEquals(loggedInAsUname.getText().trim(), "Logged in as " + Name);
		
		


	}
	
	public void regWthExistingUser() {
		clickOnsignup_loginbtn();
		newUserSignUp = driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/h2"));
		String actualResult = newUserSignUp.getText();
		Assert.assertEquals(actualResult, "New User Signup!");
		System.out.println(" 'New User Signup!' is visible");
		name = driver.findElement(By.xpath("//input[@data-qa=\"signup-name\"]"));
		String Name = "logout";
		name.sendKeys(Name);
		Email = driver.findElement(By.xpath("//input[@data-qa='signup-email']"));
		Email.sendKeys("logout@gmail.com");
		Signup = driver.findElement(By.xpath("//div[@class=\"signup-form\"]//form//button"));
		Signup.click();
		errMsg = driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/form/p"));
		Assert.assertEquals(errMsg.getText(), "Email Address already exist!");
		System.out.println("'Email Address already exist!' is visible");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.alert = function() {};"); // Disable alert popups

	}
	
	public void deleteAcc() {
		WebElement delAccbtn = driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[5]/a"));
		delAccbtn.click();

		WebElement accDltd = driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div/h2/b"));
		Assert.assertEquals(accDltd.getText(), "ACCOUNT DELETED!");
		System.out.println(" 'ACCOUNT DELETED!' is visible");
	}
	
	public void clickOnsignup_loginbtn() {
		signup_loginbtn = driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[4]/a"));
		signup_loginbtn.click();
	}
	
	public void clickOncont() {
		WebElement cont =  driver.findElement(By.xpath("//a[@data-qa=\"continue-button\"]"));
		cont.click();
	}

}
