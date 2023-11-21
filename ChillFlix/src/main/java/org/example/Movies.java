package org.example;



import java.util.ArrayList;
import java.util.Set;

public class Movies implements Media {
    private final String movieName;
    private final int releaseDate;
    private final ArrayList<String> genre;
    private final float rating;
    protected TextUI ui = new TextUI();

    public Movies(String movieName, int releaseDate, ArrayList<String>genre, float rating){
        this.movieName = movieName;
        this.genre = genre;
        this.releaseDate = releaseDate;
        this.rating = rating;
    }

    public void play() {
        //ui.displayMsg(movies.movieName + " is now playing");
        //ArrayList<Movies> m = new ArrayList<>();
        //user.addToWatchedMovies(m, movies);
    }

    public void addToUserList() {
        //user.addToWatchedMovies(ArrayList<>, movies);
    }

    public void removeFromUserList() {

    }

    public ArrayList<String> getGenre() {
        return genre;
    }

    @Override
    public String toString() {
        return "Movie name: " + movieName + " Genre: " + genre + " releaseDate: " + releaseDate + " Rating: " + rating;
    }

}
