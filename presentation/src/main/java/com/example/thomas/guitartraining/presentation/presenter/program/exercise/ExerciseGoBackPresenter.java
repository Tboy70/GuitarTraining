package com.example.thomas.guitartraining.presentation.presenter.program.exercise;

import com.example.thomas.guitartraining.di.PerActivity;
import com.example.thomas.guitartraining.presentation.view.ProgramNavigatorListener;
import com.example.thomas.guitartraining.presentation.view.program.exercise.ExerciseGoBackView;

import javax.inject.Inject;

/**
 * Created by Thomas on 16/05/2017.
 */
@PerActivity
public class ExerciseGoBackPresenter {
    private ExerciseGoBackView exerciseGoBackView;
    private ProgramNavigatorListener programNavigatorListener;

    @Inject
    public ExerciseGoBackPresenter() {

    }

    public void setExerciseGoBackView(ExerciseGoBackView exerciseGoBackView) {
        this.exerciseGoBackView = exerciseGoBackView;
    }

    public void setProgramNavigatorListener(ProgramNavigatorListener programNavigatorListener) {
        this.programNavigatorListener = programNavigatorListener;
    }

    public void showNextExercise(int nextExercisePosition) {
        programNavigatorListener.showNextExercise(nextExercisePosition);
    }
}
