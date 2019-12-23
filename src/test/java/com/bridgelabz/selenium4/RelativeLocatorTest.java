package com.bridgelabz.selenium4;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RelativeLocatorTest {

	WebDriver driver;

	@BeforeClass
	public void setup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/");

	}

	@Test
	public void testRelative() {

		WebElement element = driver.findElement(RelativeLocator.withTagName("div").toRightOf(By.id("desktop-grid-1"))
				.toLeftOf(By.id("desktop-grid-3")));

		// WebElement element =
		// driver.findElement(By.xpath("//div[@id='desktop-grid-2']"));

		System.out.println("Found element::::::" + element.getAttribute("id"));
		assertEquals(element.getAttribute("id"), "desktop-grid-2");
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
