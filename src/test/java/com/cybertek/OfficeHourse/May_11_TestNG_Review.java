package com.cybertek.OfficeHourse;

import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class May_11_TestNG_Review {
    /*
    Topic: TestNG
        @Test: a test case
            priority: decides which @Test method to run first. (in Acsending order)
            enable: If true(default), @Test will be executed, if false @Test will be ignored
            description: it's used to write test case description, explains the test case
            invocationcount: desides how many time the test case should be executed
            timeout: gives time limits to test case
            expectedexceptions: Defines that the test case might throw an unchecked

            TestNG Annotations:
                Control how to @Test(TestNG') should be executed

                @BeforeMethod: runs before each @Test Method
                @AfterMethod: runs after the completion each @Test Method
                @BeforeClass: runs before the first @Test method of the class
                @AfterClass: runs after the completion of last @Test method

     */

    @Test(priority = 1, enabled = false)
    public void testCase() {
        System.out.println("Test case 1 is completed");
    }

    @Ignore
    @Test(priority = -1, description = "this is testing testNG")
    public void testCase2() {
        System.out.println("Test case 2 is completed");
    }

    @Test(invocationCount = 3)
    public void testCase3() {
        System.out.println("Test case 3 is completed");
    }

    @Test(timeOut = 3000)
    public void testCase4() {
        System.out.println("Test case 4 is completed");

    }

    @Test(expectedExceptions = ArrayIndexOutOfBoundsException.class)
    public void testCase5() {
        System.out.println("Test case 5 is completed");

        int arr[] = {1, 2, 3, 4, 5};
        System.out.println(arr[100]);
        System.out.println("Extra test step");
    }

}
