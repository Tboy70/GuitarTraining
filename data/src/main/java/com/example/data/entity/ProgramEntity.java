package com.example.data.entity;

import java.util.List;

/**
 * Program entity.
 */
public class ProgramEntity {

    private String idProgram;
    private String nameProgram;
    private String descriptionProgram;
    private boolean defaultProgram;
    private String idUser;
    private List<ExerciseEntity> exerciseEntities;

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

    public boolean isDefaultProgram() {
        return defaultProgram;
    }

    public void setDefaultProgram(boolean defaultProgram) {
        this.defaultProgram = defaultProgram;
    }

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public List<ExerciseEntity> getExerciseEntities() {
        return exerciseEntities;
    }

    public void setExerciseEntities(List<ExerciseEntity> exerciseEntities) {
        this.exerciseEntities = exerciseEntities;
    }
}
