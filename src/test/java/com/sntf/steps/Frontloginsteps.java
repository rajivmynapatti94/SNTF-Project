package com.sntf.steps;

import java.io.IOException;
import java.util.Base64;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.sntf.driver.SharedBrowser;
import com.sntf.driver.SharedProperties;
import com.sntf.screens.FrontloginScreen;

public class Frontloginsteps {

static SharedProperties properties = new SharedProperties();
	
WebDriver driver;
	
		@BeforeMethod
		public void Openbrowser_and_hit_url() throws IOException
		{
			driver=SharedBrowser.Browser(properties.getfronturl()+"login");
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
			
			String asB64 = Base64.getEncoder().encodeToString(properties.getUserPassword().getBytes("utf-8"));
			System.out.println("Encrypted password is "+asB64);
			
			byte[] asBytes = Base64.getDecoder().decode(asB64);
			System.out.println(new String(asBytes, "utf-8"));
			
			
	
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
			loginpage.invalid_password_login_sntf();;
		}
	
		@Test(priority=1)
		public void empty_Credentials_Login()
		{
			FrontloginScreen loginpage=PageFactory.initElements(driver, FrontloginScreen.class);
			loginpage.empty_login_sntf();
		}

}
