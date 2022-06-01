package com.soosalu_simsel.elunautleja_app;

import android.app.Application;

import androidx.lifecycle.MutableLiveData;

import com.google.gson.JsonObject;
import com.koushikdutta.ion.Ion;
import com.soosalu_simsel.elunautleja_app.model.Movie;

import java.util.ArrayList;

public class MovieRepository {

    private static final String API_KEY = "dc1fdf0f82ff4a18d5a0d571cae88c42";
    private static final String URL = "https://api.themoviedb.org/3/movie/popular?api_key=%s";
    private final Application application;
    private final MutableLiveData<ArrayList<Movie>> movieLiveData;
    private final ArrayList<Movie> arrayList = new ArrayList<>();

    public MovieRepository(Application application) {
        this.application = application;
        movieLiveData = new MutableLiveData<>();
    }

    public void getDayMovie() {
        Ion.with(application)
                .load(String.format(URL, API_KEY)).asJsonObject()
                .setCallback((e, result) -> {
                    parseResults(result);
                });
    }
    public String removeAbles(String text) {return text.substring(1,text.length()-1); }

    private void parseResults(JsonObject result) {
        JsonObject movieData = (JsonObject) result.getAsJsonArray("results").get(0);

        String title = String.valueOf(movieData.get("title"));
        String overview = String.valueOf(movieData.get("overview"));
        String image = String.valueOf(movieData.get("poster_path"));
        String imageUrl = "https://image.tmdb.org/t/p/w500" + removeAbles(image);

        Movie movie = new Movie(removeAbles(title), removeAbles(overview), imageUrl);
        arrayList.add(movie);

        movieLiveData.setValue(arrayList);
    }
    public MutableLiveData<ArrayList<Movie>> getMovieLiveData() {
        return movieLiveData;
    }
}
