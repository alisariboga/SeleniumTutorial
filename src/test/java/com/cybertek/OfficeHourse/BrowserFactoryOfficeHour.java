package com.cybertek.OfficeHourse;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserFactoryOfficeHour {
    private static WebDriver driver;

    //to prevent object creation
    private BrowserFactoryOfficeHour() {

    }

    //synchronized needs to yield threads. So we will make that during parallel execution our tests will not break.
    public static WebDriver getDriver(String browser) {
        if (driver != null) {
            if (browser.equals("chrome")) {
                System.setProperty("webdriver.chrome.driver", "/Users/alisariboga/Documents/selenium dependencies/drivers/chromedriver");
                return new ChromeDriver();
            } else if (browser.equals("firefox")) {
                System.setProperty("webdriver.gecko.driver", "/Users/alisariboga/Documents/selenium dependencies/drivers/geckodriver");
                return new FirefoxDriver();
            } else {
                throw new IllegalArgumentException("Wrong driver name");
            }
        }
        return driver;
    }
}
