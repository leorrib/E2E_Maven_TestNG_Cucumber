Feature: Webpage validation

Scenario Outline: Login attempt

Given user enters QA tutorial website
When user enters <email> and <password> 
Then error message "Invalid email or password." is displayed

Examples:
|	email 			| password|
|user1@email.com	| 123456  |
|user2@email.com	| 123456  |


Scenario: Validate Navigation Bar

Given user enters QA tutorial website
Then verifies if navigation bar is present 