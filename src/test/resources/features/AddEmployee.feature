#Author: syntax team

Feature: Add Employee

Scenario: Add Employee
Given I navigated to OrangeHrm
And I logged in into OrangeHrm
When I click on PIM
And I click on Add Employee link
And I provide Employee details
And I click on save button
Then I see Employee is added successfully
And I close browser


  