package com.cybertek.tests.day13_actions_jsexecutor;

import com.cybertek.utilities.SeleniumUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Sleeper;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class JavaScriptExecutorTests {
    WebDriver driver;

    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void jsExecutor() {
        driver.get("http://practice.cybertekschool.com/");
        //we want to run some javascript code
        //for this, we have to use JavaScriptExecutor interface
        //since it's an interface, we cannot crerate an object
        //we just have to cast webdrriver
        JavascriptExecutor js = (JavascriptExecutor) driver;
        //and then to execute script itselfd
        //we call executeScript() method
        //executeScript returns an object
        String title = (String) js.executeScript("return document.title");
        //or you can execute some script without any return
        SeleniumUtils.waitPlease(2);
        js.executeScript("alert('Good Morning Vietnam')");
        SeleniumUtils.waitPlease(3);
        //Alert interface handles alerts
        //what is alert?
        //it looks like pop up window
        Alert alert = driver.switchTo().alert();
        //we can use accept() method to select ok in the pop up
        alert.accept();
        System.out.println(title);
    }

    @Test
    public void scrollTest1() {
        driver.get("http://practice.cybertekschool.com/infinite_scroll");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        for (int i = 0; i < 11; i++) {
            js.executeScript("window.scrollBy(0, 250)");
            SeleniumUtils.waitPlease(2);
        }
    }
    //TEST CASE
    //step 1 go to "http://practice.cybertekschool.com"

    @Test
    public void scrollTest2() {
        driver.get("http://practice.cybertekschool.com");
        WebElement footerLink = driver.findElement(By.linkText("CYDEO"));

        JavascriptExecutor js = (JavascriptExecutor) driver;
        SeleniumUtils.waitPlease(2);
        //Scroll until footerLink is not visible
        //ones you see footerLink, script will stop scrolling
        js.executeScript("arguments[0].scrollIntoView(true)", footerLink);
        SeleniumUtils.waitPlease(2);
        //to click with jsExecutor
        js.executeScript("arguments[0].click()", footerLink);
        SeleniumUtils.waitPlease(2);

    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }
}
