package com.example.thomas.guitartraining.presentation.presenter.user;

import com.example.thomas.guitartraining.presentation.navigator.BaseNavigatorListener;
import com.example.thomas.guitartraining.presentation.activity.listener.UserPanelNavigatorListener;
import com.example.thomas.guitartraining.presentation.view.user.UserSongsView;

import javax.inject.Inject;

public class UserSongsPresenter {

    private UserSongsView userSongsView;
    private UserPanelNavigatorListener userPanelNavigatorListener;

    @Inject
    UserSongsPresenter(BaseNavigatorListener baseNavigatorListener) {
        if (baseNavigatorListener instanceof UserPanelNavigatorListener) {
            this.userPanelNavigatorListener = (UserPanelNavigatorListener) baseNavigatorListener;
        }
    }

    public void setUserSongsView(UserSongsView userSongsView) {
        this.userSongsView = userSongsView;
    }

    public void setUserPanelNavigatorListener(UserPanelNavigatorListener userPanelNavigatorListener) {
        this.userPanelNavigatorListener = userPanelNavigatorListener;
    }
}
