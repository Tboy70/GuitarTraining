package com.example.thomas.guitartraining.presentation.presenter.program;

import android.app.Activity;
import android.app.ProgressDialog;
import android.util.Log;

import com.example.executor.PostExecutionThread;
import com.example.executor.ThreadExecutor;
import com.example.interactor.GetProgramFromId;
import com.example.interactor.GetTextIntroProgram;
import com.example.model.Exercise;
import com.example.model.Program;
import com.example.model.Text;
import com.example.repository.ProgramRepository;
import com.example.repository.TextRepository;
import com.example.thomas.guitartraining.R;
import com.example.thomas.guitartraining.di.PerActivity;
import com.example.thomas.guitartraining.presentation.activity.ProgramActivity;
import com.example.thomas.guitartraining.presentation.fragment.program.IntroProgramFragment;
import com.example.thomas.guitartraining.presentation.view.ProgramNavigatorListener;
import com.example.thomas.guitartraining.presentation.view.program.IntroProgramView;

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
    private TextRepository textRepository;
    private final ThreadExecutor threadExecutor;
    private final PostExecutionThread postExecutionThread;

    @Inject
    public IntroProgramPresenter(ProgramRepository programRepository, TextRepository textRepository, ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread) {
        this.programRepository = programRepository;
        this.textRepository = textRepository;
        this.threadExecutor = threadExecutor;
        this.postExecutionThread = postExecutionThread;
    }

    public void setIntroProgramView(IntroProgramFragment introProgramView) {
        this.introProgramView = introProgramView;
    }

    public void setProgramNavigatorListener(ProgramNavigatorListener programNavigatorListener) {
        this.programNavigatorListener = programNavigatorListener;
    }

    public void retrieveProgramFromId(Activity activity, final int idProgram) {
        final ProgressDialog dialog = ProgressDialog.show(activity, activity.getString(R.string.loading_program_title),
                activity.getString(R.string.loading_program_description), true);
        GetProgramFromId getProgramFromId = new GetProgramFromId(threadExecutor, postExecutionThread, programRepository, idProgram);
        getProgramFromId.execute(new Subscriber<Program>() {

            @Override
            public void onCompleted() {
                dialog.dismiss();
            }

            @Override
            public void onError(Throwable e) {
                dialog.dismiss();
            }

            @Override
            public void onNext(Program program) {
                retrieveTextIntroProgram(program, dialog);
            }
        });
    }

    private void retrieveTextIntroProgram(final Program program, final ProgressDialog dialog) {
        GetTextIntroProgram getTextIntroProgram = new GetTextIntroProgram(threadExecutor, postExecutionThread, textRepository, program.getIdProgram());
        getTextIntroProgram.execute(new Subscriber<Text>() {
            @Override
            public void onCompleted() {
                dialog.dismiss();
            }

            @Override
            public void onError(Throwable e) {
            }

            @Override
            public void onNext(Text text) {
                introProgramView.updateUI(program, text);
            }
        });
    }

    public void startExercises(List<Exercise> programExercises) {
        programNavigatorListener.showNextExercise(programExercises, 0);
    }
}
