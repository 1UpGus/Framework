package com.ui.stepdefinitions;

import com.ui.pages.ForgotPasswordPage;
import com.ui.pages.SignInPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class SignInPageSteps extends BaseSteps {

    //@When("I enter \"([^\"]*)\"(?: and \"([^\"]*)\")?$")
    @When("^I enter \"([^\"]*)\" and \"([^\"]*)\"$")
    public void iEnterSomethingAndSomething(String username, String password) throws Throwable {
        SignInPage.enterUsernameAndPassword(username,password);
    }

}