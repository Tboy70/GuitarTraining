package com.example.thomas.guitartraining.presentation.presenter.user;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.example.data.module.ModuleSharedPrefsImpl;
import com.example.interactor.program.RetrieveProgramsListByUserId;
import com.example.model.Program;
import com.example.thomas.guitartraining.di.PerActivity;
import com.example.thomas.guitartraining.presentation.activity.listener.UserPanelNavigatorListener;
import com.example.thomas.guitartraining.presentation.navigator.BaseNavigatorListener;
import com.example.thomas.guitartraining.presentation.view.user.UserProgramsListView;

import java.util.List;

import javax.inject.Inject;

import rx.Subscriber;

@PerActivity
public class UserProgramsListPresenter {

    private UserProgramsListView userProgramsListView;
    private UserPanelNavigatorListener userPanelNavigatorListener;

    private RetrieveProgramsListByUserId retrieveProgramsListByUserId;

    @Inject
    UserProgramsListPresenter(BaseNavigatorListener baseNavigatorListener, RetrieveProgramsListByUserId retrieveProgramsListByUserId) {
        if (baseNavigatorListener instanceof UserPanelNavigatorListener) {
            this.userPanelNavigatorListener = (UserPanelNavigatorListener) baseNavigatorListener;
        }
        this.retrieveProgramsListByUserId = retrieveProgramsListByUserId;
    }

    public void setUserProgramsListView(UserProgramsListView userProgramsListView) {
        this.userProgramsListView = userProgramsListView;
    }

    public void setUserPanelNavigatorListener(UserPanelNavigatorListener userPanelNavigatorListener) {
        this.userPanelNavigatorListener = userPanelNavigatorListener;
    }

    public String getIdUser(Context context) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);

        return prefs.getString(ModuleSharedPrefsImpl.CURRENT_USER_ID, "0");
    }

    public void retrieveProgramsListByUserId(String userId) {
        userProgramsListView.startRefresh();
        retrieveProgramsListByUserId.execute(new Subscriber<List<Program>>() {
            @Override
            public void onCompleted() {
                userProgramsListView.stopRefresh();
            }

            @Override
            public void onError(Throwable e) {
                userProgramsListView.stopRefresh();
            }

            @Override
            public void onNext(List<Program> programs) {
                userProgramsListView.stopRefresh();
                userProgramsListView.displayProgramsList(programs);
            }
        }, RetrieveProgramsListByUserId.Params.forList(userId));
    }

    public void displayProgramDetails(String programId) {
        userPanelNavigatorListener.displayProgramDetails(programId);
    }

    public void addUserProgram(String programId) {
        userPanelNavigatorListener.displayUserProgramCreation(programId);
    }
}
