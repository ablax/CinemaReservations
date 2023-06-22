package me.ablax.reservations.makereservation;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.assertEquals;

public class MakeReservationAction {

    MakeReservationModel model = new MakeReservationModel();
    @Given("Reservation page is open")
    public void openReservationScreen() {
    }
    @Given("Current time is {string}")
    public void currentTime(String currentTime) {
        model.setCurrentTime(currentTime);
    }
    @When("Movie name is entered as {string}")
    public void enterMovieName(String movie) {
        model.setMovie(movie);
    }

    @When("Seat number is entered as {int}")
    public void enterSeatNumber(int seatNumber) {
        model.setSeatNumber(seatNumber);
    }

    @When("User name is entered as {string}")
    public void enterUserName(String username) {
        model.setUsername(username);
    }

    @When("Reserve button is clicked")
    public void clickReserveButton() {
        model.reserveSeat();
    }

    @Then("The message {string} appears")
    public void verifyMessage(String expectedMessage) {
        assertEquals(expectedMessage, model.getMessage());
    }

}
