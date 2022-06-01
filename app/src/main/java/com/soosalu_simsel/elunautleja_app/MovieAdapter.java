package com.soosalu_simsel.elunautleja_app;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.textfield.TextInputEditText;
import com.soosalu_simsel.elunautleja_app.model.Movie;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder> {
    private ArrayList<Movie> movieList;

    public MovieAdapter() {this.movieList = new ArrayList<>(); }

    @NonNull
    @Override

    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_movie,parent, false);
        return new MovieViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, int position) {
        Movie movie = movieList.get(position);
        holder.title.setText(movie.getTitle());
        holder.overview.setText(movie.getOverview());
        Picasso.get().load(movie.getImage()).into(holder.image);
    }

    public void setMovieList(final ArrayList<Movie>movieList) {
        this.movieList = movieList;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() { return movieList.size(); }

    static class MovieViewHolder extends RecyclerView.ViewHolder {
        private final TextInputEditText title;
        private final TextInputEditText overview;
        private final ImageView image;

        public MovieViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.txtMovieTitle);
            overview = itemView.findViewById(R.id.txtOverview);
            image = itemView.findViewById(R.id.imgMoviePoster);
        }
    }
}
