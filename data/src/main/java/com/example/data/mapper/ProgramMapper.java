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

        List<ExerciseEntity> exerciseEntityList = programEntity.getExerciceEntities();
        List<Exercise> exercisesList = new ArrayList<>();
        for (int i = 0; i < exerciseEntityList.size(); i++) {
            Exercise exercise = new Exercise();
            exercise.setIdExercise(exerciseEntityList.get(i).getIdExercice());
            exercise.setDurationExercise(exerciseEntityList.get(i).getDurationExercice());
            exercise.setIdProgram(exerciseEntityList.get(i).getIdProgram());
            exercise.setTypeExercise(exerciseEntityList.get(i).getTypeExercice());

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
        List<ExerciseEntity> exerciseEntityList= new ArrayList<>();
        for (int i = 0; i < exercisesList.size(); i++) {
            ExerciseEntity exerciseEntity = new ExerciseEntity();
            exerciseEntity.setIdExercice(exercisesList.get(i).getIdExercise());
            exerciseEntity.setDurationExercice(exercisesList.get(i).getDurationExercise());
            exerciseEntity.setIdProgram(exercisesList.get(i).getIdProgram());
            exerciseEntity.setTypeExercice(exercisesList.get(i).getTypeExercise());

            exerciseEntityList.add(exerciseEntity);
        }

        programEntity.setExerciceEntities(exerciseEntityList);

        return programEntity;
    }
}
