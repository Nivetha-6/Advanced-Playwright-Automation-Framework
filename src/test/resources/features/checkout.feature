Feature: Checkout

Scenario: Complete checkout
  Given user has items in cart
  When user completes checkout
  Then order should be placed successfully