package com.example.data.mapper;

import com.example.data.entity.ExerciseEntity;
import com.example.model.Exercise;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Mapper to pass from exercise entity to exercise model and vice versa.
 */
@Singleton
public class ExerciseEntityDataMapper {

    @SuppressWarnings("WeakerAccess")
    @Inject
    public ExerciseEntityDataMapper() {}

    @SuppressWarnings("unused")
    public Exercise transformEntityToModel(ExerciseEntity exerciseEntity) {
        Exercise exercise = new Exercise();
        exercise.setIdExercise(exerciseEntity.getIdExercise());
        exercise.setDurationExercise(exerciseEntity.getDurationExercise());
        exercise.setIdProgram(exerciseEntity.getIdProgram());
        exercise.setTypeExercise(exerciseEntity.getTypeExercise());

        return exercise;
    }

    @SuppressWarnings("unused")
    public ExerciseEntity transformModelToEntity(Exercise exercise) {
        ExerciseEntity exerciseEntity = new ExerciseEntity();
        exerciseEntity.setIdExercise(exercise.getIdExercise());
        exerciseEntity.setDurationExercise(exercise.getDurationExercise());
        exerciseEntity.setIdProgram(exercise.getIdProgram());
        exerciseEntity.setTypeExercise(exercise.getTypeExercise());

        return exerciseEntity;
    }
}
