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
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.soosalu_simsel.elunautleja_app.R;
import com.soosalu_simsel.elunautleja_app.UserRecyclerAdapter;
import com.soosalu_simsel.elunautleja_app.viewmodel.UserViewModel;

public class UserFragment extends Fragment {
    //declaring variables
    private UserViewModel userViewModel;
    private UserRecyclerAdapter userRecyclerAdapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        userViewModel = new ViewModelProvider(this).get(UserViewModel.class);
        userViewModel.getLoggedOutMutableLiveData().observe(this, loggedOut ->{
            if(loggedOut){
                if (getView() != null) Navigation.findNavController(getView())
                        .navigate(R.id.action_userFragment_to_loginFragment);
            }
        });
        userViewModel.getUserLiveData().observe(this,
                userArrayList -> userRecyclerAdapter.updateUserList(userArrayList));
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_user,container,false);
        setHasOptionsMenu(true);
        //changing the menu bar title
        requireActivity().setTitle(getString(R.string.user_info));
        //initializing the recyclerview
        RecyclerView recyclerView = view.findViewById(R.id.userRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        userRecyclerAdapter = new UserRecyclerAdapter();
        recyclerView.setAdapter(userRecyclerAdapter);
        return view;
    }


    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.menu_user,menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.user_logout){
            userViewModel.logOut();
        }
        return false;
    }

}