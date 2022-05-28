package com.soosalu_simsel.elunautleja_app.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;
import com.soosalu_simsel.elunautleja_app.R;
import com.soosalu_simsel.elunautleja_app.viewmodel.LoginViewModel;

public class LoginFragment extends Fragment {
    //declaring variables
    private TextInputEditText login_email;
    private TextInputEditText login_password;
    private CoordinatorLayout contained;
    private LoginViewModel loginViewModel;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loginViewModel = new ViewModelProvider(this).get(LoginViewModel.class);
        loginViewModel.getUserMutableLiveData().observe(this, firebaseUser -> {
            if (firebaseUser != null){
                if (getView() != null) Navigation.findNavController(getView())
                        .navigate(R.id.action_loginFragment_to_mainFragment);
            }
        });
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login,container,false);
        //changing the menu bar title
        requireActivity().setTitle(getString(R.string.login));
        //initialize variables
        contained = view.findViewById(R.id.login_coordinator);
        login_email = view.findViewById(R.id.emailLogin);
        login_password =view.findViewById(R.id.etPasswordLogin);
        //Login button click handler
        view.findViewById(R.id.btnLogin).setOnClickListener(view1 -> {
            String email = login_email.getText().toString().trim();
            String password = login_password.getText().toString().trim();
            if (email.length() > 0 && password.length() > 0){
                loginViewModel.login(email,password);
            } else {
                Snackbar.make(view.findViewById(R.id.login_coordinator),
                        getString(R.string.missing),Snackbar.LENGTH_SHORT).show();
            }
        });
        //Register button click handler
        view.findViewById(R.id.btnRegisterUser).setOnClickListener(view1 -> {
            Navigation.findNavController(view).navigate(R.id.action_loginFragment_to_registerFragment);
        });

        return view;
    }
}
