package com.example.thomas.guitartraining.presentation.activity.listener;

import com.example.model.Exercise;
import com.example.thomas.guitartraining.presentation.navigator.BaseNavigatorListener;

import java.util.List;

public interface ProgramNavigatorListener extends BaseNavigatorListener {

    void showNextExercise(List<Exercise> exercisesOfProgram, int i);

    void showNextExercise(int i);

    void setProgramToolbar(String toolbarTitle);
}
