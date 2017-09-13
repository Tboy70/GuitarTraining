package com.example.thomas.guitartraining.presentation.presenter.activity;

import com.example.thomas.guitartraining.presentation.navigator.BaseNavigatorListener;
import com.example.thomas.guitartraining.presentation.activity.listener.LoginNavigatorListener;

import javax.inject.Inject;

public class LoginPresenter {

    @SuppressWarnings({"unused", "FieldCanBeLocal"})
    private LoginNavigatorListener loginNavigatorListener;

    @SuppressWarnings("WeakerAccess")
    @Inject
    public LoginPresenter(BaseNavigatorListener baseNavigatorListener) {
        if (baseNavigatorListener instanceof LoginNavigatorListener) {
            this.loginNavigatorListener = (LoginNavigatorListener) baseNavigatorListener;
        }
    }
}
