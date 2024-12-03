#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@NewCandidate
Feature: Creating a new candidate

@SmokeTest
Scenario Outline: Create a new candidate in the system
	Given User navigates on "Recruitment" page
  When User creates a new user in system as "<FirstName>" "<MiddleName>" "<LastName>"
  Then New user is created in system
  And The fetched records display "<FirstName>" "<MiddleName>" "<LastName>"

Examples:
|FirstName|MiddleName|LastName|
|Shantanu|Vilas|Karambalkar|