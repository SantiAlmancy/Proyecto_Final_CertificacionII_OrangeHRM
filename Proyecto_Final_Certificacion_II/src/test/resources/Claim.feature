Feature: Claim submit

  Background: User login into Orange HRM
    Given I am in Orange HRM web page

  @submitAClaim
  Scenario Outline: Submit a claim
    Given I set the user name field with "Admin"
    And I set the password field with "admin123"
    When I click on the login button
    Then I must be in the Home Page
    When I click on the claim button
    Then I must be in the claim page
    When I click on submit claim button
    Then I must be in the submit claim page
    When I select the event "<event>" for the claim
    When I select the currency "<currency>" for the claim
    And I give some remarks like "<remarks>"
    And I click on the create claim button
    Then I must be in the add expenses page
    When I click on Add Expense
    And I select the expense type as "<type>"
    And I click on the calendar icon
    And I select the date as today
    And I give the total amount of expense "<expense>"
    And I add a note like "<note>"
    And I click on Save the expense
    When I click on Add Expense
    And I select the expense type as "<type2>"
    And I click on the calendar icon
    And I select the date as today
    And I give the total amount of expense "<expense2>"
    And I add a note like "<note2>"
    And I click on Save the expense
    And I click on submit claim
    When I save my claim information and total expense
    And I click on my claims button
    Then The claim information and total expense must be correct
    Examples:
      | event                 | currency            | remarks                                                 | type            | expense | note                              | type2             | expense2  | note2                             |
      | Accommodation         | Afghanistan Afghani | I need the claim for my accommodation as I'm new here   | Accommodation   | 24      | Was a need                        | Planned Surgery   | 23        | Had to get attended               |
      | Medical Reimbursement | Albanian Lek        | I am in need of medical consult                         | Fuel Allowance  | 56      | Ran out of gas                    | Transport         | 78        | Needed to get to the nearest town |
      | Travel Allowance      | Algerian Dinar      | My family has planned a trip to Bosnia                  | Transport       | 78      | Needed to get to the nearest town | Fuel Allowance    | 56        | Ran out of gas                    |
      | Travel Allowance      | Algerian Dinar      | My family has planned a trip to Bosnia                  | Planned Surgery | 23      | Had to get attended               | Accommodation     | 24        | Was a need                        |