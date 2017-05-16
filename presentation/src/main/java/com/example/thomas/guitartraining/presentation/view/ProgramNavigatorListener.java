package com.example.thomas.guitartraining.presentation.view;

import com.example.model.Exercise;

import java.util.List;

/**
 * Created by amiltonedev_lt043 on 08/05/2017.
 */

public interface ProgramNavigatorListener {
    void showNextExercise(List<Exercise> exercisesOfProgram, int i);

    void showNextExercise(int i);
}
