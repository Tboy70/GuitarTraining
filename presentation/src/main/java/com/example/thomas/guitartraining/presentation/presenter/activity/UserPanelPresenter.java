package com.example.thomas.guitartraining.presentation.presenter.activity;

import com.example.thomas.guitartraining.presentation.navigator.BaseNavigatorListener;
import com.example.thomas.guitartraining.presentation.activity.listener.UserPanelNavigatorListener;

import javax.inject.Inject;

public class UserPanelPresenter {

    @SuppressWarnings({"unused", "FieldCanBeLocal"})
    private UserPanelNavigatorListener userPanelNavigatorListener;

    @SuppressWarnings("WeakerAccess")
    @Inject
    public UserPanelPresenter(BaseNavigatorListener baseNavigatorListener) {
        if (baseNavigatorListener instanceof UserPanelNavigatorListener)
            this.userPanelNavigatorListener = (UserPanelNavigatorListener) baseNavigatorListener;
    }
}
