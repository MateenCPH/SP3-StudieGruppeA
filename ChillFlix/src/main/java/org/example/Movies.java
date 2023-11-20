package org.example;


public class Movies implements Media {
    private final String movieName;
    private final String category;
    private final int releaseDate;
    private final float rating;

    public Movies(String movieName, String category, int releaseDate, float rating){
        this.movieName = movieName;
        this.category = category;
        this.releaseDate = releaseDate;
        this.rating = rating;
    }

    public void play(){

    }

    public void addToUserList() {

    }

    public void removeFromUserList() {

    }

    @Override
    public String toString() {
        return "Movie name: " + movieName + " Category: " + category + " releaseDate: " + releaseDate + " Rating: " + rating;
    }
}
