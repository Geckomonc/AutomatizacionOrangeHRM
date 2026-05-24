Feature: User login in OrangeHRM

  Scenario Outline: Successful login with valid credentials
    Given The user is on the OrangeHRM login page
    When The user fill username "<username>", password "<password>" and click the login button
    Then The user should see the dashboard page

    Examples:
      | username | password |
      | Admin    | admin123 |