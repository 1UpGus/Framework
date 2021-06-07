package com.ui.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static com.google.common.truth.Truth.assertWithMessage;

public class GenericPage extends BasePage {

    private static Logger log = LogManager.getLogger(GenericPage.class);

    public static void getPage(String page) throws Exception {
        log.info("Going to " + page + " page");
        switch (page) {
            case "Sign in":
                driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
                break;
            case "Women":
                driver.get("http://automationpractice.com/index.php?id_category=3&controller=category");
                break;
            case "Contact us":
                driver.get("http://automationpractice.com/index.php?controller=contact");
                break;
            default:
                throw new Exception("For the page '" + page + "' url is not defined");
        }
    }

//    ASK JOSEPH ABOUT THAT METHOD!
    public static void clickOnSomething(String element1, String clickable) throws Exception {
        log.info("Clicking on " + clickable + " => '" + element1 + "'");
        WebElement element = waitForVisibleElement(By.xpath("//*[contains(text(),'" + element1 + "')] | //*[@id='" + element1 + "'] | //*[contains(@title,'" + element1 + "')]"));
        element.click();
    }

    public static void iSeeAnyTextOnThePage(String message) throws Exception {
        log.info("Going to assert => '" + message + "'");
        WebElement element = waitForVisibleElement(By.xpath("//*[contains(text(),'" + message + "')]"));
        assertWithMessage("Text => '" + message + "' <= is not visible").that(element.isDisplayed()).isTrue();
    }
}

