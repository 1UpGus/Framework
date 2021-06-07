package com.ui.stepdefinitions;

import com.ui.pages.GenericPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class GenericSteps extends BaseSteps {

    @Given("^I am on ([^\"]*)$")
    public void iAmOnHomePage(String something) throws Throwable {
    }

    @Given("^I go to \"([^\"]*)\" page$")
    public void iGoToSomePage(String page) throws Throwable {
        GenericPage.getPage(page);
    }

    //ASK JOSEPH ABOUT THAT METHOD!
    @And("^I click on \"([^\"]*)\" ([^\"]*)$")
    public void iClickOnSomething(String element, String clickable) throws Throwable {
        GenericPage.clickOnSomething(element, clickable);
    }

    @Then("^I see message \"([^\"]*)\"$")
    public void iSeeMessageSomething(String message) throws Throwable {
        GenericPage.iSeeAnyTextOnThePage(message);
    }
}


























