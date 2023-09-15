Feature: Login Orange HRM

  Background: User login into Orange HRM
    Given I am in Orange HRM web page

    @loginWithValidCredentials
    Scenario: Login into Orange HRM page with valid credentials
      Given I set the user name field with "Admin"
      And I set the password field with "admin123"
      When I click on the login button
      Then I must be in the Home Page
      Given I click on the profile toggle button
      And I click on the logout button
      Then I must be back in the Login Page