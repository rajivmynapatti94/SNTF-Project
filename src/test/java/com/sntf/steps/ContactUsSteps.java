package com.sntf.steps;

import java.awt.AWTException;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.sntf.driver.SharedBrowser;
import com.sntf.driver.SharedProperties;
import com.sntf.screens.ContactUsScreen;

public class ContactUsSteps extends SharedBrowser{
	static SharedProperties properties = new SharedProperties();
	
	@Test
	
	public void Contactform() throws AWTException, InterruptedException, IOException {
		
	Browser(properties.getfronturl()+"contactus");
		
		
		ContactUsScreen contact = PageFactory.initElements(driver, ContactUsScreen.class);
		
		contact.ContactUsform(properties.getContactusername(), properties.getContactuseremail(), properties.getContactmessage());
		
	}

}
