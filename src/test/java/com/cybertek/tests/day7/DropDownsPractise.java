package com.cybertek.tests.day7;

import com.cybertek.utilities.BrowserFactory;
import com.cybertek.utilities.SeleniumUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class DropDownsPractise {
    static WebDriver driver = BrowserFactory.getDriver("chrome");

    public static void main(String[] args) {
        openDropDownPage();
//        SeleniumUtils.waitPlease(2);
//        test1();
        SeleniumUtils.waitPlease(2);
        test6();
        driver.close();

    }

    public static void openDropDownPage() {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/dropdown");
        String expected = "Dropdown List";
        //String actual = driver.findElement(By.tagName("h3")).getText();
        WebElement element = driver.findElement(By.xpath("//h3[text()='Dropdown List']"));
        SeleniumUtils.verifyIsDisplay(element);

    }

    public static void test1() {
        WebElement dropdown1 = driver.findElement(By.id("dropdown"));
        /*
        to work with select elements
        we need to use Select class
        don't forget to pass element of that dropdown that you found into constructor
        */
        Select dropdownSelect = new Select(dropdown1);
        //since dropdown consist of options
        //we can check which one is selected
        //getFirstSelectedOption() return webelement, use getText() method if you want to
        //get a text is a visible part of dropdown. Value or other attributes of dropdown, not visible.
        String actual = dropdownSelect.getFirstSelectedOption().getText();
        String expected = "Please select an option";
        SeleniumUtils.verifyEquals(expected, actual);
        /*
         * we can get list of options that are present in the dropdown*/
        List<WebElement> options = dropdownSelect.getOptions();
        for (WebElement option : options) {
            System.out.println(option.getText());
        }
    }

    public static void test2() {
        WebElement dropdownState = driver.findElement(By.id("state"));
        Select dropdownSelect = new Select(dropdownState);
        List<WebElement> states = dropdownSelect.getOptions();
        for (WebElement element : states) {
            System.out.println(element.getText());
        }
        //let's select virginia
        //we have to use object of Select class
        dropdownSelect.selectByVisibleText("Virginia");
        SeleniumUtils.waitPlease(2);
        dropdownSelect.selectByVisibleText("Texas");
        SeleniumUtils.waitPlease(2);
        dropdownSelect.selectByVisibleText("California");
        SeleniumUtils.waitPlease(2);
        dropdownSelect.selectByVisibleText("Kansas");
        SeleniumUtils.waitPlease(2);
        dropdownSelect.selectByVisibleText("New Jersey");
        SeleniumUtils.waitPlease(2);
        dropdownSelect.selectByVisibleText("Florida");
        SeleniumUtils.waitPlease(2);
        dropdownSelect.selectByVisibleText("Tennessee");
        SeleniumUtils.waitPlease(2);
        dropdownSelect.selectByVisibleText("Ohio");
        SeleniumUtils.waitPlease(2);
        dropdownSelect.selectByVisibleText("Colorado");
        SeleniumUtils.waitPlease(2);
        dropdownSelect.selectByVisibleText("Nebraska");
        SeleniumUtils.waitPlease(2);
        dropdownSelect.selectByVisibleText("Arkansas");
        SeleniumUtils.waitPlease(2);
        dropdownSelect.selectByVisibleText("District Of Columbia");
        SeleniumUtils.waitPlease(2);
    }

    public static void test3() {
        WebElement dropdownState = driver.findElement(By.id("state"));
        Select dropdownSelect = new Select(dropdownState);
        //we found all options that are available to select
        //it has methods that helps to work with drop downs
        List<WebElement> states = dropdownSelect.getOptions();
        //we loop through all options
        for (WebElement option : states) {
            SeleniumUtils.waitPlease(1);
            /*
             *and select every option by text
             * <option value="PA">Pennsylvania</option>
             * means find option that has text Pennsylavania and select it
             */

            dropdownSelect.selectByVisibleText(option.getText());
        }
    }

    //select by value
    public static void test4() {
        WebElement dropdownState = driver.findElement(By.id("state"));
        Select dropdownSelect = new Select(dropdownState);
        //<option value="PA">Pennsylvania</option>
        //means find option that has value PA and select it
        dropdownSelect.selectByValue("PA");
        SeleniumUtils.waitPlease(2);
        String expected = "Pennsylvania";
        //to read option is selected.
        String actual = dropdownSelect.getFirstSelectedOption().getText();
        SeleniumUtils.verifyEquals(expected, actual);
    }

    //select by index
    public static void test5() {
        WebElement dropdownState = driver.findElement(By.id("state"));
        Select dropdownSelect = new Select(dropdownState);
        dropdownSelect.selectByIndex(5);
        SeleniumUtils.waitPlease(3);
    }

    //multiple select
    public static void test6(){
        WebElement multipleSelectionWebElement = driver.findElement(By.xpath("//select[@name='Languages']"));
        Select multipleSelectionSelect = new Select(multipleSelectionWebElement);
        SeleniumUtils.waitPlease(2);
        multipleSelectionSelect.selectByVisibleText("Java");
        SeleniumUtils.waitPlease(2);
        multipleSelectionSelect.selectByVisibleText("JavaScript");
        SeleniumUtils.waitPlease(2);
    }
}
