package com.example.thomas.guitartraining.presentation.activity.listener;

import com.example.thomas.guitartraining.presentation.navigator.BaseNavigatorListener;

public interface UserPanelNavigatorListener extends BaseNavigatorListener {
    void displayProgramDetails(String programId);

    void displayUserProgramCreation(String programId);
}
