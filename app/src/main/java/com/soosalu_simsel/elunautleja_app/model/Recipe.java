package com.soosalu_simsel.elunautleja_app.model;

import android.text.Spanned;

public class Recipe {
    private final String title;
    private final String ingredients;
    private final Spanned instructions;
    private final String image;

    public Recipe(String title, String ingredients, Spanned instructions, String image) {
        this.title = title;
        this.ingredients = ingredients;
        this.instructions = instructions;
        this.image = image;

    }

    public String getTitle() {
        return title;
    }
    public String getIngredients() { return ingredients; }
    public Spanned getInstructions() {
        return  instructions;
    }
    public String getImage() { return image; }

}
