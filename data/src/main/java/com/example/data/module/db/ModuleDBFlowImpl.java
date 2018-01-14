package com.example.data.module.db;

import com.example.data.entity.db.ProgramDBEntity;
import com.example.data.entity.db.ProgramDBEntity_Table;
import com.raizlabs.android.dbflow.annotation.Database;
import com.raizlabs.android.dbflow.config.FlowManager;
import com.raizlabs.android.dbflow.sql.language.SQLite;
import com.raizlabs.android.dbflow.structure.database.DatabaseWrapper;
import com.raizlabs.android.dbflow.structure.database.transaction.ITransaction;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

@Database(name = ModuleDB.DB_NAME, version = ModuleDB.DB_VERSION)
@Singleton
public class ModuleDBFlowImpl implements ModuleDB {

    @Inject
    public ModuleDBFlowImpl() {

    }

    @Override
    public void saveProgramsList(final List<ProgramDBEntity> programDBEntities) {
        FlowManager.getDatabase(ModuleDBFlowImpl.class).executeTransaction(new ITransaction() {
            @Override
            public void execute(DatabaseWrapper databaseWrapper) {
                for (ProgramDBEntity programDBEntity : programDBEntities) {
                    programDBEntity.save();
                }
            }
        });
    }

    @Override
    public List<ProgramDBEntity> getProgramsList() {
        return SQLite.select().from(ProgramDBEntity.class).queryList();
    }

    @Override
    public void deleteAllPrograms() {
        SQLite.delete().from(ProgramDBEntity.class).execute();
    }

    @Override
    public ProgramDBEntity getProgramById(String programId) {
        return SQLite.select().from(ProgramDBEntity.class).where(ProgramDBEntity_Table.idProgram.eq(programId)).querySingle();
    }

    @Override
    public void createProgram(ProgramDBEntity programDBEntity) {
        programDBEntity.save();
    }

    @Override
    public void updateProgram(ProgramDBEntity programDBEntity) {
        programDBEntity.save();
    }
}
