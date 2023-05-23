package com.cybertek.tests.OfficeHourse;

import com.cybertek.utilities.SeleniumUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNGIntro {
    private WebDriver driver;

    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

    }


    @Test(priority = 5)
    public void openEtsyTest() {
        driver.get("http://practice.cybertekschool.com/dropdown");
        driver.findElement(By.id("dropdownMenuLink")).click();
        driver.findElement(By.linkText("Etsy")).click();
        SeleniumUtils.waitPlease(2);
        String expectedURL = "https://www.etsy.com/";
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL);
    }

//    @Test(priority = 3)
//    public void openYahooTest() {
//        driver.get("http://practice.cybertekschool.com/dropdown");
//        driver.findElement(By.id("dropdownMenuLink")).click();
//        driver.findElement(By.linkText("Yahoo")).click();
//        SeleniumUtils.waitPlease(2);
//        String expectedURL = "https://uk.yahoo.com/";
//        Assert.assertEquals(driver.getCurrentUrl(), expectedURL);
//    }  // Does not work!

    @Test(priority = 4)
    public void openFacebookTest() {
        driver.get("http://practice.cybertekschool.com/dropdown");
        driver.findElement(By.id("dropdownMenuLink")).click();
        driver.findElement(By.linkText("Facebook")).click();
        SeleniumUtils.waitPlease(2);
        String expectedURL = "https://www.facebook.com/";
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL);
    }

    @Test(priority = 2)
    public void openAmazonTest() {
        driver.get("http://practice.cybertekschool.com/dropdown");
        driver.findElement(By.id("dropdownMenuLink")).click();
        driver.findElement(By.linkText("Amazon")).click();
        SeleniumUtils.waitPlease(2);
        String expectedURL = "https://www.amazon.com/";
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL);
    }
    @Test(priority = 1)
    public void openGoogleTest() {
        driver.get("http://practice.cybertekschool.com/dropdown");
        driver.findElement(By.id("dropdownMenuLink")).click();
        driver.findElement(By.linkText("Google")).click();
        SeleniumUtils.waitPlease(2);
        String expectedURL = "https://www.google.com/";
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL);
    }


    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}