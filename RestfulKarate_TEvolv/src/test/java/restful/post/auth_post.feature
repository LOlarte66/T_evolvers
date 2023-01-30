Feature: Auth - Booking
  As a user of the APIS-Restful website,
  i need to Auth to generate a token

  @Auth
  Scenario: Auth - Booking
    * print "Scenario: Auth Post"
    * def requestH = {Content-Type: 'application/json', Accept: 'application/json'}
    Given url "https://restful-booker.herokuapp.com"
    And headers requestH
    And path "/auth"
    And request read("../json/post/auth.json")
    When method post
    Then status 200
    And match $ == read("../json/post/auth_response_type.json")
    And def token1 = $.token

