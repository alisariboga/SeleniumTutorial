package com.cybertek.OfficeHourse;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static com.cybertek.OfficeHourse.Library.sleep;

public class June_27 {
    public static void main(String[] args) throws Exception {
//        System.setProperty("Webdrivername", "filepath" );
        WebDriverManager.chromedriver().setup(); // Sets System property
        WebDriver driver = new ChromeDriver(); // opens the browser
        // Webdriver is an interface implemented by chromedriver class

        driver.get("http://www.google.com"); //protocol must be provided
        // http: hypertext transfer protocol
        //https: hypertext transfer protocol secure

        String pageTitle = driver.getTitle();
        //if (pageTitle.contains("Google")) {
        if (pageTitle.contains("Amazon")) { // Failed
            System.out.println("Page title is verified");
        } else {
            System.out.println("Page title is no verified");
        }
        System.out.println("Test Completed");
//        method1(); // throws
//        method2(); //try & catch

        sleep(2);

        // maximize window:
        driver.manage().window().maximize();
        sleep(2);
        //fullscreen
        driver.manage().window().fullscreen();
        sleep(2);
//        driver.manage().window().setSize(new Dimension(60, 180));
//        sleep(2);

        //Navigate: refresh, go back, go forward, open URL
        //refresh():
        driver.navigate().refresh();
        sleep(2);

        //go back:
        driver.navigate().back();
        sleep(2);
        driver.navigate().forward();
        sleep(2);

        driver.navigate().to("https://www.amazon.co.uk");
        sleep(2);

        /*
        Differences between navigate().to and get():
                    get() wait for webpage fully uploaded
                    navigate.to() does not have to wait (faster)

        Navigation: with navigation we can:
            refresh: navigate().refresh();
            go back: Navigate().back();
            forward: Navigate().forward();

        Manage window:
            full screen: driver.manage().window().fullscreen();
            maximize: driver.manage().window().maximize();
            setSize: driver.manage().window().setSize(new Dimension(int, int));

        to verify webPage title: getTitle();
        to verify the URL: getCurrentURL();
         */

        String pageURL = driver.getCurrentUrl();
        //expected: URL should contain "www.amazon.co.uk"

        if (pageURL.contains("www.amazon.co.uk")) {
            System.out.println("URL is verified");
        } else {
            System.out.println("URL is not verified");
        }


        driver.navigate().back();

        /*
        Differences between quite() and close();
                    close(): closes the one siongle tab.
                    quite(): closes the entire tab and browser
         */
        driver.quit();
    }

    public static void method1() throws Exception {
        Thread.sleep(1000);
    }

    public static void method2() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }
    }
}