package com.ui.stepdefinitions;

import com.ui.pages.SignInPage;
import io.cucumber.java.en.And;


public class SignInPageSteps extends BaseSteps {

    @And("^I set \"([^\"]*)\" on the (Create Account Email address|Email address|Password) box$")
    public void iEnterSomething(String userDetailsText, String elementTextBox) throws Throwable {
        SignInPage.enterUserDetails(userDetailsText, elementTextBox);
    }

    @And("^I click on Sign in button$")
    public void iClickOnSignInButton() throws Throwable {
        SignInPage.clickOnSignInButton();
    }

    @And("^The (Email address|Password) box is empty$")
    public void theEmailAddressBoxIsEmpty(String elementTextBox) throws Throwable {
        SignInPage.clearingEmptyTextBox(elementTextBox);
    }

    
}