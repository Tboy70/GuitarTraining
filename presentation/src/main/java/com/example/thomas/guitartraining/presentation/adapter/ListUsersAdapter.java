package com.example.thomas.guitartraining.presentation.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.model.User;
import com.example.thomas.guitartraining.R;
import com.example.thomas.guitartraining.presentation.adapter.holder.ListUsersViewHolder;

import java.util.Collections;
import java.util.List;

import javax.inject.Inject;

/**
 * Created by Thomas on 13/03/2017.
 */

public class ListUsersAdapter extends RecyclerView.Adapter<ListUsersViewHolder> {

    private List<User> userList;
    private Context context;

    @Inject
    ListUsersAdapter(Context context) {
        userList = Collections.emptyList();
        this.context = context;
    }

    @Override
    public ListUsersViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_users_fragment, parent, false);
        return new ListUsersViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ListUsersViewHolder holder, int position) {
        User user = new User();
        holder.fillHolder(user, context);
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    public void addUser(List<User> users) {
        userList = users;
        notifyDataSetChanged();
    }

    public void clearUsers() {
        userList.clear();
    }
}
