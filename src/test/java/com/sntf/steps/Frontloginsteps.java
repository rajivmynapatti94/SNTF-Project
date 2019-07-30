package com.sntf.steps;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.sntf.driver.SharedBrowser;
import com.sntf.driver.SharedProperties;
import com.sntf.screens.FrontloginScreen;

public class Frontloginsteps extends SharedBrowser {

static SharedProperties properties = new SharedProperties();

	
		@BeforeMethod
		public void Openbrowser_and_hit_url() throws IOException
		{
			Browser(properties.getfronturl()+"login");
		}

		@AfterMethod
		public void tearDown()
		{
			driver.quit();
		}
	
	
		@Test(priority=4)
		public void ValidUser() throws IOException
		{
			FrontloginScreen loginpage=PageFactory.initElements(driver, FrontloginScreen.class);
 
			// Call the method
			loginpage.valid_login_sntf(properties.getUserName(), properties.getUserPassword());
		}
	
		@Test(priority=3)
		public void invalid_Username()
		{
			FrontloginScreen loginpage=PageFactory.initElements(driver, FrontloginScreen.class);
			loginpage.invalid_username_login_sntf();
		}
	
		@Test(priority=2)
		public void invalid_Password()
		{
			FrontloginScreen loginpage=PageFactory.initElements(driver, FrontloginScreen.class);
			loginpage.invalid_password_login_sntf();
		}
	
		@Test(priority=1)
		public void empty_Credentials_Login()
		{
			FrontloginScreen loginpage=PageFactory.initElements(driver, FrontloginScreen.class);
			loginpage.empty_login_sntf();
		}

}
