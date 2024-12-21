Feature: Client Login

  Scenario: Successful login with valid credentials
    Given User is on the home page and navigating to login page
    When User enter a valid username and password
    And User click the login button
    And User should see a welcome message with the username

  Scenario: Unsuccessful login with invalid credentials
    Given User is on the home page and navigating to login page
    When User enter an invalid username and password
    And User click the login button
    Then User should see an error message "Login failed. Please try again."
