package com.sntf.driver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;
import com.sntf.driver.SharedProperties;

public class SharedBrowser{  

	public static WebDriver driver;
	
	static SharedProperties properties = new SharedProperties();
	

	public static WebDriver Browser(String URL) throws IOException {

		if(properties.getbrowserName().equalsIgnoreCase("Chrome")) {
			/*driver = new ChromeDriver();
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/chromedriver");*/
			
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if(properties.getbrowserName().equalsIgnoreCase("Firefox")){
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		else if(properties.getbrowserName().equalsIgnoreCase("IE")) {
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
		}
		
		driver.get(URL);
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		return driver;
}
	
	public static void singleOptionSelectionDropdownHandle(String Elementid , String SearchedData) {
		 Select dropdown = new Select(driver.findElement(By.cssSelector(Elementid)));

		    //Get all options
		    List<WebElement> dd = dropdown.getOptions();

		    //Get the length
		    System.out.println("Total count of Campaigns in the dropdown are "+dd.size());

		    // Loop to print one by one
		    for (int j = 0; j < dd.size(); j++) {
		       // System.out.println(dd.get(j).getText());
		        
		        if(dd.get(j).getText().equalsIgnoreCase(SearchedData)) {
		        	dd.get(j).click();
		        }

		    }
	}
	
	public static void globalSearchAndClickOnResult(String SearchedText , String textToSelect) throws InterruptedException {
		
		WebElement autoOptions= driver.findElement(By.cssSelector("#global_search_input"));
		autoOptions.sendKeys(SearchedText);
		Thread.sleep(2000);
		
		WebElement searchResult = (new WebDriverWait(driver, 10))
				  .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#searchResult")));

		List<WebElement> optionsToSelect = driver.findElements(By.cssSelector("#searchResult > div > div > ul > li > a"));
		 
		
		int flag = 0;
		for(int i=0 ; i<optionsToSelect.size(); i++){
		    System.out.println(optionsToSelect.get(i).getText());
		    
		    if(optionsToSelect.get(i).getText().contains(textToSelect)) {
		        System.out.println("Trying to select: "+textToSelect);
		        optionsToSelect.get(i).click();
	
		        flag = 1;
		    break;
		}
		    
		    
	}
		if(flag == 0) {
		    System.out.println("Searched Result not found and clicking on very first searched result in Products Listing");
		    driver.findElement(By.cssSelector("#searchResult > .SearchOptioncampaign > ul > li:nth-child(1) > a")).click();
		    }
		

	}
	
	public static void removeItemsInCart () {
		
		WebElement ProductInCart = (new WebDriverWait(driver, 10))
				  .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.productInCartWrap.cart-body")));
		
		Actions actions = new Actions(driver);
		
		List<WebElement> Products = driver.findElements(By.cssSelector(".relativeBox > .boxWrap > div.productInCartWrap.cart-body > div"));
		System.out.println( "Total count of items in Cart are "+Products.size());
		
		int CartItemsize= Products.size();
		
		WebElement RemoveProducts=	driver.findElement(By.cssSelector(".relativeBox > .boxWrap > div.productInCartWrap.cart-body > div > div > div.proImg > div"));

		for(int i=0 ; i<Products.size(); i++){
			
			if(CartItemsize >0) {
				actions.moveToElement(RemoveProducts).perform();
				
				RemoveProducts.click();
				Alert simpleAlert = driver.switchTo().alert();
				simpleAlert.accept();
				CartItemsize--;
				
				
		//System.out.println("After removing the items is "+CartItemsize);
		
		}
			else {
				System.out.println("Your cart is Empty");
			}
		
		}
		System.out.println("All Items from the cart removed successfully");

		
	}
	
	public static void capture(String testCaseName, WebDriver driver) {
		    // Cast driver object to TakesScreenshot
		    TakesScreenshot screenshot = (TakesScreenshot) driver;
		    // Get the screenshot as an image File
		    File src = screenshot.getScreenshotAs(OutputType.FILE);
		    try {
		      // Specify the destination where the image will be saved
		      File dest = new File(System.getProperty("user.dir")+"/target/Screenshots/" + testCaseName + "_" + timestamp() + ".png");
		      // Copy the screenshot to destination
		      FileUtils.copyFile(src, dest);
		    } catch (IOException ex) {
		      System.out.println(ex.getMessage());
		    }
		  }
	
	public static String timestamp() {
		    // Timestamp to make each screenshot name unique
		    return new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new Date());
		  }

}

