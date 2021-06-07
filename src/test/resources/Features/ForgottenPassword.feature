@parallel
Feature: Forgotten Password

  @logo
  Scenario: Recovering forgotten password
  User is not registered on the page

    Given I go to "Sign in" page
    And I click on "Forgot your password?" link
    When I enter "gus@gmail.com"
    And I click on "Retrieve Password" Button
    Then  I see message "There is 1 error"
    And  I see message "There is no account registered for this email address"