package com.example.thomas.guitartraining.presentation.presenter.program.exercise;

import com.example.thomas.guitartraining.di.PerActivity;
import com.example.thomas.guitartraining.presentation.view.ProgramNavigatorListener;
import com.example.thomas.guitartraining.presentation.view.program.exercise.ExerciseBackForthView;

import javax.inject.Inject;

/**
 * Created by Thomas on 16/05/2017.
 */
@PerActivity
public class ExerciseBackForthPresenter {
    private ExerciseBackForthView exerciseBackForthView;
    private ProgramNavigatorListener programNavigatorListener;

    @Inject
    public ExerciseBackForthPresenter() {

    }

    public void setExerciseBackForthView(ExerciseBackForthView exerciseBackForthView) {
        this.exerciseBackForthView = exerciseBackForthView;
    }

    public void setProgramNavigatorListener(ProgramNavigatorListener programNavigatorListener) {
        this.programNavigatorListener = programNavigatorListener;
    }

    public void showNextExercise(int nextExercisePosition) {
        programNavigatorListener.showNextExercise(nextExercisePosition);
    }
}
