package com.example.thomas.guitartraining.presentation.presenter.activity;

import com.example.thomas.guitartraining.presentation.navigator.BaseNavigatorListener;
import com.example.thomas.guitartraining.presentation.activity.listener.OfflineNavigatorListener;

import javax.inject.Inject;

/**
 * Presenter of the offline activity.
 */
public class OfflinePresenter {

    @SuppressWarnings({"unused", "FieldCanBeLocal"})
    private OfflineNavigatorListener offlineNavigatorListener;

    @SuppressWarnings("WeakerAccess")
    @Inject
    public OfflinePresenter(BaseNavigatorListener baseNavigatorListener) {
        if (baseNavigatorListener instanceof OfflineNavigatorListener) {
            this.offlineNavigatorListener = (OfflineNavigatorListener) baseNavigatorListener;
        }
    }
}
