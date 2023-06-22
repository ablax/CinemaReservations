package me.ablax.reservations.repository;

import me.ablax.reservations.model.Projection;
import me.ablax.reservations.model.Reservation;
import me.ablax.reservations.model.User;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class LocalRepository {

    //Singleton implementation

    private static LocalRepository instance;

    public static LocalRepository getInstance() {
        if (instance == null) {
            instance = new LocalRepository();
        }
        return instance;
    }
    private final List<Projection> movies;
    private final List<User> users;
    private final List<Reservation> reservations;
    private LocalRepository() {
        this.movies = Stream.of("Avatar", "Inception", "Avengers", "Titanic")
                .map(movieName ->
                        new Projection(movieName, LocalDateTime.of(2023, 6, 24, 13, 30), 10)
                )
                .toList();

        this.users = new ArrayList<>();
        this.reservations = new ArrayList<>();

        addUser("John");
        addUser("Denis");
    }

    public User getUserByName(final String name){
        return users.stream()
                .filter(user -> user.getName().equals(name))
                .findFirst()
                .orElse(null);
    }

    public void addUser(final String name){
        users.add(new User(name));
    }

    public Reservation getReservationByUserNameAndProjectionName(final String userName, final String projectionName){
        return reservations.stream()
                .filter(reservation -> reservation.getUser().getName().equals(userName))
                .filter(reservation -> reservation.getSeat().getProjection().getMovieName().equals(projectionName))
                .findFirst().orElse(null);
    }

    public Projection getProjection(final String movieName) {
        return this.movies.stream()
                .filter(movie -> movie.getMovieName().equals(movieName))
                .findFirst()
                .orElse(null);
    }

    public void addReservation(final Reservation reservation) {
        this.reservations.add(reservation);
    }
}
