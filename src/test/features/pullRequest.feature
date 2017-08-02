Feature: Basic pull request tests for GIT

Scenario: Autorized user can get a single pull request
Given user is logged in
When user retrieves single pull request
Then the status code is 200

Scenario: Not autorized user receives 401 response on pull request
When user retrieves single pull request
Then the status code is 401