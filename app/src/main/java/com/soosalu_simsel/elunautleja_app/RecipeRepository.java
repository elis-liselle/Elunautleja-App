package com.soosalu_simsel.elunautleja_app;

import android.app.Application;
import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.google.gson.JsonObject;
import com.koushikdutta.ion.Ion;
import com.soosalu_simsel.elunautleja_app.model.Recipe;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Locale;

public class RecipeRepository {
    private static final String API_KEY = "472f31ce4a5e4e5792ca9ab6d1833e51";
    private static final String URL = "https://api.spoonacular.com/recipes/random";
    private final Application application;
    private final MutableLiveData<ArrayList<Recipe>> recipeLiveData;
    private final ArrayList<Recipe> arrayList = new ArrayList<>();

    public RecipeRepository(Application application) {
        this.application = application;
        recipeLiveData = new MutableLiveData<>();
    }

    public void getDayRecipe(String recipes) {
        Ion.with(application)
                .load(String.format(URL,API_KEY)).asJsonObject()
                .setCallback((e, result) -> {
                    Log.i( "getRandomRecipe",result.getAsJsonPrimitive("cod").toString());
                    parseResults(result);
                });
    }

    public String removeAbles(String text) {return text.substring(1,text.length()-1); }

    private void parseResults(JsonObject result) {
        JsonObject details = (JsonObject) result.getAsJsonArray("recipes").get(0);
        String title = String.valueOf(details.get("title")).toUpperCase(Locale.getDefault());
        recipeLiveData.setValue(arrayList);


    }

    public MutableLiveData<ArrayList<Recipe>> getRecipeLiveData() {
        return recipeLiveData;
    }
}
