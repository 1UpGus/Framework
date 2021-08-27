package com.ui.stepdefinitions;

import com.ui.pages.ShoppingCartPage;
import io.cucumber.java.en.And;

public class ShoppingCartSteps extends BaseSteps{

    @And("^I click on the trash bin icon$")
    public void iClickOnTheTrashBinIcon() throws Throwable {
        ShoppingCartPage.clickingOnTheTrashBinIcon();
    }

}



