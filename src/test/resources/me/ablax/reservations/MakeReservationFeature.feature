Feature: Reservation

  Scenario Outline: Reserve a seat
    Given Reservation page is open
    Given Current time is "<currentTime>"
    When Movie name is entered as "<movie>"
    And Seat number is entered as <seatNumber>
    And User name is entered as "<username>"
    And Reserve button is clicked
    Then The message "<expectedMessage>" appears

    Examples:
      | username | movie          | currentTime          | seatNumber | expectedMessage              |
      | John     | Avatar         | 23.06.2023 10:00     | 5          | Seat reserved successfully   |
      | Derek    | Avatar         | 23.06.2023 10:00     | 4          | User not found               |
      | John     | Star Wars      | 23.06.2023 10:00     | 4          | Projection not found         |
      | John     | Avatar         | 23.06.2023 10:00     | 11         | Seat not found               |
      | Denis    | Avatar         | 23.06.2023 10:00     | 5          | Seat is already reserved     |
      | Denis    | Avatar         | 24.06.2023 13:00     | 4          | Cannot make reservations 1 hour before projection and during projection     |
      | Denis    | Avatar         | 24.06.2023 15:00     | 4          | Cannot make reservations 1 hour before projection and during projection     |


  Scenario Outline: Check reservation
    Given Check reservations page page is open
    When Check movie name is entered as "<movie>"
    And Username is entered as "<username>"
    And Check button is clicked
    Then The message "<expectedMessage>" is shown

    Examples:
      | username | movie          | expectedMessage                           |
      | John     | Avatar         | Projection reservation exists on seat 5   |
      | Derek    | Avatar         | User not found                            |
      | John     | Star Wars      | Projection not found                      |
      | John     | Avatar         | Projection reservation exists on seat 5   |
      | Denis    | Avatar         | No reservation found for this projection  |
      | John     | Avengers       | No reservation found for this projection  |
