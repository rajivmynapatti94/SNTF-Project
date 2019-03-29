package com.sntf.screens;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class ContactUsScreen {
	WebDriver driver;

	public ContactUsScreen(WebDriver ldriver)
	{
	this.driver=ldriver;
	}
	
	@FindBy(id="name") 
	@CacheLookup
	WebElement Contact_UserName;
	
	@FindBy(id="email") 
	@CacheLookup
	WebElement Contact_Emailid;
	
	@FindBy(id="comment") 
	@CacheLookup
	WebElement Contact_Message_box;
	
	@FindBy(css="button.btn.btn-default") 
	@CacheLookup
	WebElement SendButton;
	
	public void ContactUsform(String uid,String pass, String message) throws AWTException, InterruptedException
	{
		Contact_UserName.sendKeys(uid);
		Contact_Emailid.sendKeys(pass);
		Contact_Message_box.sendKeys(message);
		
		try {
		Robot Rob = new Robot();
		Rob.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(2000);
		Rob.keyPress(KeyEvent.VK_ENTER);}
		catch(Exception e){	
			
			System.out.println("Captcha not checked");
		}
		
		Thread.sleep(3000);
		SendButton.click();
	}

}
