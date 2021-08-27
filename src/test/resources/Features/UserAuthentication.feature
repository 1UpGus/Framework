@parallel
Feature: User Authentication

  @login
  Scenario: User authentication verification
  User is not registered on the page

    Given I go to "Sign in" page
    When I set "gus@gmail.com" on the Email address box
    And I set "1q2w3e4r5t" on the Password box
    And I click on Sign in button
    Then I see message "There is 1 error"
    And I see message "Authentication failed"
