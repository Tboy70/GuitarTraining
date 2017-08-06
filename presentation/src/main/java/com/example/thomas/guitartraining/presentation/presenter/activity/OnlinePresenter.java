package com.example.thomas.guitartraining.presentation.presenter.activity;

import com.example.thomas.guitartraining.presentation.navigator.BaseNavigatorListener;
import com.example.thomas.guitartraining.presentation.activity.listener.OnlineNavigatorListener;

import javax.inject.Inject;

public class OnlinePresenter {

    private OnlineNavigatorListener onlineNavigatorListener;

    @SuppressWarnings("WeakerAccess")
    @Inject
    public OnlinePresenter(BaseNavigatorListener baseNavigatorListener) {
        if (baseNavigatorListener instanceof OnlineNavigatorListener) {
            this.onlineNavigatorListener = (OnlineNavigatorListener) baseNavigatorListener;
        }
    }
}
