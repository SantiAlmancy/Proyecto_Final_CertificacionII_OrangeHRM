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
      When 