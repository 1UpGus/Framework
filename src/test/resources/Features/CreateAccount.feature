@parallel
Feature: Create an account

  @create
  Scenario: User creates a new account

    Given I go to "Sign in" page
    When I set "gus@gmail.com" on the Create Account Email address box
    * I enter password "sddklfnsldkn"
    * I click on "SubmitCreate" Button
    When I enter user personal information
      | Field                                        | Information               |
      | Title                                        | Mr                        |
      | First name                                   | Gus                       |
      | Last name                                    | Andrade                   |
      | Password                                     | 1q2w3e4r5t                |
      | Day of birth                                 | 10                        |
      | Month of birth                               | September                 |
      | Year of birth                                | 1987                      |
      | Company                                      | Testing&Co                |
      | Address                                      | Times Square              |
      | Address (Line 2)                             | Apart 1                   |
      | City                                         | New York                  |
      | State                                        | New York                  |
      | Zip/Postal Code                              | E1 8GF                    |
      | Additional information                       | No additional information |
      | Home phone                                   | +12123456789              |
      | Mobile phone                                 | +12121236789              |
      | Assign an address alias for future reference | My Address                |
    * I click on "Register" button
    Then  I see message "There is 1 error"
    * I see message "There is no account registered for this email address"