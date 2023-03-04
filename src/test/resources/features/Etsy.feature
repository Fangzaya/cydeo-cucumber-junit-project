
Feature: Etsy search functionality
  Agile story: User should be able to type any keyword and see relevant information

Scenario: Etsy Title Verification
  Given user is on the Etsy homepage
  Then  user should see title is as expected
  #expectedTitle: Etsy - Shop for handmade, vintage, custom, and unique gifts for everyone

Scenario: Etsy Search Functionality Title Verification (without parameterization)
  Given user is on the Etsy homepage
  When User types Wooden Spoon in the search box
  Then User clicks search button
  Then User sees Wooden Spoon is in the title

 @Etsy
  Scenario: Etsy Search Functionality Title Verification (without parameterization)
    Given user is on the Etsy homepage
    When User types "Spoon" in the search box
    Then User clicks search button
    Then User sees "Spoon" is in the title


