@parallel
Feature: Add item to cart without sign in

  @addtocart
  Scenario: Adding any item to cart as a visitor

    Given I go to "Women" page
    And I click on "Faded Short Sleeve T-shirts" link
    When I click on "Add to cart" button
    Then I see message "There is 1 item in your cart"