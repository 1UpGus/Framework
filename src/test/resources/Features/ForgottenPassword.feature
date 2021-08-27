@parallel
Feature: Forgotten Password

  @logo
  Scenario: Recovering forgotten password
  User is not registered on the page

    Given I go to "Sign in" page
    And I click on "Forgot your password?" link
    When I set "gus@gmail.com" on the Email address box
    And I click on "Retrieve Password" button
    Then  I see message "There is 1 error"
    And  I see message "There is no account registered for this email address"