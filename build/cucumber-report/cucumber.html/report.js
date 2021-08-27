$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/Features/RemovingFromCart.feature");
formatter.feature({
  "name": "Adding and removing item to cart",
  "description": "",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@parallel"
    }
  ]
});
formatter.scenario({
  "name": "Adding and removing any item to cart",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@parallel"
    },
    {
      "name": "@removeItem"
    }
  ]
});
formatter.before({
  "error_message": "java.lang.IllegalStateException: The path to the driver executable must be set by the webdriver.edge.driver system property; for more information, see https://github.com/SeleniumHQ/selenium/wiki/MicrosoftWebDriver. The latest version can be downloaded from http://go.microsoft.com/fwlink/?LinkId\u003d619687\r\n\tat com.google.common.base.Preconditions.checkState(Preconditions.java:847)\r\n\tat org.openqa.selenium.remote.service.DriverService.findExecutable(DriverService.java:134)\r\n\tat org.openqa.selenium.edge.EdgeDriverService.access$000(EdgeDriverService.java:37)\r\n\tat org.openqa.selenium.edge.EdgeDriverService$Builder.findDefaultExecutable(EdgeDriverService.java:90)\r\n\tat org.openqa.selenium.remote.service.DriverService$Builder.build(DriverService.java:355)\r\n\tat org.openqa.selenium.edge.EdgeDriverService.createDefaultService(EdgeDriverService.java:70)\r\n\tat org.openqa.selenium.edge.EdgeDriver.\u003cinit\u003e(EdgeDriver.java:96)\r\n\tat com.ui.stepdefinitions.Hooks.openBrowser(Hooks.java:30)\r\n",
  "status": "failed"
});
formatter.step({
  "name": "I go to \"Women\" page",
  "keyword": "Given "
});
formatter.match({
  "location": "com.ui.stepdefinitions.GenericSteps.iGoToSomePage(java.lang.String)"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "I click on \"Faded Short Sleeve T-shirts\" link",
  "keyword": "And "
});
formatter.match({
  "location": "com.ui.stepdefinitions.GenericSteps.iClickOnButtonOrLink(java.lang.String)"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "I click on \"Add to cart\" button",
  "keyword": "* "
});
formatter.match({
  "location": "com.ui.stepdefinitions.GenericSteps.iClickOnButtonOrLink(java.lang.String)"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "I click on \"Proceed to checkout\" button",
  "keyword": "When "
});
formatter.match({
  "location": "com.ui.stepdefinitions.GenericSteps.iClickOnButtonOrLink(java.lang.String)"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "I click on the trash bin icon",
  "keyword": "And "
});
formatter.match({
  "location": "com.ui.stepdefinitions.ShoppingCartSteps.iClickOnTheTrashBinIcon()"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "I see message \"Your shopping cart is empty\"",
  "keyword": "Then "
});
formatter.match({
  "location": "com.ui.stepdefinitions.GenericSteps.iSeeMessageSomething(java.lang.String)"
});
formatter.result({
  "status": "skipped"
});
formatter.after({
  "error_message": "java.lang.NullPointerException\r\n\tat com.ui.stepdefinitions.Hooks.closeBrowser(Hooks.java:36)\r\n",
  "status": "failed"
});
formatter.after({
  "error_message": "java.lang.NullPointerException\r\n\tat com.ui.stepdefinitions.Hooks.embedScreenshot(Hooks.java:46)\r\n",
  "status": "failed"
});
});
