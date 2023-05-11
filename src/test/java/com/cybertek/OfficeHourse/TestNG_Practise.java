package com.cybertek.OfficeHourse;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNG_Practise {
    static WebDriver driver;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.facebook.com");
    }

    @Test(priority = 2,
            description = "Verify the URL",
            timeOut = 4000,
            enabled = false)
    public void test1() {
        String URL = driver.getCurrentUrl();
        System.out.println(URL.contains("wwww.facebook.com"));
        Library.sleep(3);
    }

    @Test(priority = -100,
            description = "Verify the title",
            timeOut = 4000,
            enabled = false)
    public void test2() {
        String title = driver.getTitle().toLowerCase();
        System.out.println(title.contains("facebook"));
    }

    /*
    tagname: button
    linktext: Sign Up
    //button[text(), 'Sign Up']
    //button[contains(text(),'Sign')]
     */

    @Test(description = "Verify the sign up button")
    public static void signUpButton() {
        WebElement cookies = driver.findElement(By.xpath("//button[@id='u_0_j_8D']"));
        cookies.click();
        WebElement sigUp = driver.findElement(By.id("u_0_0_ol"));
        System.out.println(sigUp.isEnabled());
    }

    @AfterMethod
    public void tearDown() {
        Library.sleep(4);
        driver.quit();
    }
}
