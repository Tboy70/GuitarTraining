package com.example.thomas.guitartraining.presentation.presenter.program.exercise;

import android.app.Activity;
import android.content.Context;

import com.example.thomas.guitartraining.R;
import com.example.thomas.guitartraining.di.PerActivity;
import com.example.thomas.guitartraining.presentation.component.presenter.DialogComponent;
import com.example.thomas.guitartraining.presentation.component.presenter.MaterialDialogComponent;
import com.example.thomas.guitartraining.presentation.component.presenter.listener.SingleChoiceMaterialDialogListener;
import com.example.thomas.guitartraining.presentation.fragment.program.exercise.ExerciseModeFragment;
import com.example.thomas.guitartraining.presentation.presenter.program.exercise.listener.OnTimerDialogDismiss;
import com.example.thomas.guitartraining.presentation.activity.listener.ProgramNavigatorListener;
import com.example.thomas.guitartraining.presentation.view.program.exercise.ExerciseModeView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import javax.inject.Inject;

@PerActivity
public class ExerciseModePresenter {

    private static final int NB_MODES = 7;

    private Context context;
    private DialogComponent dialogComponent;
    private MaterialDialogComponent materialDialogComponent;

    private ExerciseModeView exerciseModeView;
    private ProgramNavigatorListener programNavigatorListener;

    private List<String> items;
    private String selectedItem;

    @SuppressWarnings("WeakerAccess")
    @Inject
    public ExerciseModePresenter(Context context, DialogComponent dialogComponent, MaterialDialogComponent materialDialogComponent) {
        this.context = context;
        this.dialogComponent = dialogComponent;
        this.materialDialogComponent = materialDialogComponent;
        this.items = new ArrayList<>();
    }

    public void setExerciseModeView(ExerciseModeFragment exerciseModeView) {
        this.exerciseModeView = exerciseModeView;
    }

    public void setProgramNavigatorListener(ProgramNavigatorListener programNavigatorListener) {
        this.programNavigatorListener = programNavigatorListener;
    }

    public void showNextExercise(int nextExercisePosition) {
        programNavigatorListener.showNextExercise(nextExercisePosition);
    }

    public void showSimpleChoiceDialog() {
        String title;

        String[] modesArray = context.getResources().getStringArray(R.array.list_modes);
        title = context.getString(R.string.exercise_mode_dialog_choice_mode);
        items = Arrays.asList(modesArray);

        materialDialogComponent.showSingleChoiceDialog(title, items, selectedItem, R.color.colorPrimary, true, new SingleChoiceMaterialDialogListener() {

            @Override
            public void onItemSelected(String item) {
                selectedItem = item;
                displaySelectedChoice();
            }

            @Override
            public void onCancelClick() {
            }

            @Override
            public void getPositionSelected(int which) {
            }
        });
    }

    public void randomModeSelection() {
        Random modeRandom = new Random();
        int modeValue = modeRandom.nextInt(NB_MODES);

        String[] modesArray = context.getResources().getStringArray(R.array.list_modes);
        String selectedMode = modesArray[modeValue];
        selectedItem = selectedMode;
        exerciseModeView.displaySelectedChoice(selectedMode);
    }

    public void launchTimer(Activity activity, long durationLeft) {
        dialogComponent.showTimerDialog(activity, durationLeft, new OnTimerDialogDismiss() {
            @Override
            public void onDismiss(long timeCountInMilliSeconds) {
                exerciseModeView.setLeftDuration(timeCountInMilliSeconds);
            }
        });
    }

    private void displaySelectedChoice() {
        exerciseModeView.displaySelectedChoice(selectedItem);
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
