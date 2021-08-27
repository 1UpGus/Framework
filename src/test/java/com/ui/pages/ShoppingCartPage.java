package com.ui.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ShoppingCartPage extends BasePage{

    private static Logger log = LogManager.getLogger(ShoppingCartPage.class);

    public static void clickingOnTheTrashBinIcon() throws Exception {
        log.info("Clicking on the trash bin icon");
        WebElement element = waitForVisibleElement(By.className("icon-trash"));
        waitAndClickWithRetry(element);
    }
}
