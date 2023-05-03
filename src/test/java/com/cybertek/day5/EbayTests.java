package com.cybertek.day5;

import com.cybertek.utilities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class EbayTests {
    static WebDriver driver = BrowserFactory.getDriver("chrome");

    public static void main(String[] args) throws Exception {
        ebayWebsiteTest();

    }

    public static void ebayWebsiteTest() throws Exception{
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.ebay.co.uk/");
        Thread.sleep(3000);
        driver.findElement(By.id("gh-ac")).sendKeys("Java Book", Keys.ENTER);

        Thread.sleep(3000);
        String result = driver.findElement(By.className("srp-controls__count-heading")).getText();
        System.out.println(result);

        driver.close();

    }
}
