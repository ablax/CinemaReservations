package me.ablax.reservations.model;

public class Seat {

    private final Projection projection;
    private final int seatNumber;
    private boolean isFree;

    public Seat(final Projection projection, final int seatNumber) {
        this.projection = projection;
        this.seatNumber = seatNumber;
        this.isFree = true;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public boolean isFree() {
        return isFree;
    }

    public void setFree(boolean isFree) {
        this.isFree = isFree;
    }

    public Projection getProjection() {
        return projection;
    }
}
