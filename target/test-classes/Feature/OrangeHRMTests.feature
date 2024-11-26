@LoginTest
Feature: All Login Scenarios

Background: Navigate on the application and choose the browser
Given User has selected the "Chrome" browser
When User is navigated to the "OrangeHRMURL"
Then Login page is loaded

@RegressionTest
Scenario: Login With Blank credentials
Given User is on the Login page
When User is trying to login with blank credentials using "" and ""
Then Error message displays as "Required" under username and password textboxes

@SanityTest
Scenario Outline: Login with Invalid credentials
Given User is on the Login page
When User is trying to login with invalid credentials using "<userName>" and "<password>"
Then Error message displays as "Invalid credentials"

Examples:

|userName|password|
|Admin|aaa|
|aaa|admin123|


@SmokeTest @SanityTest
Scenario: Login with Valid Credentials
Given User is on the Login page
When User is trying to login with valid credentials using "username" and "password"
Then User gets login successfully on "Dashboard" page
      

      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      