package com.cybertek.day11_vytrack;

import com.cybertek.utilities.SeleniumUtils;
import com.cybertek.utilities.VYTrackUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class CreateButtonTests {
    WebDriver driver;
    String logCallButtonLocator = "a[title='Log call']";
    String createCalendarEventButtonLocator = "a[title='Create Calendar event']";

    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://qa2.vytrack.com/user/login");
    }

    @Test(priority = 1)
    public void storeManagerLogCallButtonTest() {
        //Login
        VYTrackUtils.login(driver, "storemanager85", "UserUser123");
        //Navigate to the Calls
        VYTrackUtils.navigateToModule(driver, "Activities", "Calls");
        SeleniumUtils.waitPlease(1);
        Assert.assertTrue(driver.findElement(By.cssSelector(logCallButtonLocator)).isDisplayed());

    }

    @Test(priority = 2)
    public void storeManagerCreateCalendarEventButtonTest() {
        //Login
        VYTrackUtils.login(driver, "storemanager85", "UserUser123");
        //Navigate to the Calendar Events
        VYTrackUtils.navigateToModule(driver, "Activities", "Calendar Events");
        SeleniumUtils.waitPlease(1);
        Assert.assertTrue(driver.findElement(By.cssSelector(createCalendarEventButtonLocator)).isDisplayed());

    }

    @Test(priority = 3)
    public void salesManagerLogCallButtonTest() {
        //Login
        VYTrackUtils.login(driver, "salesmanager253", "UserUser123");
        //Navigate to the Calendar Events
        VYTrackUtils.navigateToModule(driver, "Activities", "Calls");
        SeleniumUtils.waitPlease(1);
        //driver.findElement(By.cssSelector(logCallButtonLocator)).click();
        Assert.assertTrue(driver.findElement(By.cssSelector(logCallButtonLocator)).isDisplayed());

    }

    @Test(priority = 4)
    public void salesManagerCreateCalendarEventButtonTest() {
        //Login
        VYTrackUtils.login(driver, "salesmanager253", "UserUser123");
        //Navigate to the Calendar Events
        VYTrackUtils.navigateToModule(driver, "Activities", "Calendar Events");
        SeleniumUtils.waitPlease(1);
        Assert.assertTrue(driver.findElement(By.cssSelector(createCalendarEventButtonLocator)).isDisplayed());

    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
