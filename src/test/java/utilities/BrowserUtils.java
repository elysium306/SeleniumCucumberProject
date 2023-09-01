package utilities;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BrowserUtils {

	private static BrowserUtils utils = new BrowserUtils();

	private static WebDriver driver = Driver.getDriver();
	Alert alert;
	WebDriverWait wait;
	static Select letsSelect;
	Actions act;

	public void switchToAlert() {
		alert = Driver.getDriver().switchTo().alert();
	}

	public String alertGetText() {
		return alert.getText();
	}

	public void alertAccept() {
		alert.accept();
	}

	public void alertDismiss() {
		alert.dismiss();
	}

	public void sendKeysOnAlert(String name) {
		alert.sendKeys(name);
	}

	public void waitUntilAlertIsPresent() {
		wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
		wait.until(ExpectedConditions.alertIsPresent());
	}

	public void waitUntilElementVisible(WebElement element) {
		wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public void selectByVisibleText(WebElement element, String optionToSelect) {
		letsSelect = new Select(element);
		letsSelect.selectByVisibleText(optionToSelect);
	}

	public boolean isElementPresent(WebElement element) {
		try {
			element.isDisplayed();
		} catch (NoSuchElementException e) {
			return false;
		}
		return true;
	}

	// hover over to an element
	public void hoverOverToElement(WebElement element) {
		act = new Actions(Driver.getDriver());
		act.moveToElement(element).perform();
	}

	// drag the source element to the target element
	public void dragAndDrop(WebElement sourceElement, WebElement targetElement) {
		act = new Actions(Driver.getDriver());
		act.dragAndDrop(sourceElement, targetElement).perform();
	}

	// this method is for deleting the pre-populated value of an input field with
	// backspace key events
	public void clearValueOnTheField(WebElement element) {
		String temp = element.getAttribute("value");
		for (int i = 0; i < temp.length(); i++) {
			element.sendKeys(Keys.BACK_SPACE);
		}
	}

	// this method is for deleting the pre-populated value of an input field with
	// control + a keys event for windows
	public void clearTextOfTheField(WebElement element) {
		element.sendKeys(Keys.chord(Keys.CONTROL), "a");
		element.sendKeys(Keys.DELETE);
	}

	// this method is for deleting the pre-populated value of an input field with
	// command + a keys event for Mac
	public void clearTextOfAField(WebElement element) {
		element.sendKeys(Keys.chord(Keys.COMMAND), "a");
		element.sendKeys(Keys.DELETE);
	}

	public void waitForElementToBeClickable(WebElement element) {
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public void waitForElementToBeClickable(By locator) {
		wait.until(ExpectedConditions.elementToBeClickable(locator));
	}

	public void waitForElementToBeVisible(WebElement element) {
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public void wait(int seconds) throws InterruptedException {
		driver.wait(seconds);
	}
}