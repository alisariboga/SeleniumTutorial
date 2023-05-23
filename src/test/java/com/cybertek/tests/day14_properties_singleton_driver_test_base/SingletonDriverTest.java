package com.cybertek.tests.day14_properties_singleton_driver_test_base;

import com.cybertek.utilities.Driver;
import com.cybertek.utilities.SeleniumUtils;
import org.testng.annotations.Test;

public class SingletonDriverTest {

    @Test
    public void test1() {
        Driver.getDriver().get("https://www.google.com/");
        SeleniumUtils.waitPlease(2);
        Driver.closeDriver();
    }
}
