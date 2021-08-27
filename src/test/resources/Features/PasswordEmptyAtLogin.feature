@parallel
Feature: User Authentication - Password empty at login

  @passwordEmpty
  Scenario: User authentication verification
  User fill email but do not fill password information

    Given I go to "Sign in" page
    And I set "gus@gmail.com" on the Email address box
    But The Password box is empty
    When I click on Sign in button
    Then I see message "There is 1 error"
    And I see message "Password is required"
