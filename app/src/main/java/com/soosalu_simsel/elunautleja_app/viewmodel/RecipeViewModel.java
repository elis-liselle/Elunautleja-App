package com.soosalu_simsel.elunautleja_app.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.soosalu_simsel.elunautleja_app.RecipeRepository;
import com.soosalu_simsel.elunautleja_app.model.Recipe;

import java.util.ArrayList;

public class RecipeViewModel extends AndroidViewModel{
    private final RecipeRepository recipeRepository;
    private final MutableLiveData<ArrayList<Recipe>> recipeLiveData;

    public RecipeViewModel(@NonNull Application application)  {
        super(application);
        recipeRepository = new RecipeRepository(application);
        recipeLiveData = recipeRepository.getRecipeLiveData();

        }
        public MutableLiveData<ArrayList<Recipe>> getRecipeLiveData() {return recipeLiveData; }

        public void getDayRecipe(String recipes) { recipeRepository.getDayRecipe(recipes); }
}

