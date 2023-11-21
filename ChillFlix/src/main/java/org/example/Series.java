package org.example;

import java.util.ArrayList;

public class Series implements Media{

    private final String seriesName;
    private final ArrayList<String> genre;
    private final int releaseDateStart;
    private final int releaseDateEnd;
    private final float rating;
    private final int season;
    private final int episode;

    public Series(String seriesName, int releaseDateStart, int releaseDateEnd, ArrayList<String> genre, float rating, int season, int episode){
        this.seriesName = seriesName;
        this.season = season;
        this.episode = episode;
        this.genre = genre;
        this.releaseDateStart = releaseDateStart;
        this.releaseDateEnd=releaseDateEnd;
        this.rating = rating;
    }

    public void play() {
        System.out.println(seriesName + " " + season + " " + episode + " is now playing");
        //user.addToWatchedSeries(ArrayList<>, series);
    }

    public void addToUserList() {
        //user.addToSavedSeries(ArrayList<>, series);
    }

    public void removeFromUserList() {

    }

    @Override
    public String toString() {
        return "Series name: " + seriesName + " Season: " + season + " Episode: " + episode + " Genre: " + genre + " ReleaseDate: " + releaseDateStart + " Rating: " + rating;
    }
}
