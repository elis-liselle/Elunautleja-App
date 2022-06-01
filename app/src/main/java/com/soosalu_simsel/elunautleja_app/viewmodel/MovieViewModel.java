package com.soosalu_simsel.elunautleja_app.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.soosalu_simsel.elunautleja_app.MovieRepository;
import com.soosalu_simsel.elunautleja_app.model.Movie;

import java.util.ArrayList;

public class MovieViewModel extends AndroidViewModel {
    private final MovieRepository movieRepository;
    private final MutableLiveData<ArrayList<Movie>> movieLiveData;

    public MovieViewModel(@NonNull Application application) {
        super(application);
        movieRepository = new MovieRepository(application);
        movieLiveData = movieRepository.getMovieLiveData();
    }

    public MutableLiveData<ArrayList<Movie>> getMovieLiveData() {
        return movieLiveData;
    }
    public void getDayMovie() {
        movieRepository.getDayMovie();
    }

}
