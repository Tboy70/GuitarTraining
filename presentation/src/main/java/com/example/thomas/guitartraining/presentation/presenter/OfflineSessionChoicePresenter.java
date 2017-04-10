package com.example.thomas.guitartraining.presentation.presenter;

import com.example.thomas.guitartraining.di.PerActivity;
import com.example.thomas.guitartraining.presentation.view.OfflineNavigatorListener;

import javax.inject.Inject;

/**
 * Presenter for the offlineSessionChoice fragment.
 */
@PerActivity
public class OfflineSessionChoicePresenter {

    private OfflineNavigatorListener offlineNavigatorListener;

    @Inject
    OfflineSessionChoicePresenter(OfflineNavigatorListener offlineNavigatorListener) {
        this.offlineNavigatorListener = offlineNavigatorListener;
    }

}
