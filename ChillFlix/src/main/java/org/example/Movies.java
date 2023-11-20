package org.example;


import java.util.ArrayList;
import java.util.Set;

public class Movies implements Media {
    private final String movieName;
    private final int releaseDate;
    private final Set<String> genre;
    private final double rating;

    public Movies(String movieName, int releaseDate, Set<String>genre, double rating){
        this.movieName = movieName;
        this.genre = genre;
        this.releaseDate = releaseDate;
        this.rating = rating;
    }

    public void play(User user, Movies movies) {
        System.out.println(movieName + " is now playing");
        ArrayList<Movies> m = new ArrayList<>();
        user.addToWatchedMovies(m, movies);
    }

    public void addToUserList(User user, Movies movies) {
        user.addToWatchedMovies(ArrayList<>, movies);
    }

    public void removeFromUserList() {

    }

    public Set<String> getGenre() {
        return genre;
    }

    @Override
    public String toString() {
        return "Movie name: " + movieName + " Category: " + genre + " releaseDate: " + releaseDate + " Rating: " + rating;
    }
}
