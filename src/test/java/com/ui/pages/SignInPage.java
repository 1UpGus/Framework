package com.ui.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignInPage extends BasePage {

    @FindBy(id = "email")
    public static WebElement emailAddressTextBox;
    @FindBy(id = "passwd")
    public static WebElement passwordTextBox;
    @FindBy(id = "email_create")
    public static WebElement createAccountEmailAddressTextBox;


    private static Logger log = LogManager.getLogger(SignInPage.class);

    public static void enterUserDetails(String userDetailText, String elementTextBox) throws Exception {
        if (elementTextBox.equals("Email address")) {
            log.info("Entering user email address: '" + userDetailText + "'");
            waitForElementToBeVisible(emailAddressTextBox);
            emailAddressTextBox.sendKeys(userDetailText);
        } else if (elementTextBox.equals("Create Account Email address")) {
            log.info("Entering user email address: '" + userDetailText + "' to create a new account");
            waitForElementToBeVisible(createAccountEmailAddressTextBox);
            createAccountEmailAddressTextBox.sendKeys(userDetailText);
        } else {
            log.info("Entering user password: '" + userDetailText + "'");
            waitForElementToBeVisible(passwordTextBox);
            passwordTextBox.sendKeys(userDetailText);
        }
    }

    public static void clickOnSignInButton() throws Exception {
        log.info("Clicking on Sign in button");
        WebElement element = waitForVisibleElement(By.id("SubmitLogin"));
        waitAndClickWithRetry(element);
    }

    public static void clearingEmptyTextBox(String elementTextBox) throws Exception {
        log.info("Cleaning text box: '" + elementTextBox + "'");
        if (elementTextBox.equals("Email address")) {
            waitForElementToBeVisible(emailAddressTextBox);
            emailAddressTextBox.clear();
        } else {
            waitForElementToBeVisible(passwordTextBox);
            passwordTextBox.clear();
        }
    }
}