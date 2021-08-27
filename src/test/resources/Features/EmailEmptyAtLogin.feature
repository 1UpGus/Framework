@parallel
Feature: User Authentication - Email empty at login

  @emailEmpty
  Scenario: User authentication verification
  User do not fill email but fill password information

    Given I go to "Sign in" page
    And The Email address box is empty
    But I set "1q2w3e4r5t" on the Password box
    And I click on Sign in button
    Then I see message "There is 1 error"
    And I see message "An email address required"