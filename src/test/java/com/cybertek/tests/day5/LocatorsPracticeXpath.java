package com.cybertek.tests.day5;

import com.cybertek.utilities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class LocatorsPracticeXpath {
    static WebDriver driver = BrowserFactory.getDriver("chrome");

    public static void main(String[] args) throws Exception {
        test1();
    }

    public static void test1() throws Exception{
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/sign_up");
        driver.findElement(By.xpath("//input[@name='full_name']")).sendKeys("James Bond"); // //*[@id="login"]/div[1]/div/input
        driver.findElement(By.xpath("//input[@name='email']")).sendKeys("deneme@gmial.com");
        driver.findElement(By.xpath("//input[@name='wooden_spoon']")).click();
        Thread.sleep(2000);
        driver.close();
    }
}

