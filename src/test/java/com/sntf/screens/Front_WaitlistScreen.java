package com.sntf.screens;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.sntf.driver.SharedBrowser;

public class Front_WaitlistScreen extends SharedBrowser {

	WebDriver driver;

	public Front_WaitlistScreen(WebDriver ldriver)
	{
	this.driver=ldriver;
	}
	
	@FindBy(id="name") 
	@CacheLookup
	WebElement Name;
	
	@FindBy(css="label[for='name'][class='error']")
	@CacheLookup
	WebElement errorForName;
	
	@FindBy(id="email") 
	@CacheLookup
	WebElement Email;
	
	@FindBy(css="label[for='email'][class='error']")
	@CacheLookup
	WebElement errorForEmail;
	
	@FindBy(id="contact_number") 
	@CacheLookup
	WebElement phoneNumber;
	
	@FindBy(css="label[for='contact_number'][class='error']")
	@CacheLookup
	WebElement errorForContactNumber;
	
	@FindBy(id="organization_name") 
	@CacheLookup
	WebElement organizationName;
	
	@FindBy(xpath="//*[contains(text(),'Submit')]") 
	@CacheLookup
	WebElement submitButton;
	
	@FindBy(xpath="//*[contains(text(),'Back to Home')]")
	@CacheLookup
	WebElement backToHomeButton;
	
	public void checkValidationWithBlankData() {
		System.out.println(driver.getTitle());
		submitButton.click();
		
		String error1 = errorForName.getText();
		String actual1 = "Name is required.";
		
		String error2 = errorForEmail.getText();
		String actual2 = "Email is required.";
		
		String error3 = errorForContactNumber.getText();
		String actual3 = "Phone Number is required.";
		
		Assert.assertEquals(actual1, error1);
		Assert.assertEquals(actual2, error2);
		Assert.assertEquals(actual3, error3);
		}
	

}
