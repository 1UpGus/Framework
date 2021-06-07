@parallel
Feature: Add item to cart

  @addtocart
  Scenario: Adding any item to cart

    Given I go to "Women" page
    And I click on "Faded Short Sleeve T-shirts" link
    When I click on "Add to cart" Button
    Then  I see message "Product successfully added to your shopping cart"