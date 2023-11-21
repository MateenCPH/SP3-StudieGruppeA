package org.example;

import java.util.Set;

public class Movies {
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

    public  void play(User user) {
        System.out.println(movieName + " is now playing");
        user.addToWatchedMovies(this);
    }

    public Set<String> getGenre() {
        return genre;
    }

    @Override
    public String toString() {
        return "Movie name: " + movieName + " Category: " + genre + " releaseDate: " + releaseDate + " Rating: " + rating;
    }
}