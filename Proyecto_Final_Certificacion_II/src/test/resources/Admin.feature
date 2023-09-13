Feature: Creation of a new user

  Background: User login into Orange HRM
    Given I am in Orange HRM web page

    @createNewUser
    Scenario: Create a new user
      Given I set the user name field with "Admin"
      And I set the password field with "admin123"
      When I click on the login button
      Then I must be in the Home Page
      When I click on the admin button
      Then I must be in the Admin Page
      When I click on the User Management button
      And I click on the User button
      Then I must be in System Users
      When I click on the new user button
      Then I must be in New User form
      When I set the username in form field with "<username>"
      And I set the password in form field with "Pass123"
      And I set the repeated password in form field with "Pass123"
      And I set de role in form with "<role>"
      And I set the status in form with "<status>"
      And I set the employee whose name starts with "<employee>"
      When I click on the save button
      Then The user of username "<username>" from employee must be created
      Examples:
        | role  | employee  |  status    |  username  |
        | Admin | A         |  Enabled   |  Admin1    |
        | ESS   | B         |  Disabled  |  Admin2    |
        | Admin | C         |  Disabled  |  Admin3    |
        | ESS   | D         |  Enabled   |  Admin4    |

