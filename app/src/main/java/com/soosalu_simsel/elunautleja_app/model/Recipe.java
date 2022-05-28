package com.soosalu_simsel.elunautleja_app.model;

public class Recipe {
    private final String title;
    private final String instructions;

    public Recipe(String title, String instructions) {
        this.title = title;
        this.instructions = instructions;
    }

    public String getTitle() {
        return title;
    }
    public String getInstructions() {
        return  instructions;
    }
}
