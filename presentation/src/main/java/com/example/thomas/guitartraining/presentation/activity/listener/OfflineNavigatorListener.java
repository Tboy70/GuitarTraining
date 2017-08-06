package com.example.thomas.guitartraining.presentation.activity.listener;

import com.example.thomas.guitartraining.presentation.navigator.BaseNavigatorListener;

/**
 * Interface implemented by the OfflineActivity.
 */
public interface OfflineNavigatorListener extends BaseNavigatorListener {
    void launchProgramActivity(int idProgram);
}
