package org.example;

import java.util.ArrayList;
import java.util.Map;

public class User {
    private final String username;
    private final String password;
    private ArrayList<Movies> watchedMovies;
    private ArrayList<Movies> savedMovies;
    private final ArrayList<Series> watchedSeries;
    private final ArrayList<Series> savedSeries;

    public User(String username, String password){
        this.username = username;
        this.password = password;
        this.watchedMovies = new ArrayList<>();
        this.savedMovies = new ArrayList<>();
        this.watchedSeries =  new ArrayList<>();
        this.savedSeries = new ArrayList<>();
    }

    public void addToWatchedMovies(Movies movies){
        watchedMovies.add(movies);
    }

    public void addToSavedMovies(ArrayList<Movies> savedMovies, Movies movies){
        savedMovies.add(movies);
    }

    public void addToWatchedSeries(Series series){
        watchedSeries.add(series);
    }

    public void addToSavedSeries(ArrayList<Series> savedSeries, Series series){
        savedSeries.add(series);
    }





}
