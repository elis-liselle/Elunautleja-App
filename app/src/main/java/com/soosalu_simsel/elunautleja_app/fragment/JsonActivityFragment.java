package com.soosalu_simsel.elunautleja_app.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.soosalu_simsel.elunautleja_app.R;
import com.soosalu_simsel.elunautleja_app.model.JsonActivity;
import com.soosalu_simsel.elunautleja_app.model.Movie;
import com.soosalu_simsel.elunautleja_app.model.Recipe;
import com.soosalu_simsel.elunautleja_app.utils.Utils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class JsonActivityFragment extends Fragment {

    private Utils utils = new Utils();
    private List activities;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_json_activity, container, false);
        LinearLayout linearLayout = view.findViewById(R.id.jsonActivityLayout);
        Log.d("TAG", "JsonFragmentOnCreateView" );

        activities = utils.getToDosFromJsonFile(getContext(), "activities.json");

        Iterator iterator = activities.iterator();
        while (iterator.hasNext()) {
            JsonActivity jsonActivity = (JsonActivity) iterator.next();
            String[] toDo = {jsonActivity.getToDo()};
            Random r = new Random();
            int randomNumber = r.nextInt(toDo.length);


            TextView txtJsonActivity = new TextView(getContext());
            txtJsonActivity.setText(toDo[randomNumber]);

            linearLayout.addView(txtJsonActivity);
        }
        return view;
    }
}