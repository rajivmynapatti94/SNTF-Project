package com.sntf.steps;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.sntf.driver.SharedBrowser;
import com.sntf.driver.SharedProperties;

public class Product_Purchase {

static SharedProperties properties = new SharedProperties();

public static String SelectProduct = "Hockey";
public static String SelectCampaign = "Black Arts";
public static String Emailid = "rajiv.mynapatti+88@indianic.com";
public static String Password = "indianic";
	
	WebDriver driver;
		
			@BeforeMethod
			public void Openbrowser_and_hit_url() throws IOException
			{
				driver=SharedBrowser.Browser(properties.getfronturl()+"products");
			}

			@AfterMethod
			public void tearDown()
			{
				driver.quit();
			}
			
			@Test
			public void Wipeup() throws InterruptedException {
			
				driver.findElement(By.cssSelector(".search-toggle-btn")).click();
				
				SharedBrowser.globalSearchAndClickOnResult("hockey", SelectProduct);
				
				SharedBrowser.capture("A_Product_Page", driver);

			//User will now navigate to Product Description Page
				WebElement prodDescription = (new WebDriverWait(driver, 10))
						  .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".botm-content")));
				
				driver.findElement(By.cssSelector(".botm-content > div:nth-child(3) > #pro_quentity")).click();
				
				//Cart pop up will appear and click on Checkout button
				WebElement cartPopUp = (new WebDriverWait(driver, 10))
						  .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".cartitemlist.cart-quote-list.open")));
				
				driver.findElement(By.cssSelector(".cartitemlist.cart-quote-list.open > div > a")).click();
			
				
				//User will redirect to cart page and selection of campaign
				WebElement campaignSelection = (new WebDriverWait(driver, 10))
						  .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[name='campaign_id']")));
				
				//Campaign select method for selection of particular campagin
				SharedBrowser.singleOptionSelectionDropdownHandle("[name='campaign_id']", SelectCampaign);
				
				SharedBrowser.capture("B_Add_Product_to_Cart", driver);
				
				Thread.sleep(2000);
				
				//Now click on sign in to checkout button and handle the bootstrap login form
				driver.findElement(By.cssSelector(".btn-box > a.btn.orangeBtn.checkout-btn")).click();
				
				WebElement loginPopUp = (new WebDriverWait(driver, 10))
						  .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".login-wrapper")));
				
				//Enter login credentials in bootstrap login form
				
				WebElement emailTextField = (new WebDriverWait(driver, 10))
						  .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("form#ajaxlogin > div:nth-child(2) > input#emailForm")));
				emailTextField.sendKeys(Emailid);
				
				WebElement passwordTextField = (new WebDriverWait(driver, 10))
						  .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("form#ajaxlogin > div:nth-child(3) > input#password")));
				passwordTextField.sendKeys(Password);
				
				driver.findElement(By.cssSelector("form#ajaxlogin > button")).click();
				
				Thread.sleep(2000);
				
				//Now to Remove the added products in the cart
				SharedBrowser.removeItemsInCart();	
				Thread.sleep(1000);
				SharedBrowser.capture("C_Empty_Cart_Page", driver);
				
				
				
			
				}

	}
