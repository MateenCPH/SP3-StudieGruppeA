package org.example;

import java.util.ArrayList;
import java.util.Map;

public class Series implements Media {

    private final String seriesName;
    private final ArrayList<String> genre;
    private final int releaseDateStart;
    private final int releaseDateEnd;
    private final float rating;
    protected static final int ONGOING = Integer.MAX_VALUE;
    private final Map<Integer, Integer> episodesPerSeason;

    public Series(String seriesName, int releaseDateStart, int releaseDateEnd, ArrayList<String> genre, float rating, Map<Integer, Integer> episodesPerSeason) {
        this.seriesName = seriesName;
        this.releaseDateStart = releaseDateStart;
        this.releaseDateEnd = releaseDateEnd;
        this.genre = genre;
        this.rating = rating;
        this.episodesPerSeason = episodesPerSeason;
    }

    public void play() {
        //System.out.println(seriesName + " " + season + " " + episode + " is now playing");
        //user.addToWatchedSeries(ArrayList<>, series);
    }

    public void addToUserList() {
        //user.addToSavedSeries(ArrayList<>, series);
    }

    public void removeFromUserList() {

    }

    public boolean isOnGoing() {
        return releaseDateEnd == ONGOING;
    }

    public Map<Integer, Integer> getEpisodesPerSeason() {
        return episodesPerSeason;
    }

    @Override
    public String toString() {
        return "Series name: " + seriesName + " | Release date start: " + releaseDateStart + " Release date end: " + (releaseDateEnd == Series.ONGOING ? "Ongoing" : String.valueOf(releaseDateEnd)) + " | Genre: " + genre + " Rating: " + rating + episodesPerSeason;
    }
}
