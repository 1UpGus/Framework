package com.ui.pages;

import com.ui.stepdefinitions.Hooks;
import org.openqa.selenium.WebDriver;

public class BasePage {
    public static WebDriver driver;

    public void BasePage(){
        driver = Hooks.driver;
    }
}