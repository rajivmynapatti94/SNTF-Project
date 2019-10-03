package com.sntf.steps;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.sntf.driver.SharedBrowser;

public class iris extends SharedBrowser {

	@Test
	public void header() throws IOException, InterruptedException {

		Browser("https://testponting7.studinow.com/#/university/login");

//		
//		
//		driver.findElement(By.cssSelector("span.custom-checkbox > label > span")).click();
//		Thread.sleep(2000);
		//Check box is not checked
		WebElement chBox = driver.findElement(By.cssSelector("input.ng-untouched.ng-valid.ng-pristine"));
		System.out.println("chBox is selected " + chBox.isSelected());
		
		Thread.sleep(2000);
		
		//Click on the checkbox
		driver.findElement(By.cssSelector("span.custom-checkbox > label > span")).click();
		Thread.sleep(2000);
		
		//After checkbox is checked, now get the status of the checkbox
		System.out.println("After clicked the status is " + driver.findElement(By.cssSelector("input.ng-untouched.ng-valid.ng-dirty")).isSelected());
		
		Thread.sleep(2000);
		
		//Again check the checkbox
		driver.findElement(By.cssSelector("span.custom-checkbox > label > span")).click();
		Thread.sleep(2000);
		
		//Now the status of the checkbox should be false
		System.out.println("After clicking again the status is " + driver.findElement(By.cssSelector("input.ng-untouched.ng-valid.ng-dirty")).isSelected());
		
		
		driver.quit();
		
		 
		
		

	}

}
