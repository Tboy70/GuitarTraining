package com.example.thomas.guitartraining.presentation.presenter.activity;

import com.example.thomas.guitartraining.presentation.view.OfflineNavigatorListener;

import javax.inject.Inject;

/**
 * Presenter of the offline activity.
 */
public class OfflinePresenter {

    private OfflineNavigatorListener offlineNavigatorListener;

    @Inject
    public OfflinePresenter(OfflineNavigatorListener offlineNavigatorListener) {
        this.offlineNavigatorListener = offlineNavigatorListener;
    }
}
