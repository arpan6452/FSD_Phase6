package com.app.ui;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CartPage {
	
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
		public void validCardDisplayOnPage() throws InterruptedException {
			WebDriverWait wait = new WebDriverWait(driver, 30);
			driver.findElement(By.xpath("//li[contains(@class,'sign-in')]")).click();
			wait.until(ExpectedConditions.elementToBeClickable(By.id("emailId"))).sendKeys("joe@gmail.com");
			wait.until(ExpectedConditions.elementToBeClickable(By.id("password"))).sendKeys("P@ssword");
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Sign In']"))).click();
			Thread.sleep(10000);
			
			List<WebElement> cards = wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.id("card"), 1));
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='card'][1]//button[contains(@class,'addSubBtn')][2]"))).click();						
			Thread.sleep(1000);
			WebElement goToCart = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()=' Go to Cart']/i")));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", goToCart);

			Thread.sleep(10000);
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()=' Go to Cart']/i"))).click();
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username"))).sendKeys("Joe");				
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username"))));
			Thread.sleep(1000);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='shipping']//input[@id='email']"))).sendKeys("joe@gmail.com");
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='shipping']//input[@id='address1']"))).sendKeys("105, Ideal Star");
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='shipping']//input[@id='address2']"))).sendKeys("Chansandra Main Road");
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='shipping']//input[@id='city']"))).sendKeys("Kolkata");
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='shipping']//input[@id='state']"))).sendKeys("West Bengal");
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='shipping']//input[@id='pincode']"))).sendKeys("560098");
			/*
			 * Actions actions = new Actions(driver);
			 * actions.moveToElement(wait.until(ExpectedConditions.elementToBeClickable(By.
			 * xpath("//button[text()='Payment']")))).click().build().perform();
			 */
			
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("//h1[text()='PharmaFast']")));			
			Thread.sleep(10000);
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Payment']"))).click();
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("cname"))).sendKeys("Arpan Ghosh");
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ccnum"))).sendKeys("111-2222-3333-4444");
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("expmonth"))).sendKeys("September");
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("expyear"))).sendKeys("2021");
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("cvv"))).sendKeys("123");
			Thread.sleep(10000);
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()=' Checkout ']"))).click();
			
		}
}
