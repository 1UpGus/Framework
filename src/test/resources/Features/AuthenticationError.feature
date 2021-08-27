@parallel
Feature: User Authentication - Email and Password empty at login

  @empty
  Scenario: User authentication verification
  User do not fill both email nor password information

    Given I go to "Sign in" page
    But The Email address box is empty
    * The Password box is empty
    When I click on Sign in button
    Then I see message "There is 1 error"
    And I see message "An email address required"
