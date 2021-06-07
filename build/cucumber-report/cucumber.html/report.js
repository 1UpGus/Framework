$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/Features/UserAuthenticationExample.feature");
formatter.feature({
  "name": "User Authentication",
  "description": "",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@parallel"
    }
  ]
});
formatter.scenario({
  "name": "Recovering forgotten password",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@parallel"
    },
    {
      "name": "@Test2"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "I go to \"Sign in\" page",
  "keyword": "Given "
});
formatter.match({
  "location": "com.ui.stepdefinitions.GenericSteps.iGoToSomePage(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I click on \"Forgot your password?\" link",
  "keyword": "When "
});
formatter.match({
  "location": "com.ui.stepdefinitions.GenericSteps.iClickOnButtonOrLink(java.lang.String,java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I enter \"gus@gmail.com\"",
  "keyword": "And "
});
formatter.match({
  "location": "com.ui.stepdefinitions.ForgotPasswordSteps.iEnterSomething(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I click on \"Retrieve Password\" button",
  "keyword": "And "
});
formatter.match({
  "location": "com.ui.stepdefinitions.GenericSteps.iClickOnButtonOrLink(java.lang.String,java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I see message \"There is no account registered for this email address\"",
  "keyword": "Then "
});
formatter.match({
  "location": "com.ui.stepdefinitions.GenericSteps.iSeeMessageSomething(java.lang.String)"
});
formatter.result({
  "error_message": "java.lang.Exception: No elements became visible. Tried for 18seconds.\r\n\tat com.ui.pages.BasePage.waitForVisibleElement(BasePage.java:224)\r\n\tat com.ui.pages.BasePage.waitForVisibleElement(BasePage.java:204)\r\n\tat com.ui.pages.SignInPage.iSeeAnyTextOnThePage(SignInPage.java:62)\r\n\tat com.ui.stepdefinitions.GenericSteps.iSeeMessageSomething(GenericSteps.java:38)\r\n\tat ✽.I see message \"There is no account registered for this email address\"(file:///D:/SOFTWARE%20TESTING/IdeaProjects/Framework/src/test/resources/Features/UserAuthenticationExample.feature:24)\r\n",
  "status": "failed"
});
formatter.after({
  "status": "passed"
});
});
$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/Features/Example.feature");
formatter.feature({
  "name": "This is example feature",
  "description": "",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@parallel"
    }
  ]
});
formatter.scenario({
  "name": "Recovering forgotten password",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@parallel"
    },
    {
      "name": "@logo"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "I go to \"Sign in\" page",
  "keyword": "Given "
});
formatter.match({
  "location": "com.ui.stepdefinitions.GenericSteps.iGoToSomePage(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I click on \"Forgot your password?\" link",
  "keyword": "When "
});
formatter.match({
  "location": "com.ui.stepdefinitions.GenericSteps.iClickOnButtonOrLink(java.lang.String,java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I enter \"gus@gmail.com\"",
  "keyword": "And "
});
formatter.match({
  "location": "com.ui.stepdefinitions.ForgotPasswordSteps.iEnterSomething(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I click on \"Retrieve Password\" button",
  "keyword": "And "
});
formatter.match({
  "location": "com.ui.stepdefinitions.GenericSteps.iClickOnButtonOrLink(java.lang.String,java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I see message \"There is no account registered for this email address\"",
  "keyword": "Then "
});
formatter.match({
  "location": "com.ui.stepdefinitions.GenericSteps.iSeeMessageSomething(java.lang.String)"
});
formatter.result({
  "error_message": "java.lang.Exception: No elements became visible. Tried for 18seconds.\r\n\tat com.ui.pages.BasePage.waitForVisibleElement(BasePage.java:224)\r\n\tat com.ui.pages.BasePage.waitForVisibleElement(BasePage.java:204)\r\n\tat com.ui.pages.SignInPage.iSeeAnyTextOnThePage(SignInPage.java:62)\r\n\tat com.ui.stepdefinitions.GenericSteps.iSeeMessageSomething(GenericSteps.java:38)\r\n\tat ✽.I see message \"There is no account registered for this email address\"(file:///D:/SOFTWARE%20TESTING/IdeaProjects/Framework/src/test/resources/Features/Example.feature:9)\r\n",
  "status": "failed"
});
formatter.after({
  "status": "passed"
});
});
