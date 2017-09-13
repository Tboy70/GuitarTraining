package com.example.thomas.guitartraining.presentation.presenter.user;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Log;

import com.example.data.module.ModuleSharedPrefsImpl;
import com.example.interactor.program.RetrieveProgramsListByUserId;
import com.example.model.Program;
import com.example.thomas.guitartraining.di.PerActivity;
import com.example.thomas.guitartraining.presentation.activity.listener.UserPanelNavigatorListener;
import com.example.thomas.guitartraining.presentation.navigator.BaseNavigatorListener;
import com.example.thomas.guitartraining.presentation.view.user.UserProgramsView;

import java.util.List;

import javax.inject.Inject;

import rx.Subscriber;

@PerActivity
public class UserProgramsPresenter {

    private UserProgramsView userProgramsView;
    private UserPanelNavigatorListener userPanelNavigatorListener;

    private RetrieveProgramsListByUserId retrieveProgramsListByUserId;

    @Inject
    UserProgramsPresenter(BaseNavigatorListener baseNavigatorListener, RetrieveProgramsListByUserId retrieveProgramsListByUserId) {
        if (baseNavigatorListener instanceof UserPanelNavigatorListener) {
            this.userPanelNavigatorListener = (UserPanelNavigatorListener) baseNavigatorListener;
        }
        this.retrieveProgramsListByUserId = retrieveProgramsListByUserId;
    }

    public void setUserProgramsView(UserProgramsView userProgramsView) {
        this.userProgramsView = userProgramsView;
    }

    public void setUserPanelNavigatorListener(UserPanelNavigatorListener userPanelNavigatorListener) {
        this.userPanelNavigatorListener = userPanelNavigatorListener;
    }

    public void getIdUser(Context context) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);

        int userId = prefs.getInt(ModuleSharedPrefsImpl.CURRENT_USER_ID, 0);

        retrieveProgramsListByUserId(userId);
    }

    private void retrieveProgramsListByUserId(int userId) {
        retrieveProgramsListByUserId.execute(new Subscriber<List<Program>>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                Log.e("TEST", "onError: ");
            }

            @Override
            public void onNext(List<Program> programs) {
                userProgramsView.displayProgramsList(programs);
            }
        }, RetrieveProgramsListByUserId.Params.forList(userId));
    }
}
