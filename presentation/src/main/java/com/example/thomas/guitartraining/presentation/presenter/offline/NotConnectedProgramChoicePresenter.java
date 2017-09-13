package com.example.thomas.guitartraining.presentation.presenter.offline;

import com.example.thomas.guitartraining.di.PerActivity;
import com.example.thomas.guitartraining.presentation.activity.listener.NotConnectedNavigatorListener;
import com.example.thomas.guitartraining.presentation.navigator.BaseNavigatorListener;

import javax.inject.Inject;

/**
 * Presenter for the offlineSessionChoice fragment.
 */
@PerActivity
public class NotConnectedProgramChoicePresenter {

    private NotConnectedNavigatorListener notConnectedNavigatorListener;

    @Inject
    NotConnectedProgramChoicePresenter(BaseNavigatorListener baseNavigatorListener) {
        if (baseNavigatorListener instanceof NotConnectedNavigatorListener) {
            this.notConnectedNavigatorListener = (NotConnectedNavigatorListener) baseNavigatorListener;
        }
    }

    public void launchProgramActivity(int idProgram) {
        notConnectedNavigatorListener.launchProgramActivity(idProgram);
    }
}
