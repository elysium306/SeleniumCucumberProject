package utilities;

import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BrowserUtils {

	Alert alert;
	WebDriverWait letswait;
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
		letswait = new WebDriverWait(Driver.getDriver(), 10);
		letswait.until(ExpectedConditions.alertIsPresent());
	}

	public void waitUntilElementVisible(WebElement element) {
		letswait = new WebDriverWait(Driver.getDriver(), 10);
		letswait.until(ExpectedConditions.visibilityOf(element));
	}

	public static void selectByVisibleText(WebElement element, String optionToSelect) {
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

	// hoverover to an element
	public void hoverOverToElement(WebElement element) {
		act = new Actions(Driver.getDriver());
		act.moveToElement(element).perform();
	}

	// drag the source element to the target element
	public void dragAndDrop(WebElement sourceElement, WebElement tagtetElement) {
		act = new Actions(Driver.getDriver());
		act.dragAndDrop(sourceElement, tagtetElement).perform();
	}

	// this method is for deleting the pre-populated value of an input field with
	// back space key events
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
	// command + a keys event for mac
	public void clearTextOfAField(WebElement element) {
		element.sendKeys(Keys.chord(Keys.COMMAND), "a");
		element.sendKeys(Keys.DELETE);
	}
}
