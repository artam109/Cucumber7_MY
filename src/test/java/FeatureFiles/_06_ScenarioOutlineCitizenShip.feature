Feature: Citizenship Outline

  Background: #before scenario
    Given Navigate to Campus
    When Enter username and password and click login button
    Then User should logged in successfully
    And Navigate to citizenships

  Scenario Outline: Create a Citizenship with parameter
    When Create a citizenship name as "<name>" shortname as "<shortname>"
    Then Success message should be displayed

    When Create a citizenship name as "<name>" shortname as "<shortname>"
    Then Already exist message should be displayed

    When user delete name as "<name>"
    Then Success message should be displayed
    Examples:
      | name    | shortname   |
      | polar18 | librarian13 |
      | polar28 | librarian23 |
      | polar38 | librarian33 |
      | polar48 | librarian43 |
      | polar58 | librarian53 |