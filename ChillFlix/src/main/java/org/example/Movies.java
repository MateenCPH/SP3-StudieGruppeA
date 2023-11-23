package org.example;


import java.util.ArrayList;
import java.util.Set;

public class Movies extends Media {

    public Movies(String mediaName, int releaseDate, ArrayList<String> genre, float rating) {
        super(mediaName, releaseDate, genre, rating);
    }

    public void addToUserList() {
        //user.addToWatchedMovies(ArrayList<>, movies);
    }

    public void removeFromUserList() {

    }

    @Override
    public String toString() {
        return "Movie name: " + getMediaName() + super.toString();
    }

    /*public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Media media = (Media) o;
        return Object.equals(genre, media.genre);
    }

    public int hasCode() {
        return Object.hash(genre);
    }*/
}
