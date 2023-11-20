package org.example;
import java.util.ArrayList;

public class Homepage {
    FileIO io = new FileIO();
    private ArrayList<Movies> movieList;
    private ArrayList<Movies> watchedMovies;
    private ArrayList<Movies> savedMovies;
    private ArrayList<Series> serieList;
    private ArrayList<Series> watchedSeries;
    private ArrayList<Series> savedSeries;

    public Homepage(){
        this.movieList = new ArrayList<>();
        this.watchedMovies = new ArrayList<>();
        this.savedMovies = new ArrayList<>();
        this.serieList = new ArrayList<>();
        this.watchedSeries = new ArrayList<>();
        this.savedSeries = new ArrayList<>();
    }

    public void setUp(){
        //String [] readData = io.readMediaData("data/")
        ArrayList<String> readData = io.readMediaData("data/");
            for (String s : readData){
                String [] row = s.split(";");
                String Name = row[0];
                String Genre = row[1];
            }

        }


    public ArrayList<Movies> getMovieList() {
        return movieList;
    }
    public ArrayList<Movies> getWatchedMovies(){
        return watchedMovies;
    }
    public ArrayList<Movies> getSavedMovies(){
        return savedMovies;
    }
    public ArrayList<Series> getSerieList(){
        return serieList;
    }
    public ArrayList<Series> getWatchedSeries(){
        return watchedSeries;
    }
    public ArrayList<Series> getSavedSeries(){
        return savedSeries;
    }
    public void endStreming(){

    }

    //Rodney laver USECASE2 = RegisterUser
}
