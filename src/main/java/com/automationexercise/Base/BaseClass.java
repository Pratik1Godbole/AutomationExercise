package com.automationexercise.Base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.automationexercise.utils.utils;



public class BaseClass {
	public static WebDriver driver;
	public  static Properties prop;
	public WebDriverWait wait;
	public BaseClass() {

		try {
			prop = new Properties();
			FileInputStream ip= new FileInputStream("C:\\Users\\prati\\OneDrive\\Desktop\\Java Projects\\AutomationExercise\\src\\main\\java\\com\\automationexercise\\config\\config.properties"); 
			prop.load(ip);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@BeforeMethod
	public void setUp() {

		System.out.println("Launching chrome browser");
		ChromeOptions options = new ChromeOptions();
		options.addExtensions(new File("C:\\Users\\prati\\OneDrive\\Desktop\\Java Projects\\AutomationExercise\\Files\\AdBlock-—-best-ad-blocker.crx")); 
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(ChromeOptions.CAPABILITY, options);
//		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("disablePopupBlocking", true);
		options.addArguments("--disable-save-password-bubble");
		options.merge(capabilities);
		driver = new ChromeDriver(options);
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(utils.PAGE_LOAD_TIMEOUT,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(utils.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));

		String mainWindowHandle = driver.getWindowHandle();
		driver.switchTo().window(mainWindowHandle);

		wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		wait.until(ExpectedConditions.titleIs("Automation Exercise"));
		driver.navigate().refresh();
		driver.navigate().refresh();
		String expectedTitle = "Automation Exercise";
		Assert.assertEquals(driver.getTitle(), expectedTitle);
		System.out.println("Home Page is Visible. ");



	}



//		@AfterMethod
//		public void tearDown() {
//			// Close the WebDriver instance
//			if (driver != null) {
//				driver.quit();
//			}
//		}
}




