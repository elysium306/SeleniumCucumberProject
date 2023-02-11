package package3;

import java.util.Scanner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class Test2 {
	
	private static Scanner keyboard = new Scanner(System.in);
	private static WebDriver firefox = new FirefoxDriver();
	private static WebDriver chrome = new ChromeDriver();
	
	@Test
	public static void test1() {
		System.out.println("Enter a name: ");
		String name = keyboard.nextLine();

		System.out.println("Enter a number: ");
		int number = keyboard.nextInt();
		
		System.out.println("You've entered the name: " + name);
		System.out.println("You've entered the number: " + number);
		
	}
	
	@Test
	public static void test2() {
		firefox.get("http://www.amazon.com");
		firefox.manage().window().maximize();
		String currTitle = firefox.getTitle();
		System.out.println(currTitle);
		
		firefox.quit();
	}
	
	@Test
	public static void test3() {
		chrome.get("http://www.google.com");
		chrome.manage().window().maximize();
		
		System.out.println(chrome.getTitle());
		chrome.quit();
	}
}
