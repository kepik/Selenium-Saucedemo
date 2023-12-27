@login #tag login that will be inherit the next tags
Feature: Login

  @valid-login
  Scenario: Login with valid username and password
    Given User is on the login page
    And User input username with "standard_user"
    And User input password with "secret_sauce"
    When User click on the login button
    Then User will be redirected to the homepage

  @invalid-login
  Scenario: Login with invalid username and password
    Given User is on the login page
    And User input username with "standard_user"
    And User input password with "wrong_pass"
    When User click on the login button
    Then An error message will be displayed "Epic sadface: Username and password do not match any user in this service"
