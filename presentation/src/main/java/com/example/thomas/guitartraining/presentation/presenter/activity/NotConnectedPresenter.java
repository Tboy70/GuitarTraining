package com.example.thomas.guitartraining.presentation.presenter.activity;

import com.example.thomas.guitartraining.presentation.navigator.BaseNavigatorListener;
import com.example.thomas.guitartraining.presentation.activity.listener.NotConnectedNavigatorListener;

import javax.inject.Inject;

/**
 * Presenter of the offline activity.
 */
public class NotConnectedPresenter {

    @SuppressWarnings({"unused", "FieldCanBeLocal"})
    private NotConnectedNavigatorListener notConnectedNavigatorListener;

    @SuppressWarnings("WeakerAccess")
    @Inject
    public NotConnectedPresenter(BaseNavigatorListener baseNavigatorListener) {
        if (baseNavigatorListener instanceof NotConnectedNavigatorListener) {
            this.notConnectedNavigatorListener = (NotConnectedNavigatorListener) baseNavigatorListener;
        }
    }
}
