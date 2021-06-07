package com.ui.pages;

import com.ui.stepdefinitions.ForgotPasswordSteps;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ForgotPasswordPage extends BasePage {

    @FindBy(id = "email")
    public static WebElement emailAddressTextBox;

    private static Logger log = LogManager.getLogger(ForgotPasswordPage.class);

    public static void enterUserEmailAddress(String emailAddress) {
        log.info("Entering user details '" + emailAddress + "'");
        waitForElementToBeVisible(emailAddressTextBox);
        emailAddressTextBox.sendKeys(emailAddress);
    }
}




















