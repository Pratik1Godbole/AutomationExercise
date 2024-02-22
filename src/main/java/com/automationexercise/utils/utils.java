/**
 * 
 */
package com.automationexercise.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.automationexercise.config.Constants;

/**
 * 
 */
public class utils {

	Constants con;
	static Properties props;




	public static  WebElement waitForClickableElement(WebDriver driver, By locator, Duration timeoutInSeconds) {
		WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
		return wait.until(ExpectedConditions.elementToBeClickable(locator));

	}	

	static{
		try {
			props = new Properties();
			FileInputStream ip= new FileInputStream("C:\\Users\\prati\\OneDrive\\Desktop\\Java Projects\\AutomationExercise\\src\\main\\java\\com\\automationexercise\\config\\payment.properties"); 
			props.load(ip);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}


	public static  WebDriver driver;
	public static long PAGE_LOAD_TIMEOUT = 30;
	public static long IMPLICIT_WAIT =20;
	//	public static WebElement addToCartButton = driver.findElement(By.id("add-to-cart-sauce-labs-backpack"));


	public static void scrollBy(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,450)", "");
	}
	public static void logOut(WebDriver driver) {
		WebElement burgerMenu = driver.findElement(By.id("react-burger-menu-btn"));
		burgerMenu.click();
		WebElement logout = driver.findElement(By.id("logout_sidebar_link"));
		logout.click();
		driver.manage().deleteAllCookies();
	}

	public static void clickElement(WebDriver driver, By locator) {
		try {
			WebElement element = driver.findElement(locator);
			element.click();
		} catch (Exception e) {
			// Add logging or error handling as needed
			e.printStackTrace();
		}
	}

	// Method for entering text into a text field
	public static void enterText(WebDriver driver, By locator, String text) {
		WebElement element = driver.findElement(locator);
		element.clear();
		element.sendKeys(text);
	}

	// Method for getting text from an element
	public static String getText(WebDriver driver, By locator) {
		WebElement element = driver.findElement(locator);
		return element.getText();
	}

	// Method for navigating to a URL
	public static void navigateToURL(WebDriver driver, String url) {
		driver.navigate().to(url);
	}

	// Method for waiting for an element to be present
	//    public static void waitForElementPresent(WebDriver driver, By locator, int timeoutInSeconds) {
	//        // Implementation of wait logic using WebDriverWait
	//        // This is just a basic example, you might want to use WebDriverWait with ExpectedConditions
	//    }

	public static WebElement waitForElementPresent(WebDriver driver, By locator, Duration timeoutInSeconds) {
		WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}



	//########## Method to Select data from Excel Sheet #########//
	public static Object[][] getDatafromExcelsheet(String sheetname) throws IOException
	{
		File excelfile = new File(System.getProperty("user.dir")+"//src//test//java//resources//TestData//ExcelData.xlsx");
		//XSSFWorkbook workbook = null;

		FileInputStream fisSheet = new FileInputStream(excelfile);

		XSSFWorkbook workbook = new XSSFWorkbook(fisSheet);

		/*try
  		{
  			FileInputStream fisSheet = new FileInputStream(excelfile);
  			workbook = new XSSFWorkbook(fisSheet);
  		}
  		catch (Throwable e)
  		{
  			e.printStackTrace();
  		}*/


		XSSFSheet sheet = workbook.getSheet(sheetname);

		int rows = sheet.getLastRowNum();
		int columns = sheet.getRow(0).getLastCellNum();

		Object[][] data = new Object[rows][columns];

		for(int i=0; i<rows;i++)
		{
			XSSFRow row= sheet.getRow(i+1); // Read the data from second row while skipping header

			for(int j=0; j<columns; j++)
			{
				XSSFCell cell=row.getCell(j);
				CellType celltype = cell.getCellType();

				switch(celltype) {

				case STRING:
					data[i][j] = cell.getStringCellValue();
					System.out.println("Cell value:"+data[i][j]);
					break;
				case NUMERIC:
					data[i][j] = Integer.toString((int)cell.getNumericCellValue());
					break;
				case BOOLEAN:
					data[i][j] = cell.getBooleanCellValue();
					break;
				default:
					System.out.println("No cell data found");
					break;
				}

			}
		}

		return data;
	}





	public static void refresh() {
		driver.navigate().refresh();
	}


	public static void waitForElementToDisappear(WebDriver driver, String elementId, Duration timeoutInSeconds) {
		WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id(elementId)));
	}

	public static boolean isElementPresent(By locator) {
		try {
			try {
				driver.findElement(locator);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	public static void addToCart(WebDriver driver) {
		WebElement cartbtn = driver.findElement(By.xpath("//ul[@class=\"nav navbar-nav\"]//a[@href=\"/view_cart\"][1]"));
		cartbtn.click();
		Assert.assertEquals(driver.getCurrentUrl(), "https://automationexercise.com/view_cart");
		System.out.println("cart page is displayed");
	}

	public static void payment(WebDriver driver) {

		WebElement NameOnCard = driver.findElement(By.xpath("//input[@data-qa='name-on-card']"));
		NameOnCard.sendKeys(props.getProperty("NameOnCard"));
		WebElement CardNumber = driver.findElement(By.xpath("//input[@data-qa='card-number']"));
		CardNumber.sendKeys(props.getProperty("CardNumber"));
		WebElement CVC = driver.findElement(By.xpath("//input[@data-qa='cvc']"));
		CVC.sendKeys(props.getProperty("CVV"));
		WebElement Expiration = driver.findElement(By.xpath("//input[@data-qa='expiry-month']"));
		Expiration.sendKeys(props.getProperty("MONTH"));
		WebElement year = driver.findElement(By.xpath("//input[@data-qa='expiry-year']"));
		year.sendKeys(props.getProperty("YEAR"));

		WebElement PayAndConfirmOrder = driver.findElement(By.id("submit"));
		PayAndConfirmOrder.click();
		
		driver.navigate().back();
		

		
		try {
			// Find the success message element using XPath
			WebElement successMessage = driver.findElement(By.xpath("//div[@id='success_message']//div"));

			// Get the text of the success message
			String messageText = successMessage.getText();
			System.out.println("Success Message: " + messageText);

			//		System.out.println(sucMsg.getText());
			//		WebElement sucMsg = utils.waitForElementPresent(driver,By.xpath("//div[@id='success_message']") , Duration.ofSeconds(20));
					Assert.assertEquals(messageText, "Your order has been placed successfully!");
		}catch(Exception e) {
			e.printStackTrace();
		}

	}
}