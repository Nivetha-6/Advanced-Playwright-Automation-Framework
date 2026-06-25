Feature: Logout

Scenario: Logout user
  Given user in the login page
  When user clicked logout
  Then user should have been logged out