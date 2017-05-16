package com.example.thomas.guitartraining.presentation.presenter.program.exercise;

import com.example.thomas.guitartraining.di.PerActivity;
import com.example.thomas.guitartraining.presentation.view.ProgramNavigatorListener;
import com.example.thomas.guitartraining.presentation.view.program.exercise.ExerciseTappingView;

import javax.inject.Inject;

/**
 * Created by Thomas on 16/05/2017.
 */
@PerActivity
public class ExerciseTappingPresenter {

    private ExerciseTappingView exerciseTappingView;
    private ProgramNavigatorListener programNavigatorListener;

    @Inject
    public ExerciseTappingPresenter() {

    }

    public void setExerciseTappingView(ExerciseTappingView exerciseTappingView) {
        this.exerciseTappingView = exerciseTappingView;
    }

    public void setProgramNavigatorListener(ProgramNavigatorListener programNavigatorListener) {
        this.programNavigatorListener = programNavigatorListener;
    }
}
