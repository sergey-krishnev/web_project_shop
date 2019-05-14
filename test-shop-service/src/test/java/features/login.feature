Feature: Login to shop service

  Scenario: Login with correct username and password
    Given a User admin goes to login page
    When I fill in username with "admin"
    And I fill in password with "admin"
    And I press login
    Then I should be on the home page
    When I press the button logout
    Then I should be on the login page

  Scenario: Login with incorrect username and correct password
    Given a User admin goes to login page
    When I fill in username with "odmin"
    And I fill in password with "admin"
    And I press login
    Then I get the message with bad credentials

  Scenario: Login with correct username and incorrect password
    Given a User admin goes to login page
    When I fill in username with "admin"
    And I fill in password with "odmin"
    And I press login
    Then I get the message with bad credentials

  Scenario: Login with incorrect username and password
    Given a User admin goes to login page
    When I fill in username with "odmin"
    When I fill in password with "odmin"
    And I press login
    Then I get the message with bad credentials