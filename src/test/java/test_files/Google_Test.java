package test_files;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utilities.Driver;

public class Google_Test {
    private WebDriver driver;
    private final String baseURL = "https://www.amazon.com";

    @BeforeTest
    public void setup(){
        driver = Driver.getDriver();
        driver.get(baseURL);
        driver.manage().window().maximize();
    }

    @Test
    public void searchFunction(){
        driver.findElement(By.id("gLFyf")).sendKeys("Selenium WebDriverIO JavaScript");
    }

    @AfterTest
    public void teardown(){
        driver.quit();
    }
}
