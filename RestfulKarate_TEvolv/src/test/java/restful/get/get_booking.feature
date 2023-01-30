Feature: Get booking
  As a user of the APIS-Restful website,
  i need to get a registered booking

  @GettingE2E
  Scenario Outline: Get a booking (Snippet for Update booking Post)
    * print "Scenario: Get a booking E2E¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨"
    * call read("../post/create_booking_post.feature@CreateE2E")
    * def requestH = {Content-Type: 'application/json', Accept: '*/*'}
    Given url "https://restful-booker.herokuapp.com"
    And headers requestH
    And path "/booking/" + id
    When method get
    Then status 200
    And match $ == read("../json/get/get_booking_response.json")
    And match $ == read("../json/get/get_booking_response_type.json")
    Examples:
      | read('../json/put/update_create_body_data.json') |


  @GetMultiple
  Scenario Outline: Get a booking multi
    * print "Scenario: Get a booking¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨"
    * call read("../post/create_booking_post.feature@ForGetOnly")
    * def requestH = {Content-Type: 'application/json', Accept: '*/*'}
    Given url "https://restful-booker.herokuapp.com"
    And headers requestH
    And path "/booking/" + id
    When method get
    Then status 200
    And match $ == read("../json/get/get_booking_response.json")
    And match $ == read("../json/get/get_booking_response_type.json")
    Examples:
      | read('../json/post/create_body_data.json') |


  Scenario: Get a booking with bad id
    * print "Scenario: Get a booking with bad id¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨"
    * def requestH = {Content-Type: 'application/json', Accept: '*/*'}
    Given url "https://restful-booker.herokuapp.com"
    And headers requestH
    And path "/booking/wq212"
    When method get
    * def codeStatus = responseStatus
    Then match karate.range(400,499) contains codeStatus