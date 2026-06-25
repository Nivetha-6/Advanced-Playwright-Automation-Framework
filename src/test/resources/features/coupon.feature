Feature: Coupon Validation

Scenario: Apply discount coupon

Given user has product in cart
When user applies valid coupon
Then discount should be applied