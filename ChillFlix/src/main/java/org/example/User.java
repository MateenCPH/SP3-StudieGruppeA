package org.example;

import java.util.ArrayList;
import java.util.Map;

public class User {
    private String username;
    private String password;

    private ArrayList<Movies> watchedMovies;
    private ArrayList<Movies> savedMovies;
    private ArrayList<Series> watchedSeries;
    private final ArrayList<Series> savedSeries;

    public User(String username, String password){
        this.username = username;
        this.password = password;
        this.watchedMovies = new ArrayList<>();
        this.savedMovies = new ArrayList<>();
        this.watchedSeries =  new ArrayList<>();
        this.savedSeries = new ArrayList<>();
    }
    public void registerUser(){

        System.out.println("Please create an account with a username & password.");
    }

    public void addToWatchedMovies(Movies movies) {
        watchedMovies.add(movies);
    }

    public void addToSavedMovies(Movies movies) {
        savedMovies.add(movies);
    }

    public void removeFromSavedMovies(Movies movies) {
        savedMovies.remove(movies);
    }

    public void addToWatchedSeries(Series series) {
        watchedSeries.add(series);
    }

    public void addToSavedSeries(Series series) {
        savedSeries.add(series);
    }

    public void removeFromSavedSeries(Series series) {
        savedSeries.remove(series);
    }

    public String getUsername(){
        return username;
    }
    public String getPassword(){
        return password;
    }
    public void setUsername(String username){
        this.username = username;
    }
    public void setPassword(String password){
        this.password = password;
    }
}

