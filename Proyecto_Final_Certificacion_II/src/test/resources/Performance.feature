Feature: Creation of a new key performance indicator

  Background: User login into Orange HRM
    Given I am in Orange HRM web page

  @createNewUser
  Scenario Outline: Create a new key performance indicator
    Given I set the user name field with "Admin"
    And I set the password field with "admin123"
    When I click on the login button
    Then I must be in the Home Page
    When I click on the performance button
    Then I must be in the Performance Page
    When I click on the configure performance button
    And I select the KPIs option
    Then I must be in the key performance indicator section
    When I click on the add new KPI button
    And I set the key performance indicator as "<indicator>"
    And I set the minimum rating as "<minimum>"
    And I set the maximum rating as "<maximum>"
    And I click on the job title button
    Given I select the job title: "<job>"
    And I set the default scale: "<default>"
    And I click on the save KPI button 12
    Then The new created KPI must haven been recorded 13
    Examples:
      | indicator             | minimum | maximum | job                     | default |
      | Sales Revenue         | 0       | 100     | Account Assistant       | no      |
      | Customer Satisfaction | 1       | 10      | Chief Executive Officer | yes     |
      | Productivity          | 50      | 100     | Chief Financial Officer | yes     |
      | Quality of Work       | 0       | 10      | Chief Technical Officer | yes     |
      | Employee Engagement   | 10      | 50      | Content Specialist      | no      |

