Feature: Basic test to get GIT start page

  @test
  Scenario: Non authorized user can get information from start page
  When user retrieves start page
  Then the status code is 200
  And header contains <param> with <value>
  Examples:
  | param                     |  value            | 
  | Cache-Control             |  no-cache         | 
  | Strict-Transport-Security |  max-age=31536000 | 
  | X-Content-Type-Options    |  nosniff          |



