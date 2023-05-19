package com.cybertek.day12_waits_practise;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class ExplicitWaitTest {
    String startButtonLocator = "#start > button";
    String usernameLocator = "#username";
    String passwordLocator = "#pwd";
    String submitButtonLocator = "button[type ='submit']";
    String loginBarLocator = "div[id='loading']";
    String enableButtonLocator = "#input-example > button";
    //    String addButtonLocator = "button[onclick = 'swapCheckbox()']";
    String addButtonLocator = "//button[text() ='Add']"; //xpath locator!
    String removeButtonLocator = "//button[text() ='Remove']"; //xpath locator!
    String spinnerLocator = "div[class='fa fa-cog fa-spin']";
    WebDriver driver;

    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        //implicit wait for element to be available
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @Test
    public void waitForVisibilityTest() {
        driver.get("http://practice.cybertekschool.com/dynamic_loading/1");
        driver.findElement(By.cssSelector(startButtonLocator)).click();
        System.out.println(driver.findElement(By.cssSelector(loginBarLocator)).getText());
        //Explicit wait
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        //wait until input box username is visible
        //it works only for element that you provided
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector(usernameLocator))));
        driver.findElement(By.cssSelector(usernameLocator)).sendKeys("tomsmith");
        driver.findElement(By.cssSelector(passwordLocator)).sendKeys("SuperSecretPassword");
        driver.findElement(By.cssSelector(submitButtonLocator)).click();
    }

    @Test
    public void waitForElementToBeClickable() {
        driver.get("http://practice.cybertekschool.com/dynamic_controls");
        driver.findElement(By.cssSelector(enableButtonLocator)).click();
        driver.findElement(By.cssSelector(enableButtonLocator)).click();

        driver.findElement(By.xpath(removeButtonLocator)).click();
        driver.findElement(By.xpath(addButtonLocator)).click();
    }

    @Test
    public void waitForElementToBeClickable2() {
        driver.get("http://practice.cybertekschool.com/dynamic_loading/5");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        //we use this condition to wait until overlay screen will disappear
        wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(spinnerLocator))));
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.cssSelector(submitButtonLocator))));
        driver.findElement(By.cssSelector(submitButtonLocator)).click();
    }


    @AfterMethod
    public void teardown() {
        driver.quit();
    }

}
