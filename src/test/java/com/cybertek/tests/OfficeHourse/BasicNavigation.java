package com.cybertek.tests.OfficeHourse;

import com.cybertek.utilities.BrowserFactory;
import org.openqa.selenium.WebDriver;

public class BasicNavigation {

    public static void main(String[] args) {
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("http://google.com");
        driver.navigate().to("htpp://amazon.com");
        driver.navigate().back(); //navigate back in browser history
        driver.navigate().forward(); //navigate forward in browser history
        driver.navigate().refresh(); //reload page
        driver.getTitle(); // to read title of the page <title>Some Title</title.
        driver.close();// to close browser at end of test, but if there is 2 tabs, it will close only tab it has focus on
        driver.quit();// quit will close all windows and tabs that webdriver opened
        //at end of execution we use quite() to make sure that we closed whatever selenium webdriver opened
        driver.getPageSource();// to read source code of the web page. source code consist of html+css+js
        // we will not see whole source code of the page we application
        // we will see only current page
        driver.manage().window().maximize();//put this before get()
        driver.manage().window().fullscreen();//or this, before get()
        //at work, we used maximize() not fullscreen()
        driver.switchTo().alert();//for pop up message

    }
}
