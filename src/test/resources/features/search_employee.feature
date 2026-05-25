Feature: Search employee in PIM

  Scenario Outline: Search employee by employee id
    Given The admin is authenticated in OrangeHRM for employee search
    And The admin is on the employee list page
    When The admin searches employee by id "<EmployeeId>"
    Then The employee with id "<EmployeeId>" should be displayed in the results

    Examples:
      | EmployeeId |
      | 0295       |
      | 0087       |

  Scenario Outline: Search employee by non-existent id
    Given The admin is authenticated in OrangeHRM for employee search
    And The admin is on the employee list page
    When The admin searches employee by id "<EmployeeId>"
    Then A "<ExpectedMessage>" message should be displayed

    Examples:
      | EmployeeId | ExpectedMessage  |
      | 999999     | No Records Found |
      | ABC123     | No Records Found |