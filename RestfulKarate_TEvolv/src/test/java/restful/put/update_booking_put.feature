Feature: Put user on Restful
  As a user of the APIS-Restful website,
  i need to update a registered booking

  Scenario Outline: Put a booking
    * print "Scenario: Update a booking Put¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨"
    * call read("../get/get_booking.feature@GettingE2E")
    * call read("../post/auth_post.feature@Auth")
    * def token_aux = "token=" + token1
    * def requestH = {Content-Type: 'application/json', Accept: '*/*', Cookie: '#(token_aux)'}
    Given url "https://restful-booker.herokuapp.com"
    And headers requestH
    And path "/booking/" + id
    And request read("../json/put/update_body.json")
    When method put
    Then status 200
    And match $ == read("../json/get/get_booking_response.json")
    And match $ == read("../json/get/get_booking_response_type.json")
    Examples:
      | read('../json/put/update_body_data_request.json') |

