package com.soosalu_simsel.elunautleja_app.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.soosalu_simsel.elunautleja_app.R;


public class MainFragment extends Fragment {

    NavController navController;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        navController = Navigation.findNavController(view);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main,container,false);
        setHasOptionsMenu(true);
        requireActivity().setTitle(getString(R.string.main));

        view.findViewById(R.id.btnRecipe).setOnClickListener(view1 -> {
         Navigation.findNavController(view).navigate(R.id.action_mainFragment_to_recipeFragment);
        });

        return view;
    }

}
