package com.example.thomas.guitartraining.presentation.presenter.user;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Log;

import com.example.data.module.ModuleSharedPrefsImpl;
import com.example.interactor.program.UpdateProgramAndRemoveExercises;
import com.example.model.Exercise;
import com.example.model.Program;
import com.example.thomas.guitartraining.R;
import com.example.thomas.guitartraining.di.PerActivity;
import com.example.thomas.guitartraining.presentation.activity.listener.UserProgramNavigatorListener;
import com.example.thomas.guitartraining.presentation.component.navigator.ErrorRendererComponent;
import com.example.thomas.guitartraining.presentation.component.presenter.MaterialDialogComponent;
import com.example.thomas.guitartraining.presentation.component.presenter.listener.SingleChoiceMaterialDialogListener;
import com.example.thomas.guitartraining.presentation.listener.AddExerciseListener;
import com.example.thomas.guitartraining.presentation.navigator.BaseNavigatorListener;
import com.example.thomas.guitartraining.presentation.view.user.UserProgramUpdateView;

import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

import rx.Subscriber;

@PerActivity
public class UserProgramUpdatePresenter {

    private Context context;
    private MaterialDialogComponent materialDialogComponent;

    private UserProgramUpdateView userProgramUpdateView;
    private UserProgramNavigatorListener userProgramNavigatorListener;

    private UpdateProgramAndRemoveExercises updateProgramAndRemoveExercises;

    private String selectedItem;

    @Inject
    UserProgramUpdatePresenter(Context context, MaterialDialogComponent materialDialogComponent,
                               BaseNavigatorListener baseNavigatorListener, UpdateProgramAndRemoveExercises updateProgramAndRemoveExercises) {
        this.context = context;
        this.materialDialogComponent = materialDialogComponent;
        if (baseNavigatorListener instanceof UserProgramNavigatorListener) {
            this.userProgramNavigatorListener = (UserProgramNavigatorListener) baseNavigatorListener;
        }
        this.updateProgramAndRemoveExercises = updateProgramAndRemoveExercises;
    }

    public void setUserProgramUpdateView(UserProgramUpdateView userProgramUpdateView) {
        this.userProgramUpdateView = userProgramUpdateView;
    }

    public void showSimpleDialog(final AddExerciseListener addExerciseListener) {
        String[] exercisesArray = context.getResources().getStringArray(R.array.list_exercises);
        String title = context.getString(R.string.generic_exercise_choice_creation_program);
        List<String> items = Arrays.asList(exercisesArray);

        materialDialogComponent.showSingleChoiceDialog(title, items, selectedItem, R.color.colorPrimary, true, new SingleChoiceMaterialDialogListener() {

            @Override
            public void onItemSelected(String item) {
                selectedItem = item;
                displaySelectedChoice(addExerciseListener);
            }

            @Override
            public void onCancelClick() {
            }

            @Override
            public void getPositionSelected(int which) {
            }
        });
    }

    public void checkInformationAndValidateUpdate(String idProgram, String nameProgram, String descriptionProgram, List<Exercise> programListExercises, List<Exercise> exercisesToBeRemoved) {
        if (checkInformation(nameProgram, programListExercises)) {
            // TODO: 24/09/2017 Faire un useCase pour récupérer l'id user dans les shared prefs
            SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);

            Program program = new Program();
            program.setIdProgram(idProgram);
            program.setNameProgram(nameProgram);
            program.setDescriptionProgram(descriptionProgram);
            program.setExercises(programListExercises);
            program.setDefaultProgram(false);
            program.setIdUser(prefs.getString(ModuleSharedPrefsImpl.CURRENT_USER_ID, "0"));

            updateProgramAndRemoveExercises.execute(new Subscriber<Boolean>() {
                @Override
                public void onCompleted() {

                }

                @Override
                public void onError(Throwable e) {
                    // TODO: 03/10/2017 Handle error
                    Log.e("TEST", "onError: ");
                }

                @Override
                public void onNext(Boolean isSuccess) {
                    if (isSuccess) {
                        userProgramNavigatorListener.requestDisplayProgramList();
                    }
                }
            }, UpdateProgramAndRemoveExercises.Params.forUpdate(program, exercisesToBeRemoved));
        } else {
            userProgramNavigatorListener.requestRenderErrorString(context.getString(R.string.snackbar_error_wrong_information), ErrorRendererComponent.ERROR_DISPLAY_MODE_SNACKBAR, null);
        }
    }

    private void displaySelectedChoice(AddExerciseListener addExerciseListener) {
        addExerciseListener.onExerciseChosen(selectedItem);
        addExerciseListener.onAllInformationCompleted();
    }

    private boolean checkInformation(String nameProgram, List<Exercise> exercises) {
        if (nameProgram == null || nameProgram.isEmpty()) {
            return false;
        } else {
            for (Exercise exercise : exercises) {
                if (exercise.getTypeExercise() == -1) {
                    return false;
                } else if (!String.valueOf(exercise.getDurationExercise()).trim().matches("^[0-9]*$")) {
                    return false;
                }
            }
            return true;
        }
    }
}
