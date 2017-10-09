package com.example.data.mapper.db;

import com.example.data.entity.ProgramEntity;
import com.example.data.entity.db.ProgramDBEntity;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class ProgramDBEntityDataMapper {

    @Inject
    public ProgramDBEntityDataMapper() {}


    public List<ProgramDBEntity> transformToDBEntity(List<ProgramEntity> programEntities) {
        List<ProgramDBEntity> programDBEntityList = new ArrayList<>();
        for (ProgramEntity programEntity : programEntities) {
            programDBEntityList.add(transform(programEntity));
        }
        return programDBEntityList;
    }

    public List<ProgramEntity> transform(List<ProgramDBEntity> programDBEntities) {
        List<ProgramEntity> programEntityList = new ArrayList<>();
        for (ProgramDBEntity programDBEntity : programDBEntities) {
            programEntityList.add(transform(programDBEntity));
        }
        return programEntityList;
    }

    public ProgramEntity transform(ProgramDBEntity programDBEntity) {
        ProgramEntity programEntity = new ProgramEntity();

        programEntity.setIdProgram(programDBEntity.getIdProgram());
        programEntity.setNameProgram(programDBEntity.getNameProgram());
        programEntity.setDescriptionProgram(programDBEntity.getDescriptionProgram());
        programEntity.setIdUser(programDBEntity.getIdUser());
        programEntity.setDefaultProgram(programDBEntity.isDefaultProgram());
        programEntity.setExerciseEntities(programDBEntity.getExercisesList());

        return programEntity;
    }

    public ProgramDBEntity transform(ProgramEntity programEntity) {
        ProgramDBEntity programDBEntity = new ProgramDBEntity();

        programDBEntity.setIdProgram(programEntity.getIdProgram());
        programDBEntity.setNameProgram(programEntity.getNameProgram());
        programDBEntity.setDescriptionProgram(programEntity.getDescriptionProgram());
        programDBEntity.setIdUser(programEntity.getIdUser());
        programDBEntity.setDefaultProgram(programEntity.isDefaultProgram());
        programDBEntity.setExercisesList(programEntity.getExerciseEntities());

        return programDBEntity;
    }
}
