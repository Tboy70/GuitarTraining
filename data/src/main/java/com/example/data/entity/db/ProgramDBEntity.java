package com.example.data.entity.db;

import com.example.data.entity.db.converter.StringListTypeConverter;
import com.example.data.module.db.ModuleDBFlowImpl;
import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;

import java.util.List;

@Table(database = ModuleDBFlowImpl.class)
public class ProgramDBEntity extends BaseModel {

    @Column
    @PrimaryKey
    private String idProgram;

    @Column
    private String nameProgram;

    @Column
    private String descriptionProgram;

    @Column
    private String idUser;

    @Column
    private boolean defaultProgram;

    @Column(typeConverter = StringListTypeConverter.class)
    private List exercisesList;

    public String getIdProgram() {
        return idProgram;
    }

    public void setIdProgram(String idProgram) {
        this.idProgram = idProgram;
    }

    public String getNameProgram() {
        return nameProgram;
    }

    public void setNameProgram(String nameProgram) {
        this.nameProgram = nameProgram;
    }

    public String getDescriptionProgram() {
        return descriptionProgram;
    }

    public void setDescriptionProgram(String descriptionProgram) {
        this.descriptionProgram = descriptionProgram;
    }

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public boolean isDefaultProgram() {
        return defaultProgram;
    }

    public void setDefaultProgram(boolean defaultProgram) {
        this.defaultProgram = defaultProgram;
    }

    public List getExercisesList() {
        return exercisesList;
    }

    public void setExercisesList(List exercisesList) {
        this.exercisesList = exercisesList;
    }
}
