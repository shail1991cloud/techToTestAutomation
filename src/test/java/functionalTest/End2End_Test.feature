Feature: Booking of flight in mercury ssite

@smoke
Scenario Outline: validate use logins into mercury site and performs some functions on it
Given user is on login page
When  enters "<username>" and "<password>"
Then  he is able to validate "<header>"
Examples:
|username|password|header|
|kdmvin |vinayak123|      |