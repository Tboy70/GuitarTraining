package com.example.data.entity;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Program entity mapping the JSON.
 */
public class ProgramEntity {

    @SerializedName("idProgram")
    private int idProgram;

    @SerializedName("nameProgram")
    private String nameProgram;

    @SerializedName("defaultProgram")
    private boolean defaultProgram;

    @SerializedName("userIdProgram")
    private int userIdProgram;

    @SerializedName("exercices")
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

    public int getUserIdProgram() {
        return userIdProgram;
    }

    public void setUserIdProgram(int userIdProgram) {
        this.userIdProgram = userIdProgram;
    }

    public List<ExerciseEntity> getExerciceEntities() {
        return exerciseEntities;
    }

    public void setExerciceEntities(List<ExerciseEntity> exerciseEntities) {
        this.exerciseEntities = exerciseEntities;
    }
}
