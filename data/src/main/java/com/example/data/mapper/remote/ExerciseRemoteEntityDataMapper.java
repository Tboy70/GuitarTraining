package com.example.data.mapper.remote;

import com.example.data.entity.ExerciseEntity;
import com.example.data.entity.remote.ExerciseRemoteEntity;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Mapper to pass from exercise remote entity to exercise entity and vice versa.
 */
@Singleton
public class ExerciseRemoteEntityDataMapper {

    @SuppressWarnings("WeakerAccess")
    @Inject
    public ExerciseRemoteEntityDataMapper() {
    }

    public List<ExerciseEntity> transformRemoteToEntityList(List<ExerciseRemoteEntity> exerciseRemoteEntities) {
        List<ExerciseEntity> exerciseEntities = new ArrayList<>();
        for (ExerciseRemoteEntity exerciseRemoteEntity : exerciseRemoteEntities) {
            exerciseEntities.add(transformRemoteToEntity(exerciseRemoteEntity));
        }
        return exerciseEntities;
    }

    private ExerciseEntity transformRemoteToEntity(ExerciseRemoteEntity exerciseRemoteEntity) {
        ExerciseEntity exerciseEntity = new ExerciseEntity();
        exerciseEntity.setIdExercise(exerciseRemoteEntity.getIdExercise());
        exerciseEntity.setDurationExercise(exerciseRemoteEntity.getDurationExercise());
        exerciseEntity.setIdProgram(exerciseRemoteEntity.getIdProgram());
        exerciseEntity.setTypeExercise(exerciseRemoteEntity.getTypeExercise());

        return exerciseEntity;
    }

    public List<ExerciseRemoteEntity> transformEntityToRemoteList(List<ExerciseEntity> exerciseEntities) {
        List<ExerciseRemoteEntity> exerciseRemoteEntities = new ArrayList<>();
        for (ExerciseEntity exerciseEntity : exerciseEntities) {
            exerciseRemoteEntities.add(transformEntityToRemote(exerciseEntity));
        }

        return exerciseRemoteEntities;
    }

    public ExerciseRemoteEntity transformEntityToRemote(ExerciseEntity exerciseEntity) {
        ExerciseRemoteEntity exerciseRemoteEntity = new ExerciseRemoteEntity();
        exerciseRemoteEntity.setIdExercise(exerciseEntity.getIdExercise());
        exerciseRemoteEntity.setDurationExercise(exerciseEntity.getDurationExercise());
        exerciseRemoteEntity.setIdProgram(exerciseEntity.getIdProgram());
        exerciseRemoteEntity.setTypeExercise(exerciseEntity.getTypeExercise());

        return exerciseRemoteEntity;
    }
}
