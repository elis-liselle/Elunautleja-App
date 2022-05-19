package com.soosalu_simsel.elunautleja_app.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
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
import com.soosalu_simsel.elunautleja_app.viewmodel.RegisterViewModel;
import com.soosalu_simsel.elunautleja_app.viewmodel.UserViewModel;

public class RegisterFragment extends Fragment {
    //declaring variables
    private TextInputEditText first_name;
    private TextInputEditText last_name;
    private TextInputEditText register_email;
    private TextInputEditText register_password;
    private TextInputEditText confirm_password;
    private CoordinatorLayout contained;
    private RegisterViewModel registerViewModel;
    private UserViewModel userViewModel;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        registerViewModel = new ViewModelProvider(this).get(RegisterViewModel.class);
        userViewModel = new ViewModelProvider(this).get(UserViewModel.class);
        userViewModel.getLoggedOutMutableLiveData().observe(this, loggedOut ->{
            if (loggedOut){
                if (getView() != null) Navigation.findNavController(getView())
                        .navigate(R.id.action_registerFragment_to_loginFragment);
            }
        });

        userViewModel.getUserMutableLiveData().observe(this, firebaseUser -> {
            if(firebaseUser != null){
                Snackbar.make(contained,"User is logged in",Snackbar.LENGTH_SHORT).show();
            }
        });
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_register,container,false);
        setHasOptionsMenu(true);
        //changing the menu bar title
        requireActivity().setTitle(getString(R.string.reg_user));
        //initialize variables
        contained = view.findViewById(R.id.register_coordinator);
        first_name = view.findViewById(R.id.etRegisterFirstName);
        last_name =view.findViewById(R.id.etRegisterLastName);
        register_email = view.findViewById(R.id.etRegisterEmail);
        register_password =view.findViewById(R.id.etRegisterPassword);
        confirm_password = view.findViewById(R.id.etRegisterPasswordConfirm);
        return view;
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.menu_register,menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.register_user){
            String first = first_name.getText().toString().trim();
            String last = last_name.getText().toString().trim();
            String email = register_email.getText().toString().trim();
            String password = register_password.getText().toString().trim();
            String confirm = confirm_password.getText().toString().trim();

            if (isAnyStringNullOrEmpty(first,last,email,password,confirm)){
                Snackbar.make(contained,getString(R.string.missing),Snackbar.LENGTH_SHORT).show();
            }else{
                if (password.length() < 6 || confirm.length() < 6){
                    Snackbar.make(contained,getString(R.string.passLength),Snackbar.LENGTH_SHORT).show();
                }else{
                    if (password.equals(confirm)){
                        registerViewModel.userRegistration(first,last,email,password);
                        userViewModel.logOut();
                    }else{
                        Snackbar.make(contained,getString(R.string.noMatch),Snackbar.LENGTH_SHORT).show();
                    }
                }
            }
        }
        return false;
    }

    //method for checking the edittext fields for empty values
    public static boolean isAnyStringNullOrEmpty(String... strings) {
        for (String s : strings)
            if (s == null || s.isEmpty())
                return true;
        return false;
    }
}
