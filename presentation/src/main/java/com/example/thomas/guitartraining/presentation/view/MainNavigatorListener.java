package com.example.thomas.guitartraining.presentation.view;

import com.example.model.Text;

/**
 * Interface implemented by the MainActivity.
 */
public interface MainNavigatorListener {

    void loadListUsers();
    void callDialogFragment(Text text);
}
