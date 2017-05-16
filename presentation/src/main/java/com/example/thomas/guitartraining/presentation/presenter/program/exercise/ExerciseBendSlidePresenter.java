package com.example.thomas.guitartraining.presentation.presenter.program.exercise;

import com.example.thomas.guitartraining.di.PerActivity;
import com.example.thomas.guitartraining.presentation.view.ProgramNavigatorListener;
import com.example.thomas.guitartraining.presentation.view.program.exercise.ExerciseBendSlideView;

import javax.inject.Inject;

/**
 * Created by Thomas on 16/05/2017.
 */

@PerActivity
public class ExerciseBendSlidePresenter {

    private ExerciseBendSlideView exerciseBendSlideView;
    private ProgramNavigatorListener programNavigatorListener;

    @Inject
    public ExerciseBendSlidePresenter() {

    }

    public void setExerciseBendSlideView(ExerciseBendSlideView exerciseBendSlideView) {
        this.exerciseBendSlideView = exerciseBendSlideView;
    }

    public void setProgramNavigatorListener(ProgramNavigatorListener programNavigatorListener) {
        this.programNavigatorListener = programNavigatorListener;
    }
}
