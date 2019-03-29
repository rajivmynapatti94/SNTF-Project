package com.sntf.screens;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import com.sntf.driver.SharedBrowser;

public class HomePageScreen extends SharedBrowser {
	
	WebDriver driver;

	public HomePageScreen(WebDriver ldriver)
	{
	this.driver=ldriver;
	}
	
	@FindBy(css="span.search-toggle-btn") 
	@CacheLookup
	WebElement SearchIcon;
	
	@FindBy(css="a.navbar-brand.page-scroll") 
	@CacheLookup
	WebElement SNTFLogo;
	
	@FindBy(css="a#headerCampaign.dropdown-toggle")
	@CacheLookup
	WebElement AllCampaign;
	

}
