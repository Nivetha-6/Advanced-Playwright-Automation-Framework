Feature: Cart Functionality

Scenario: Add product to cart
  Given user is logged in
  When user adds product to cart
  Then product should be added successfully