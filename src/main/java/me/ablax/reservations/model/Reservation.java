package me.ablax.reservations.model;

public class Reservation {

    private final Seat seat;
    private final User user;

    public Reservation(Seat seat, User user) {
        this.seat = seat;
        this.user = user;
    }


    public Seat getSeat() {
        return seat;
    }

    public User getUser() {
        return user;
    }

}
