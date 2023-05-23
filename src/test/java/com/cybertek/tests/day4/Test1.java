package com.cybertek.tests.day4;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test1 {
    public static void main(String[] args) throws Exception {
        // this line replaces System.setProperty("webdriver", "")
        WebDriverManager.chromedriver().setup(); //setup webdriver
        //Driver will give us access to the browser
        WebDriver driver = new ChromeDriver(); //create object of chromedriver
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/forgot_password"); //open url

        WebElement emailInputBox = driver.findElement(By.name("email"));
        WebElement submitButton = driver.findElement(By.id("form_submit"));

        emailInputBox.sendKeys("john@gmail.com");
        Thread.sleep(2000);

        submitButton.click();
        Thread.sleep(3000);

        //let's find confirmation message and verify it
        WebElement confirmationMessage = driver.findElement(By.name("confirmation_message"));

        String expectMessage = "Your e-mail's been sent!";
        String actualMessage = confirmationMessage.getText(); // How to get text of element

        if (actualMessage.equals(expectMessage)) {
            System.out.println("Test Passed");
        } else {
            System.out.println("Test Failed" + "Expected message: " + expectMessage + "Actual Message: " + actualMessage);
        }

        driver.close(); // selenium clean up after yourself, close browser
    }
}
