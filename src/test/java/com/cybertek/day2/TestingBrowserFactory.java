package com.cybertek.day2;

import com.cybertek.utilities.BrowserFactory;
import org.openqa.selenium.WebDriver;

public class TestingBrowserFactory {
    public static void main(String[] args) {
        //getDriver is a static method
        //so we don't need to create an obiect
        // to use that method
        //in order to call static members
        // we use classname not object name
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.manage().window().maximize(); // command to maximize browser
        driver.get("http://practice.cybertekschool.com"); // open some website
        try {
            // sleep method thros checjed exception
            // that means we have to handle it
            // unchecked exceptions occurs during runtime
            Thread.sleep(5000); // this command will stop execution for 3 seconds
            //it will wait for 5 seconds
            //before closing next step
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        //This is out test
        //We are checking if expected title is the same as actual
        String actualTitle = driver.getTitle();
        String expectedTitle = "Practise";
        if (actualTitle.equals(expectedTitle)){
            System.out.println("Passed");
        }else{
            System.out.println("Failed");
            System.out.println("Expected title: "+expectedTitle);
            System.out.println("Actual title: "+actualTitle);
        }
        driver.close(); // close browser


    }
}
