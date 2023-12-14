Feature: Login feature

  Scenario: Launch browser
    When User launch url
    And User enters credentials
    Then User should land on home page
    Then User should quit browser