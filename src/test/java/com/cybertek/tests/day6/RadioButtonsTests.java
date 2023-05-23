package com.cybertek.tests.day6;

import com.cybertek.utilities.BrowserFactory;
import com.cybertek.utilities.SeleniumUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class RadioButtonsTests {
    static WebDriver driver = BrowserFactory.getDriver("chrome");

    public static void main(String[] args) throws Exception {
        openRadioButtonPage();
        //test1();
        //test2();
        //test3();
        test4();
        driver.close();

    }

    public static void openRadioButtonPage() {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/radio_buttons");

    }

    // let's check if blue button selected
    public static String test1() {
        WebElement blueBtn = driver.findElement(By.id("blue"));

        if (blueBtn.isSelected()) {
            //System.out.println("PASSED");
            return "PASSED";
        } else {
            //System.out.println("FAILED");
            return "FAILED";
        }
        //SeleniumUtils.waitPlease(3);
    }

    //let's check that green button is disabled, that means not clickable and black button is clickable
    public static void test2() {
        WebElement blackBtn = driver.findElement(By.id("black"));
        WebElement greenBtn = driver.findElement(By.id("green"));
        if (blackBtn.isEnabled() && !greenBtn.isEnabled()) {
            System.out.println("PASSED");
        } else {
            System.out.println("FAILED");
        }
        SeleniumUtils.waitPlease(3);
    }

    /*
    write a test that will do following:
    verify that blue button is selected
    then click on black button
    verify that black button is selected
    verify that blue button is not selected */
    public static void test3() {
        WebElement blackBtn = driver.findElement(By.id("black"));
        WebElement blueBtn = driver.findElement(By.id("blue"));
        test1();
        SeleniumUtils.waitPlease(3);

        if (test1().equals("PASSED")) {
            System.out.println("Blue button is selected");
        } else {
            System.out.println("Blue button is not selected");
        }

        SeleniumUtils.waitPlease(3);
        blackBtn.click();
        SeleniumUtils.waitPlease(3);

        if (blackBtn.isSelected() && !blueBtn.isSelected()) {
            System.out.println("PASSED");
            System.out.println("Black is selected");
        } else {
            System.out.println("FAILED");
            System.out.println("Black is not selected");
        }


    }

    //Let's write a test
    //that will make sure
    //that only one radio button is selected
    public static void test4() {
        List<WebElement> listOfRadioButtons = driver.findElements(By.xpath("//input[@type='radio']"));
        //Let's create counter
        //how many selected radio buttons
        int counter = 0;
        //we will go through list of web elements
        //and check one by one
        //which radio button is selected
        //if radio button is selected increase counter
        for (WebElement radioButton : listOfRadioButtons) {
            if (radioButton.isSelected()) {
                System.out.println(radioButton.getAttribute("id"));
                counter++;
            }
        }
        System.out.println(counter);

    }
}
