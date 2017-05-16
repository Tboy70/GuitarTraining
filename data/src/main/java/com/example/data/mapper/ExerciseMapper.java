package com.example.data.mapper;

import com.example.data.entity.ExerciseEntity;
import com.example.model.Exercise;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class ExerciseMapper {

    @Inject
    public ExerciseMapper() {

    }

    public Exercise transformToModel(ExerciseEntity exerciseEntity) {
        Exercise exerciseModel = new Exercise();

        exerciseModel.setIdExercise(exerciseEntity.getIdExercise());
        exerciseModel.setDurationExercise(exerciseEntity.getDurationExercise());
        exerciseModel.setIdProgram(exerciseEntity.getIdProgram());
        exerciseModel.setTypeExercise(exerciseEntity.getTypeExercise());

        return exerciseModel;
    }

    public ExerciseEntity transformToEntity(Exercise exerciseModel) {
        ExerciseEntity exerciseEntity = new ExerciseEntity();

        exerciseEntity.setIdExercise(exerciseModel.getIdExercise());
        exerciseEntity.setDurationExercise(exerciseModel.getDurationExercise());
        exerciseEntity.setIdProgram(exerciseModel.getIdProgram());
        exerciseEntity.setTypeExercise(exerciseModel.getTypeExercise());

        return exerciseEntity;
    }
}
