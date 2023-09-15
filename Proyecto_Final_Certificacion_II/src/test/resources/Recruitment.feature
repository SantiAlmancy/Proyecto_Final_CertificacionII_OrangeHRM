Feature: Creation of a new vacancy

  Background: User login into Orange HRM
    Given I am in Orange HRM web page

  @createNewUser
  Scenario Outline: Create a new vacancy
    Given I set the user name field with "Admin"
    And I set the password field with "admin123"
    When I click on the login button
    Then I must be in the Home Page
    When I click on the recruitment button
    Then I must be in the recruitment page
    When I click on the vacancies button
    Then I must be in the vacancies page
    When I click on the add new vacancy button
    And I set the vacancy name as "<vacancy>"
    And I set the number of positions as "<position>"
    And I click on the job title for vacancy button
    And I select the job title for vacancy: "<job>"
    And I set the description for the vacancy as "<description>"
    When I set the hiring manager in form field as "<manager>"
    And I set the active option: "<active>"
    And I set the Publish in RSS Feed and Web Page option: "<publish>"
    Given I click on the save vacancy button
    When I click on the recruitment button
    When I click on the vacancies button
    Then The new created vacancy must have been recorded
    Given I click on the profile toggle button
    And I click on the logout button
    Then I must be back in the Login Page
    Examples:
      | vacancy                   | position | job                     | active  |  publish | manager | description                                                                                                           |
      | Junior Account Assistant  | 3        | Account Assistant       | no      |  no      | A       | We are seeking a highly motivated and detail-oriented Junior Account Assistant to join our finance team.              |
      | Chief Executive Officer   | 1        | Chief Executive Officer | yes     |  no      | B       | We are seeking a visionary and results-driven Chief Executive Officer (CEO) to lead our organization to new heights.  |
      | Financial Analyst         | 18       | Chief Financial Officer | no      |  yes     | C       | We are seeking a highly motivated Financial Analyst to join our finance team.                                         |
      | Data Scientist            | 6        | Chief Technical Officer | yes     |  yes     | D       | We are seeking a highly motivated and skilled Data Scientist to join our dynamic team.                                |
      | DevOps Engineer           | 10       | Content Specialist      | no      |  no      | E       | We are seeking a skilled and proactive DevOps Engineer to join our dynamic software development team.                 |

