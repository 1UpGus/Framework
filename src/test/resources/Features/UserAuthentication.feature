@parallel
Feature: User Authentication

  @test
  Scenario: User authentication verification
  User is not registered on the page

    Given I go to "Sign in" page
    When I enter "gus@gmail.com" and "1q2w3e4r5t"
    And I click on "SubmitLogin" button
    Then I see message "There is 1 error"
    And I see message "Authentication failed."



