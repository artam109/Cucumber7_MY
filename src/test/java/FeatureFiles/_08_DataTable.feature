Feature: DataTable Functionality

  Background:
    Given Navigate to Campus
    When Enter username and password and click login button
    Then User should logged in successfully

  Scenario: Create Country
    And Click on the Element in LeftNav
      | setup      |
      | parameters |
      | countries  |

    And Click on the Element in Dialog
      | addButton |

    And User sending the keys in Dialog
      | nameInput | artam |
      | codeInput | cibo  |

    And Click on the Element in Dialog
      | saveButton |

    Then Success message should be displayed

    And User delete the Element from Dialog
      | artam |

    Then Success message should be displayed


  Scenario: Create Citizenship
    And Click on the Element in LeftNav
      | setup        |
      | parameters   |
      | citizenships |

    And Click on the Element in Dialog
      | addButton |

    And User sending the keys in Dialog
      | nameInput | artam |
      | shortName | cibo  |

    And Click on the Element in Dialog
      | saveButton |

    Then Success message should be displayed

    And User delete the Element from Dialog
      | artam |

    Then Success message should be displayed

  Scenario: Create Nationality and Delete
    And Click on the Element in LeftNav
      | setup         |
      | parameters    |
      | nationalities |

    And Click on the Element in Dialog
      | addButton |

    And User sending the keys in Dialog
      | nameInput | Xenomorph |

    And Click on the Element in Dialog
      | saveButton |

    Then Success message should be displayed

    And User delete the Element from Dialog
      | Xenomorph |

    Then Success message should be displayed

  Scenario: Fee Functionality and Delete
    And Click on the Element in LeftNav
      | setup      |
      | parameters |
      | fees       |

    And Click on the Element in Dialog
      | addButton |

    And User sending the keys in Dialog
      | nameInput       | side    |
      | codeInput       | kingdom |
      | integrationCode | 634     |
      | priorityInput   | 1248664 |


    And Click on the Element in Dialog
      | toggleBar  |
      | saveButton |

    Then Success message should be displayed

    And User delete the Element from Dialog
      | side |

    Then Success message should be displayed



