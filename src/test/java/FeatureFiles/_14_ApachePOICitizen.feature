Feature: ApachePOI Citizen functionality

  Background:
    Given Navigate to Campus
    When Enter username and password and click login button
    Then User should logged in successfully
    And Navigate to citizenships


  Scenario: Create and Delete CitizenShip from excel
    When User create citizenship with ApachePOI
    Then User delete citizenship with ApachePOI