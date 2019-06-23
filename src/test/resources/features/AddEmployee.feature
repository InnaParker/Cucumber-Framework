#Author: syntax team
@sprint4 @addEmployee
Feature: Add Employee

  Background: 
    Given I logged in into OrangeHrm
    And I click on PIM
    And I click on Add Employee link

  @smoke 
  Scenario Outline: Add Employee
    When I provide "<fName>", "<mName>", "<lName>" and "<location>"
    And I click on save button
    Then I see "<fName>", "<lName>" is displayed

    Examples: 
      | fName | lName | location |
      | Alexa | Smith | HQ       |
      | James | Smart | HQ       |

  @regression2 
  Scenario: Add Employee Labels Verification
    Then I see following labels
      | First Name           |
      | Middle Name          |
      | Last Name            |
      | Employee Id          |
      | Location             |
      | Create Login Details |

  @regression3
  Scenario Outline: Add Employee and Create Login Details
    When I provide "<firstName>", "<middleName>", "<lastName>" and "<location>"
    And I click on create login details
    And I provide fields "<userName>", "<password>", "<confirmPassword>", "<essRole>" and "<supervisorRole>"
    And I click on save button
    Then I see employee is added successfully "<firstName>" and "<lastName>"

    Examples: 
      | firstName | middleName | lastName | location | userName | password  | confirmPassword | essRole |
      | Alexa     | Joy        | Smith    | HQ       | alexas   | test12345 | test12345       | admin   |
