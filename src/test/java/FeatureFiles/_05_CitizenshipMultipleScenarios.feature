#Senaryo
#CitizenShip sayfasına gidiniz.
#Create işlemini parameter yöntemi ile doğrulayınız.
#Daha sonra aynı bilgilerle tekrar Create yapılamadığını doğrulayınız. (negatif test)
#Ayrı sebaryoda girilen bilgiyi silme işlemini doğrulayınız

 Feature: Citizenship Multi Scenario

  Background: #before scenario
    Given Navigate to Campus
    When Enter username and password and click login button
    Then User should logged in successfully
    And Navigate to citizenships

  Scenario: Create a Citizenship
    When Create a citizenship name as "KryArgentinaste" shortname as "524794"
    Then Success message should be displayed

  Scenario: Create a Citizenship Negative
    When Create a citizenship name as "KryArgentinaste" shortname as "126827230"
    Then Already exist message should be displayed

  Scenario: Delete Citizenship
    When user delete name as "Dr.h"
    Then Success message should be displayed
