package org.example;

public class Series implements Media{

    private final String seriesName;
    private final String category;
    private final int releaseDate;
    private final float rating;
    private final int season;
    private final int episode;

    public Series(String seriesName, int season, int episode, String category, int releaseDate, float rating){
        this.seriesName = seriesName;
        this.season = season;
        this.episode = episode;
        this.category = category;
        this.releaseDate = releaseDate;
        this.rating = rating;

    }

    public void play() {

    }

    public void addToUserList() {

    }

    public void removeFromUserList() {

    }

    @Override
    public String toString() {
        return "Series name: " + seriesName + " Season: " + season + " Episode: " + episode + " Category: " + category + " ReleaseDate: " + releaseDate + " Rating: " + rating;
    }
}
