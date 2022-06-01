package com.soosalu_simsel.elunautleja_app.model;

public class Movie {
    private final String title;
    private final String overview;
    private final String image;

    public Movie(String title, String overview, String image) {
        this.title = title;
        this.overview = overview;
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public String getOverview() {
        return overview;
    }

    public String getImage() {
        return image;
    }
}

