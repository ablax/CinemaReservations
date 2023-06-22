package me.ablax.reservations.checkreservation;

import me.ablax.reservations.service.ReservationService;

public class CheckReservationModel {
    private final ReservationService reservationService = ReservationService.getInstance();
    private String movie;
    private String username;
    private String message;

    public void setMovie(String movie) {
        this.movie = movie;
    }


    public void setUsername(String username) {
        this.username = username;
    }

    public String getMessage() {
        return message;
    }

    public void checkReservation() {
        this.message = reservationService.checkReservation(movie, username);
    }
}
