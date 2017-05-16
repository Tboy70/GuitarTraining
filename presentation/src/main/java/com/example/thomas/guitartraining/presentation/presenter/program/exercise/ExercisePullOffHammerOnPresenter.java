package com.example.thomas.guitartraining.presentation.presenter.program.exercise;

import com.example.thomas.guitartraining.di.PerActivity;
import com.example.thomas.guitartraining.presentation.view.ProgramNavigatorListener;
import com.example.thomas.guitartraining.presentation.view.program.exercise.ExercisePullOffHammerOnView;

import javax.inject.Inject;

/**
 * Created by Thomas on 16/05/2017.
 */
@PerActivity
public class ExercisePullOffHammerOnPresenter {

    private ExercisePullOffHammerOnView exercisePullOffHammerOnView;
    private ProgramNavigatorListener programNavigatorListener;

    @Inject
    public ExercisePullOffHammerOnPresenter() {

    }

    public void setExercisePullOffHammerOnView(ExercisePullOffHammerOnView exercisePullOffHammerOnFragment) {
        this.exercisePullOffHammerOnView = exercisePullOffHammerOnFragment;
    }

    public void setProgramNavigatorListener(ProgramNavigatorListener programNavigatorListener) {
        this.programNavigatorListener = programNavigatorListener;
    }
}
