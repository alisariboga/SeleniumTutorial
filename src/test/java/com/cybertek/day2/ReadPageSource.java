package com.cybertek.day2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ReadPageSource {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "/Users/alisariboga/Documents/selenium dependencies/drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com");
        // Get the source of the last loaded page.
        String pageSource = driver.getPageSource(); // this code reads HTML codes of website page
        System.out.println(pageSource);
        driver.close();
    }
}
