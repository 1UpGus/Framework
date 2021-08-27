$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/Features/UserAuthentication.feature");
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
  "name": "User authentication verification",
  "description": "  User is not registered on the page",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@parallel"
    },
    {
      "name": "@test"
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
  "name": "I set email address \"gus@gmail.com\" and password \"1q2w3e4r5t\" to login",
  "keyword": "When "
});
formatter.match({
  "location": "com.ui.stepdefinitions.SignInPageSteps.iSetEmailAndPasswordToLogin(java.lang.String,java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I click on \"SubmitLogin\" button",
  "keyword": "And "
});
formatter.match({
  "location": "com.ui.stepdefinitions.GenericSteps.iClickOnButtonOrLink(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I see message \"There is 1 error\"",
  "keyword": "Then "
});
formatter.match({
  "location": "com.ui.stepdefinitions.GenericSteps.iSeeMessageSomething(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I see message \"Authentication failed.\"",
  "keyword": "And "
});
formatter.match({
  "location": "com.ui.stepdefinitions.GenericSteps.iSeeMessageSomething(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
});