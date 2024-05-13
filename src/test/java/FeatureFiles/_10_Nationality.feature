#Nationality menusunun kayıt ve silme özelliğini
#DataTable ile 5 fakrlı değer seti ile çalıştırınız.

Feature:

  Background:
    Given Navigate to Campus
    When Enter username and password and click login button
    Then User should logged in successfully

  Scenario Outline: Nationality Functionality and Delete
    And Click on the Element in LeftNav
      | setup         |
      | parameters    |
      | nationalities |

    And Click on the Element in Dialog
      | addButton |

#    And User sending random word to Dialog
#      | nameInput |

    And User sending the keys in Dialog
      | nameInput | <name> |

    And Click on the Element in Dialog
      | saveButton |

    Then Success message should be displayed

    And User delete the Element from Dialog
      | <name> |

#    And User delete the random created Element from Dialog

    Then Success message should be displayed

    Examples:
      | name       |
      | wisdom     |
      | thermal    |
      | farming    |
      | fires      |
      | categories |


