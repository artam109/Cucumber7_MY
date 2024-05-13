Feature: Data table example

  Scenario: Users List
    When write username "Artam"

    And write username and password "Artam" and "1245"

    And write username as DataTable
      | artam     |
      | Markel    |
      | Stepanie  |
      | Marquist  |
      | Nicodemus |
      | Nyla      |

    And write username and password as DataTable
      | artam     | 4235   |
      | Markel    | 745754 |
      | Stepanie  | 23545  |
      | Marquist  | 685213 |
      | Nicodemus | 1523   |
      | Nyla      | 754    |


 #  dataProvider (TestNG için), Senaryo Outline (cucumber)
 #  görevi verilen her değer için, tüm senayo çalışır
 #
 #  DataTable ise , sadece bir step e, çoklu parametre vermek
 #  için kullanılır, sadece 1 kez tüm parametreleri stepin içine atar
