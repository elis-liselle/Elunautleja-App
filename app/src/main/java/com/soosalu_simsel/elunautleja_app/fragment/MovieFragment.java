package com.soosalu_simsel.elunautleja_app.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.soosalu_simsel.elunautleja_app.MovieAdapter;
import com.soosalu_simsel.elunautleja_app.R;
import com.soosalu_simsel.elunautleja_app.viewmodel.MovieViewModel;

public class MovieFragment extends Fragment {

private MovieAdapter movieAdapter;

@Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.fragment_movie, container, false);
    requireActivity().setTitle("Enjoy a Movie!");
    RecyclerView recyclerView = view.findViewById(R.id.RecyclerView_movie);
    recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
    recyclerView.setHasFixedSize(true);
    movieAdapter = new MovieAdapter();
    recyclerView.setAdapter(movieAdapter);
    return view;
}

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        MovieViewModel movieViewModel = new ViewModelProvider(this).get(MovieViewModel.class);
        movieViewModel.getDayMovie();
        movieViewModel.getMovieLiveData().observe(this, movies -> movieAdapter.setMovieList(movies));
    }

}