package com.example.thomas.guitartraining.presentation.presenter.user;


import com.example.thomas.guitartraining.di.PerActivity;
import com.example.thomas.guitartraining.presentation.activity.listener.UserProgramNavigatorListener;
import com.example.thomas.guitartraining.presentation.navigator.BaseNavigatorListener;
import com.example.thomas.guitartraining.presentation.view.user.UserProgramView;

import javax.inject.Inject;

@PerActivity
public class UserProgramPresenter {

    private UserProgramNavigatorListener userProgramNavigatorListener;
    private UserProgramView userProgramView;

    @SuppressWarnings("WeakerAccess")
    @Inject
    public UserProgramPresenter(BaseNavigatorListener baseNavigatorListener) {
        if (baseNavigatorListener instanceof UserProgramNavigatorListener) {
            this.userProgramNavigatorListener = (UserProgramNavigatorListener) baseNavigatorListener;
        }
    }
    public void setUserProgramView(UserProgramView userProgramView) {
        this.userProgramView = userProgramView;
    }
}
