package com.soosalu_simsel.elunautleja_app.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.google.firebase.auth.FirebaseUser;
import com.soosalu_simsel.elunautleja_app.FirebaseRepository;

public class RegisterViewModel extends AndroidViewModel {
    private final FirebaseRepository firebaseRepository;
    private final MutableLiveData<FirebaseUser> userMutableLiveData;

    public RegisterViewModel(@NonNull Application application) {
        super(application);
        firebaseRepository = new FirebaseRepository(application);
        userMutableLiveData = firebaseRepository.getUserMutableLiveData();
    }
    public void userRegistration(String firstName, String lastName, String email, String password){
        firebaseRepository.userRegistration(firstName,lastName,email,password);
    }

    public MutableLiveData<FirebaseUser> getUserMutableLiveData() {
        return userMutableLiveData;
    }
}
