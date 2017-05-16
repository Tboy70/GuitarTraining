package com.example.thomas.guitartraining.presentation.presenter.program.exercise;

import com.example.thomas.guitartraining.di.PerActivity;
import com.example.thomas.guitartraining.presentation.view.ProgramNavigatorListener;
import com.example.thomas.guitartraining.presentation.view.program.exercise.ExerciseSweepPickingView;

import javax.inject.Inject;

/**
 * Created by Thomas on 16/05/2017.
 */
@PerActivity
public class ExerciseSweepPickingPresenter {

    private ExerciseSweepPickingView exerciseSweepPickingView;
    private ProgramNavigatorListener programNavigatorListener;

    @Inject
    public ExerciseSweepPickingPresenter() {

    }

    public void setExerciseSweepPickingView(ExerciseSweepPickingView exerciseSweepPickingView) {
        this.exerciseSweepPickingView = exerciseSweepPickingView;
    }

    public void setProgramNavigatorListener(ProgramNavigatorListener programNavigatorListener) {
        this.programNavigatorListener = programNavigatorListener;
    }
}
