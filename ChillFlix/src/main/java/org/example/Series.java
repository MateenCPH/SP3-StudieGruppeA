package org.example;

import java.util.ArrayList;

public class Series {

    private final String seriesName;
    private ArrayList<String> category = new ArrayList<>();
    private final int releaseDate;
    private final float rating;
    private final int season;
    private final int episode;

    public Series(String seriesName, int season, int episode, ArrayList<String> category, int releaseDate, float rating){
        this.seriesName = seriesName;
        this.season = season;
        this.episode = episode;
        this.category = category;
        this.releaseDate = releaseDate;
        this.rating = rating;
    }

    public void play(User user) {
        System.out.println(seriesName + " " + season + " " + episode + " is now playing");
        user.addToWatchedSeries(this);
    }

    @Override
    public String toString() {
        return "Series name: " + seriesName + " Season: " + season + " Episode: " + episode + " Category: " + category + " ReleaseDate: " + releaseDate + " Rating: " + rating;
    }
}
