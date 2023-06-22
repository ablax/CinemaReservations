package me.ablax.reservations.checkreservation;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.assertEquals;

public class CheckReservationAction {

    CheckReservationModel model = new CheckReservationModel();
    @Given("Check reservations page page is open")
    public void openCheckReservationsPage() {
    }
    @When("Check movie name is entered as {string}")
    public void enterMovieName(String movie) {
        model.setMovie(movie);
    }

    @When("Username is entered as {string}")
    public void enterUserName(String username) {
        model.setUsername(username);
    }

    @When("Check button is clicked")
    public void clickReserveButton() {
        model.checkReservation();
    }

    @Then("The message {string} is shown")
    public void verifyMessage(String expectedMessage) {
        assertEquals(expectedMessage, model.getMessage());
    }

}
