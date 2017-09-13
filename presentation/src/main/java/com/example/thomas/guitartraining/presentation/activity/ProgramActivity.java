package com.example.thomas.guitartraining.presentation.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.model.Exercise;
import com.example.thomas.guitartraining.R;
import com.example.thomas.guitartraining.presentation.activity.listener.ProgramNavigatorListener;
import com.example.thomas.guitartraining.presentation.navigator.ProgramNavigator;
import com.example.thomas.guitartraining.presentation.presenter.activity.ProgramPresenter;
import com.example.thomas.guitartraining.presentation.utils.ConstantTag;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.ButterKnife;

import static com.example.thomas.guitartraining.presentation.navigator.NotConnectedNavigator.ID_PROGRAM;

/**
 * Activity handling the program.
 */
public class ProgramActivity extends BaseActivity implements ProgramNavigatorListener {

    @Inject
    ProgramPresenter programPresenter;
    @Inject
    ProgramNavigator programNavigator;

    private List<Exercise> exercisesOfProgram;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_program);
        getActivityComponent().inject(this);
        ButterKnife.bind(this);
        exercisesOfProgram = new ArrayList<>();
        Bundle extras = getIntent().getExtras();

        if (extras.containsKey(ID_PROGRAM)) {
            programNavigator.displayProgram(this, extras.getInt(ID_PROGRAM));
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        setProgramToolbar(null);
    }

    @Override
    public void showNextExercise(List<Exercise> exercisesOfProgram, int exercisePosition) {
        this.exercisesOfProgram = exercisesOfProgram;
        programNavigator.displayExercise(this, exercisesOfProgram.get(exercisePosition), exercisePosition);
    }

    @Override
    public void showNextExercise(int exercisePosition) {
        if (exercisePosition < exercisesOfProgram.size()) {
            programNavigator.displayExercise(this, exercisesOfProgram.get(exercisePosition), exercisePosition);
        } else {
            programNavigator.displayEndOfProgram(this);
        }
    }

    @Override
    public void setProgramToolbar(String toolbarTitle) {

        Toolbar toolbar = (Toolbar) findViewById(R.id.activity_program_toolbar);
        setSupportActionBar(toolbar);

        toolbar.setTitleTextColor(ContextCompat.getColor(this, android.R.color.white));
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        if (toolbarTitle != null) {
            toolbar.setTitle(toolbarTitle);
        }

    }

    @Override
    public void onBackPressed() {
        String currentFragment = getFragmentManager().getBackStackEntryAt(getFragmentManager().getBackStackEntryCount() - 1).getName();

        if (currentFragment.equals(ConstantTag.INTRO.toString())) {
            displayQuitProgramDialogFragment(this);
        } else {
            String previousFragment = getFragmentManager().getBackStackEntryAt(getFragmentManager().getBackStackEntryCount() - 2).getName();
            if (previousFragment.equals(ConstantTag.INTRO.toString())) {
                displayQuitProgramDialogFragment(this);
            } else {
                super.onBackPressed();
            }
        }
    }

    @Override
    public void requestRenderError(Throwable e, int mode, View viewId) {
    }

    private void displayQuitProgramDialogFragment(Activity activity) {
        programPresenter.displayQuitProgramDialogFragment(activity);
    }
}
