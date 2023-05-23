package com.cybertek.tests.day14_properties_singleton_driver_test_base;

import org.testng.annotations.Test;

import java.util.Map;
import java.util.Properties;

public class SystemPropertiesTest {

    @Test
    public void systemPropertiesTest1() {
        String os = System.getProperty("os.name");
        System.out.println("The OS is: " + os);

        String osVersion = System.getProperty("os.version");
        System.out.println("The os version is: " + osVersion);

        String javaVersion = System.getProperty("java.version");
        System.out.println("The java version is: " + javaVersion);

        String javaSpecificationVersion = System.getProperty("java.specification.version");
        System.out.println("The specific java version is: " + javaSpecificationVersion);

        String username = System.getProperty("user.name");
        System.out.println(username);

        String homeDirectory = System.getProperty("user.home");
        System.out.println(homeDirectory);

        System.out.println("--------------------------------------------");
        Properties properties = System.getProperties();
        //this is an entry set of all properties
        //since it's a key -value pair, we use Map to store this information
        for (Map.Entry<Object, Object> property : properties.entrySet()) {
            //get key of every item(os.name)                    value of every property (Mac OS X)
            System.out.println("Key: " + property.getKey() + ", Value" + property.getValue());
        }
    }
}
