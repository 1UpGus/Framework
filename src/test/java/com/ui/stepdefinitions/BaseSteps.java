package com.ui.stepdefinitions;

import com.ui.pages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;


public class BaseSteps {
    public WebDriver driver = Hooks.driver;

    public BaseSteps() {
        PageFactory.initElements(driver, SignInPage.class);
        PageFactory.initElements(driver, ForgotPasswordPage.class);
        PageFactory.initElements(driver, GenericPage.class);
        PageFactory.initElements(driver, HomePage.class);
        PageFactory.initElements(driver, CreateAccountPage.class);
        PageFactory.initElements(driver, ShoppingCartPage.class);
    }
}



