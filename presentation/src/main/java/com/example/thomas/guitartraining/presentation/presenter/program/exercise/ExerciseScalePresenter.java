package com.example.thomas.guitartraining.presentation.presenter.program.exercise;

import android.app.Activity;
import android.content.Context;

import com.example.thomas.guitartraining.R;
import com.example.thomas.guitartraining.di.PerActivity;
import com.example.thomas.guitartraining.presentation.component.presenter.DialogComponent;
import com.example.thomas.guitartraining.presentation.component.presenter.MaterialDialogComponent;
import com.example.thomas.guitartraining.presentation.component.presenter.listener.SingleChoiceMaterialDialogListener;
import com.example.thomas.guitartraining.presentation.fragment.program.exercise.ExerciseScaleFragment;
import com.example.thomas.guitartraining.presentation.presenter.program.exercise.listener.OnTimerDialogDismiss;
import com.example.thomas.guitartraining.presentation.activity.listener.ProgramNavigatorListener;
import com.example.thomas.guitartraining.presentation.view.program.exercise.ExerciseScaleView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import javax.inject.Inject;

@PerActivity
public class ExerciseScalePresenter {

    private static final int NB_NOTES = 12;
    private static final int NB_MODES = 3;

    private Context context;
    private DialogComponent dialogComponent;
    private MaterialDialogComponent materialDialogComponent;

    private ExerciseScaleView exerciseScaleView;
    private ProgramNavigatorListener programNavigatorListener;

    private List<String> items;
    private String selectedItem;

    @SuppressWarnings("WeakerAccess")
    @Inject
    public ExerciseScalePresenter(Context context, DialogComponent dialogComponent, MaterialDialogComponent materialDialogComponent) {
        this.context = context;
        this.dialogComponent = dialogComponent;
        this.materialDialogComponent = materialDialogComponent;
        this.items = new ArrayList<>();
    }

    public void setExerciseScaleView(ExerciseScaleFragment exerciseScaleView) {
        this.exerciseScaleView = exerciseScaleView;
    }

    public void setProgramNavigatorListener(ProgramNavigatorListener programNavigatorListener) {
        this.programNavigatorListener = programNavigatorListener;
    }

    public void showNextExercise(int nextExercisePosition) {
        programNavigatorListener.showNextExercise(nextExercisePosition);
    }

    public void showSimpleChoiceDialog(final int listTypeSelection) {

        String title = "";

        switch (listTypeSelection) {
            case ExerciseScaleFragment.SCALE_NOTE_SELECTION:
                String[] notesArray = context.getResources().getStringArray(R.array.list_notes);
                title = context.getString(R.string.exercise_scale_dialog_choice_note);
                items = Arrays.asList(notesArray);
                break;
            case ExerciseScaleFragment.SCALE_MODE_SELECTION:
                String[] toneArray = context.getResources().getStringArray(R.array.list_tones);
                title = context.getString(R.string.exercise_scale_dialog_choice_mode);
                items = Arrays.asList(toneArray);
                break;
        }

        materialDialogComponent.showSingleChoiceDialog(title, items, selectedItem, R.color.colorPrimary, true, new SingleChoiceMaterialDialogListener() {

            @Override
            public void onItemSelected(String item) {
                selectedItem = item;
                displaySelectedChoice(listTypeSelection);
            }

            @Override
            public void onCancelClick() {
            }

            @Override
            public void getPositionSelected(int which) {
            }
        });
    }

    public void randomScaleSelection() {
        Random scaleNoteRandom = new Random();
        int scaleNoteValue = scaleNoteRandom.nextInt(NB_NOTES);

        Random scaleModeRandom = new Random();
        int scaleModeValue = scaleModeRandom.nextInt(NB_MODES);

        String[] notesArray = context.getResources().getStringArray(R.array.list_notes);
        String selectedNote = notesArray[scaleNoteValue];
        selectedItem = selectedNote;
        exerciseScaleView.displaySelectedChoice(selectedNote, ExerciseScaleFragment.SCALE_NOTE_SELECTION);

        String[] modesArray = context.getResources().getStringArray(R.array.list_tones);
        String selectedMode = modesArray[scaleModeValue];
        selectedItem = selectedMode;
        exerciseScaleView.displaySelectedChoice(selectedMode, ExerciseScaleFragment.SCALE_MODE_SELECTION);

    }

    public void launchTimer(Activity activity, long durationLeft) {
        dialogComponent.showTimerDialog(activity, durationLeft, new OnTimerDialogDismiss() {
            @Override
            public void onDismiss(long timeCountInMilliSeconds) {
                exerciseScaleView.setLeftDuration(timeCountInMilliSeconds);
            }
        });
    }

    private void displaySelectedChoice(int listTypeSelection) {
        exerciseScaleView.displaySelectedChoice(selectedItem, listTypeSelection);
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
