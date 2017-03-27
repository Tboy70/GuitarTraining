package com.example.thomas.guitartraining.presentation.adapter.holder;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.model.User;
import com.example.thomas.guitartraining.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * View holder for the adapter of the ListUsers fragment.
 */
public class ListUsersViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.id_user)
    TextView idUser;

    @BindView(R.id.first_name_user)
    TextView firstNameUser;

    @BindView(R.id.last_name_user)
    TextView lastNameUser;

    public ListUsersViewHolder(View itemView) {
        super(itemView);

        ButterKnife.bind(this, itemView);
        itemView.setTag(itemView);
    }

    public void fillHolder(User user, Context context) {
        idUser.setText(String.valueOf(user.getIdUser()));
        firstNameUser.setText(user.getPseudoUser());
        lastNameUser.setText(user.getPasswordUser());
    }
}
