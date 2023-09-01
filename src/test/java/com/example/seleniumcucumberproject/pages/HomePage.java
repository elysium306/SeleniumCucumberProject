package com.example.seleniumcucumberproject.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.springframework.stereotype.Component;

@Component
public class HomePage {

    @FindBy(how = How.ID, using = "twotabsearchtextbox")
    public WebElement searchBox;

    @FindBy(how = How.ID, using = "nav-search-submit-button")
    public WebElement findBtn;

//    @FindBy(how = How.LINK_TEXT, using = "login")
//    public WebElement searchBox;
//
//    @FindBy(how = How.LINK_TEXT, using = "Employee List")
//    public WebElement findBtn;

    public void search(String searchItem){
        System.out.println("Click the hope page login");
        searchBox.sendKeys(searchItem);
    }

    public void clickFind(){
        findBtn.click();
    }

}
