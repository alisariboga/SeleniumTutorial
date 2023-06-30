package com.cybertek.tests.day15_review;

import com.cybertek.pages.vytrack.CalendarEventsPage;
import com.cybertek.utilities.TestBase;
import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.VYTrackUtils;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class CalendarEventsTests extends TestBase {
    //BeforeMethod is coming from TestBase
    CalendarEventsPage calendarPage = new CalendarEventsPage();

    @Test
    public void verifyRepeatOptions() {
        String username = ConfigurationReader.getProperty("storemanagerusername");
        String password = ConfigurationReader.getProperty("storemanagerpassword");

        VYTrackUtils.login(driver, username, password); //login

        //go to Calendar Events
        VYTrackUtils.navigateToModule(driver, "Activities", "Calendar Events");
        //since vytrack displays overlay screen during loading of the page
        //we have wait, until that overlay screen disappear
        VYTrackUtils.waitUntilLoaderScreenDisappear(driver);
        driver.findElement(By.cssSelector(calendarPage.createCalendarEventBtnLocator)).click();

        VYTrackUtils.waitUntilLoaderScreenDisappear(driver);
        driver.findElement(By.cssSelector(calendarPage.repeatCheckBoxLocator)).click();

        List<String> expectedOptions = Arrays.asList("Daily", "Weekly", "Monthly", "Yearly");
        List<String> actualOption = calendarPage.getRepeatOptions();
        System.out.println(expectedOptions);
        System.out.println(actualOption);
        //correct way to check if 2 collections are equals.
        Assert.assertEquals(actualOption, expectedOptions);
    }

    public void dailyRepeatOptionRepeatEveryTest() {
    }
    //AfterMethod is coming from TestBase
}
