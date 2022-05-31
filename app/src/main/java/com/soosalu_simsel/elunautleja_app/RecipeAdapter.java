package com.soosalu_simsel.elunautleja_app;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.textfield.TextInputEditText;
import com.soosalu_simsel.elunautleja_app.model.Recipe;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class RecipeAdapter extends RecyclerView.Adapter<RecipeAdapter.RecipeViewHolder> {
    private ArrayList<Recipe> recipeList;

    public RecipeAdapter() { this.recipeList = new ArrayList<>(); }

    @NonNull
    @Override
    public RecipeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_recipe,parent,false);
        return new RecipeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecipeViewHolder holder, int position) {
        Recipe recipe = recipeList.get(position);
        holder.title.setText(recipe.getTitle());
        holder.timeInMinutes.setText(recipe.getReadyInMinutes());
        holder.servings.setText(recipe.getServings());
        holder.sourceUrl.setText(recipe.getSourceUrl());
        holder.instructions.setText(recipe.getInstructions());
        Picasso.get().load(recipe.getImage()).into(holder.image);
    }
    public void setRecipeList(final ArrayList<Recipe>recipeList) {this.recipeList = recipeList; notifyDataSetChanged(); }

    @Override
    public int getItemCount() { return recipeList.size(); }

    static class RecipeViewHolder extends RecyclerView.ViewHolder {
        private final TextInputEditText title;
        private final TextInputEditText timeInMinutes;
        private final TextInputEditText servings;
        private final TextInputEditText sourceUrl;
        private final TextInputEditText instructions;
        private final ImageView image;

        public RecipeViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.txtRecipeTitle);
            timeInMinutes = itemView.findViewById(R.id.txtTimeRecipe);
            servings = itemView.findViewById(R.id.txtServings);
            sourceUrl = itemView.findViewById(R.id.txtSourceUrl);
            instructions = itemView.findViewById(R.id.txtInstructions);
            image = itemView.findViewById(R.id.imgRecipeImage);
        }
    }

}
