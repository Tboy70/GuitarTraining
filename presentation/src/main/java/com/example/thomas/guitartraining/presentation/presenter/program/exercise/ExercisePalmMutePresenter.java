package com.example.thomas.guitartraining.presentation.presenter.program.exercise;

import android.app.Activity;

import com.example.thomas.guitartraining.R;
import com.example.thomas.guitartraining.di.PerActivity;
import com.example.thomas.guitartraining.presentation.component.presenter.DialogComponent;
import com.example.thomas.guitartraining.presentation.component.presenter.MaterialDialogComponent;
import com.example.thomas.guitartraining.presentation.presenter.program.exercise.listener.OnTimerDialogDismiss;
import com.example.thomas.guitartraining.presentation.activity.listener.ProgramNavigatorListener;
import com.example.thomas.guitartraining.presentation.view.program.exercise.ExercisePalmMuteView;

import javax.inject.Inject;

@PerActivity
public class ExercisePalmMutePresenter {

    private DialogComponent dialogComponent;
    private MaterialDialogComponent materialDialogComponent;

    private ExercisePalmMuteView exercisePalmMuteView;
    private ProgramNavigatorListener programNavigatorListener;

    @SuppressWarnings("WeakerAccess")
    @Inject
    public ExercisePalmMutePresenter(DialogComponent dialogComponent, MaterialDialogComponent materialDialogComponent) {
        this.dialogComponent = dialogComponent;
        this.materialDialogComponent = materialDialogComponent;
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

    public void launchTimer(Activity activity, long durationLeft) {
        dialogComponent.showTimerDialog(activity, durationLeft, new OnTimerDialogDismiss() {
            @Override
            public void onDismiss(long timeCountInMilliSeconds) {
                exercisePalmMuteView.setLeftDuration(timeCountInMilliSeconds);
            }
        });
    }

    public void setToolbar(String toolbarTitle) {
        programNavigatorListener.setProgramToolbar(toolbarTitle);
    }

    public void displayDescriptionExercise(Activity activity, String descriptionExercise) {
        materialDialogComponent.showSingleDialog(
                activity,
                activity.getString(R.string.dialog_title_about),
                descriptionExercise,
                activity.getString(R.string.dialog_fragment_lets_go),
                R.color.colorPrimary);
    }
}
