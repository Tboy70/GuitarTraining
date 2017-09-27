package com.example.thomas.guitartraining.presentation.presenter.user;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Log;
import android.util.SparseIntArray;

import com.example.data.module.ModuleSharedPrefsImpl;
import com.example.interactor.exercise.CreateExercise;
import com.example.interactor.program.CreateProgram;
import com.example.model.Exercise;
import com.example.model.Program;
import com.example.thomas.guitartraining.R;
import com.example.thomas.guitartraining.di.PerActivity;
import com.example.thomas.guitartraining.presentation.activity.listener.UserProgramNavigatorListener;
import com.example.thomas.guitartraining.presentation.component.presenter.MaterialDialogComponent;
import com.example.thomas.guitartraining.presentation.component.presenter.listener.SingleChoiceMaterialDialogListener;
import com.example.thomas.guitartraining.presentation.listener.AddExerciseListener;
import com.example.thomas.guitartraining.presentation.navigator.BaseNavigatorListener;
import com.example.thomas.guitartraining.presentation.view.user.UserProgramCreationView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

import rx.Subscriber;

@PerActivity
public class UserProgramCreationPresenter {

    private Context context;
    private MaterialDialogComponent materialDialogComponent;

    private UserProgramCreationView userProgramCreationView;
    private UserProgramNavigatorListener userProgramNavigatorListener;

    private CreateProgram createProgram;
    private CreateExercise createExercise;

    private String selectedItem;

    @Inject
    UserProgramCreationPresenter(Context context, BaseNavigatorListener baseNavigatorListener,
                                 MaterialDialogComponent materialDialogComponent, CreateProgram createProgram,
                                 CreateExercise createExercise) {
        this.context = context;
        this.materialDialogComponent = materialDialogComponent;
        if (baseNavigatorListener instanceof UserProgramNavigatorListener) {
            this.userProgramNavigatorListener = (UserProgramNavigatorListener) baseNavigatorListener;
        }
        this.createProgram = createProgram;
        this.createExercise = createExercise;
    }

    public void setUserProgramCreationView(UserProgramCreationView userProgramCreationView) {
        this.userProgramCreationView = userProgramCreationView;
    }

    public void requestAddExercise() {
        userProgramCreationView.addFieldToCreateExercise();
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

    public void validateCreation(String nameProgram, final SparseIntArray exercises) {
        // TODO: 24/09/2017 Faire un useCase pour récupérer l'id user dans les shared prefs
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);

        Program program = new Program();
        program.setNameProgram(nameProgram);
        program.setDefaultProgram(false);
        program.setIdUser(prefs.getString(ModuleSharedPrefsImpl.CURRENT_USER_ID, "0"));

        createProgram.execute(new Subscriber<Program>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                Log.e("TEST", "onError: ");
            }

            @Override
            public void onNext(Program program) {
                setCreatedExercisesToCreatedProgram(program.getIdProgram(), exercises);
            }
        }, CreateProgram.Params.forCreation(program));
    }


    private void setCreatedExercisesToCreatedProgram(final String idProgram, final SparseIntArray exercises) {
        List<Exercise> exercisesList = new ArrayList<>();
        for (int i = 0; i < exercises.size(); i++) {
            Exercise exercise = new Exercise();
            exercise.setIdProgram(idProgram);
            int key = exercises.keyAt(i);
            exercise.setTypeExercise(key);
            exercise.setDurationExercise(exercises.get(key));

            exercisesList.add(exercise);
        }

        createExercise.execute(new Subscriber<Boolean>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                Log.e("TEST", "onError: ");
            }

            @Override
            public void onNext(Boolean isSuccess) {
                if (isSuccess) {
                    userProgramNavigatorListener.requestDisplayProgramList();
                }
            }
        }, CreateExercise.Params.forCreation(exercisesList));

    }

    private void displaySelectedChoice(AddExerciseListener addExerciseListener) {
        addExerciseListener.onExerciseChosen(selectedItem);
        addExerciseListener.onAllInformationCompleted();
    }
}
