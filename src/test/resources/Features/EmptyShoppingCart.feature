@parallel
Feature: Empty Shopping Cart

  @cart
  Scenario: Checking empty shopping cart

    Given I am on home page
    When I click on "shopping cart" button
    Then  I see message "Your shopping cart is empty"