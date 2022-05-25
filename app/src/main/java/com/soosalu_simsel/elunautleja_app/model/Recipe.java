package com.soosalu_simsel.elunautleja_app.model;

public class Recipe {
    private final String recipeTitle;
    private final String recipeInfo;

    public Recipe(String recipeTitle, String recipeInfo) {
        this.recipeTitle = recipeTitle;
        this.recipeInfo = recipeInfo;
    }

    public String getRecipeTitle() {
        return recipeTitle;
    }
    public String getRecipeInfo() {
        return  recipeInfo;
    }
}
