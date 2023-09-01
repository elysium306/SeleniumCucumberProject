package com.example.seleniumcucumberproject;

@SpringBootApplication
public class SeleniumCucumberProjectApplication {

    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(SeleniumCucumberProjectApplication.class, args);
        var car = applicationContext.getBean(Car.class);
        car.getCar();
        System.out.println("Spring Boot 'main' Application Starting ...");
    }

}
