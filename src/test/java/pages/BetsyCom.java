package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BetsyCom {
	
	@FindBy(id="global-enhancements-search-query")
	WebElement searchBox;
	
	@FindBy(className = "wt-input-btn-group__btn global-enhancements-search-input-btn-group__btn ")
	WebElement submitButton;
	
	WebDriver driver;
	
	public BetsyCom(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, BetsyCom.class);
	}
	
	public void searchFor(String str) {
		searchBox.sendKeys("coffee mug");
	}
	
	public void pressSearch() {
		submitButton.click();
	}
}
