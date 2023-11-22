package org.example;

import java.util.*;
import java.util.HashMap;


public class Homepage {
    FileIO io = new FileIO();
    private ArrayList<Movies> movies;
    private ArrayList<Series> series;
    private ArrayList<Series> seriesList;
    private final TextUI ui = new TextUI();
    private final User u = new User("Username", "Password");
    ArrayList<User> userList = new ArrayList<>();

    public Homepage() {
        this.movies = new ArrayList<>();
        this.seriesList = new ArrayList<>();
        this.series = new ArrayList<>();
    }

    public void setup() {
        //String [] readData = io.readMediaData("data/")
        ArrayList<String> movieData = io.readMediaData("C:\\Users\\mjar\\Documents\\dev\\SP3-StudieGruppeA\\ChillFlix\\src\\main\\java\\org\\example\\movies.txt");

        for (String s : movieData) {
            String[] row = s.split(";");
            String name = row[0].trim();
            int releaseDate = Integer.parseInt((row[1]).trim());
            ArrayList<String> genres = new ArrayList<>(Arrays.asList(row[2].trim().split(",")));
            String ratingString = row[3].trim().replace(",", ".");
            float rating = Float.parseFloat(ratingString);

            registerMovies(name, releaseDate, genres, rating);
        }
        this.displayMovies();

        ArrayList<String> seriesData = io.readMediaData("C:\\Users\\mjar\\Documents\\dev\\SP3-StudieGruppeA\\ChillFlix\\src\\main\\java\\org\\example\\series.txt");
        for (String s : seriesData) {
            String[] row = s.split(";");
            String name = row[0];
            int releaseDateStart = Integer.parseInt(row[1].trim().split("-")[0]);
            int releaseDateEnd = Integer.parseInt(row[1].trim().split("-")[1]);
            List<String> genres = new ArrayList<>(Arrays.asList(row[2].trim().split(",")));
            String ratingString = row[3].trim().replace(",", ".");
            double rating = Double.parseDouble(ratingString);
            String season = Arrays.toString(row[4].trim().split(","));
        }
        displaySeries();
    }

    public void logInDialog() {
        String input = "";
        ui.displayMsg("Welcome to ChillFix");
        ui.displayMsg("Would you like to login or create a new user?");
        input = ui.getInput("Press 'L' for Login or 'N' to create a new user");
        ui.displayMsg(" ");
        if (input.equalsIgnoreCase("N")) {
            createAccount();
        } else if (input.equalsIgnoreCase("L")) {
            loginAccount();
        } else {
            ui.displayMsg("Please only enter 'N' or 'L'");
            logInDialog();
        }
    }

    public void createAccount() {
        String newUsername = ui.getInput("Enter a new username:");
        String newPassword = ui.getInput("Enter a new password:");

        User newUser = new User(newUsername, newPassword);
        userList.add(newUser);
        //saveUserList();
        ui.displayMsg("");
        ui.displayMsg("New user created successfully");
        loginAccount();
    }

    public void loginAccount() {
        String inputUserName = ui.getInput("Enter your username:");
        String inputPassword = ui.getInput("Enter your password:");

        for (User user : userList) {
            if (user.getUsername().equals(inputUserName) && user.getPassword().equals(inputPassword)) {
                System.out.println("Welcome " + inputUserName);

                return;
            }
        }
        ui.displayMsg("");
        System.out.println("Invalid username or password. Please try again.");
        loginAccount();
    }

    private void registerMovies(String name, int releaseDate, ArrayList<String> genres, float rating) {
        Movies m = new Movies(name, releaseDate, genres, rating);
        movies.add(m);
    }

    public ArrayList<Movies> getMovies() {
        return movies;
    }

    /*public ArrayList<Movies> getWatchedMovies(){
        return watchedMovies;
    }
    public ArrayList<Movies> getSavedMovies(){
        return savedMovies;
    }*/
    public ArrayList<Series> getSerieList() {
        return seriesList;
    }

    public void endStreaming() {

    }

    private void displayMovies() {
        String s = "\nAll movies:\n";

        for (Movies movies : movies) {
            s = s.concat(movies.toString() + "\n");
        }
        ui.displayMsg(s);
    }

    private void displaySeries() {
        String j = "\nAll series:";

        for (Series series : series) {
            j = j.concat(series.toString() + "\n");
        }
        ui.displayMsg(j);
    }
}

