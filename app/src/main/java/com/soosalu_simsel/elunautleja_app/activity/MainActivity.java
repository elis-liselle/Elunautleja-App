package com.soosalu_simsel.elunautleja_app.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.google.firebase.firestore.FirebaseFirestore;
import com.soosalu_simsel.elunautleja_app.R;

public class MainActivity extends AppCompatActivity {

    FirebaseFirestore db = FirebaseFirestore.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}