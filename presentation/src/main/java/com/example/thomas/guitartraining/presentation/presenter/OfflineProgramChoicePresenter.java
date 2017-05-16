package com.example.thomas.guitartraining.presentation.presenter;

import com.example.thomas.guitartraining.di.PerActivity;
import com.example.thomas.guitartraining.presentation.view.OfflineNavigatorListener;

import javax.inject.Inject;

/**
 * Presenter for the offlineSessionChoice fragment.
 */
@PerActivity
public class OfflineProgramChoicePresenter {

    private OfflineNavigatorListener offlineNavigatorListener;

    @Inject
    OfflineProgramChoicePresenter(OfflineNavigatorListener offlineNavigatorListener) {
        this.offlineNavigatorListener = offlineNavigatorListener;
    }

    public void launchProgramActivity(int idProgram) {
        offlineNavigatorListener.launchProgramActivity(idProgram);
    }
}
