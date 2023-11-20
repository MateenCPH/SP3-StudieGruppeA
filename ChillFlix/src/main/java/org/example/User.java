package org.example;

import java.util.ArrayList;
import java.util.Map;

public class User {
    private String username;
    private String password;
    ArrayList<Movies> savedMovies;
    ArrayList<Series> savedSeries;

    public User(String username, String password){
        this.username = username;
        this.password = password;
        this.savedMovies = new ArrayList<>();
        this.savedSeries = new ArrayList<>();
    }

    public void createAccount(){

    }

    public void loginAccount(){

    }

    public void addToSeenMovies(ArrayList<Movies> seenMovies,Movies movie){
        seenMovies.add(movie);
    }

    public void addToSavedMovies(ArrayList<Movies> savedMovies, Movies movie){
        savedMovies.add(movie);
    }



}
