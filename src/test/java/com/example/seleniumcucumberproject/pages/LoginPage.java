package com.example.seleniumcucumberproject.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.springframework.stereotype.Component;

@Component
public class LoginPage extends BasePage{

    @FindBy(how = How.NAME, using = "UserName")
    public WebElement txtUserName;

    @FindBy(how = How.NAME, using = "Password")
    public WebElement txtPassword;

    @FindBy(how = How.CSS, using = ".btn-default")
    public WebElement btnLogin;

    public HomePage ClickLogin() {
        System.out.println("This is from loginpage.");
        return new HomePage();
    }

    public void login(String userName, String passwordd){
        System.out.println("UserName and Password: " + userName + "---" + passwordd);
    }
}
