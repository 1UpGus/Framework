@parallel
Feature: User Authentication - invalid email at login

  @invalidEmail
  Scenario: User authentication verification
  User set invalid email and valid password information

    Given I go to "Sign in" page
    And I set "gus@gmailcom" on the Email address box
    And I set "1q2w3e4r5t" on the Password box
    When I click on Sign in button
    Then I see message "There is 1 error"
    And I see message "Invalid email address"