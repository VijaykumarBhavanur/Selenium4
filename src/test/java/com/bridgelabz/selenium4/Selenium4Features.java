package com.bridgelabz.selenium4;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Selenium4Features {

	// Capture screenshot of individual web element

	@Test
	public void testWebelementCaptureScreenshotSelenium4Feature() throws InterruptedException, IOException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.get("https://hangouts.google.com/");
		Thread.sleep(2000);

		WebElement googleHangout = driver.findElement(By.xpath("//div[@aria-label='Start chat conversation']"));

		// Capturing screenshot og google hangout logo
		File file = googleHangout.getScreenshotAs(OutputType.FILE);

		// Copying captured screenshot to folder
		FileUtils.copyFile(file, new File("chatBox.jpeg"));

		Thread.sleep(2000);
		driver.quit();

	}

	// @Test
	public void testOpenNewTabSelenium4Feature() throws InterruptedException, IOException {

		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://hangouts.google.com/");
		Thread.sleep(2000);
		driver.switchTo().newWindow(WindowType.TAB);
		Thread.sleep(2000);
		driver.navigate().to("https://mvnrepository.com/");
		Thread.sleep(2000);
		driver.quit();
	}

	// @Test
	public void testOpenNewWindowSelenium4Feature() throws InterruptedException, IOException {

		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://hangouts.google.com/");
		Thread.sleep(2000);
		driver.switchTo().newWindow(WindowType.WINDOW);
		Thread.sleep(2000);
		driver.navigate().to("https://mvnrepository.com/");
		Thread.sleep(2000);
		driver.quit();
	}

	// @Test
	public void testObjectLocationSelenium4Feature() throws InterruptedException, IOException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://hangouts.google.com/");
		WebElement logo = driver.findElement(By.xpath("//img[@class='gb_ua']"));

		System.out.println("Logo hieght:: " + logo.getRect().getDimension().getHeight());
		System.out.println("Logo width:: " + logo.getRect().getDimension().getWidth());
		System.out.println("Logo X-cordinate:: " + logo.getRect().getX());
		System.out.println("Logo Y-cordinate:: " + logo.getRect().getY());
		driver.quit();
	}
}
