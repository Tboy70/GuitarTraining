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
 * Mapper to pass from program model to program entity and program entity to program model.
 */
@Singleton
public class ProgramMapper {

    @Inject
    public ProgramMapper() {
    }

    public Program transformToModel(ProgramEntity programEntity) {
        Program programModel = new Program();

        programModel.setIdProgram(programEntity.getIdProgram());
        programModel.setNameProgram(programEntity.getNameProgram());
        programModel.setDefaultProgram(programEntity.isDefaultProgram());
        programModel.setUserId(programEntity.getUserIdProgram());

        List<ExerciseEntity> exerciseEntityList = programEntity.getExerciseEntities();
        List<Exercise> exercisesList = new ArrayList<>();
        for (int i = 0; i < exerciseEntityList.size(); i++) {
            Exercise exercise = new Exercise();
            exercise.setIdExercise(exerciseEntityList.get(i).getIdExercise());
            exercise.setDurationExercise(exerciseEntityList.get(i).getDurationExercise());
            exercise.setIdProgram(exerciseEntityList.get(i).getIdProgram());
            exercise.setTypeExercise(exerciseEntityList.get(i).getTypeExercise());

            exercisesList.add(exercise);
        }

        programModel.setExercises(exercisesList);

        return programModel;
    }

    public ProgramEntity transformToEntity(Program programModel) {
        ProgramEntity programEntity = new ProgramEntity();

        programEntity.setIdProgram(programModel.getIdProgram());
        programEntity.setNameProgram(programModel.getNameProgram());
        programEntity.setDefaultProgram(programModel.isDefaultProgram());
        programEntity.setUserIdProgram(programModel.getUserId());

        List<Exercise> exercisesList = programModel.getExercises();
        List<ExerciseEntity> exerciseEntityList = new ArrayList<>();
        for (int i = 0; i < exercisesList.size(); i++) {
            ExerciseEntity exerciseEntity = new ExerciseEntity();
            exerciseEntity.setIdExercise(exercisesList.get(i).getIdExercise());
            exerciseEntity.setDurationExercise(exercisesList.get(i).getDurationExercise());
            exerciseEntity.setIdProgram(exercisesList.get(i).getIdProgram());
            exerciseEntity.setTypeExercise(exercisesList.get(i).getTypeExercise());

            exerciseEntityList.add(exerciseEntity);
        }

        programEntity.setExerciseEntities(exerciseEntityList);

        return programEntity;
    }
}
