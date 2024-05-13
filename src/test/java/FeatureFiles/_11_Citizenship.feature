#CitizenShip menusunun kayıt ve silme özelliğini
#(DataTable ile) 5 farklı değer seti ile çalıştırınız.

Feature:

  Background:
    Given Navigate to Campus
    When Enter username and password and click login button
    Then User should logged in successfully

  Scenario Outline: Nationality Functionality and Delete
    And Click on the Element in LeftNav
      | setup        |
      | parameters   |
      | citizenships |

    And Click on the Element in Dialog
      | addButton |

    And User sending the keys in Dialog
      | nameInput | <name>      |
      | shortName | <shortname> |

    And Click on the Element in Dialog
      | saveButton |

    Then Success message should be displayed

    And User delete the Element from Dialog
      | <name> |

    Then Success message should be displayed

    Examples:
      | name       | shortname |
      | wisdom     | wiom      |
      | farming    | faing     |
      | thermal    | thmal     |
      | fires      | fis       |
      | categories | cagors    |


