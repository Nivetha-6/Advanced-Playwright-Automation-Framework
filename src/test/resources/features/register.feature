Feature: User Registration

  Scenario: Register with valid details
    Given user is on registration page
    When user enters registration details
    Then user account should be created successfully