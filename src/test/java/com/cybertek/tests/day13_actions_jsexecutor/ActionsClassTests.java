package com.cybertek.tests.day13_actions_jsexecutor;

import com.cybertek.utilities.SeleniumUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class ActionsClassTests {
    WebDriver driver;
    String user1TextLocator = "//a[@href='/users/1']/preceding-sibling::h5";
    String firstImageLocator = "(//img)[1]";
    String enabledOptionLocator = "a[id='ui-id-3']";
    String downloadsOptionLocator = "a[id='ui-id-4']";
    String pdfOptionLocator = "a[id='ui-id-5']";
    String csvOptionLocator = "ui-id-6";
    String excelOptionLocator = "ui-id-7";
    //drag and drop
    String acceptCookiesButtonLocator = "button[id='onetrust-accept-btn-handler']";
    String moonLocator = "div[id='draggable']";
    String earthLocator = "div[id='droptarget']";


    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test(priority = 1)
    public void hoverTest1() {
        driver.get("http://practice.cybertekschool.com/hovers");
        //We are creating object of Actions class
        //We have provide object of WebDriver
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(By.xpath(firstImageLocator))).perform();
        String expectedText = "name: user1";
        String actualText = driver.findElement(By.xpath(user1TextLocator)).getText();

        // verify that after hover event text is visible
        Assert.assertTrue(driver.findElement(By.xpath(user1TextLocator)).isDisplayed());
        Assert.assertEquals(actualText, expectedText);

    }

    @Test(priority = 2)
    public void hoverTest2() {
        driver.get("http://practice.cybertekschool.com/hovers");
        //We are creating object of Actions class
        //We have provide object of WebDriver
        Actions action = new Actions(driver);
        List<WebElement> images = driver.findElements(By.tagName("img"));
        for (WebElement image : images) {
            SeleniumUtils.waitPlease(1);
            action.moveToElement(image).perform();
        }
    }

    @Test(priority = 3)
    public void hoverTestEnableButtonDownloadOptionPDF() {
        driver.get("http://practice.cybertekschool.com/jqueryui/menu#");
        Actions action = new Actions(driver);
        WebElement enabledElement = driver.findElement(By.cssSelector(enabledOptionLocator));
        WebElement downloadsElement = driver.findElement(By.cssSelector(downloadsOptionLocator));
        WebElement pdfElement = driver.findElement(By.cssSelector(pdfOptionLocator));
        WebElement csvElement = driver.findElement(By.id(csvOptionLocator));
        WebElement excelElement = driver.findElement(By.id(excelOptionLocator));

        action.moveToElement(enabledElement)
                .pause(1000).moveToElement(downloadsElement)
                .pause(1000).moveToElement(pdfElement).build().perform();
        SeleniumUtils.waitPlease(2); //Just For Demo
    }

    @Test(priority = 4)
    public void hoverTestEnableButtonDownloadOptionCSV() {
        driver.get("http://practice.cybertekschool.com/jqueryui/menu#");
        Actions action = new Actions(driver);
        WebElement enabledElement = driver.findElement(By.cssSelector(enabledOptionLocator));
        WebElement downloadsElement = driver.findElement(By.cssSelector(downloadsOptionLocator));
        WebElement csvElement = driver.findElement(By.id(csvOptionLocator));

        action.moveToElement(enabledElement)
                .pause(1000).moveToElement(downloadsElement)
                .pause(1000).moveToElement(csvElement).build().perform();
        SeleniumUtils.waitPlease(2); //Just For Demo
    }

    @Test(priority = 5)
    public void hoverTestEnableButtonDownloadOptionExcel() {
        driver.get("http://practice.cybertekschool.com/jqueryui/menu#");
        Actions action = new Actions(driver);
        WebElement enabledElement = driver.findElement(By.cssSelector(enabledOptionLocator));
        WebElement downloadsElement = driver.findElement(By.cssSelector(downloadsOptionLocator));
        WebElement excelElement = driver.findElement(By.id(excelOptionLocator));

        action.moveToElement(enabledElement)
                .pause(1000).moveToElement(downloadsElement)
                .pause(1000).moveToElement(excelElement).build().perform();
        SeleniumUtils.waitPlease(2); //Just For Demo
    }

    @Test(priority = 6)
    public void dragAndDropTest1() {
        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/index");
        Actions actions = new Actions(driver);
        WebElement acceptButtonElement = driver.findElement(By.cssSelector(acceptCookiesButtonLocator));
        SeleniumUtils.waitPlease(2);

        acceptButtonElement.click();
        SeleniumUtils.waitPlease(2);

        WebElement moonElement = driver.findElement(By.cssSelector(moonLocator)); //source
        WebElement earthElement = driver.findElement(By.cssSelector(earthLocator)); //target
        actions.dragAndDrop(moonElement, earthElement).perform();

        String expectedMessage = "You did great!";
        String actualMessage = earthElement.getText();
        SeleniumUtils.waitPlease(2);
        Assert.assertEquals(actualMessage, expectedMessage);
    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }
}
