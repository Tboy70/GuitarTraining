package com.example.thomas.guitartraining.presentation.presenter.program.exercise;

import com.example.thomas.guitartraining.di.PerActivity;
import com.example.thomas.guitartraining.presentation.fragment.program.exercise.ExerciseModeFragment;
import com.example.thomas.guitartraining.presentation.view.ExerciseModeView;
import com.example.thomas.guitartraining.presentation.view.ProgramNavigatorListener;

import javax.inject.Inject;

/**
 * Created by Thomas on 09/05/2017.
 */
@PerActivity
public class ExerciseModePresenter {

    private ExerciseModeView exerciseModeView;
    private ProgramNavigatorListener programNavigatorListener;

    @Inject
    public ExerciseModePresenter() {
    }

    public void setExerciseModeView(ExerciseModeFragment exerciseModeView) {
        this.exerciseModeView = exerciseModeView;
    }

    public void setProgramNavigatorListener(ProgramNavigatorListener programNavigatorListener) {
        this.programNavigatorListener = programNavigatorListener;
    }

    public void showNextExercise(int i) {
        programNavigatorListener.showNextExercise(i);
    }
}
