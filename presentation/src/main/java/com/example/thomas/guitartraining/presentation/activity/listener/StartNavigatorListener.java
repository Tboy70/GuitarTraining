package com.example.thomas.guitartraining.presentation.activity.listener;

import com.example.thomas.guitartraining.presentation.navigator.BaseNavigatorListener;

/**
 * Interface implemented by the StartActivity.
 */
public interface StartNavigatorListener extends BaseNavigatorListener {

    void launchLoginActivity();

    void launchNotConnectedActivity();

    void launchRightScreen(String idUser);
}
