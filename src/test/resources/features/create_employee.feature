Feature: Create employee in PIM

  Background:
    Given The user is authenticated in OrangeHRM
    And The user is on the Add Employee page

  Scenario Outline: Create a new employee
    When The admin completes employee data: "<FirstName>", "<MiddleName>", "<LastName>"
    And The admin sets employee id "<EmployeeId>"
    And The admin enables login details if "<CreateLogin>"
    And If CreateLogin is "yes", the admin sets login details "<Username>", "<Password>", "<ConfirmPassword>", "<Status>"
    And The admin saves the employee
    Then The user should see the employee profile picture

    Examples:
      | FirstName | MiddleName | LastName | EmployeeId | CreateLogin | Username | Password  | ConfirmPassword | Status  |
      | Juan      | Carlos     | Perez    | 1035       | yes         | jperez   | Passw0rd! | Passw0rd!       | Enabled |
      | Maria     | Elena      | Gomez    | 1036       | yes         | megomez   | Passw0rd! | Passw0rd!       | Enabled |

  Scenario Outline: Prevent employee creation with invalid data
    When The admin tries to create an employee with data "<FirstName>", "<MiddleName>", "<LastName>", "<EmployeeId>", "<CreateLogin>", "<Username>", "<Password>", "<ConfirmPassword>", "<Status>"
    And The admin saves the employee
    Then The employee creation validation message "<ExpectedMessage>" should be displayed

    Examples:
      | FirstName | MiddleName | LastName | EmployeeId | CreateLogin | Username       | Password  | ConfirmPassword | Status  | ExpectedMessage                                       |
      | EMPTY     | Carlos     | Perez    | 910001     | no          | EMPTY          | EMPTY     | EMPTY           | EMPTY   | Required                                              |
      | Pruebas   | Perano     | Sultano  | 0295       | no          | EMPTY          | EMPTY     | EMPTY           | EMPTY   | Employee Id already exists                            |
      | Pruebas   | Perano     | Sultano  | 910002     | yes         | peranito910002 | Ab1       | Ab1             | Enabled | Should have at least 7 characters                     |
      | Pruebas   | Perano     | Sultano  | 910003     | yes         | peranito910003 | PASSW0RD! | PASSW0RD!       | Enabled | Your password must contain minimum 1 lower-case letter |
      | Pruebas   | Perano     | Sultano  | 910004     | yes         | peranito910004 | Passw0rd! | Passw0rd1!      | Enabled | Passwords do not match                                |