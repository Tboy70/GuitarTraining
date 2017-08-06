package com.example.thomas.guitartraining.presentation.presenter.user;

import com.example.thomas.guitartraining.di.PerActivity;
import com.example.thomas.guitartraining.presentation.navigator.BaseNavigatorListener;
import com.example.thomas.guitartraining.presentation.activity.listener.MainNavigatorListener;
import com.example.thomas.guitartraining.presentation.view.user.UserProgramsView;

import javax.inject.Inject;

@PerActivity
public class UserProgramsPresenter {

    private UserProgramsView userProgramsView;
    private MainNavigatorListener mainNavigatorListener;

    @Inject
    UserProgramsPresenter(BaseNavigatorListener baseNavigatorListener) {
        if (baseNavigatorListener instanceof MainNavigatorListener) {
            this.mainNavigatorListener = (MainNavigatorListener) baseNavigatorListener;
        }
    }

    public void setUserProgramsView(UserProgramsView userProgramsView) {
        this.userProgramsView = userProgramsView;
    }

    public void setMainNavigatorListener(MainNavigatorListener mainNavigatorListener) {
        this.mainNavigatorListener = mainNavigatorListener;
    }
}
