package com.sntf.steps;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.sntf.driver.SharedBrowser;
import com.sntf.driver.SharedProperties;
import com.sntf.screens.Front_WaitlistScreen;

public class Waitlist_steps {
	static SharedProperties properties = new SharedProperties();
	
	WebDriver driver;
		
			@BeforeMethod
			public void Openbrowser_and_hit_url() throws IOException
			{
				driver=SharedBrowser.Browser(properties.getfronturl()+"get-listed");
			}

			@AfterMethod
			public void tearDown()
			{
				driver.quit();
			}

			@Test
			public void ValidationChecker() throws IOException, InterruptedException
			{
				Front_WaitlistScreen waitlist=PageFactory.initElements(driver, Front_WaitlistScreen.class);
	 
				// Call the method
				waitlist.checkValidationWithBlankData();
		
			}

}
