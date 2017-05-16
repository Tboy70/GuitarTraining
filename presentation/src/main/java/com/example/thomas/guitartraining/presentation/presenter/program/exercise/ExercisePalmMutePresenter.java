package com.example.thomas.guitartraining.presentation.presenter.program.exercise;

import com.example.thomas.guitartraining.di.PerActivity;
import com.example.thomas.guitartraining.presentation.view.ProgramNavigatorListener;
import com.example.thomas.guitartraining.presentation.view.program.exercise.ExercisePalmMuteView;

import javax.inject.Inject;

/**
 * Created by Thomas on 16/05/2017.
 */
@PerActivity
public class ExercisePalmMutePresenter {

    private ExercisePalmMuteView exercisePalmMuteView;
    private ProgramNavigatorListener programNavigatorListener;

    @Inject
    public ExercisePalmMutePresenter() {

    }

    public void setExercisePalmMuteView(ExercisePalmMuteView exercisePalmMuteView) {
        this.exercisePalmMuteView = exercisePalmMuteView;
    }

    public void setProgramNavigatorListener(ProgramNavigatorListener programNavigatorListener) {
        this.programNavigatorListener = programNavigatorListener;
    }

    public void showNextExercise(int nextExercisePosition) {
        programNavigatorListener.showNextExercise(nextExercisePosition);
    }
}
