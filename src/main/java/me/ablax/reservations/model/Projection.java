package me.ablax.reservations.model;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.IntStream;

public class Projection {

    private final String movieName;
    private final LocalDateTime projectionTime;
    private final List<Seat> seats;

    public Projection(String movieName, LocalDateTime projectionTime, int freeSeats) {
        this.movieName = movieName;
        this.projectionTime = projectionTime;

        this.seats = IntStream.rangeClosed(1, freeSeats)
                .mapToObj(i -> new Seat(i, true))
                .toList();
    }

    public String getMovieName() {
        return movieName;
    }

    public LocalDateTime getProjectionTime() {
        return projectionTime;
    }

    public List<Seat> getSeats() {
        return seats;
    }
}
