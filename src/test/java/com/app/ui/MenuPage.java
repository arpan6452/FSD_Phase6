package com.app.ui;

import static org.testng.Assert.assertEquals;

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

public class MenuPage {
	
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
		public void invalidUserCredsTest() throws InterruptedException {
			WebDriverWait wait = new WebDriverWait(driver, 30);
			// actions
			driver.findElement(By.xpath("//li[contains(@class,'sign-in')]")).click();
			wait.until(ExpectedConditions.elementToBeClickable(By.id("emailId"))).sendKeys("joe_a@gmail.com");
			wait.until(ExpectedConditions.elementToBeClickable(By.id("password"))).sendKeys("P@ssword");
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Sign In']"))).click();
			
			//delay
			Thread.sleep(10000);
			List<WebElement> error = wait.until(ExpectedConditions.numberOfElementsToBe(By.xpath("//small[text()='Incorrect Credetials!!']"), 1));
			assertEquals("Incorrect Credetials!!", error.get(0).getText());// Incorrect Credetials!! 
		}
		
		@Test
		public void validUserCredsTest() throws InterruptedException {
			WebDriverWait wait = new WebDriverWait(driver, 30);
			// actions
			driver.findElement(By.xpath("//li[contains(@class,'sign-in')]")).click();
			wait.until(ExpectedConditions.elementToBeClickable(By.id("emailId"))).sendKeys("joe@gmail.com");
			wait.until(ExpectedConditions.elementToBeClickable(By.id("password"))).sendKeys("P@ssword");
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Sign In']"))).click();
		}
		
		@Test
		public void validCardDisplayOnPage() throws InterruptedException {
			WebDriverWait wait = new WebDriverWait(driver, 30);
			driver.findElement(By.xpath("//li[contains(@class,'sign-in')]")).click();
			wait.until(ExpectedConditions.elementToBeClickable(By.id("emailId"))).sendKeys("joe@gmail.com");
			wait.until(ExpectedConditions.elementToBeClickable(By.id("password"))).sendKeys("P@ssword");
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Sign In']"))).click();
			Thread.sleep(10000);
			List<WebElement> error = wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.id("card"), 1));
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='card'][1]//button[contains(@class,'addSubBtn')]"))).click();			
			
		}
}
