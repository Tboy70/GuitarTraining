package com.example.thomas.guitartraining.presentation.presenter.activity;

import com.example.thomas.guitartraining.presentation.navigator.BaseNavigatorListener;
import com.example.thomas.guitartraining.presentation.activity.listener.MainNavigatorListener;

import javax.inject.Inject;

public class MainPresenter {

    @SuppressWarnings({"unused", "FieldCanBeLocal"})
    private MainNavigatorListener mainNavigatorListener;

    @SuppressWarnings("WeakerAccess")
    @Inject
    public MainPresenter(BaseNavigatorListener baseNavigatorListener) {
        if (baseNavigatorListener instanceof MainNavigatorListener)
            this.mainNavigatorListener = (MainNavigatorListener) baseNavigatorListener;
    }
}
