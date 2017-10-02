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
public class ProgramEntityDataMapper {

    @SuppressWarnings("WeakerAccess")
    @Inject
    public ProgramEntityDataMapper() {
    }

    public List<Program> transformEntityToModelList(List<ProgramEntity> programEntities) {
        List<Program> programList = new ArrayList<>();
        for (ProgramEntity programEntity : programEntities) {
            programList.add(transformEntityToModel(programEntity));
        }
        return programList;
    }

    public Program transformEntityToModel(ProgramEntity programEntity) {
        Program program = new Program();
        program.setIdProgram(programEntity.getIdProgram());
        program.setNameProgram(programEntity.getNameProgram());
        program.setDescriptionProgram(programEntity.getDescriptionProgram());
        program.setDefaultProgram(programEntity.isDefaultProgram());
        program.setIdUser(programEntity.getIdUser());

        if (programEntity.getExerciseEntities() != null) {
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

            program.setExercises(exercisesList);
        }

        return program;
    }

    @SuppressWarnings("unused")
    public List<ProgramEntity> transformModelToEntityList(List<Program> programs) {
        List<ProgramEntity> programEntityList = new ArrayList<>();
        for (Program program : programs) {
            programEntityList.add(transformModelToEntity(program));
        }
        return programEntityList;
    }

    public ProgramEntity transformModelToEntity(Program program) {
        ProgramEntity programEntity = new ProgramEntity();

        programEntity.setIdProgram(program.getIdProgram());
        programEntity.setNameProgram(program.getNameProgram());
        programEntity.setDescriptionProgram(program.getDescriptionProgram());
        programEntity.setDefaultProgram(program.isDefaultProgram());
        programEntity.setIdUser(program.getIdUser());

        if (program.getExercises() != null) {
            List<Exercise> exercisesList = program.getExercises();
            List<ExerciseEntity> exerciseList = new ArrayList<>();
            for (int i = 0; i < exercisesList.size(); i++) {
                ExerciseEntity exerciseEntity = new ExerciseEntity();
                exerciseEntity.setIdExercise(exercisesList.get(i).getIdExercise());
                exerciseEntity.setDurationExercise(exercisesList.get(i).getDurationExercise());
                exerciseEntity.setIdProgram(exercisesList.get(i).getIdProgram());
                exerciseEntity.setTypeExercise(exercisesList.get(i).getTypeExercise());

                exerciseList.add(exerciseEntity);
            }

            programEntity.setExerciseEntities(exerciseList);
        }

        return programEntity;
    }
}
