package com.cybertek.tests.day4;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Locale;

public class Test2 {
    public static void main(String[] args) throws Exception {
        // this line replaces System.setProperty("webdriver", "")
        WebDriverManager.chromedriver().setup(); //setup webdriver
        //Driver will give us access to the browser
        WebDriver driver = new ChromeDriver(); //create object of chromedriver
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/forgot_password"); //open url

        WebElement emailInputBox = driver.findElement(By.name("email"));
        WebElement submitButton = driver.findElement(By.id("form_submit"));

        Faker faker = new Faker();

//        emailInputBox.sendKeys("john@gmail.com" + Keys.ENTER); // to enter text and hit enter
        String name = faker.pokemon().name().replace(" ", "").toLowerCase();
        Thread.sleep(3000);
        emailInputBox.sendKeys(faker.internet().emailAddress());


        Thread.sleep(3000);
        emailInputBox.clear(); // clears text from input box
        Thread.sleep(3000);

        emailInputBox.sendKeys(name + "@gmail.com" + Keys.ENTER);
        Thread.sleep(3000);
        driver.close();
    }
}
