package com.example.thomas.guitartraining.presentation.presenter.program.exercise;

import com.example.thomas.guitartraining.di.PerActivity;
import com.example.thomas.guitartraining.presentation.fragment.program.exercise.ExerciseScaleFragment;
import com.example.thomas.guitartraining.presentation.view.ProgramNavigatorListener;
import com.example.thomas.guitartraining.presentation.view.program.exercise.ExerciseScaleView;

import javax.inject.Inject;

/**
 * Created by Thomas on 09/05/2017.
 */
@PerActivity
public class ExerciseScalePresenter {

    private ExerciseScaleView exerciseScaleView;
    private ProgramNavigatorListener programNavigatorListener;

    @Inject
    public ExerciseScalePresenter() {
    }

    public void setExerciseScaleView(ExerciseScaleFragment exerciseScaleView) {
        this.exerciseScaleView = exerciseScaleView;
    }

    public void setProgramNavigatorListener(ProgramNavigatorListener programNavigatorListener) {
        this.programNavigatorListener = programNavigatorListener;
    }

    //TODO : Rename "i"
    public void showNextExercise(int i) {
        programNavigatorListener.showNextExercise(i);
    }
}
