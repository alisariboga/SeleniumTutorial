package com.cybertek.day1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SecondAutomationScript {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "/Users/alisariboga/Documents/selenium dependencies/drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://amazon.co.uk");
    }
}
