Feature: Country Multi Scenario

  Background: #before scenario
    Given Navigate to Campus
    When Enter username and password and click login button
    Then User should logged in successfully
    And Navigate to country

  @Regression
  Scenario: Create a Country
    When Create a country
    Then Success message should be displayed

  Scenario: Create a Country 2
    When Create a country name as "runtime" code as "Lvl9"
    Then Success message should be displayed
