@Smoke @E2E @CSV
Feature: End to End Flow  

  Scenario: CSV based user flow

    Given user data is loaded
    And user registers
    And user is logged into the application
    When user searches for a product
    And user adds product to wishlist
    And user adds product to cart
    And user completes checkout
    Then user logs out successfully