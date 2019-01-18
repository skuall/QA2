Feature: Ticket reservation
  Scenario: Ticket reservation testing
    Given departure airport: RIX
    And destination airport: MEL
    And user data is:
      | name           | John       |
      | surname        | Smith      |
      | discountCode   | lol        |
      | personCount    | 0          |
      | childrenCount  | 0          |
      | luggageCount   | 0          |
      | nextFlightDate | 13-05-2018 |
    And place is 8
    And we are on the home page

    When we are selectiing airports
    And we are presssing Gogogo button
    Then registration page appears

    When we fill registration form
    And we are pressing Get price button
    Then our price will be 1000 euro

    When we are pressing Book button
    Then we are redirected on select seat page

    When we are selecting our seat number
    And we are clicking Book button
    Then successfull registration page appears with message: Thank You for flying with us!

    When we are requesting reservation list
    Then we can see our rservation in the list

    When we are deleting our reservation ticket
    And we are requesting reservation list again
    Then we can see our reservation is deleted




