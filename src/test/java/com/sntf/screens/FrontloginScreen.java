package com.sntf.screens;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import com.sntf.driver.SharedBrowser;

public class FrontloginScreen extends SharedBrowser {
	

	WebDriver driver;

	public FrontloginScreen(WebDriver ldriver)
	{
	this.driver=ldriver;
	}
	
	@FindBy(id="emailLogin") 
	@CacheLookup
	WebElement username;
	
	@FindBy(id="passwordLogin")
	@CacheLookup
	WebElement password;
	
	@FindBy(css="button.btn.cmn-btn.btn-default.login")
	@CacheLookup
	WebElement SignIn;
	
	@FindBy(linkText="Forgot Password ?")
	@CacheLookup
	WebElement Forgotpasswordlink;
	
	@FindBy(css= "div.checkbox-group.m-t-20")
	@CacheLookup
	WebElement RememberMe;
	
	public void valid_login_sntf(String uid,String pass)
	{
	username.sendKeys(uid);
	password.sendKeys(pass);
	SignIn.click();
	}

	public void invalid_username_login_sntf()
	{
		username.sendKeys("rajiv@123.com");
		password.sendKeys("indianic");
		SignIn.click();
	}
	
	public void invalid_password_login_sntf()
	{
		username.sendKeys("rajiv.mynapatti@indianic.com");
		password.sendKeys("00000000");
		SignIn.click();
		
	}
	
	public void empty_login_sntf()
	{
		/*username.sendKeys("");
		password.sendKeys("");*/
		SignIn.click();
	}
	
}