package me.ablax.reservations.makereservation;

import me.ablax.reservations.service.ReservationService;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class MakeReservationModel {
    private final ReservationService reservationService = ReservationService.getInstance();
    private String movie;
    private LocalDateTime currentTime;
    private int seatNumber;
    private String username;
    private String message;

    public void setCurrentTime(final String currentTime) {
        final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");
        this.currentTime = LocalDateTime.parse(currentTime, dateTimeFormatter);
    }

    public void setMovie(String movie) {
        this.movie = movie;
    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMessage() {
        return message;
    }

    public void reserveSeat() {
        this.message = reservationService.reserveSeat(movie, currentTime, seatNumber, username);
    }
}
