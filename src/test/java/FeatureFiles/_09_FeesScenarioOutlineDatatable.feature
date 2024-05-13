Feature:

  Background:
    Given Navigate to Campus
    When Enter username and password and click login button
    Then User should logged in successfully

  Scenario Outline: Fee Functionality and Delete
    And Click on the Element in LeftNav
      | setup      |
      | parameters |
      | fees       |

    And Click on the Element in Dialog
      | addButton |

    And User sending the keys in Dialog
      | nameInput       | <name>     |
      | codeInput       | <code>     |
      | integrationCode | <intCode>  |
      | priorityInput    | <priority> |

    And Click on the Element in Dialog
      | toggleBar  |
      | saveButton |

    Then Success message should be displayed

    And User delete the Element from Dialog
      | <name> |

    Then Success message should be displayed

    Examples:
      | name      | code  | intCode  | priority |
      | burning1  | 239412 | PayPal   | 45667    |
      | burning13 | 239422 | Cash     | 45668    |
      | burning14 | 239432 | Cheque   | 45663    |
      | burning12 | 239442 | ApplePay | 45661    |
      | burning16 | 239452 | Crypto   | 456679    |