package com.example.thomas.guitartraining.presentation.presenter.user;

import android.util.Log;

import com.example.interactor.program.RetrieveProgramById;
import com.example.model.Program;
import com.example.thomas.guitartraining.di.PerActivity;
import com.example.thomas.guitartraining.presentation.activity.listener.UserProgramNavigatorListener;
import com.example.thomas.guitartraining.presentation.fragment.ui.view.viewmodel.ProgramViewModel;
import com.example.thomas.guitartraining.presentation.navigator.BaseNavigatorListener;
import com.example.thomas.guitartraining.presentation.view.user.UserProgramDetailsView;

import javax.inject.Inject;

import rx.Subscriber;

@PerActivity
public class UserProgramDetailsPresenter {
    
    private UserProgramDetailsView userProgramDetailsView;

    private UserProgramNavigatorListener userProgramNavigatorListener;

    private RetrieveProgramById retrieveProgramById;

    @Inject
    UserProgramDetailsPresenter(BaseNavigatorListener baseNavigatorListener, RetrieveProgramById retrieveProgramById) {
        if (baseNavigatorListener instanceof UserProgramNavigatorListener) {
            this.userProgramNavigatorListener = (UserProgramNavigatorListener) baseNavigatorListener;
        }
        this.retrieveProgramById = retrieveProgramById;
    }
    
    public void setUserProgramDetailsView(UserProgramDetailsView userProgramDetailsView) {
        this.userProgramDetailsView = userProgramDetailsView;
    }

    public void getProgramById(String programId) {
        retrieveProgramById.execute(new Subscriber<Program>() {

            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable t) {
                // TODO : HANDLE ERROR !
                 Log.e("TEST", "onError: ");
            }

            @Override
            public void onNext(Program program) {
                ProgramViewModel programViewModel = new ProgramViewModel(program);
                userProgramDetailsView.displayUserProgramDetails(programViewModel);
            }
        }, RetrieveProgramById.Params.forProgram(programId));
    }
}
