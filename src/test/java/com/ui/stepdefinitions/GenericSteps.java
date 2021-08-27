package com.ui.stepdefinitions;

import com.ui.pages.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class GenericSteps extends BaseSteps {

    @Given("^I am on ([^\"]*)$")
    public void iAmOnHomePage(String something) {
    }

    @Given("^I go to \"([^\"]*)\" page$")
    public void iGoToSomePage(String page) throws Throwable {
        GenericPage.getPage(page);
    }

    //@When("I enter \"([^\"]*)\"(?: and \"([^\"]*)\")?$")
    @When("^I enter \"([^\"]*)\" on \"([^\"]*)\" field$")
    public void iEnterTextOnField(String text, String elementTextBox) throws Throwable {
        GenericPage.enterTextOnField(text, elementTextBox);
    }

    @And("^I click on \"([^\"]*)\" (?:button|link)$")
    public void iClickOnButtonOrLink(String elementText) throws Throwable {
        GenericPage.clickOnElementText(elementText);
    }

    @Then("^I see message \"([^\"]*)\"$")
    public void iSeeMessageSomething(String message) throws Throwable {
        GenericPage.iSeeAnyTextOnThePage(message);
    }
}


























