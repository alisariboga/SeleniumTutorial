package com.cybertek.tests.day1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Task1 {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "/Users/alisariboga/Documents/selenium dependencies/drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://cydeo.com/");

        System.setProperty("webdriver.gecko.driver", "/Users/alisariboga/Documents/selenium dependencies/drivers/geckodriver");
        driver = new FirefoxDriver();
        driver.get("http://practice.cybertekschool.com");
    }
}
