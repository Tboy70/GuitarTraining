package com.example.thomas.guitartraining.presentation.presenter.program.exercise;

import com.example.thomas.guitartraining.di.PerActivity;
import com.example.thomas.guitartraining.presentation.view.ProgramNavigatorListener;
import com.example.thomas.guitartraining.presentation.view.program.exercise.ExerciseSkipStringView;

import javax.inject.Inject;

/**
 * Created by Thomas on 16/05/2017.
 */
@PerActivity
public class ExerciseSkipStringPresenter {

    private ExerciseSkipStringView exerciseSkipStringView;
    private ProgramNavigatorListener programNavigatorListener;

    @Inject
    public ExerciseSkipStringPresenter() {

    }

    public void setExerciseSkipStringView(ExerciseSkipStringView exerciseSkipStringView) {
        this.exerciseSkipStringView = exerciseSkipStringView;
    }

    public void setProgramNavigatorListener(ProgramNavigatorListener programNavigatorListener) {
        this.programNavigatorListener = programNavigatorListener;
    }

    public void showNextExercise(int nextExercisePosition) {
        programNavigatorListener.showNextExercise(nextExercisePosition);
    }
}
