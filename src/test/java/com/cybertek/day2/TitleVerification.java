package com.cybertek.day2;

import com.cybertek.utilities.BrowserFactory;
import org.openqa.selenium.WebDriver;

import java.util.Arrays;
import java.util.List;

public class TitleVerification {
    public static void main(String[] args) throws Exception {
        List<String> urls = Arrays.asList("http://practice.cybertekschool.com",
                "http://practice.cybertekschool.com/dropdown",
                "http://practice.cybertekschool.com/login");
        //This is expecting title for every website
        String expectedTitle = "Practise";
        String expectedURL = "http://practice.cybertekschool.com/";

        WebDriver driver = BrowserFactory.getDriver("chrome");

        for (String url : urls) {
            driver.get(url);
            Thread.sleep(2000);
            //We are checking if page title is correct
            if (driver.getTitle().equals(expectedTitle)) {
                System.out.println("title is correct");
                System.out.println("Passed");
                Thread.sleep(3000);
            } else {
                System.out.println("Title incorrect: " + driver.getTitle());
                System.out.println("Failed");
            }
            //to verify if every page url starts with expected URL
            Thread.sleep(3000);
            if (driver.getCurrentUrl().startsWith(expectedURL)){
                System.out.println("URL is correct");
                System.out.println("Passed");
                Thread.sleep(3000);
            }else{
                System.out.println("URL is not coorect: "+driver.getCurrentUrl());
                System.out.println("Failed");
            }

            driver.close();
        }
    }
}