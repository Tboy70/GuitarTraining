package com.example.thomas.guitartraining.presentation.presenter.navigation;

import com.example.thomas.guitartraining.di.PerActivity;
import com.example.thomas.guitartraining.presentation.navigator.BaseNavigatorListener;
import com.example.thomas.guitartraining.presentation.activity.listener.StartNavigatorListener;

import javax.inject.Inject;

/**
 * Presenter for the fragment AuthenticationChoice.
 */
@PerActivity
public class AuthenticationChoicePresenter {

    private StartNavigatorListener startNavigatorListener;

    @Inject
    AuthenticationChoicePresenter(BaseNavigatorListener baseNavigatorListener) {
        if (baseNavigatorListener instanceof StartNavigatorListener) {
            this.startNavigatorListener = (StartNavigatorListener) baseNavigatorListener;
        }
    }

    public void launchOfflineActivity() {
        startNavigatorListener.launchOfflineActivity();
    }

    public void launchOnlineActivity() {
        startNavigatorListener.launchOnlineActivity();
    }
}
