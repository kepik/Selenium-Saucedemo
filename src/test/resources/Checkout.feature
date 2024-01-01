@checkout
Feature: Checkout

  @add-product
  Scenario: Add a product to the cart
    Given User is logged in
    When User click on the Add to Cart button
    And The product is added into the cart
    Then Validate the product in the cart

  @checkout-finish
  Scenario: Checkout an item
    Given User is logged in
    And User click on the Add to Cart button
    And The product is added into the cart
    And Validate the product in the cart
    And User click on the Checkout button
    And User input info details "First Name", "Last Name", "123"
    When Click the Continue button
    And Click the Finish button
    Then The page shows page "Thank you for your order!"