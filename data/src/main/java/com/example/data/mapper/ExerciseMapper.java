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

        exerciseModel.setIdExercise(exerciseEntity.getIdExercice());
        exerciseModel.setDurationExercise(exerciseEntity.getDurationExercice());
        exerciseModel.setIdProgram(exerciseEntity.getIdProgram());
        exerciseModel.setTypeExercice(exerciseEntity.getTypeExercice());

        return exerciseModel;
    }

    public ExerciseEntity transformToEntity(Exercise exerciseModel) {
        ExerciseEntity exerciseEntity = new ExerciseEntity();

        exerciseEntity.setIdExercice(exerciseModel.getIdExercise());
        exerciseEntity.setDurationExercice(exerciseModel.getDurationExercise());
        exerciseEntity.setIdProgram(exerciseModel.getIdProgram());
        exerciseEntity.setTypeExercice(exerciseModel.getTypeExercice());

        return exerciseEntity;
    }
}
