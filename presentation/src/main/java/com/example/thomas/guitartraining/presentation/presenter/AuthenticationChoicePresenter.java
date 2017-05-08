package com.example.thomas.guitartraining.presentation.presenter;

import com.example.thomas.guitartraining.di.PerActivity;
import com.example.thomas.guitartraining.presentation.view.MainNavigatorListener;

import javax.inject.Inject;

/**
 * Presenter for the fragment AuthentificationChoice.
 */
@PerActivity
public class AuthenticationChoicePresenter {

    private MainNavigatorListener mainNavigatorListener;

    @Inject
    AuthenticationChoicePresenter(MainNavigatorListener mainNavigatorListener) {
        this.mainNavigatorListener = mainNavigatorListener;
    }

    public void launchOfflineActivity() {
        mainNavigatorListener.launchOfflineActivity();
    }
}
