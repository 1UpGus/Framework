package com.ui.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.google.common.truth.Truth.assertWithMessage;

public class SignInPage extends BasePage {

    @FindBy(id = "email")
    public static WebElement emailAddressTextBox;
    @FindBy(id = "passwd")
    public static WebElement passwordTextBox;

    private static Logger log = LogManager.getLogger(SignInPage.class);

    public static void enterUsernameAndPassword(String username, String password) {
        log.info("Entering user details '" + username + "' and '" + password + "'");
        waitForElementToBeVisible(emailAddressTextBox);
        emailAddressTextBox.sendKeys(username);
        waitForElementToBeVisible(passwordTextBox);
        passwordTextBox.sendKeys(password);
    }
}
