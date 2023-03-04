Feature: Webb table app login functionality
  Agile story: User should be able to login with correct credentials

  Scenario:Positive Login scenario
    Given User is on the login page
    And User enter valid username
    And  User enter valid password
    And User clicks on login button
    Then User should see URL  as expected
    #Expected: URL should end with “orders”
    #username: Test
    #password: Tester

  Scenario:Positive Login scenario
    Given User is on the login page
    And User enter "Test" username and "Tester" password
    And User clicks on login button
    Then User should see URL  as expected
#Parameterized implementation (Cucumber expressions)

  Scenario:Positive Login scenario
    Given User is on the login page
    And User enter below valid credentials
      | username | Test   |
      | password | Tester |
    And User clicks on login button
    Then User should see URL  as expected

    #Data Tables implementation