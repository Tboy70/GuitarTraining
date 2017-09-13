package com.example.data.entity.remote;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Program remote entity mapping the JSON.
 */
public class ProgramRemoteEntity {

    @SerializedName("idProgram")
    private int idProgram;

    @SerializedName("nameProgram")
    private String nameProgram;

    @SerializedName("defaultProgram")
    private boolean defaultProgram;

    @SerializedName("idUser")
    private int idUser;

    @SerializedName("exercises")
    private List<ExerciseRemoteEntity> exerciseRemoteEntities;

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

    public List<ExerciseRemoteEntity> getExerciseRemoteEntities() {
        return exerciseRemoteEntities;
    }

    public void setExerciseRemoteEntities(List<ExerciseRemoteEntity> exerciseRemoteEntities) {
        this.exerciseRemoteEntities = exerciseRemoteEntities;
    }
}
