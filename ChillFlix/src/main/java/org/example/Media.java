package org.example;

import java.util.ArrayList;
import java.util.Objects;
import java.util.List;


public class Media {

    private final String mediaName;
    private final int releaseDateStart;
    protected final ArrayList<String> genre;
    private final float rating;

    public Media(String mediaName, int releaseDateStart, ArrayList<String> genre, float rating) {
        this.mediaName = mediaName;
        this.releaseDateStart = releaseDateStart;
        this.genre = genre;
        this.rating = rating;
    }

    public String getMediaName() {
        return mediaName;
    }

    public int getReleaseDateStart() {
        return releaseDateStart;
    }

   /* public ArrayList<String> getGenre() {
        return genre.stream();
    }*/

    public double getRating() {
        return rating;
    }


    public String toString() {
        return " Release date: " + releaseDateStart + " | Genre: " + genre + " | Rating: " + getRating();
    }

    /*@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Media media = (Media) o;
        return Object.equals(genre, media.genre);
    }
    @Override
    public int hasCode() {
    return Object.hash(genre);
    }*/
}
