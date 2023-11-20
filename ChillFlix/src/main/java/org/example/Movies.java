package org.example;


import java.util.ArrayList;

public class Movies implements Media {
    private final String movieName;
    private ArrayList<String>category = new ArrayList<>();
    private final int releaseDate;
    private final float rating;

    public Movies(String movieName, ArrayList<String>category, int releaseDate, float rating){
        this.movieName = movieName;
        this.category = category;
        this.releaseDate = releaseDate;
        this.rating = rating;
    }

    public void play(){
        System.out.println(movieName + " is now playing");
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
