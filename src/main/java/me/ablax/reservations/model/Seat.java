package me.ablax.reservations.model;

public class Seat {

    private final int seatNumber;
    private boolean isFree;

    public Seat(final int seatNumber) {
        this(seatNumber, true);
    }

    public Seat(int seatNumber, boolean isFree) {
        this.seatNumber = seatNumber;
        this.isFree = isFree;
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

}
