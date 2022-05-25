package com.soosalu_simsel.elunautleja_app.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.soosalu_simsel.elunautleja_app.R;
import com.soosalu_simsel.elunautleja_app.RecipeAdapter;
import com.soosalu_simsel.elunautleja_app.viewmodel.RecipeViewModel;


public class RecipeFragment extends Fragment {

   String recipes;
   private RecipeAdapter recipeAdapter;

   @Override
   public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       View view = inflater.inflate(R.layout.fragment_recipe, container, false);
       RecyclerView recyclerView = view.findViewById(R.id.recyclerView_recipe);
       recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
       recyclerView.setHasFixedSize(true);
       recipeAdapter = new RecipeAdapter();
       recyclerView.setAdapter(recipeAdapter);
       return view;
   }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            recipes = getArguments().getString("recipes");

        } else Toast.makeText(getActivity(), "No recipe available", Toast.LENGTH_SHORT).show();

        RecipeViewModel recipeViewModel = new ViewModelProvider(this).get(RecipeViewModel.class);
        recipeViewModel.getDayRecipe(recipes);
        recipeViewModel.getRecipeLiveData().observe(this, recipes -> recipeAdapter.setRecipeList(recipes));
    }
}