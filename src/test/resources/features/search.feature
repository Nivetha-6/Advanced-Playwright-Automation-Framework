Feature: Search Product

Scenario: Search product
  Given user logged in
  When user search for "book"
  Then results will be displayed on the screen