package com.cybertek.tests.day4;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test3 {
    public static void main(String[] args) throws Exception {
        // this line replaces System.setProperty("webdriver", "")
        WebDriverManager.chromedriver().setup(); //setup webdriver
        //Driver will give us access to the browser
        WebDriver driver = new ChromeDriver(); //create object of chromedriver
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/forgot_password"); //open url

        WebElement emailInputBox = driver.findElement(By.name("email"));
        WebElement submitButton = driver.findElement(By.id("form_submit"));

        emailInputBox.sendKeys("sdetpro3000@gmail.com"); //to enter text into input box

        System.out.println(emailInputBox.getAttribute("pattern"));// to read value of pattern attribute. We can read any attribute of element
        System.out.println(emailInputBox.getAttribute("value"));// value it's a text that you enter into input box
        Thread.sleep(3000);
        submitButton.submit(); //it works only with buttons. Click method is more flexible.


        Thread.sleep(3000);
        driver.close();

    }
}
