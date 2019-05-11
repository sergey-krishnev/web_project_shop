Feature: Login to shop service

  Scenario: Login with correct username and password
    Given a User admin exists with password admin
    When I fill in username with "admin"
    And I fill in password with "admin"
    And I press login
    Then I should be on the home page