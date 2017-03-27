package com.example.thomas.guitartraining.presentation.view;

import com.example.model.User;

import java.util.List;

/**
 * Interface implemented by the ListUsers fragment.
 */
public interface ListUsersView {
    void displayError(String s);
    void updateUI(List<User> users);
}
