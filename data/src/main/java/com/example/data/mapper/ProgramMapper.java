package com.example.data.mapper;

import com.example.data.entity.ProgramEntity;
import com.example.model.Program;

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
        programModel.setUserIdProgram(programEntity.getUserIdProgram());

        // TODO : See for map a list !

        return programModel;
    }

    public ProgramEntity transformToEntity(Program programModel) {
        ProgramEntity programEntity = new ProgramEntity();

        programEntity.setIdProgram(programModel.getIdProgram());
        programEntity.setNameProgram(programModel.getNameProgram());
        programEntity.setDefaultProgram(programModel.isDefaultProgram());
        programEntity.setUserIdProgram(programModel.getUserIdProgram());

        // TODO : See for map a list !

        return programEntity;
    }
}
