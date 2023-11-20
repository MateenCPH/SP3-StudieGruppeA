package org.example;

import java.util.ArrayList;
import java.util.Map;

public class User {
    private String username;
    private String password;
    ArrayList<Movies> watchedMovies;
    ArrayList<Movies> savedMovies;
    ArrayList<Series> watchedSeries;
    ArrayList<Series> savedSeries;
    private TextUI ui = new TextUI();

    public User(String username, String password){
        this.username = username;
        this.password = password;
        this.watchedMovies = new ArrayList<>();
        this.savedMovies = new ArrayList<>();
        this.watchedSeries =  new ArrayList<>();
        this.savedSeries = new ArrayList<>();
    }

    public void createAccount() {
        String name = "";
        String code = "";
        name = ui.getInput(" Type Username");
        if (name.length() > 15) {
            System.out.println("User name is too long, try again");
        } else {
            code = ui.getInput("Type Password");
            if (code.length() <= 8) {
                System.out.println("New account is now registered");
            }// hvordan får man tilføjet den nye bruger til userList.txt?
        }
    }








    public void loginAccount(){

    }

    public void addToWatchedMovies(ArrayList<Movies> watchedMovies, Movies movies){
        watchedMovies.add(movies);
    }

    public void addToSavedMovies(ArrayList<Movies> savedMovies, Movies movies){
        savedMovies.add(movies);
    }

    public void addToWatchedSeries(ArrayList<Series> watchedSeries,Series series){
        watchedSeries.add(series);
    }

    public void addToSavedSeries(ArrayList<Series> savedSeries, Series series){
        savedSeries.add(series);
    }





}
