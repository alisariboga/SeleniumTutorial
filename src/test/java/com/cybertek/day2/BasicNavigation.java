package com.cybertek.day2;

import org.openqa.selenium.WebDriver;

public class BasicNavigation {
    public static void main(String[] args) throws Exception {
        //throw Exception means someone else is responsible to handle this exception
        //whoever is calling method
        //it works without try/catch because we can throw exception on the method level declaration
        //that means we are not responsible for handling this exception any more
        WebDriver driver = BrowserFactory.getDriver("chrome");
        //BasicNavigation is not supposed to be a child class of any class
        //That's why it is not suppose to extend any class
        //Preferable to use BrowserFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("https://www.google.com");
        Thread.sleep(1000);
        driver.navigate().to("https://www.amazon.co.uk");
        Thread.sleep(3000);
        driver.navigate().back(); //navigates to the previous url
        /*
        The question is: can we navigate back to the google.com?
        If we opened amazon.com with get() method not navigate().to()
        as we know, navigate() helps to jump in the browser history
        in our case is google.com*/
        Thread.sleep(3000);
        driver.navigate().forward();
        Thread.sleep(3000);
        System.out.println("Title: "+driver.getTitle());
        System.out.println("URL: "+driver.getCurrentUrl());
        driver.navigate().refresh(); // to refresh the page
        Thread.sleep(3000);
        driver.close();
    }
}
