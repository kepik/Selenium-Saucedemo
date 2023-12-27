@checkout
Feature: Checkout

  @add-product
  Scenario: Add a product to the cart
    Given User is already login
    When User click on the Add to Cart button
    Then The product is added into the cart
    And Validate the product in the cart

  @checkout-finish
  Scenario: Checkout an item
    Given The product is added to the cart
    And User click on the Checkout button
    And User input "First Name", "Last Name", "123456"
    When Click the Continue button
    And Click the Finish button
    Then The page shows page "Thank you for your order!"