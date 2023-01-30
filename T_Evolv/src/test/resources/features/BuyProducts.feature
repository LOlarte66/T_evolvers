Feature: Buy products
  As user (Yazmin) of the DemoBlaze Website,
  i need to buy products

  Scenario Outline: Buy products successfully
    Given Yazmin has accessed the main page
    And Yazmin tries to enter her account
      | username   | password   |
      | <username> | <password> |
    When Yazmin try to add some products
      | nameProducts   | category   |
      | <nameProducts> | <category> |
    And Yazmin places the order
      | name   | country   | city   | creditCard   | month   | year   |
      | <name> | <country> | <city> | <creditCard> | <month> | <year> |
    Then Yazmin is going to see products value
    Examples:
      | username | password   | category                | nameProducts                                    | name | country  | city    | creditCard | month | year |
      | Luchogo  | Luis123*** | Laptops,Phones,Monitors | Sony vaio i5,Samsung galaxy s6,Apple monitor 24 | Lu   | Colombia | Medelin | 123        | 1     | 2030 |
      | Luchogo  | Luis123*** | Laptops,Phones          | Sony vaio i5,Samsung galaxy s6                  | Lu   | Colombia | Medelin | 123        | 1     | 2030 |

  @new
  Scenario Outline: Buy products unsuccessfully without payment details
    Given Yazmin has accessed the main page
    And Yazmin tries to enter her account
      | username   | password   |
      | <username> | <password> |
    When Yazmin try to add some products
      | nameProducts   | category   |
      | <nameProducts> | <category> |
    And Yazmin places the order
      | name   | country   | city   | creditCard   | month   | year   |
      | <name> | <country> | <city> | <creditCard> | <month> | <year> |
    Then Yazmin can not continue the payment
    Examples:
      | username | password   | category        | nameProducts                       | name | country | city | creditCard | month | year |
      | Luchogo  | Luis123*** | Phones,Monitors | Samsung galaxy s6,Apple monitor 24 |      |         |      |            |       |      |

