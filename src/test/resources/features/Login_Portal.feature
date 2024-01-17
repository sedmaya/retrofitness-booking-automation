@login-portal @regression

Feature: WebDriver University - Login Portal Page

  Background:
    Given I access to Login Portal

  Scenario Outline: Verify login validation message
    When I enter username <username>
    And I enter password <password>
    And I click on the login button
    Then I should be presented with alert <loginValidationMessage>

    Examples:
      | username   | password      | loginValidationMessage |
      | webdriver  | webdriver123  | validation succeeded   |
      | webdriver1 | webdriver123  | validation failed      |
      | webdriver  | webdriver1234 | validation failed      |
      | webdriver1 | webdriver1234 | validation failed      |
