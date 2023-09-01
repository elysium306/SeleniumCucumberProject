package package3;

import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import io.qameta.allure.Link;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

public class Test2 {
	
	private static final Scanner keyboard = new Scanner(System.in);
	private static final WebDriver firefox = new FirefoxDriver();
	private static final WebDriver chrome = new ChromeDriver();
	private static final WebDriver edge = new EdgeDriver();
	
	@Link(type = "Java Core")
	@Description("Scanner take user input & compare the value test")
	@Severity(SeverityLevel.NORMAL)
	@Test(groups = {"UI", "JavaCore"}, singleThreaded = false, successPercentage = 100)
	public static void test1() {
		
		Allure.step("Initializing the Edge driver");
		edge.get("https://www.amazon.com");
		edge.manage().window().maximize();
		
		Allure.step("Here it asks for a name");
		edge.findElement(By.cssSelector("input[placeholder=\"Search Amazon\"]")).sendKeys("selenium java books");
		edge.findElement(By.id("nav-search-submit-button")).click();
		String name = keyboard.nextLine();

		Allure.step("Here it asks for a number");
		System.out.println("Enter a number: ");
		int number = keyboard.nextInt();
		
		Allure.step("Here it compares random number 2 and 3 -- draws conclusion");
		Assert.assertNotEquals(2, 3);
		
		Allure.step("Here it prints out the input that user entered earlier");
		System.out.println("You've entered the name: " + name);
		System.out.println("You've entered the number: " + number);
		
	}
	
	@Link(url = "https://amazon.com")
	@Description("Amazon get title test")
	@Severity(SeverityLevel.CRITICAL)
	@Test(groups = {"UI","Selenium"}, singleThreaded = false, successPercentage = 90)
	public static void test2() {
		
		Allure.step("Driver is initiatlized");
		firefox.get("http://www.amazon.com");
		
		Allure.step("Driver maximized the window");
		firefox.manage().window().maximize();
		
		Allure.step("Driver gets the title of the page");
		String currTitle = firefox.getTitle();
		System.out.println(currTitle);
		
		Allure.step("Driver asserts that the title is not empty");
		Assert.assertNotNull(currTitle, "Assert that the current title is NOT null");
		firefox.quit();
	}
	
	@Link(url = "https://google.com")
	@Description("Google get title test")
	@Severity(SeverityLevel.CRITICAL)
	@Test(groups = {"UI","Selenium"}, singleThreaded = false, successPercentage = 80)
	public static void test3() {
		
		Allure.step("Driver navigates to Google home page");
		chrome.get("http://www.google.com");
		
		Allure.step("Driver maximized the window");
		chrome.manage().window().maximize();
		String currTitle = chrome.getTitle();
		
		Allure.step("Driver gets the title and compared with the lower case 'google' to check they're not equal");
		System.out.println(chrome.getTitle());
		Assert.assertNotEquals(currTitle, "google");
		chrome.quit();
	}
	
	@AfterTest
	public void tearDown() {
		chrome.quit();
		firefox.quit();
	}
}
