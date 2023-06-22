package me.ablax.reservations.model;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Projection {

    private final String movieName;
    private final LocalDateTime projectionTime;
    private final Map<Integer, Seat> seats;

    public Projection(String movieName, LocalDateTime projectionTime, int freeSeats) {
        this.movieName = movieName;
        this.projectionTime = projectionTime;

        this.seats = IntStream.rangeClosed(1, freeSeats)
                .mapToObj(i -> new Seat(this, i))
                .collect(Collectors.toMap(Seat::getSeatNumber, seat -> seat));
    }

    public String getMovieName() {
        return movieName;
    }

    public LocalDateTime getProjectionTime() {
        return projectionTime;
    }

    public Seat getSeat(int seatNumber) {
        return seats.get(seatNumber);
    }
}
