Feature:Verifying buttons feature of the application


Given Navigate to "buttons" page
  When  Click "Double click" button
  Then  Verify text :"You have done a double click" should be visible
  And   Click "Right click" button
  Then  Verify text :"You have done a right click" should be visible
  And   Click "Click me" button
  Then  Verify text :"You have done a dynamic click" should be visible

  Scenario: Getting Responses by Created link
    Given Navigate to "links" page
    When User clicks on "Created" on the links page
    Then Verify the message contains "statusCode""statusText"

  @wip
  Scenario Outline: Getting different responses by different links
    Given Navigate to "links" page
    When User clicks on "<link>" on the links page
    Then Verify the message contains "<statusCode>""<statusText>"
    Examples:
      | link         | statusCode | statusText        |
      | Created      | 201        | Created           |
      | No Content   | 204        | No Content        |
      | Moved        | 301        | Moved Permanently |
      | Bad Request  | 400        | Bad Request       |
      | Unauthorized | 401        | Unauthorized      |
      | Forbidden    | 403        | Forbidden         |
      | Not Found    | 404        | Not Found         |
