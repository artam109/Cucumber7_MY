#Senaryo :
#  Exam Formunun Çalışmasını test ediniz
#  1 sınav girişi yapıp
#  sonrasında silmesini yapınız
#  Yukarıdaki adımları 4 farklı değer seti için tekrarlatınız.

Feature:

  Background:
    Given Navigate to Campus
    When Enter username and password and click login button
    Then User should logged in successfully

  Scenario Outline: Inventory Functionality and Delete

    And Click on the Element in LeftNav
      | entranceExams    |
      | entranceSetup    |
      | subEntranceExams |

    And Click on the Element in Dialog
      | addButton |

    And User sending the keys in Dialog
      | nameInput | <name> |

    And Click on the Element in Dialog
      | academicPeriod |
      | internship     |

    And Click on the Element in Dialog
      | gradeLevel |

    And Click on the Element in Dialog
      | firstMatOption |

    And Click on the Element in Dialog
      | saveButton |

    And Click on the Element in Dialog
      | newExamBar |

    Then Success message should be displayed

    And User delete the Element from Dialog
      | <name> |

    Then Success message should be displayed

    Examples:
      | name   |
      | heart1 |
      | heart2 |
      | heart3 |
      | heart4 |
      | heart5 |