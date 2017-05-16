package com.example.thomas.guitartraining.presentation.presenter.program.exercise;

import com.example.thomas.guitartraining.presentation.view.ProgramNavigatorListener;
import com.example.thomas.guitartraining.presentation.view.program.exercise.ExerciseSpeedView;

import javax.inject.Inject;

/**
 * Created by Thomas on 16/05/2017.
 */

public class ExerciseSpeedPresenter {

    private ExerciseSpeedView exerciseSpeedView;
    private ProgramNavigatorListener programNavigatorListener;

    @Inject
    public ExerciseSpeedPresenter() {

    }

    public void setExerciseSpeedView(ExerciseSpeedView exerciseSpeedView) {
        this.exerciseSpeedView = exerciseSpeedView;
    }

    public void setProgramNavigatorListener(ProgramNavigatorListener programNavigatorListener) {
        this.programNavigatorListener = programNavigatorListener;
    }
}
