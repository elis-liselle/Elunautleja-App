package com.soosalu_simsel.elunautleja_app.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.google.firebase.auth.FirebaseUser;
import com.soosalu_simsel.elunautleja_app.FirebaseRepository;
import com.soosalu_simsel.elunautleja_app.model.User;

import java.util.ArrayList;

public class UserViewModel extends AndroidViewModel {
    private final FirebaseRepository firebaseRepository;
    private final MutableLiveData<FirebaseUser> userMutableLiveData;
    private final MutableLiveData<Boolean> loggedOutMutableLiveData;
    private final MutableLiveData<ArrayList<User>> userLiveData;

    public UserViewModel(@NonNull Application application) {
        super(application);
        firebaseRepository = new FirebaseRepository(application);
        userMutableLiveData = firebaseRepository.getUserMutableLiveData();
        loggedOutMutableLiveData = firebaseRepository.getLoggedOutMutableLiveData();
        userLiveData = firebaseRepository.getUserLiveData();
    }
    public void logOut(){ firebaseRepository.logout(); }

    public MutableLiveData<FirebaseUser> getUserMutableLiveData() {
        return userMutableLiveData;
    }

    public MutableLiveData<Boolean> getLoggedOutMutableLiveData() {
        return loggedOutMutableLiveData;
    }

    public MutableLiveData<ArrayList<User>> getUserLiveData() {
        return userLiveData;
    }
}
