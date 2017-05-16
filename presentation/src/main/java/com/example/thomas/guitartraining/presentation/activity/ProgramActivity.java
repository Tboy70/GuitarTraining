package com.example.thomas.guitartraining.presentation.activity;

import android.os.Bundle;

import com.example.model.Exercise;
import com.example.thomas.guitartraining.presentation.navigator.ProgramNavigator;
import com.example.thomas.guitartraining.presentation.presenter.activity.ProgramPresenter;
import com.example.thomas.guitartraining.presentation.view.ProgramNavigatorListener;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.ButterKnife;

import static com.example.thomas.guitartraining.presentation.navigator.OfflineNavigator.ID_PROGRAM;

/**
 * Created by amiltonedev_lt043 on 08/05/2017.
 */

public class ProgramActivity extends BaseActivity implements ProgramNavigatorListener {

    @Inject
    ProgramPresenter programPresenter;

    private ProgramNavigator programNavigator;

    private List<Exercise> exercisesOfProgram;

    private Bundle extras;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getActivityComponent().inject(this);
        ButterKnife.bind(this);
        injectParameters();
        exercisesOfProgram = new ArrayList<>();
        extras = getIntent().getExtras();
    }

    private void injectParameters() {
        programNavigator = new ProgramNavigator();
    }

    @Override
    protected void onStart() {
        super.onStart();

        if (extras.containsKey(ID_PROGRAM)) {
            programNavigator.displayProgram(this, extras.getInt(ID_PROGRAM));
        }
    }

    //TODO : rename "i"
    @Override
    public void showNextExercise(List<Exercise> exercisesOfProgram, int i) {
        this.exercisesOfProgram = exercisesOfProgram;
        programNavigator.displayExercise(this, exercisesOfProgram.get(i), i);
    }

    @Override
    public void showNextExercise(int i) {
        if (i < exercisesOfProgram.size()) {
            programNavigator.displayExercise(this, exercisesOfProgram.get(i), i);
        } else {
            programNavigator.displayEndOfProgram(this);
        }
    }
}
