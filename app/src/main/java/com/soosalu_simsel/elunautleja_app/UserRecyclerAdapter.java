package com.soosalu_simsel.elunautleja_app;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.textfield.TextInputEditText;
import com.soosalu_simsel.elunautleja_app.model.User;

import java.util.ArrayList;

//custom class for the recyclerview
public class UserRecyclerAdapter extends RecyclerView.Adapter<UserRecyclerAdapter.UserViewHolder>{
    ArrayList<User> userArrayList;
    public UserRecyclerAdapter() {
        this.userArrayList = new ArrayList<>();
    }
    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_user_data,parent,false);
        return new UserViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        User user = userArrayList.get(position);
        holder.firstName.setText(user.getFirstname());
        holder.lastName.setText(user.getLastname());
        holder.email.setText(user.getEmail());
    }
    @Override
    public int getItemCount() {
        return userArrayList.size();
    }
    public void updateUserList(final ArrayList<User> userArrayList){
        this.userArrayList = userArrayList;
        notifyDataSetChanged();
    }

    static class UserViewHolder extends RecyclerView.ViewHolder{
        private final TextInputEditText firstName;
        private final TextInputEditText lastName;
        private final TextInputEditText email;

        public UserViewHolder(@NonNull View itemView) {
            super(itemView);
            firstName = itemView.findViewById(R.id.etUserFirstName);
            lastName = itemView.findViewById(R.id.etUserLastName);
            email = itemView.findViewById(R.id.etUserEmail);
        }
    }
}