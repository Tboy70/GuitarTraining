package com.example.data.mapper;

import com.example.data.entity.ExerciseEntity;
import com.example.data.entity.ProgramEntity;
import com.example.model.Exercise;
import com.example.model.Program;

import java.util.ArrayList;
import java.util.List;

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

    public List<Exercise> transformEntityToModelList(List<ExerciseEntity> exerciseEntities) {
        List<Exercise> exerciseList = new ArrayList<>();
        for (ExerciseEntity exerciseEntity : exerciseEntities) {
            exerciseList.add(transformEntityToModel(exerciseEntity));
        }
        return exerciseList;
    }

    public Exercise transformEntityToModel(ExerciseEntity exerciseEntity) {
        Exercise exercise = new Exercise();
        exercise.setIdExercise(exerciseEntity.getIdExercise());
        exercise.setDurationExercise(exerciseEntity.getDurationExercise());
        exercise.setIdProgram(exerciseEntity.getIdProgram());
        exercise.setTypeExercise(exerciseEntity.getTypeExercise());

        return exercise;
    }

    public List<ExerciseEntity> transformModelToEntityList(List<Exercise> exercises) {
        List<ExerciseEntity> exerciseEntityList = new ArrayList<>();
        for (Exercise exercise : exercises) {
            exerciseEntityList.add(transformModelToEntity(exercise));
        }
        return exerciseEntityList;
    }

    public ExerciseEntity transformModelToEntity(Exercise exercise) {
        ExerciseEntity exerciseEntity = new ExerciseEntity();
        exerciseEntity.setIdExercise(exercise.getIdExercise());
        exerciseEntity.setDurationExercise(exercise.getDurationExercise());
        exerciseEntity.setIdProgram(exercise.getIdProgram());
        exerciseEntity.setTypeExercise(exercise.getTypeExercise());

        return exerciseEntity;
    }
}
