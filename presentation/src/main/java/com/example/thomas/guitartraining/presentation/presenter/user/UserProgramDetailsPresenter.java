package com.example.thomas.guitartraining.presentation.presenter.user;

import android.util.Log;

import com.example.interactor.program.RemoveProgram;
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
    private RemoveProgram removeProgram;

    private Program currentProgram;

    @Inject
    UserProgramDetailsPresenter(BaseNavigatorListener baseNavigatorListener, RetrieveProgramById retrieveProgramById,
                                RemoveProgram removeProgram) {
        if (baseNavigatorListener instanceof UserProgramNavigatorListener) {
            this.userProgramNavigatorListener = (UserProgramNavigatorListener) baseNavigatorListener;
        }
        this.retrieveProgramById = retrieveProgramById;
        this.removeProgram = removeProgram;
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
                currentProgram = program;
                userProgramDetailsView.displayUserProgramDetails(new ProgramViewModel(program));
            }
        }, RetrieveProgramById.Params.forProgram(programId));
    }

    public void launchProgram() {
        userProgramNavigatorListener.launchProgram(currentProgram.getIdProgram());
    }

    public void setToolbar(String toolbarTitle) {
        userProgramNavigatorListener.setUserProgramToolbar(toolbarTitle);
    }

    public void removeProgram() {
        removeProgram.execute(new Subscriber<Boolean>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                // TODO: 03/10/2017 Handle error
            }

            @Override
            public void onNext(Boolean success) {
                if (success) {
                    userProgramNavigatorListener.requestDisplayProgramList();
                }
            }
        }, RemoveProgram.Params.forSuppression(currentProgram.getIdProgram()));
    }

    public void updateProgram(String programId) {
        retrieveProgramById.execute(new Subscriber<Program>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(Program program) {
                currentProgram = program;
                userProgramNavigatorListener.displayUserProgramUpdate(new ProgramViewModel(program));
            }
        }, RetrieveProgramById.Params.forProgram(programId));
    }
}
