package com.cybertek.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SeleniumUtils {

    public static void verifyEquals(String expectedResult, String actualResult) {
        /*
         *
         *
         * @param browser name
         * @return browser object, otherwise throw exception to prevent test run
         * Verifies if two strings are equals
         * */
        if (expectedResult.equals(actualResult)) {
            System.out.println("Passed");
        } else {
            System.out.println("Failed" + "Expected Result: " + expectedResult + "Actual Result: " + actualResult);
        }


    }

    /**
     * This method will put on pause execution
     *
     * @param seconds
     */
    public static void waitPlease(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * @param page
     * @param driver this method will open example page based on link name
     */
    public static void openPage(String page, WebDriver driver) {
        //we will find all examples on the home page
        List<WebElement> listOfExamples = driver.findElements(By.tagName("a"));
        for (WebElement example : listOfExamples) {
            if (example.getText().contains(page)) {
                example.click();
                break;
            }
        }
    }

    public static void verifyIsDisplay(WebElement element) {
        if (element.isDisplayed()) {
            System.out.println("PASSED " + element.getText() + " is visible");
        } else {
            System.out.println("FAILED " + element.getText() + " is not visible!");
        }
    }

}
