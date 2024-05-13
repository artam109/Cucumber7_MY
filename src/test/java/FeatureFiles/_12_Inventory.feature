#Inventory Formunun Çalışmasını test ediniz
#Inventory girişi yapıp
#sonrasında silmesini yapınız

Feature:

  Background:
    Given Navigate to Campus
    When Enter username and password and click login button
    Then User should logged in successfully

  Scenario Outline: Inventory Functionality and Delete

    And Click on the Element in LeftNav
      | inventory      |
      | inventorySetup |
      | itemCategories |

    And Click on the Element in Dialog
      | addButton |

    And User sending the keys in Dialog
      | nameInput | <name> |

    And Click on the Element in Dialog
      | userType |
      | <type>   |

    And Click on the Element in Dialog
      | saveButton |

    Then Success message should be displayed

    And User delete the Element from Dialog
      | <name> |

    Then Success message should be displayed
    Examples:
      | name    | type          |
      | isInv14 | student       |
      | isInv24 | administrator |
      | isInv34 | student       |
      | isInv44 | administrator |
      | isInv54 | student       |
