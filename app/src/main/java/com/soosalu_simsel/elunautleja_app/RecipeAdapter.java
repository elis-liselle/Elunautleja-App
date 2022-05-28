package com.soosalu_simsel.elunautleja_app;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.textfield.TextInputEditText;
import com.soosalu_simsel.elunautleja_app.model.Recipe;

import java.util.ArrayList;

public class RecipeAdapter extends RecyclerView.Adapter<RecipeAdapter.RecipeViewHolder> {
    private ArrayList<Recipe> recipeList;

    public RecipeAdapter() { this.recipeList = new ArrayList<>(); }

    @NonNull
    @Override
    public RecipeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_main,parent,false);
        return new RecipeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecipeViewHolder holder, int position) {
        Recipe recipe = recipeList.get(position);
        holder.title.setText(recipe.getTitle());
        //holder.instructions.setText(recipe.getInstructions());
    }
    public void setRecipeList(final ArrayList<Recipe>recipeList) {this.recipeList = recipeList; notifyDataSetChanged(); }

    @Override
    public int getItemCount() { return recipeList.size(); }

    static class RecipeViewHolder extends RecyclerView.ViewHolder {
        private final TextInputEditText title;
        //private final TextInputEditText instructions;

        public RecipeViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.txtRecipeLayout);
            //instructions = itemView.findViewById(R.id.txtRecipeLayout);
        }
    }

}