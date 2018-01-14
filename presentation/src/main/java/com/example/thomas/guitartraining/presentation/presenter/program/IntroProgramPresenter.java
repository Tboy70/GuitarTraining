package com.example.thomas.guitartraining.presentation.presenter.program;

import android.app.Activity;

import com.example.interactor.program.GetProgramFromId;
import com.example.model.Exercise;
import com.example.model.Program;
import com.example.thomas.guitartraining.R;
import com.example.thomas.guitartraining.di.PerActivity;
import com.example.thomas.guitartraining.presentation.activity.listener.ProgramNavigatorListener;
import com.example.thomas.guitartraining.presentation.component.presenter.MaterialDialogComponent;
import com.example.thomas.guitartraining.presentation.fragment.program.IntroProgramFragment;
import com.example.thomas.guitartraining.presentation.navigator.BaseNavigatorListener;
import com.example.thomas.guitartraining.presentation.view.program.IntroProgramView;

import java.util.List;

import javax.inject.Inject;

import rx.Subscriber;

@PerActivity
public class IntroProgramPresenter {

    private IntroProgramView introProgramView;
    private ProgramNavigatorListener programNavigatorListener;

    private MaterialDialogComponent materialDialogComponent;

    private GetProgramFromId getProgramFromId;

    @SuppressWarnings("WeakerAccess")
    @Inject
    public IntroProgramPresenter(BaseNavigatorListener baseNavigatorListener, MaterialDialogComponent materialDialogComponent, GetProgramFromId getProgramFromId) {
        if (baseNavigatorListener instanceof ProgramNavigatorListener) {
            this.programNavigatorListener = (ProgramNavigatorListener) baseNavigatorListener;
        }
        this.materialDialogComponent = materialDialogComponent;
        this.getProgramFromId = getProgramFromId;
    }

    public void setIntroProgramView(IntroProgramFragment introProgramView) {
        this.introProgramView = introProgramView;
    }

    public void setProgramNavigatorListener(ProgramNavigatorListener programNavigatorListener) {
        this.programNavigatorListener = programNavigatorListener;
    }

    public void retrieveProgramFromId(Activity activity, final String idProgram) {
        materialDialogComponent.showProgressDialog(
                activity,
                activity.getString(R.string.dialog_program_loading_title),
                activity.getString(R.string.dialog_program_loading_description),
                R.color.colorPrimary);
        getProgramFromId.execute(new Subscriber<Program>() {

            @Override
            public void onCompleted() {
                materialDialogComponent.dismissDialog();
            }

            @Override
            public void onError(Throwable e) {
                introProgramView.updateUIError();
                materialDialogComponent.dismissDialog();
            }

            @Override
            public void onNext(Program program) {
                introProgramView.updateUISuccess(program);
            }
        }, GetProgramFromId.Params.toGet(idProgram));
    }

    public void startExercises(List<Exercise> programExercises) {
        programNavigatorListener.showNextExercise(programExercises, 0);
    }
}
