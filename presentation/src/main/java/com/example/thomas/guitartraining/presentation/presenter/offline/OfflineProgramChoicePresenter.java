package com.example.thomas.guitartraining.presentation.presenter.offline;

import com.example.thomas.guitartraining.di.PerActivity;
import com.example.thomas.guitartraining.presentation.navigator.BaseNavigatorListener;
import com.example.thomas.guitartraining.presentation.activity.listener.OfflineNavigatorListener;

import javax.inject.Inject;

/**
 * Presenter for the offlineSessionChoice fragment.
 */
@PerActivity
public class OfflineProgramChoicePresenter {

    private OfflineNavigatorListener offlineNavigatorListener;

    @Inject
    OfflineProgramChoicePresenter(BaseNavigatorListener baseNavigatorListener) {
        if (baseNavigatorListener instanceof OfflineNavigatorListener) {
            this.offlineNavigatorListener = (OfflineNavigatorListener) baseNavigatorListener;
        }
    }

    public void launchProgramActivity(int idProgram) {
        offlineNavigatorListener.launchProgramActivity(idProgram);
    }
}
