#Author: Syntax team
@sprint3
Feature: Login to OrangeHrm

@smoke @login
 Scenario: Valid login
 Given I navigated to OrangeHrm
 And I see OrangeHrm logo
 When I enter valid user name and password
 And I click login button
 Then I successfully logged in
 And I close browser
 
 @regression
 Scenario: Invalid login
 Given I navigated to OrangeHrm
 And I see OrangeHrm logo
 When I enter invalid user name and password
 And I click login button
 Then I see error message is displayed
 And I close browser
 
 
