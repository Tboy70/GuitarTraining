package com.example.data.module.db;


import com.example.data.entity.db.ProgramDBEntity;

import java.util.List;

public interface ModuleDB {
    String DB_NAME = "guitar_training_mobile";
    int DB_VERSION = 1;

    void saveProgramsList(List<ProgramDBEntity> programDBEntities);

    List<ProgramDBEntity> getProgramsList();

    void deleteAllPrograms();

    ProgramDBEntity getProgramById(String programId);

    void createProgram(ProgramDBEntity programDBEntity);
}
