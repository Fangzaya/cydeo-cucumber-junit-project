Feature: Some of the general functionality verifications

  Scenario:DropDown options verification

    Given user is already logged in to The Web table app
    When user is on the “Order” page
    Then user sees below options under “product” dropdown
      | MoneyCog   |
      | Familybea  |
      | Screenable |


  Scenario: Payment option verification
    Given user is already logged in to The Web table app
    When user is on the “Order” page
    Then user sees Visa as enable payment option
    Then user sees Mastercard as enable payment option
    Then user sees American Express as enable payment option

  Scenario: Order place validation
    Given user is already logged in to The Web table app
    When user is on the “Order” page
    Then user enters "9" for Quantity
    And  Clicks on Calculate button
    Then user enters "Test James"  for Customer name
    And user enters "2500 sandbourn "  for Street
    And user enters "Herndon"  for City
    And user enters "Virginia"  for state
    And user enters "22111"  for Zip
    And user selects payment option "MasterCard"
    And user enters "254856321566"  for Card No
    And user enters "05/28"  for Expire date
    And user clicks to “Process Order”
    Then user should see "Test James" in the first row of the web table

  @wip_atittaya
  Scenario Outline: Order place validation
    Given user is already logged in to The Web table app
    When user is on the “Order” page
    Then user enters "<Quantity>" for Quantity
    And  Clicks on Calculate button
    Then user enters "<Customer name>"  for Customer name
    And user enters "<Street>"  for Street
    And user enters "<City>"  for City
    And user enters "<state>"  for state
    And user enters "<Zip>"  for Zip
    And user selects payment option "<paymentType>"
    And user enters "<CardNumber>"  for Card No
    And user enters "<ExpireDate>"  for Expire date
    And user clicks to “Process Order”
    Then user should see "<ExpectedName>" in the first row of the web table
    Examples:
      | Quantity | Customer name | Street    | City    | state | Zip   | paymentType | CardNumber | ExpireDate | ExpectedName |
      | 3        | fang ati      | 2500 sand | herndon | va    | 21222 | Visa        | 245555522222    | 02/28      | fang ati     |
      | 3        | Resat tu      | 2500 sand | herndon | va    | 21222 | Visa        | 245555522222    | 02/28      |  Resat tu    |
    #  | 3        | wowo ty       | 2500 sand | herndon | va    | 21222 | Visa        | 245555522222    | 02/28      |wowo ty    |
    #  | 3        | gugu fa      | 2500 sand | herndon | va    | 21222 | Visa        | 245555522222    | 02/28      | gugu fa      |
     # | 3        | fang atittt      | 2500 sand | herndon | va    | 21222 | Visa        | 245555522222    | 02/28      | fang atittt     |
     # | 3        | da ati      | 2500 sand | herndon | va    | 21222 | Visa        | 245555522222    | 02/28      | da ati     |


