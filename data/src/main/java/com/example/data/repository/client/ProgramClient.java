package com.example.data.repository.client;

import com.example.data.entity.ProgramEntity;
import com.example.data.mapper.db.ProgramDBEntityDataMapper;
import com.example.data.module.db.ModuleDB;
import com.example.data.module.db.ModuleDBFlowImpl;

import javax.inject.Inject;
import javax.inject.Singleton;

import rx.Observable;

@Singleton
public class ProgramClient {

    private ModuleDB moduleDB;
    private ProgramDBEntityDataMapper programDBEntityDataMapper;

    @SuppressWarnings("WeakerAccess")
    @Inject
    public ProgramClient(ModuleDBFlowImpl moduleDB, ProgramDBEntityDataMapper programDBEntityDataMapper) {
        this.moduleDB = moduleDB;
        this.programDBEntityDataMapper = programDBEntityDataMapper;
    }

    public ProgramEntity getProgram(String programId) {
        return programDBEntityDataMapper.transform(moduleDB.getProgramById(programId));
    }
}
