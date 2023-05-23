package com.cybertek.tests.day5;

import com.cybertek.utilities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class LocatorsPractiseClassName {
    static WebDriver driver = BrowserFactory.getDriver("chrome");
    //got on http://practice.cybertekschool.com/
    // Get list of examples based on clas name list-group-item
    //use for loop to get every element and print the text of this element
    // check how many examples you will get, it must be 47.
    public static void main(String[] args) {
        test1();
    }
    public static void test1(){
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/");
        List<WebElement> examples = driver.findElements(By.className("list-group-item"));
        int count =0;
        for (WebElement element: examples) {
            System.out.println(element.getText());
            count = count +1;
        }
        System.out.println(count);
        driver.close();
    }
}
