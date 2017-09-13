package com.example.data.entity;

import java.util.List;

/**
 * Program entity.
 */
public class ProgramEntity {

    private int idProgram;
    private String nameProgram;
    private boolean defaultProgram;
    private int idUser;
    private List<ExerciseEntity> exerciseEntities;

    public int getIdProgram() {
        return idProgram;
    }

    public void setIdProgram(int idProgram) {
        this.idProgram = idProgram;
    }

    public String getNameProgram() {
        return nameProgram;
    }

    public void setNameProgram(String nameProgram) {
        this.nameProgram = nameProgram;
    }

    public boolean isDefaultProgram() {
        return defaultProgram;
    }

    public void setDefaultProgram(boolean defaultProgram) {
        this.defaultProgram = defaultProgram;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public List<ExerciseEntity> getExerciseEntities() {
        return exerciseEntities;
    }

    public void setExerciseEntities(List<ExerciseEntity> exerciseEntities) {
        this.exerciseEntities = exerciseEntities;
    }
}
