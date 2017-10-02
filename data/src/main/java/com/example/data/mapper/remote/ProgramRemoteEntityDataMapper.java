package com.example.data.mapper.remote;

import com.example.data.entity.ProgramEntity;
import com.example.data.entity.remote.ProgramRemoteEntity;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Mapper to pass from program remote entity to program entity and vice versa.
 */
@Singleton
public class ProgramRemoteEntityDataMapper {

    private ExerciseRemoteEntityDataMapper exerciseRemoteEntityDataMapper;

    @SuppressWarnings("WeakerAccess")
    @Inject
    public ProgramRemoteEntityDataMapper(ExerciseRemoteEntityDataMapper exerciseRemoteEntityDataMapper) {
        this.exerciseRemoteEntityDataMapper = exerciseRemoteEntityDataMapper;
    }

    public List<ProgramEntity> transformRemoteToEntityList(List<ProgramRemoteEntity> programRemoteEntities) {
        List<ProgramEntity> programEntities = new ArrayList<>();
        for (ProgramRemoteEntity programRemoteEntity : programRemoteEntities) {
            programEntities.add(transformRemoteToEntity(programRemoteEntity));
        }
        return programEntities;
    }

    public ProgramEntity transformRemoteToEntity(ProgramRemoteEntity programRemoteEntity) {
        ProgramEntity programEntity = new ProgramEntity();
        programEntity.setIdProgram(programRemoteEntity.getIdProgram());
        programEntity.setNameProgram(programRemoteEntity.getNameProgram());
        programEntity.setDescriptionProgram(programRemoteEntity.getDescriptionProgram());
        programEntity.setDefaultProgram(programRemoteEntity.isDefaultProgram());
        programEntity.setIdUser(programRemoteEntity.getIdUser());
        if (programRemoteEntity.getExerciseRemoteEntities() != null) {
            programEntity.setExerciseEntities(exerciseRemoteEntityDataMapper.transformRemoteToEntityList(programRemoteEntity.getExerciseRemoteEntities()));
        }
        return programEntity;
    }

    @SuppressWarnings("unused")
    public List<ProgramRemoteEntity> transformEntityToRemoteList(List<ProgramEntity> programEntities) {
        List<ProgramRemoteEntity> programRemoteEntities = new ArrayList<>();
        for (ProgramEntity programEntity : programEntities) {
            programRemoteEntities.add(transformEntityToRemote(programEntity));
        }
        return programRemoteEntities;
    }

    public ProgramRemoteEntity transformEntityToRemote(ProgramEntity programEntity) {
        ProgramRemoteEntity programRemoteEntity = new ProgramRemoteEntity();
        programRemoteEntity.setIdProgram(programEntity.getIdProgram());
        programRemoteEntity.setNameProgram(programEntity.getNameProgram());
        programRemoteEntity.setDescriptionProgram(programEntity.getDescriptionProgram());
        programRemoteEntity.setDefaultProgram(programEntity.isDefaultProgram());
        programRemoteEntity.setIdUser(programEntity.getIdUser());
        if (programEntity.getExerciseEntities() != null) {
            programRemoteEntity.setExerciseRemoteEntities(exerciseRemoteEntityDataMapper.transformEntityToRemoteList(programEntity.getExerciseEntities()));
        }
        return programRemoteEntity;
    }
}
