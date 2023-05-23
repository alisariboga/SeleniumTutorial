package com.cybertek.tests.day8_testng_intro;

import org.testng.annotations.*;

public class MixedAnnotationTesting {
    @BeforeClass
    public void beforeClass() {
        System.out.println("Before class");
    }

    @AfterMethod
    public void tearDown() {
        System.out.println("After method");
    }

    @AfterClass
    public void afterClass() {
        System.out.println("After Class");
    }

    @BeforeMethod
    public void setUp() {
        System.out.println("Before Method");
    }

    @Test
    public void test1() {
        System.out.println("I am a test1");
    }

    @Test
    public void test2() {
        System.out.println("I am a test2");
    }
}
