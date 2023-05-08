package com.cybertek.day1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;

public class FirstAutomationScript {
    public static void main(String[] args) {
//        System.setProperty("webdriver.chrome.driver", "/Users/alisariboga/Documents/selenium dependencies/drivers/chromedriver");
//        WebDriver driver = new ChromeDriver();
        WebDriver safariDriver = new SafariDriver();
        safariDriver.get("https://practice.cybertekschool.com");
        safariDriver.quit();
    }
}
