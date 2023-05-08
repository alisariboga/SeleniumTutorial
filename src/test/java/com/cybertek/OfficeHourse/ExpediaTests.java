package com.cybertek.OfficeHourse;

import com.cybertek.utilities.SeleniumUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class ExpediaTests {
    static WebDriver driver = BrowserFactoryOfficeHour.getDriver("Chrome");


    public static void main(String[] args) throws Exception {
        openHomePage();
        flightsTest1();
        driver.close();
    }

    public static void openHomePage() {
        driver.manage().window().maximize();
        driver.get("https://www.expedia.com/");
        String expectedTitle = "Expedia Travel: Vacation Homes, Hotels, Car Rentals, Flights & More";
        SeleniumUtils.waitPlease(3);
        String actualTitle = driver.getTitle();
        SeleniumUtils.waitPlease(3);
        SeleniumUtils.verifyEquals(expectedTitle, actualTitle);
    }

    public static void flightsTest1() throws Exception {
        driver.findElement(By.id("uitk-tab-active")).click();
        driver.findElement(By.id("location-field-leg1-origin-menu-trigger")).sendKeys("Washington (WAS - All Airports)");
        driver.findElement(By.id("location-field-leg1-destination-menu-trigger")).sendKeys("Houston (HOU - All Airports)");
        driver.findElement(By.id("d1-btn")).sendKeys("31/06/2023");
        driver.findElement(By.id("d2-btn")).sendKeys("23/07/2023");
        driver.findElement(By.id("submit-button")).click();
        Thread.sleep(3000);
    }
}
