Feature: Bing search functionality
  Agile story : As a user , when I am on the Bing search page I should be able to
  search anything and see relevant results
  Scenario:  Search result Title Verification
    Given user is on the Bing search page
    When user enter orange in the Bing search box
    Then user should see orange in the title

  #@wip_atittaya # meaning work in progress
  Scenario:  Search result Title Verification
    Given user is on the Bing search page
    When user enter "orange" in the Bing search box
    Then user should see "orange - Search" in the title
    Then User should see below info in month dropdownS