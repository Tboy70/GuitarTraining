package com.example.thomas.guitartraining.presentation.component.fragment.listener;


import android.widget.Button;
import android.widget.EditText;

public interface ExercisesUIComponentListener {
    void setTypeExerciseButtonAction(Button buttonTypeExercise, EditText durationExercise);

    void setDurationExerciseAction(EditText durationExercise, Button buttonTypeExercise);

    void addExerciseToBeRemoved();
}
