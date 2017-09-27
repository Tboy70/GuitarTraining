package com.example.data.entity.remote;

import com.google.gson.annotations.SerializedName;

/**
 * Exercise remote entity mapping the JSON.
 */
public class ExerciseRemoteEntity {

    @SerializedName("idExercise")
    private String idExercise;

    @SerializedName("durationExercise")
    private int durationExercise;

    @SerializedName("idProgram")
    private String idProgram;

    @SerializedName("typeExercise")
    private int typeExercise;

    public String getIdExercise() {
        return idExercise;
    }

    public void setIdExercise(String idExercise) {
        this.idExercise = idExercise;
    }

    public int getDurationExercise() {
        return durationExercise;
    }

    public void setDurationExercise(int durationExercise) {
        this.durationExercise = durationExercise;
    }

    public String getIdProgram() {
        return idProgram;
    }

    public void setIdProgram(String idProgram) {
        this.idProgram = idProgram;
    }

    public int getTypeExercise() {
        return typeExercise;
    }

    public void setTypeExercise(int typeExercise) {
        this.typeExercise = typeExercise;
    }
}
