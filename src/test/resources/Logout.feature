@logout
Feature: Logout

  Scenario: Logout from the Saucedemo page
    Given User is on the homepage
    When User click on the BurgerMenu
    And Click on the Logout menu
    Then The page is redirected to the login page