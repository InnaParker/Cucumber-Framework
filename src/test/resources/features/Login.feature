#Author: Syntax team
@sprint3 @login
Feature: Login to OrangeHrm

  Background: 
    Given I see OrangeHrm logo

  @smoke 
  Scenario: Valid login
    When I enter valid user name and password
    * I click login button
    Then I successfully logged in

  @regression
  Scenario: Invalid login
    When I enter invalid user name and password
    And I click login button
    Then I see error message is displayed

  @error
  Scenario: Error message validation
    When I enter invalid username and password I see errorMessage
      | UserName | Password   | ErrorMessage        |
      | Admin    | Admin123   | invalidCredentials1 |
      | Admin1   | Syntax123! | invalidCredentials2 |

      