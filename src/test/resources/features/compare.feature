Feature: Compare Products

Scenario: Compare two products

Given user is on product listing page
When user adds products to compare
And user opens compare page
Then products should be compared successfully