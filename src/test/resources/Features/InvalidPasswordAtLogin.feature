@parallel
Feature: User Authentication - invalid password at login

  @invalidPassword
  Scenario: User authentication verification
  User set valid email and invalid password information

    Given I go to "Sign in" page
    And I set "gus@gmail.com" on the Email address box
    And I set "abcd" on the Password box
    When I click on Sign in button
    Then I see message "There is 1 error"
    And I see message "Invalid password"