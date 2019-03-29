package com.sntf.driver;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class SharedProperties {
	
	private String BrowserName;
	 private String FrontUrl;
	 private String AdminUrl;
	 private String FrontUser;
	 private String FrontUserPassword;
	 private String AdminUser;
	 private String AdminUserPassword;
	 private String ContactUsmessage;
	 private String Contactuser;
	 private String Contactemail;
	 private String ContactUsLink;
	 private String websitepropertyfile = "Website.properties";
	
	public SharedProperties() {getLocalPropertiesFile();}

    public void getLocalPropertiesFile () {
        try {
            FileInputStream fileInput = new FileInputStream(new File(websitepropertyfile));
            Properties prop = new Properties();
            prop.load(fileInput);

            //Get properties from local properties file
            BrowserName = prop.getProperty("browser");
            FrontUrl = prop.getProperty("FrontUrl");
            AdminUrl = prop.getProperty("AdminUrl");
            FrontUser = prop.getProperty("FrontUser");
            FrontUserPassword = prop.getProperty("FrontPassword");
            AdminUser = prop.getProperty("AdminUser");
            AdminUserPassword = prop.getProperty("AdminPassword");
            ContactUsmessage = prop.getProperty("contactUsMessage");
            Contactuser= prop.getProperty("Contactusername");
            Contactemail = prop.getProperty("Contactuseremail");
            ContactUsLink = prop.getProperty("Contactuslink");
            
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getbrowserName() {return BrowserName;}
    public String getfronturl() {return FrontUrl;}
    public String getadminurl() {return AdminUrl;}
    public String getUserName() {return FrontUser;}
    public String getUserPassword() {return FrontUserPassword;}
    public String getAdminUserName() {return AdminUser;}
    public String getAdminUserPassword() {return AdminUserPassword;}
    public String getContactmessage() {return ContactUsmessage;}
    public String getContactusername() {return Contactuser;}
    public String getContactuseremail() {return Contactemail; }
    public String getContactUsLink() {return ContactUsLink;}

  
}
