package com.example.thomas.guitartraining.presentation.presenter.user;

import com.example.thomas.guitartraining.presentation.navigator.BaseNavigatorListener;
import com.example.thomas.guitartraining.presentation.activity.listener.MainNavigatorListener;
import com.example.thomas.guitartraining.presentation.view.user.UserSongsView;

import javax.inject.Inject;

public class UserSongsPresenter {

    private UserSongsView userSongsView;
    private MainNavigatorListener mainNavigatorListener;

    @Inject
    UserSongsPresenter(BaseNavigatorListener baseNavigatorListener) {
        if (baseNavigatorListener instanceof MainNavigatorListener) {
            this.mainNavigatorListener = (MainNavigatorListener) baseNavigatorListener;
        }
    }

    public void setUserSongsView(UserSongsView userSongsView) {
        this.userSongsView = userSongsView;
    }

    public void setMainNavigatorListener(MainNavigatorListener mainNavigatorListener) {
        this.mainNavigatorListener = mainNavigatorListener;
    }
}
