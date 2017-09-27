package com.example.thomas.guitartraining.presentation.navigator;

import android.app.Activity;
import android.app.Fragment;

import com.example.data.values.ExercisesTypeValues;
import com.example.model.Exercise;
import com.example.thomas.guitartraining.R;
import com.example.thomas.guitartraining.presentation.component.navigator.ErrorRendererComponent;
import com.example.thomas.guitartraining.presentation.fragment.program.EndProgramFragment;
import com.example.thomas.guitartraining.presentation.fragment.program.IntroProgramFragment;
import com.example.thomas.guitartraining.presentation.fragment.program.exercise.ExerciseBackForthFragment;
import com.example.thomas.guitartraining.presentation.fragment.program.exercise.ExerciseBendSlideFragment;
import com.example.thomas.guitartraining.presentation.fragment.program.exercise.ExerciseModeFragment;
import com.example.thomas.guitartraining.presentation.fragment.program.exercise.ExercisePalmMuteFragment;
import com.example.thomas.guitartraining.presentation.fragment.program.exercise.ExercisePullOffHammerOnFragment;
import com.example.thomas.guitartraining.presentation.fragment.program.exercise.ExerciseScaleFragment;
import com.example.thomas.guitartraining.presentation.fragment.program.exercise.ExerciseSkipStringFragment;
import com.example.thomas.guitartraining.presentation.fragment.program.exercise.ExerciseSpeedFragment;
import com.example.thomas.guitartraining.presentation.fragment.program.exercise.ExerciseSweepPickingFragment;
import com.example.thomas.guitartraining.presentation.fragment.program.exercise.ExerciseTappingFragment;
import com.example.thomas.guitartraining.presentation.utils.ConstantTag;

import javax.inject.Inject;

/**
 * Navigator for the ProgramActivity.
 */
public class ProgramNavigator extends BaseNavigator {

    @SuppressWarnings("WeakerAccess")
    @Inject
    public ProgramNavigator(Activity activity, ErrorRendererComponent errorRendererComponent) {
        super(activity, errorRendererComponent, R.id.activity_program_relative_layout);
    }

    public void displayProgram(Activity activity, int idProgram) {
        Fragment introProgramFragment = IntroProgramFragment.newInstance(idProgram);
        activity.getFragmentManager().beginTransaction()
                .add(R.id.activity_program_frame_layout, introProgramFragment)
                .addToBackStack(ConstantTag.INTRO.toString())
                .commit();
    }

    public void displayExercise(Activity activity, Exercise exercise, int i) {

        Fragment fragmentToDisplay;
        String tag;

        switch (Integer.valueOf(exercise.getTypeExercise())) {
            case ExercisesTypeValues.EXERCISE_SCALE:
                fragmentToDisplay = ExerciseScaleFragment.newInstance(i, exercise.getDurationExercise());
                tag = ConstantTag.SCALE.toString();
                break;
            case ExercisesTypeValues.EXERCISE_MODE:
                fragmentToDisplay = ExerciseModeFragment.newInstance(i, exercise.getDurationExercise());
                tag = ConstantTag.MODE.toString();
                break;
            case ExercisesTypeValues.EXERCISE_PULL_OFF_HAMMER_ON:
                fragmentToDisplay = ExercisePullOffHammerOnFragment.newInstance(i, exercise.getDurationExercise());
                tag = ConstantTag.PULL_OFF_HAMMER_ON.toString();
                break;
            case ExercisesTypeValues.EXERCISE_BEND_SLIDE:
                fragmentToDisplay = ExerciseBendSlideFragment.newInstance(i, exercise.getDurationExercise());
                tag = ConstantTag.BEND_SLIDE.toString();
                break;
            case ExercisesTypeValues.EXERCISE_BACK_FORTH:
                fragmentToDisplay = ExerciseBackForthFragment.newInstance(i, exercise.getDurationExercise());
                tag = ConstantTag.BACK_FORTH.toString();
                break;
            case ExercisesTypeValues.EXERCISE_PALM_MUTE:
                fragmentToDisplay = ExercisePalmMuteFragment.newInstance(i, exercise.getDurationExercise());
                tag = ConstantTag.PALM_MUTE.toString();
                break;
            case ExercisesTypeValues.EXERCISE_SKIP_STRING:
                fragmentToDisplay = ExerciseSkipStringFragment.newInstance(i, exercise.getDurationExercise());
                tag = ConstantTag.SKIP_STRING.toString();
                break;
            case ExercisesTypeValues.EXERCISE_TAPPING:
                fragmentToDisplay = ExerciseTappingFragment.newInstance(i, exercise.getDurationExercise());
                tag = ConstantTag.TAPPING.toString();
                break;
            case ExercisesTypeValues.EXERCISE_SWEEP_PICKING:
                fragmentToDisplay = ExerciseSweepPickingFragment.newInstance(i, exercise.getDurationExercise());
                tag = ConstantTag.SWEEP_PICKING.toString();
                break;
            case ExercisesTypeValues.EXERCISE_SPEED:
                fragmentToDisplay = ExerciseSpeedFragment.newInstance(i, exercise.getDurationExercise());
                tag = ConstantTag.SPEED.toString();
                break;
            default:
                fragmentToDisplay = EndProgramFragment.newInstance();
                tag = ConstantTag.END.toString();
                break;
        }

        activity.getFragmentManager()
                .beginTransaction()
                .setCustomAnimations(R.animator.slide_in_left, R.animator.slide_out_right, R.animator.slide_in_left, R.animator.slide_out_right)
                .replace(R.id.activity_program_frame_layout, fragmentToDisplay)
                .addToBackStack(tag)
                .commit();
    }

    public void displayEndOfProgram(Activity activity) {

        Fragment endProgramFragment = EndProgramFragment.newInstance();

        activity.getFragmentManager()
                .beginTransaction()
                .setCustomAnimations(R.animator.slide_in_left, R.animator.slide_out_right, R.animator.slide_in_left, R.animator.slide_out_right)
                .replace(R.id.activity_program_frame_layout, endProgramFragment)
                .addToBackStack(ConstantTag.END.toString())
                .commit();
    }
}
