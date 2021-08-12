package com.app.ui;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AdminPage {
	
		final String siteURL = "http://localhost:8989/";
		final String driverPath = "driver/chromedriver.exe";
		WebDriver driver = null;

		@BeforeMethod
		public void beforeMethod() {
			System.setProperty("webdriver.chrome.driver", driverPath);
			driver = new ChromeDriver();
			driver.get(siteURL);
			driver.manage().window().maximize();
		}

		@AfterMethod
		public void afterMethod() {
			driver.close();
		}
		
		@Test
		public void validUserCredsTest() throws InterruptedException {
			WebDriverWait wait = new WebDriverWait(driver, 30);
			// actions
			driver.findElement(By.xpath("//li[contains(@class,'sign-in')]")).click();
			wait.until(ExpectedConditions.elementToBeClickable(By.id("emailId"))).sendKeys("joe@gmail.com");
			wait.until(ExpectedConditions.elementToBeClickable(By.id("password"))).sendKeys("P@ssword");
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Sign In']"))).click();
			
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Admin']"))).click();
			List<WebElement> total_tr = wait.until(ExpectedConditions.numberOfElementsToBe(By.xpath("//table//tbody//tr"), 5));
			for(int tr=1; tr<=total_tr.size();tr++) {	
				for(int td=1; td<6;td++) {				
					System.out.println("Table Data for row : " + tr + " and col no: " + td + " is : " + wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//table//tbody//tr["+tr+"]//td["+td+"]"))).getText());
				}
			}
			
		}
}
