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

import com.soosalu_simsel.elunautleja_app.R;
import com.soosalu_simsel.elunautleja_app.RecipeAdapter;
import com.soosalu_simsel.elunautleja_app.viewmodel.RecipeViewModel;


public class RecipeFragment extends Fragment {

   private RecipeAdapter recipeAdapter;

   @Override
   public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       View view = inflater.inflate(R.layout.fragment_recipe, container, false);
       //changing the menu bar title
       requireActivity().setTitle(getString(R.string.recipe));
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

        RecipeViewModel recipeViewModel = new ViewModelProvider(this).get(RecipeViewModel.class);
        recipeViewModel.getDayRecipe();
        recipeViewModel.getRecipeLiveData().observe(this, recipes -> recipeAdapter.setRecipeList(recipes));
    }
}