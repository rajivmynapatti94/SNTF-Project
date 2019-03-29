package com.sntf.screens;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import com.sntf.driver.SharedBrowser;

public class Cart_Screen extends SharedBrowser {
	
	WebDriver driver;

	public Cart_Screen(WebDriver ldriver)
	{
	this.driver=ldriver;
	}
	
	@FindBy(css=".cartLogo > a") 
	@CacheLookup
	WebElement SNTFHomeLink;
	
	@FindBy(id="#back_to_product_list")
	@CacheLookup
	WebElement ContinueShoppingButton;
	
	@FindBy(css = ".text-right > b.cartTotal")
	@CacheLookup
	WebElement CartSubTotalCount;

	@FindBy(css = ".send-as-gift")
	@CacheLookup
	WebElement SendAsGiftCheckBox ;
	
	@FindBy(css = "#anonymous")
	@CacheLookup
	WebElement AnonymousCheckbox ;
	
	@FindBy(css = "#sticky-wrap > div > div > a")
	@CacheLookup
	WebElement UpdateCartLink;
	
	//SignIn as a User
	@FindBy(css = ".btn.orangeBtn.checkout-btn")
	@CacheLookup
	WebElement SignInToCheckout;
	
	@FindBy(css = "form#ajaxlogin > div:nth-child(2) > input#emailForm")
	@CacheLookup
	WebElement emailTextField;
	
	@FindBy(css = "form#ajaxlogin > div:nth-child(3) > input#password")
	@CacheLookup
	WebElement passwordTextField;
	
	@FindBy(css = "form#ajaxlogin > button")
	@CacheLookup
	WebElement signINButton;
	
	
	//SignUP as Guest User
	@FindBy(css = ".btn-box > a:nth-last-child(1)")
	@CacheLookup
	WebElement CheckoutAsGuestButton;
	
	//WebdriverWait for the GuestcheckoutPopup for registration
	@FindBy(css = "#guestregister_modal > div > div > .login-wrapper > .login-main.signupBox")
	@CacheLookup
	WebElement guestCheckoutPOPUP;
	
	@FindBy(css = "#guestregister_modal > div > div > .login-wrapper > .login-main.signupBox > form > div > #name")
	@CacheLookup
	WebElement GuestName;
	
	@FindBy(css = "#guestregister_modal > div > div > .login-wrapper > .login-main.signupBox > form > div > #last_name")
	@CacheLookup
	WebElement GuestLastName ;
	
	@FindBy(css = "#guestregister_modal > div > div > .login-wrapper > .login-main.signupBox > form > div > #email")
	@CacheLookup
	WebElement GuestEmailId;
	
	@FindBy(css = "#guestregister_modal > div > div > .login-wrapper > .login-main.signupBox > form > div > #contact_number" )
	@CacheLookup
	WebElement GuestContactNumber;
	
	
	@FindBy(css = "#guestregister_modal > div > div > .login-wrapper > .login-main.signupBox > form > button")
	@CacheLookup
	WebElement GuestContinueButton;
	
	
	
}
