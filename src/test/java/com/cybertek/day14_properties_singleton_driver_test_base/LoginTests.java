package com.cybertek.day14_properties_singleton_driver_test_base;

import com.cybertek.utilities.ConfigurationReader;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {
    LoginPage loginPage = new LoginPage();

    @Test
    public void loginTest1() {
        //DEMO for reading credentials from properties file
        String userName = ConfigurationReader.getProperty("username");
        String password = ConfigurationReader.getProperty("password");
        loginPage.login(userName, password);
    }

}
