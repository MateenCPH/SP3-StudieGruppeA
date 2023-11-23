package org.example;

import java.util.*;
import java.util.HashMap;


public class Homepage {
    FileIO io = new FileIO();
    private ArrayList<Movies> movies;
    private ArrayList<Series> series;
    private final TextUI ui = new TextUI();
    private final User u = new User("Username", "Password");
    ArrayList<User> userList = new ArrayList<>();
    ArrayList<String> menuOptions = new ArrayList<>();

    public Homepage() {
        this.movies = new ArrayList<>();
        this.series = new ArrayList<>();
    }

    public void setup() {
        //String [] readData = io.readMediaData("data/")
        ArrayList<String> movieData = io.readMediaData("C:\\Users\\matee\\Documents\\Intellij\\SP3-StudieGruppeA\\ChillFlix\\src\\main\\java\\data\\movies.txt");

        for (String s : movieData) {
            String[] row = s.split(";");
            String name = row[0].trim();
            String releaseDate = row[1].trim();
            String[] genres = row[2].trim().split(",");
            ArrayList<String> genre = new ArrayList<>(List.of(genres));
            String ratingString = row[3].trim().replace(",", ".");
            double rating = Double.parseDouble(ratingString);

            registerMovies(name, releaseDate, genre, rating);
        }
        //this.displayMovies();

        ArrayList<String> seriesData = io.readMediaData("C:\\Users\\matee\\Documents\\Intellij\\SP3-StudieGruppeA\\ChillFlix\\src\\main\\java\\data\\series.txt");
        for (String s : seriesData) {
            String[] row = s.split(";");
            String name = row[0];
            String runTime = row[1].trim();

            String[] genres = row[2].split(",");
            ArrayList<String> genre = new ArrayList<>(List.of(genres));

            String ratingString = row[3].trim().replace(",", ".");
            double rating = Double.parseDouble(ratingString);

            String seasonsAndEpisodes = row[4];
            Map<Integer, Integer> episodesPerSeason = new HashMap<>();
            String[] seasonEpisodesPairs = seasonsAndEpisodes.trim().split(",");
            for (String seasonEpisodesPair : seasonEpisodesPairs) {
                String[] seasonEpisode = seasonEpisodesPair.split("-");
                int seasonNumber = Integer.parseInt(seasonEpisode[0].trim());
                int episodeNumber = Integer.parseInt(seasonEpisode[1].trim());
                episodesPerSeason.put(seasonNumber, episodeNumber);
            }
            registerSeries(name, runTime, genre, rating, episodesPerSeason);
        }
        //this.displaySeries();
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
                menuDialog();
                return;
            }
        }
        ui.displayMsg("");
        System.out.println("Invalid username or password. Please try again.");
        loginAccount();
    }

    public void menuDialog() {
        ui.displayMsg("Choose one of the following category's ");
        categoryMenu();
        String input = ui.getInput("");
        if (input.equalsIgnoreCase("1") || input.equalsIgnoreCase("search movie")) { // søg efter en bestemt film
            searchMovie();
        } else if (input.equalsIgnoreCase("2") || input.equalsIgnoreCase("Categorys")) { // søg efter alle genre
            ui.displayMsg("Craaazy Categorys daaawg");
        } else if (input.equalsIgnoreCase("3") || input.equalsIgnoreCase("Watched Movies")) { // alle sete film for brugeren
            ui.displayMsg("U have watched these movies... gang gang");
        } else if (input.equalsIgnoreCase("4") || input.equalsIgnoreCase("Saved Movies")) { // alle gemte film for brugeren
            ui.displayMsg("Why did u save all these movies??..... skrrt");
        } else {
            ui.displayMsg("You didn't choose an existing category, try again noob");
            ui.displayMsg("");
            menuDialog();
        }
    }

    public void categoryMenu() {
        menuOptions.add("[1] Search specific movie");
        menuOptions.add("[2] Category's");
        menuOptions.add("[3] Watched Movies");
        menuOptions.add("[4] Saved Movies");
        System.out.println(menuOptions);
    }

    public void searchMovie() {
        ui.displayMsg("");
        String input = ui.getInput("Choose a movie");

        for (Movies movie : movies) {
            if (movie.getMediaName().equalsIgnoreCase(input)) {
                ui.displayMsg(movie.getMediaName() + "is now playing...");
                break;
            } else {
                ui.displayMsg("Could not find movie, try something else");
                searchMovie();
            }
        }
    }

    public void showWatchedMovies() {

        if (u.watchedMovies.isEmpty()) {
            ui.displayMsg(u.getUsername() + ". You have not watched any movies yet\nReturning to the main menu");
            menuDialog();

        } else {
            ui.displayMsg(u.getUsername() + ", this are the movies you have seen");

            for (Movies movie : u.watchedMovies) {
                ui.displayMsg(movie.toString());
            }
        }
    }

    /*public void movieCategory() {
        //eventuelt tilføj en equals metode (); finde ud af hvad der skal indgå i sammenligningen.
        Set<String> categories = new HashSet<>();
        for (Movies movie : movies) {
            // adAll sørger for at add alle film genre til Set categories
            categories.addAll(movie.getGenre());
        }
        ui.displayMsg("This is the categories");
        for (String category : categories) {
            ui.displayMsg(category);
        }
        System.out.println(categories);

        // Tilføjelse af der skal vælges imellem genrene af film.
        String selectedCategory = ui.getInput("Chose a category");

    }

    public boolean equals (Object o){
        if (this == o) return true;
        if (o==null || getClass() != o.getClass()) return false;
        Media media =(Media) o;
        return Object.equals(genre, media.genre);
    } */


    public void backToMenu() {
        menuDialog();
    }

    public void endApplication() {

    }

    private void registerMovies(String name, String releaseDate, ArrayList<String> genres, double rating) {
        Movies m = new Movies(name, releaseDate, genres, rating);
        movies.add(m);
    }

    private void registerSeries(String seriesName, String releaseDateStart, ArrayList<String> genre, double rating, Map<Integer, Integer> episodesPerSeason) {
        Series s = new Series(seriesName, releaseDateStart, genre, rating, episodesPerSeason);
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
    /*
    public ArrayList<Series> getSerieList() {
        return seriesList;
    }*/

    public void endStreaming() {

    }

    private void displayMovies() {
        String s = "All movies:\n";

        for (Movies movies : movies) {
            s = s.concat(movies.toString() + "\n");
        }
        ui.displayMsg(s);
    }

    private void displaySeries() {
        String j = "All series:\n";

        for (Series series : series) {
            j = j.concat(series.toString() + "\n");
        }
        ui.displayMsg(j);
    }
}

