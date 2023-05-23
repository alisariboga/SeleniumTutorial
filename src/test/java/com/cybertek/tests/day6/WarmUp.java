package com.cybertek.tests.day6;

import com.cybertek.utilities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class WarmUp {
    static WebDriver driver = BrowserFactory.getDriver("chrome");

    public static void main(String[] args) throws Exception {
        //test1();
        test2();

    }

    public static void test1() throws Exception {
        driver.manage().window().maximize();
        Thread.sleep(3000);

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("https://www.amazon.co.uk/");
        Thread.sleep(3000);

        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("book");
        driver.findElement(By.id("nav-search-submit-button")).click();
        String title = driver.getTitle();

        if (title.contains("Iphone")) {
            System.out.println("Passed");
        } else {
            System.out.println("Failed");
        }

        driver.close();

    }

    public static void test2() throws Exception {
        driver.manage().window().maximize();
        Thread.sleep(3000);

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("https://www.wikipedia.org/");
        Thread.sleep(3000);

        driver.findElement(By.id("searchInput")).sendKeys("selenium webdriver", Keys.ENTER);
        //driver.findElement(By.className("sprite svg-search-icon")).click();
        Thread.sleep(3000);
        driver.findElement(By.linkText("Selenium (software)")).click(); // title'in icindeki value'yu buraya yazdim
        Thread.sleep(3000);

        String url = driver.getCurrentUrl();

        if (url.endsWith("x")) {
            System.out.println("Passed");
        } else {
            System.out.println("Failed");
        }

        driver.close();

    }
}
