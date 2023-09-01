package com.example.seleniumcucumberproject;

import com.example.seleniumcucumberproject.pages.HomePage;
import com.example.seleniumcucumberproject.pages.LoginPage;
import com.example.seleniumcucumberproject.pages.MainPage;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SeleniumCucumberProjectApplicationTests {
    @Autowired
    private HomePage homePage;

    @Autowired
    private LoginPage loginPage;

    @Value("${app.url}")
    public String appUrl;

    @Test
    void contextLoads() {
        HomePage homePage = new HomePage();
        LoginPage loginPage = new LoginPage();

//        LoginPage loginPage = page.ClickLogin();
//        loginPage.ClickLogin();

        MainPage mainPage = new MainPage(loginPage, homePage);
        mainPage.PerformLogin();
    }

}
