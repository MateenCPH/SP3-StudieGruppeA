package org.example;

import java.util.Set;

public class Media {

    private final String mediaName;
    private final int releaseDateStart;
    private final int releaseDateEnd;
    private final Set<String> genre;
    private final double rating;

    public Media(String mediaName, int releaseDateStart, int releaseDateEnd, Set<String> genre, double rating) {
        this.mediaName = mediaName;
        this.releaseDateStart = releaseDateStart;
        this.releaseDateEnd = releaseDateEnd;
        this.genre = genre;
        this.rating = rating;
    }

    public Set<String> getGenre() {
        return genre;
    }

    @Override
    public String toString() {
        return "Media name: " + mediaName + " Release date: " + releaseDateStart + "-" + releaseDateEnd + " Genre: " + genre + " Rating: " + rating;
    }
}
