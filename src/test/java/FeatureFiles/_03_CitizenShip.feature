Feature: CitizenShip Functionality

  @SmokeTest
  Scenario: Create Citizenship

    Given Navigate to Campus
    When Enter username and password and click login button
    Then User should logged in successfully
    And Navigate to citizenships
    When Create a citizenship
    Then Success message should be displayed