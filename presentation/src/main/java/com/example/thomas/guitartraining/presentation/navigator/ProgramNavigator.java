package com.example.thomas.guitartraining.presentation.navigator;

import android.app.Activity;
import android.app.Fragment;

import com.example.data.values.ExercisesTypeValues;
import com.example.model.Exercise;
import com.example.thomas.guitartraining.R;
import com.example.thomas.guitartraining.presentation.fragment.program.EndProgramFragment;
import com.example.thomas.guitartraining.presentation.fragment.program.exercise.ExerciseBackForthForthFragment;
import com.example.thomas.guitartraining.presentation.fragment.program.exercise.ExerciseBendSlideFragment;
import com.example.thomas.guitartraining.presentation.fragment.program.exercise.ExerciseModeFragment;
import com.example.thomas.guitartraining.presentation.fragment.program.exercise.ExercisePalmMuteFragment;
import com.example.thomas.guitartraining.presentation.fragment.program.exercise.ExercisePullOffHammerOnFragment;
import com.example.thomas.guitartraining.presentation.fragment.program.exercise.ExerciseScaleFragment;
import com.example.thomas.guitartraining.presentation.fragment.program.IntroProgramFragment;
import com.example.thomas.guitartraining.presentation.fragment.program.exercise.ExerciseSkipStringFragment;
import com.example.thomas.guitartraining.presentation.fragment.program.exercise.ExerciseSpeedFragment;
import com.example.thomas.guitartraining.presentation.fragment.program.exercise.ExerciseSweepPickingFragment;

/**
 * Created by amiltonedev_lt043 on 08/05/2017.
 */

public class ProgramNavigator {

    public ProgramNavigator() {

    }

    public void displayProgram(Activity activity, int idProgram) {
        Fragment introProgramFragment = IntroProgramFragment.newInstance(idProgram);

        activity.setContentView(R.layout.activity_program);
        activity.getFragmentManager().beginTransaction().add(R.id.program_activity_frame_layout, introProgramFragment).commit();
    }

    public void displayExercise(Activity activity, Exercise exercise, int i) {

        Fragment fragmentToDisplay;

        switch (exercise.getTypeExercise()) {
            case ExercisesTypeValues.EXERCISE_SCALE:
                fragmentToDisplay = ExerciseScaleFragment.newInstance(i, exercise.getDurationExercise());
                break;
            case ExercisesTypeValues.EXERCISE_MODE:
                fragmentToDisplay = ExerciseModeFragment.newInstance(i, exercise.getDurationExercise());
                break;
            case ExercisesTypeValues.EXERCISE_PULL_OFF_HAMMER_ON:
                fragmentToDisplay = ExercisePullOffHammerOnFragment.newInstance(i, exercise.getDurationExercise());
                break;
            case ExercisesTypeValues.EXERCISE_BEND_SLIDE:
                fragmentToDisplay = ExerciseBendSlideFragment.newInstance(i, exercise.getDurationExercise());
                break;
            case ExercisesTypeValues.EXERCISE_BACK_FORTH:
                fragmentToDisplay = ExerciseBackForthForthFragment.newInstance(i, exercise.getDurationExercise());
                break;
            case ExercisesTypeValues.EXERCISE_PALM_MUTE:
                fragmentToDisplay = ExercisePalmMuteFragment.newInstance(i, exercise.getDurationExercise());
                break;
            case ExercisesTypeValues.EXERCISE_SKIP_STRING:
                fragmentToDisplay = ExerciseSkipStringFragment.newInstance(i, exercise.getDurationExercise());
                break;
            case ExercisesTypeValues.EXERCISE_TAPPING:
                fragmentToDisplay = ExerciseModeFragment.newInstance(i, exercise.getDurationExercise());
                break;
            case ExercisesTypeValues.EXERCISE_SWEEP_PICKING:
                fragmentToDisplay = ExerciseSweepPickingFragment.newInstance(i, exercise.getDurationExercise());
                break;
            case ExercisesTypeValues.EXERCISE_SPEED:
                fragmentToDisplay = ExerciseSpeedFragment.newInstance(i, exercise.getDurationExercise());
                break;
            default:
                fragmentToDisplay = EndProgramFragment.newInstance();
                break;
        }

        activity.setContentView(R.layout.activity_program);
        activity.getFragmentManager().beginTransaction().add(R.id.program_activity_frame_layout, fragmentToDisplay).commit();
    }

    public void displayEndOfProgram(Activity activity) {

        Fragment endProgramFragment = EndProgramFragment.newInstance();

        activity.setContentView(R.layout.activity_program);
        activity.getFragmentManager().beginTransaction().add(R.id.program_activity_frame_layout, endProgramFragment).commit();
    }
}
