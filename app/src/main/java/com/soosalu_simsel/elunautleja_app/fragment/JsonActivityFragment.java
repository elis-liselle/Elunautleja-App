package com.soosalu_simsel.elunautleja_app.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.soosalu_simsel.elunautleja_app.R;
import com.soosalu_simsel.elunautleja_app.model.JsonActivity;
import com.soosalu_simsel.elunautleja_app.utils.Utils;

import java.util.Iterator;
import java.util.List;

public class JsonActivityFragment extends Fragment {

    private Utils utils = new Utils();
    private List activities;


   @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.fragment_json_activity);
    }


    @Nullable
    @Override

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_json_activity, container, false);
        LinearLayout linearLayout = view.findViewById(R.id.jsonActivityLayout);
        Log.d("TAG", "JsonFragmentOnCreateView" );

        activities = utils.getToDosFromJsonFile(getContext(), "activities.json");

        Iterator iterator = activities.iterator();
        while (iterator.hasNext()){
            JsonActivity jsonActivity = (JsonActivity) iterator.next();
            Button jsonButtons = new Button(getContext());

            //TextView txtJsonActivity = new TextView(getContext());
            String toDo = jsonActivity.getToDo();
            //txtJsonActivity.setText(toDo);
            jsonButtons.setText(toDo);


            //linearLayout.addView(txtJsonActivity);
            linearLayout.addView(jsonButtons);

        }
        return view;

    }
}