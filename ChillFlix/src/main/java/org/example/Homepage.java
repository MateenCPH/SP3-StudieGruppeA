package org.example;
import java.util.HashMap;
import java.util.Map;

public class Homepage {
    FileIO io = new FileIO();
    private ArrayList<Movies> movies;
    private ArrayList<Series> seriesList;
    private ArrayList<Series> watchedSeries;
    private ArrayList<Series> savedSeries;
    private TextUI ui = new TextUI();
    private User u = new User("Username", "Password");

    public Homepage() {
        this.movies = new ArrayList<>();
        this.seriesList = new ArrayList<>();
        this.watchedSeries = new ArrayList<>();
        this.savedSeries = new ArrayList<>();
    }
    public void setup() {
        //String [] readData = io.readMediaData("data/")
        ArrayList<String> movieData = io.readMediaData("org/example/movies.txt");
        for (String s : movieData) {
            String[] row = s.split(";");
            String name = row[0];
            int releaseDate = Integer.parseInt(row[1]);
            Set<String> genres = new HashSet<>(Arrays.asList(row[2].split(",")));
            double rating = Double.parseDouble(row[3]);

                registerMovies(name,releaseDate,genres,rating);
            }

            ArrayList<String> seriesData = io.readMediaData("org/example/series.txt");
            for (String s : seriesData) {
                String [] row = s.split(";");
                String name = row[0];
                int releaseDate = Integer.parseInt(row[1]);

            }



        }

        public void logInDialog(){
        String input = "";
        input = ui.getInput("Login or New account. L/N: ");
        if (!input.equals("L")) {
            u.createAccount();
        }
        else {
            u.loginAccount();

        }
            }





        private void registerMovies(String name, int releaseDate, Set<String>genres, double rating){
        Movies m = new Movies(name,releaseDate,genres,rating);
        movies.add(m);
        }





        public ArrayList<Movies> getMovies() {
        return movies;
    }
    public ArrayList<Movies> getWatchedMovies(){
        return watchedMovies;
    }
    public ArrayList<Movies> getSavedMovies(){
        return savedMovies;
    }
    public ArrayList<Series> getSerieList(){
        return seriesList;
    }
    public ArrayList<Series> getWatchedSeries(){
        return watchedSeries;
    }
    public ArrayList<Series> getSavedSeries(){
        return savedSeries;
    }
    public void endStreming(){

    }
    public void createAccount() {
        String name = "";
        String password = "";
        name = ui.getInput(" Type Username");
        if (name.length() > 15) {
            System.out.println("User name is too long, try again");
        } else {
            password = ui.getInput("Type Password");
            if (password.length() <= 8) {
                System.out.println("New account is now registered");
            }// hvordan får man tilføjet den nye bruger til userList.txt?
        }
    }
    public Map<String, User> getUserMap() {
        return userMap;
    }

    public void loginAccount() {
        String inputUsername = ui.getInput("Enter your username:");
        String inputPassword = ui.getInput("Enter your password:");

        User user = userMap.get(inputUsername);

        if (user != null && user.getPassword().equals(inputPassword)) {
            System.out.println("Login Successful!");
        } else {
            System.out.println("Invalid username or password. Please try again.");
        }
    }
}

