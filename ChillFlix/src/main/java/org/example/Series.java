package org.example;

import java.util.ArrayList;

public class Series implements Media{

    private final String seriesName;
    private ArrayList<String> category = new ArrayList<>();
    private final int releaseDateStart;
    private final int releaseDateEnd;
    private final float rating;
    private final int season;
    private final int episode;

    public Series(String seriesName, int releaseDateStart, int releaseDateEnd, ArrayList<String> category, float rating, int season, int episode){
        this.seriesName = seriesName;
        this.season = season;
        this.episode = episode;
        this.category = category;
        this.releaseDateStart = releaseDateStart;
        this.releaseDateEnd=releaseDateEnd;
        this.rating = rating;
    }

    public void play(User user, Series series) {
        System.out.println(seriesName + " " + season + " " + episode + " is now playing");
        user.addToWatchedSeries(ArrayList<>, series);
    }

    public void addToUserList(User user, Series series) {
        user.addToSavedSeries(ArrayList<>, series);
    }

    public void removeFromUserList(User user, Series series) {

    }

    @Override
    public String toString() {
        return "Series name: " + seriesName + " Season: " + season + " Episode: " + episode + " Category: " + category + " ReleaseDate: " + releaseDateStart + " Rating: " + rating;
    }
}
