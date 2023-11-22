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
    ArrayList<String> menuOptions =  new ArrayList<>();

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
            String[] releaseDates = row[1].split("-");
            int releaseDateStart, releaseDateEnd;
            try {
                releaseDateStart = Integer.parseInt(releaseDates[0].trim());
            } catch (NumberFormatException e) {
                System.err.println("Error parsing release date start for series: " + name);
                continue;
            }
            if (row[1].endsWith("-")) {
                releaseDateEnd = Series.ONGOING;
            } else if (releaseDates.length > 1 && !releaseDates[1].trim().isEmpty()) {
                try {
                    releaseDateEnd = Integer.parseInt(releaseDates[1].trim());
                } catch (NumberFormatException e) {
                    System.err.println("Error parsing release date end for series: " + name);
                    continue;
                }
            } else {
                releaseDateEnd = Series.ONGOING;
            }
            //int releaseDateStart = Integer.parseInt(releaseDates[0]);
            //int releaseDateEnd = row[1].endsWith("-") ? Series.ONGOING : Integer.parseInt(releaseDates[1].trim());
            ArrayList<String> genre = new ArrayList<>(Arrays.asList(row[2].trim().split(",")));
            String ratingString = row[3].trim().replace(",", ".");
            float rating = Float.parseFloat(ratingString);

            String seasonsAndEpisodes = row[4];
            Map<Integer, Integer> episodesPerSeason = new HashMap<>();
            String[] seasonEpisodesPairs = seasonsAndEpisodes.trim().split(",");
            for (String seasonEpisodesPair : seasonEpisodesPairs) {
                String[] seasonEpisode = seasonEpisodesPair.split("-");
                int seasonNumber = Integer.parseInt(seasonEpisode[0].trim());
                int episodeNumber = Integer.parseInt(seasonEpisode[1].trim());
                episodesPerSeason.put(seasonNumber, episodeNumber);
            }
            registerSeries(name,releaseDateStart,releaseDateEnd,genre,rating,episodesPerSeason);
        }
        displaySeries();
    }

    public void logInDialog() {
        String input = "";
        ui.displayMsg("Welcome to ChillFlix");
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

    public void menuDialog(){
        ui.displayMsg("Choose one of the following category's ");
        categoryMenu();
        String input = ui.getInput("");
        if (input.equalsIgnoreCase("Specific Movies")){ // søg efter en bestemt film
            ui.displayMsg("these movies are super good man");
        } else if (input.equalsIgnoreCase("Categorys")){ // søg efter alle genre
            ui.displayMsg("Craaazy Categorys daaawg");
        } else if (input.equalsIgnoreCase("Watched Movies")) { // alle sete film for brugeren
            ui.displayMsg("U have watched these movies... gang gang");
        } else if (input.equalsIgnoreCase("Saved Movies")) { // alle gemte film for brugeren
            ui.displayMsg("Why did u save all these movies??..... skrrt");
        } else {
            ui.displayMsg("You didn't choose an existing category, try again noob");
            ui.displayMsg("");
            menuDialog();
        }
    }

    public void categoryMenu() {
        menuOptions.add("Best Movies");
        menuOptions.add("Category's");
        menuOptions.add("Watched Movies");
        menuOptions.add("Saved Movies");
        System.out.println(menuOptions);
    }

    public void watchedMovies(){

    }
    public void movieCategory(){

    }

    public void SearchMovie(){
        displayMovies();
        ui.displayMsg("");
        String input = ui.getInput("Choose a movie");
        if (input.equalsIgnoreCase("")){

        }
    }

    public void backToMenu(){
        menuDialog();
    }

    public void endApplication(){

    }

    private void registerMovies(String name, int releaseDate, ArrayList<String> genres, float rating) {
        Movies m = new Movies(name, releaseDate, genres, rating);
        movies.add(m);
    }

    private void registerSeries(String seriesName, int releaseDateStart, int releaseDateEnd, ArrayList<String> genre, float rating, Map<Integer, Integer> episodesPerSeason) {
        Series s = new Series(seriesName, releaseDateStart, releaseDateEnd, genre, rating, episodesPerSeason);
        series.add(s);
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

