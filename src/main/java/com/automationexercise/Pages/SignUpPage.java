package com.automationexercise.Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.automationexercise.Base.BaseClass;
import com.automationexercise.utils.utils;

public class SignUpPage extends BaseClass {
	Select sel;
	
	
	@FindBy(xpath = "//*[@id='header']/div/div/div/div[2]/div/ul/li[4]/a")
	private WebElement signup_loginbtn;
	
	@FindBy(xpath = "//*[@id='form']/div/div/div[3]/div/h2")
	private WebElement newUserSignUp;
	
	@FindBy(xpath = "//input[@data-qa='signup-name']")
	private WebElement name;
	
	@FindBy(xpath = "//input[@data-qa='signup-email']")
	private WebElement Email;
	
	@FindBy(xpath = "//div[@class='signup-form']//form//button")
	private WebElement Signup;
	
	@FindBy(xpath = "//*[@id='form']/div/div/div/div/h2")
	private WebElement enterAccInfo;
	
	@FindBy(id = "uniform-id_gender1")
	private WebElement title;
	
	@FindBy(id = "password")
	private WebElement pass;
	
	@FindBy(id = "days")
	private WebElement day;
	
	@FindBy(id = "months")
	private WebElement month;
	
	@FindBy(id = "years")
	private WebElement year;
	
	@FindBy(id = "newsletter")
	private WebElement newsLetter;
	
	@FindBy(id = "optin")
	private WebElement optns;
	
	@FindBy(id = "first_name")
	private WebElement fName;
	
	@FindBy(id = "last_name")
	private WebElement lName;
	
	@FindBy(id = "company")
	private WebElement company;
	
	@FindBy(id = "address1")
	private WebElement Add;
	
	@FindBy(id = "address2")
	private WebElement Add2;
	
	@FindBy(id = "country")
	private WebElement country; 
	
	@FindBy(id = "state")
	private WebElement state;
	
	@FindBy(id = "city")
	private WebElement city;
	
	@FindBy(id = "zipcode")
	private WebElement zipcode;
	
	@FindBy(id = "mobile_number")
	private WebElement mobNo;
	
	@FindBy(xpath = "//*[@id='form']/div/div/div/div/form/button")
	private WebElement createAcc;
	
	@FindBy(xpath = "//*[@id='form']/div/div/div/h2/b")
	private WebElement accCreated;
	
	@FindBy(xpath = "//a[@data-qa='continue-button']")
	private WebElement cont;
	
	@FindBy(xpath = "//*[@id='form']/div/div/div[3]/div/form/p")
	private WebElement errMsg;

	@FindBy(xpath = "//*[@id='header']/div/div/div/div[2]/div/ul/li[10]/a")
	private WebElement loggedInAsUname;
	@FindBy(xpath = "//*[@id='header']/div/div/div/div[2]/div/ul/li[5]/a")
	private WebElement delAccbtn;
	
	@FindBy(xpath = "//*[@id='form']/div/div/div/h2/b")
	private WebElement accDltd ;

	public SignUpPage() {
		
		PageFactory.initElements(driver, this);
	}

	public void signUp() {
		clickOnsignup_loginbtn(); 
		clickOnsignup_loginbtn();
		String actualResult = newUserSignUp.getText();
		Assert.assertEquals(actualResult, "New User Signup!");
		System.out.println(" 'New User Signup!' is visible");
	
		String Name = "pratik";
		name.sendKeys(Name);
		
		Email.sendKeys("abcdefz@gmail.com");
		
		Signup.click();
		
		Assert.assertEquals(enterAccInfo.getText(), "ENTER ACCOUNT INFORMATION");
		System.out.println("'ENTER ACCOUNT INFORMATION' is visible.");
		
		title.click();
		pass.sendKeys("pratik@123");
		sel = new Select(day);
		sel.selectByVisibleText("21");
		sel = new Select(month);
		sel.selectByVisibleText("June");
		sel = new Select(year);
		sel.selectByVisibleText("1965");
		newsLetter.click();

		
		optns.click();

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,450)", "");

		utils.waitForElementPresent(driver, fName, Duration.ofSeconds(1));
		fName.sendKeys("Pratik");
		lName= utils.waitForElementPresent(driver, lName, Duration.ofSeconds(1));
		lName.sendKeys("Godbole");
		company = utils.waitForElementPresent(driver, company, Duration.ofSeconds(1));
		company.sendKeys("excelr");

		js.executeScript("window.scrollBy(0,450)", "");

		Add = utils.waitForElementPresent(driver, Add, Duration.ofSeconds(1));
		Add.sendKeys("teen petrol pump");
		Add2 = utils.waitForElementPresent(driver, Add2, Duration.ofSeconds(1));
		Add2.sendKeys("Thane");

		js.executeScript("window.scrollBy(0,450)", "");

		country = utils.waitForElementPresent(driver, country, Duration.ofSeconds(1));
		sel = new Select(country);
		sel.selectByVisibleText("India");
		state = utils.waitForElementPresent(driver, state, Duration.ofSeconds(1));
		state.sendKeys("Maharashtra");

		city = utils.waitForElementPresent(driver, city, Duration.ofSeconds(1));
		city.sendKeys("Vasind");
		js.executeScript("window.scrollBy(0,450)", "");
		
		zipcode = utils.waitForElementPresent(driver, zipcode, Duration.ofSeconds(1));
		zipcode.sendKeys("421601");
		mobNo = utils.waitForElementPresent(driver, mobNo, Duration.ofSeconds(1));
		mobNo.sendKeys("9999999999");
		createAcc = utils.waitForElementPresent(driver, createAcc, Duration.ofSeconds(10));
		createAcc.click();
		
		Assert.assertEquals(accCreated.getText(), "ACCOUNT CREATED!");
		System.out.println("Account created is visible");
		
		cont.click();

		Assert.assertEquals(loggedInAsUname.getText().trim(), "Logged in as " + Name);
		
		


	}
	
	public void regWthExistingUser() {
		clickOnsignup_loginbtn();
		String actualResult = newUserSignUp.getText();
		Assert.assertEquals(actualResult, "New User Signup!");
		System.out.println(" 'New User Signup!' is visible");
		String Name = "logout";
		name.sendKeys(Name);
		Email.sendKeys("logout@gmail.com");
		Signup.click();
		Assert.assertEquals(errMsg.getText(), "Email Address already exist!");
		System.out.println("'Email Address already exist!' is visible");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.alert = function() {};"); // Disable alert popups

	}
	
	public void deleteAcc() {
//		WebElement delAccbtn = driver.findElement(By.xpath(""));
		delAccbtn.click();
		Assert.assertEquals(accDltd.getText(), "ACCOUNT DELETED!");
		System.out.println(" 'ACCOUNT DELETED!' is visible");	
	}
	
	public void clickOnsignup_loginbtn() {
		signup_loginbtn.click();
	}
	
	public void clickOncont() {
		cont.click();
	}

}
