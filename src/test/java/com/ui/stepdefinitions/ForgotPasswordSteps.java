package com.ui.stepdefinitions;

import com.ui.pages.ForgotPasswordPage;
import com.ui.pages.SignInPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
//import sun.jvm.hotspot.debugger.Page;

public class ForgotPasswordSteps extends BaseSteps{

    @And("^I enter \"([^\"]*)\"$")
    public void iEnterSomething(String emailAddress) throws Throwable {
        ForgotPasswordPage.enterUserEmailAddress(emailAddress);
    }

}
