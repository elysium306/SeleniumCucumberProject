package com.example.seleniumcucumberproject.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;

public class BasePage {

    @Autowired
    public WebDriver Driver;


    @PostConstruct
    public void initDriver(){
        PageFactory.initElements(Driver, this);
    }

    public void Navigagte(String url){
        this.Driver.navigate().to(url);
    }
}
