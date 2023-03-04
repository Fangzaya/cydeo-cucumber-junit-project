@wiki
Feature: Wikipedia Search Functionality
  WPS-7531
  Agile story : As a user , when I am on the Wikipedia home page I should be able to
  search anything and see relevant results

  Background:
    Given  user is on the Wikipedia home page
    When User types "Steve Jobs" in the wiki search box
    And  User clicks wiki search button
    #we parameterize  "Steve Jobs" as String
  #fang's way
  #Gruhan prefer not to add 3 step in Background: it is easier to understand the step of each Scenario

  Scenario: Wikipedia Search Functionality Title Verification
    Then User sees "Steve Jobs" is in the wiki title


  Scenario: Wikipedia Search Functionality Header Verification
    Then User sees "Steve Jobs" is in the main header


  Scenario:Wikipedia Search Functionality Image Header Verification
    Then User sees "Steve Jobs" is in the image header

  @scenarioOutline
  Scenario Outline: Wikipedia Search Functionality WITH Scenario Outline
    Given  user is on the Wikipedia home page
    When User types "<searchValue>" in the wiki search box
    And  User clicks wiki search button
    Then User sees "<expectedTitle>" is in the wiki title
    Then User sees "<expectedMainHeader>" is in the main header
    Then User sees "<expectedImageHeader>" is in the image header

    @ceos
    Examples:search values we are going tp be using in this  Scenario Outline
      | searchValue     | expectedTitle   | expectedMainHeader | expectedImageHeader |
      | Steve Jobs      | Steve Jobs      | Steve Jobs         | Steve Jobs          |
     # | Marry Barra     | Marry Barra     | Marry Barra        | Marry Barra         |
      | Rosalind Brewer | Rosalind Brewer | Rosalind Brewer    | Rosalind Brewer     |
      | Sundar Pichai   | Sundar Pichai   | Sundar Pichai      | Sundar Pichai       |

    @scientists
    Examples:
      | searchValue     | expectedTitle   | expectedMainHeader | expectedImageHeader |
      | Marie Curie     | Marie Curie     | Marie Curie        | Marie Curie         |
      | Albert Einstein | Albert Einstein | Albert Einstein    | Albert Einstein     |





