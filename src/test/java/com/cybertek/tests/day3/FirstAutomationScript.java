package com.cybertek.tests.day3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstAutomationScript {
    public static void main(String[] args) throws Exception {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/");
        Thread.sleep(3000);
        driver.close();
    }
}
