package com.cybertek.tests.day11_vytrack;

import com.cybertek.utilities.SeleniumUtils;
import com.cybertek.utilities.VYTrackUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

public class CreateCalendarEventTests {

    WebDriver driver;

    String createCalendarEventButtonLocator = "a[title='Create Calendar event']";
    String cancelButtonLocator = "a[title='Cancel']";
    //locators for save and close dropdown
    String saveAndCloseButtonLocator = "//div/button[contains(text(), 'Save and Close')]";
    String saveAndCloseDropdownLocator = "a[class='btn-success btn dropdown-toggle']";
    String saveAndCloseOptionLocator = "button[class='action-button dropdown-item']";
    String saveAndNewOptionLocator = "//button[contains(text(),'Save and New')]";
    String saveOptionLocator = "(//li/button[contains(text(), 'Save')]) [3]";
    //current user
    String currentUserLocator = "#user-menu > a";
    String selectOwnerLocator = ".select2-chosen";
    //    String titleLocator = "input[id='oro_calendar_event_form_title-uid-646275b436bda']";
    String titleLocator = "[id^='oro_calendar_event_form_title']";

    //Date and Time Locator
    String startDateLocator = "[id^='date_selector_oro_calendar_event_form_start']";
    String startTimeLocator = "[id^='time_selector_oro_calendar_event_form_start']";
    String endDateLocator = "[id^='date_selector_oro_calendar_event_form_end']";
    String endTimeLocator = "[id^='time_selector_oro_calendar_event_form_end']";


    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://qa2.vytrack.com/user/login");
        VYTrackUtils.login(driver, "salesmanager110", "UserUser123");
    }

    @Test
    public void verifyCancelButton() {
        VYTrackUtils.navigateToModule(driver, "Activities", "Calendar Events");
        SeleniumUtils.waitPlease(2);
        driver.findElement(By.cssSelector(createCalendarEventButtonLocator)).click();
        SeleniumUtils.waitPlease(2);
        Assert.assertTrue(driver.findElement(By.cssSelector(cancelButtonLocator)).isDisplayed());
    }

    @Test
    public void verifySaveAndCloseDropdown() {
        VYTrackUtils.navigateToModule(driver, "Activities", "Calendar Events");
        SeleniumUtils.waitPlease(2);
        driver.findElement(By.cssSelector(createCalendarEventButtonLocator)).click();
        SeleniumUtils.waitPlease(2);
        //verify save and close button is displayed(visible)
        Assert.assertTrue(driver.findElement(By.xpath(saveAndCloseButtonLocator)).isDisplayed());

        //click on toggle to make dropdown options visible
        driver.findElement(By.cssSelector(saveAndCloseDropdownLocator)).click();
        //verify dropdown options are visible
        driver.findElement(By.cssSelector(saveAndCloseOptionLocator)).isDisplayed();
        driver.findElement(By.xpath(saveAndNewOptionLocator)).isDisplayed();
        driver.findElement(By.xpath(saveOptionLocator)).isDisplayed();

    }

    @Test
    public void verifyDefaultOwner() {
        VYTrackUtils.navigateToModule(driver, "Activities", "Calendar Events");
        SeleniumUtils.waitPlease(2);
        driver.findElement(By.cssSelector(createCalendarEventButtonLocator)).click();
        SeleniumUtils.waitPlease(2);

        String expectedOwner = driver.findElement(By.cssSelector(currentUserLocator)).getText().trim();
        String actualOwner = driver.findElement(By.cssSelector(selectOwnerLocator)).getText().trim();
        Assert.assertEquals(actualOwner, expectedOwner);
    }

    @Test
    public void verifyTitle() {
        VYTrackUtils.navigateToModule(driver, "Activities", "Calendar Events");
        SeleniumUtils.waitPlease(2);
        driver.findElement(By.cssSelector(createCalendarEventButtonLocator)).click();
        SeleniumUtils.waitPlease(2);
        Assert.assertTrue(driver.findElement(By.cssSelector(titleLocator)).getAttribute("value").length() == 0);
    }

    @Test
    public void verifyStartDateAndTime() {
        VYTrackUtils.navigateToModule(driver, "Activities", "Calendar Events");
        SeleniumUtils.waitPlease(2);
        driver.findElement(By.cssSelector(createCalendarEventButtonLocator)).click();
        SeleniumUtils.waitPlease(2);

        String expectedStartDate = LocalDate.now().format(DateTimeFormatter.ofPattern("MMM d, yyy")).toLowerCase();
        String actualStartDate = driver.findElement(By.cssSelector(startDateLocator)).getAttribute("value").toLowerCase();

        String expectedStartTime = LocalTime.now().format(DateTimeFormatter.ofPattern("h:mm a")).toLowerCase();
        String actualStartTime = driver.findElement(By.cssSelector(startTimeLocator)).getAttribute("value").toLowerCase();


        Assert.assertEquals(actualStartTime, expectedStartTime);
        Assert.assertEquals(actualStartDate, expectedStartDate);


//        String expectedEndDate = LocalDate.now().format(DateTimeFormatter.ofPattern("hh:mm a"));
//        String expectedEndTime = driver.findElement(By.cssSelector(endTimeLocator)).getText();
//        String actualEndDate = driver.findElement(By.cssSelector(endDateLocator)).getText();
//        String actualEndTime = driver.findElement(By.cssSelector(endTimeLocator)).getText();

    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }
}
