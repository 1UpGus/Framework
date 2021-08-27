@parallel
Feature: Adding and removing item to cart

  @removeItem
  Scenario: Adding and removing any item to cart

    Given I go to "Women" page
    And I click on "Faded Short Sleeve T-shirts" link
    * I click on "Add to cart" button
    When I click on "Proceed to checkout" button
    And I click on the trash bin icon
    Then I see message "Your shopping cart is empty"