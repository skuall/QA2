Feature: Whether tests
    Scenario: Coordinates check
      Given city name: London,uk
      When we are requesting whether info
      Then lon is: -0.13
      And lat is: 51.51
      Then pressure is: 1012
      And temperature is: 280.32
      Then humidity is: 81
      And temp_min: 279.15