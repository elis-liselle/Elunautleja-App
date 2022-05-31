package com.soosalu_simsel.elunautleja_app.model;

import android.text.Spanned;

public class Recipe {
    private final String title;
    private final String readyInMinutes;
    private final String servings;
    private final String sourceUrl;
    private final Spanned instructions;
    private final String image;

    public Recipe(String title, String readyInMinutes, String servings, String sourceUrl, Spanned instructions, String image) {
        this.title = title;
        this.readyInMinutes = readyInMinutes;
        this.servings = servings;
        this.sourceUrl = sourceUrl;
        this.instructions = instructions;
        this.image = image;

    }

    public String getTitle() {
        return title;
    }
    public String getReadyInMinutes() { return readyInMinutes; }
    public String getServings() { return servings; }
    public String getSourceUrl() { return sourceUrl; }
    public Spanned getInstructions() {
        return  instructions;
    }
    public String getImage() { return image; }

}
