Feature: Post booking create
  As a user of the APIS-Restful website,
  i need to create a booking


  @CreateMultiple
  Scenario Outline: Create a booking Post Multi
    * print "Scenario Create a booking Post¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨"
    * def requestH = {Content-Type: 'application/json', Accept: 'application/json'}
    Given url "https://restful-booker.herokuapp.com"
    And headers requestH
    And path "/booking"
    And request read("../json/post/create_body.json")
    When method post
    Then status 200
    And match $ == read("../json/post/create_response.json")
    And match $ == read("../json/post/create_response_type.json")
    And def id = $.bookingid
    Examples:
      | read('../json/post/create_body_data.json') |

  @CreateE2E
  Scenario Outline: Create a booking Post (Snippet for Get booking snippet)
    * print "Scenario Create a booking Post E2E (Snippet for Get)¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨"
    * def requestH = {Content-Type: 'application/json', Accept: 'application/json'}
    Given url "https://restful-booker.herokuapp.com"
    And headers requestH
    And path "/booking"
    And request read("../json/post/create_body.json")
    When method post
    Then status 200
    And match $ == read("../json/post/create_response.json")
    And match $ == read("../json/post/create_response_type.json")
    And def id = $.bookingid
    Examples:
      | read('../json/put/update_create_body_data.json') |


  @ForGetOnly
  Scenario: Create a booking Post
    * print "Scenario Create a booking Post ForGetOnly¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨"
    * def requestH = {Content-Type: 'application/json', Accept: 'application/json'}
    Given url "https://restful-booker.herokuapp.com"
    And headers requestH
    And path "/booking"
    And request read("../json/post/create_body.json")
    When method post
    Then status 200
    And match $ == read("../json/post/create_response.json")
    And match $ == read("../json/post/create_response_type.json")
    And def id = $.bookingid


  Scenario: Create a booking Post without name
    * print "Scenario Create a booking without name Post¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨"
    * def requestH = {Content-Type: 'application/json', Accept: 'application/json'}
    Given url "https://restful-booker.herokuapp.com"
    And headers requestH
    And path "/booking"
    And request { "firstname" : , "lastname" : "Brown", "totalprice" : 111, "depositpaid" : true, "bookingdates" : { "checkin" : "2018-01-01", "checkout" : "2019-01-01" }, "additionalneeds" : "Breakfast" }
    When method post
    * def statusCode = responseStatus
    Then match karate.range(400,499) contains statusCode
    And def id = $.bookingid