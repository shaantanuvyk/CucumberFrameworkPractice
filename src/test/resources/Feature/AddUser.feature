@AddUser
Feature: Adding a new user to the sysytem

@ValidUser @SmokeTest
Scenario Outline: Add Valid User
    Given User is on the "PIM" page
    When Enter user "<FirstName>", "<MiddleName>", "<LastName>"
    And Saving the Details
    Then User gets added to the system with "<FirstName>", "<MiddleName>", "<LastName>"
    And On searching user gets fetched

    Examples: 
      | FirstName | MiddleName | LastName    |
      | Shantanu  | Vilas      | Karambalkar |
      
      
     