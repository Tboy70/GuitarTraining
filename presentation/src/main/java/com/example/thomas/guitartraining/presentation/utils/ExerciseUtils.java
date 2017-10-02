package com.example.thomas.guitartraining.presentation.utils;

import android.app.Activity;

import com.example.data.values.ExercisesTypeValues;
import com.example.thomas.guitartraining.R;

public class ExerciseUtils {

    public static String convertTypeExerciseToName(int typeExercise, Activity activity) {
        switch (typeExercise) {
            case ExercisesTypeValues.EXERCISE_SCALE:
                return activity.getString(R.string.exercise_scale_title_text);
            case ExercisesTypeValues.EXERCISE_MODE:
                return activity.getString(R.string.exercise_mode_title_text);
            case ExercisesTypeValues.EXERCISE_PULL_OFF_HAMMER_ON:
                return activity.getString(R.string.exercise_palm_mute_title_text);
            case ExercisesTypeValues.EXERCISE_BEND_SLIDE:
                return activity.getString(R.string.exercise_bend_slide_title_text);
            case ExercisesTypeValues.EXERCISE_BACK_FORTH:
                return activity.getString(R.string.exercise_back_forth_title_text);
            case ExercisesTypeValues.EXERCISE_PALM_MUTE:
                return activity.getString(R.string.exercise_palm_mute_title_text);
            case ExercisesTypeValues.EXERCISE_SKIP_STRING:
                return activity.getString(R.string.exercise_skip_string_title_text);
            case ExercisesTypeValues.EXERCISE_TAPPING:
                return activity.getString(R.string.exercise_tapping_title_text);
            case ExercisesTypeValues.EXERCISE_SWEEP_PICKING:
                return activity.getString(R.string.exercise_sweep_picking_title_text);
            case ExercisesTypeValues.EXERCISE_SPEED:
                return activity.getString(R.string.exercise_speed_title_text);
            default:
                return activity.getString(R.string.generic_error_title_text);
        }
    }
}
