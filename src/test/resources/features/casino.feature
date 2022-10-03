Feature: "Casino"

  Scenario: "Players filter"

    When Authorization like admin
    And Open player list
    Then Sort by any field
