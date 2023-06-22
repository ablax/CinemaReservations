package me.ablax.reservations.service;

import me.ablax.reservations.model.Projection;
import me.ablax.reservations.model.Reservation;
import me.ablax.reservations.model.Seat;
import me.ablax.reservations.model.User;
import me.ablax.reservations.repository.LocalRepository;

import java.time.LocalDateTime;

public class ReservationService {

    private static ReservationService instance;
    private final LocalRepository localRepository = LocalRepository.getInstance();

    private ReservationService() {
    }

    public static ReservationService getInstance() {
        if (instance == null) {
            instance = new ReservationService();
        }
        return instance;
    }

    public String reserveSeat(final String movieName, final LocalDateTime currentTime, final int seatNumber, final String userName) {
        final Projection projection = localRepository.getProjection(movieName);

        if (projection == null) {
            return "Projection not found";
        }

        if(currentTime.plusHours(1).isAfter(projection.getProjectionTime())) {
            return "Cannot make reservations 1 hour before projection and during projection";
        }

        final Seat seat = projection.getSeat(seatNumber);

        if (seat == null) {
            return "Seat not found";
        }

        if (!seat.isFree()) {
            return "Seat is already reserved";
        }

        final User user = localRepository.getUserByName(userName);
        if (user == null) {
            return "User not found";
        }

        seat.setFree(false);
        localRepository.addReservation(new Reservation(seat, user));

        return "Seat reserved successfully";
    }

    public String checkReservation(final String movieName, final String userName) {
        final Projection projection = localRepository.getProjection(movieName);

        if (projection == null) {
            return "Projection not found";
        }

        final User user = localRepository.getUserByName(userName);
        if (user == null) {
            return "User not found";
        }

        final Reservation reservationByUserNameAndProjectionName = localRepository.getReservationByUserNameAndProjectionName(userName, movieName);
        if(reservationByUserNameAndProjectionName == null){
            return "No reservation found for this projection";
        }
        final Seat seat = reservationByUserNameAndProjectionName.getSeat();

        return "Projection reservation exists on seat " + seat.getSeatNumber();
    }
}
