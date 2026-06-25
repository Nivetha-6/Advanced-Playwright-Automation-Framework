Feature: Wishlist Function

Scenario: Add product in wishlist
  Given user is in WISHLIST section
  When user select a product to put inside wishlist
  When user selected and clicked the wishlist option
  Then wishlist should be added in that section