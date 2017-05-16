package com.example.thomas.guitartraining.presentation.presenter.program;

import com.example.interactor.GetProgramFromId;
import com.example.model.Exercise;
import com.example.model.Program;
import com.example.repository.ProgramRepository;
import com.example.thomas.guitartraining.di.PerActivity;
import com.example.thomas.guitartraining.presentation.fragment.program.IntroProgramFragment;
import com.example.thomas.guitartraining.presentation.view.IntroProgramView;
import com.example.thomas.guitartraining.presentation.view.ProgramNavigatorListener;

import java.util.List;

import javax.inject.Inject;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Thomas on 08/05/2017.
 */
@PerActivity
public class IntroProgramPresenter {

    private IntroProgramView introProgramView;
    private ProgramNavigatorListener programNavigatorListener;
    private ProgramRepository programRepository;

    @Inject
    public IntroProgramPresenter(ProgramRepository programRepository) {
        this.programRepository = programRepository;

    }

    public void setIntroProgramView(IntroProgramFragment introProgramView) {
        this.introProgramView = introProgramView;
    }

    public void setProgramNavigatorListener(ProgramNavigatorListener programNavigatorListener) {
        this.programNavigatorListener = programNavigatorListener;
    }

    public void retrieveProgramFromId(int idProgram) {
        GetProgramFromId getProgramFromId = new GetProgramFromId(Schedulers.io(), AndroidSchedulers.mainThread(), programRepository);
        getProgramFromId.buildUseCaseObservable(idProgram, new Subscriber<Program>() {

            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(Program program) {
                introProgramView.updateUI(program);
            }
        });
    }

    public void startExercises(List<Exercise> programExercises) {
        programNavigatorListener.showNextExercise(programExercises, 0);
    }
}
