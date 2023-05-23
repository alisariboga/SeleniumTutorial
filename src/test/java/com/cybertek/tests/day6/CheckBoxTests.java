package com.cybertek.tests.day6;

import com.cybertek.utilities.BrowserFactory;
import com.cybertek.utilities.SeleniumUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class CheckBoxTests {
    static WebDriver driver = BrowserFactory.getDriver("chrome");

    public static void main(String[] args) {
        //test1();
        test2();
        driver.close();

    }

    public static void openCheckBoxesPage() {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/checkboxes");

    }

    //check if checkbox 1 is not selected and checkbox 2 is selected
    /*TASK
     * Go to http://practice.cybertekschool.com/checkboxes
     * Verify that checkbox 1 is not selected
     * Verify that checkbox 2 is selected */
    public static void test1() {
        openCheckBoxesPage();
        WebElement checkboxesLogo = driver.findElement(By.tagName("h3"));

        if (checkboxesLogo.isDisplayed()) {
            System.out.println("Checkboxes logo is visible");
        } else {
            System.out.println("Checkboxes logo not found");
        }

        WebElement checkbox1 = driver.findElement(By.id("box1"));
        WebElement checkbox2 = driver.findElement(By.id("box2"));
        if (!checkbox1.isSelected()) {
            System.out.println("Box1 is not selected");
        } else {
            System.out.println("Box 1 is selected");
        }
        if (checkbox2.isSelected()) {
            System.out.println("Box 2 is selected");
        } else {
            System.out.println("Box 2 is not selected");
        }

    }

    public static void test2() {
        openCheckBoxesPage();
        WebElement checkbox1 = driver.findElement(By.id("box1"));
        WebElement checkbox2 = driver.findElement(By.id("box2"));
        SeleniumUtils.waitPlease(2);

        checkbox1.click();
        SeleniumUtils.waitPlease(2);
        checkbox2.click();
        SeleniumUtils.waitPlease(2);
        if (checkbox1.isSelected() && !checkbox2.isSelected()) {
            System.out.println("PASSED");
        } else {
            System.out.println("FAILED");
        }

    }


}
