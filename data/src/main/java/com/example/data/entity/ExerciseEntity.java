package com.example.data.entity;

import com.google.gson.annotations.SerializedName;

/**
 * Exercise entity mapping the JSON.
 */
// TODO : Rename Exercice to exercise in API and database !!
public class ExerciseEntity {

    @SerializedName("idExercise")
    private int idExercise;

    @SerializedName("durationExercise")
    private int durationExercise;

    @SerializedName("idProgram")
    private int idProgram;

    @SerializedName("typeExercise")
    private int typeExercise;

    public int getIdExercise() {
        return idExercise;
    }

    public void setIdExercise(int idExercise) {
        this.idExercise = idExercise;
    }

    public int getDurationExercise() {
        return durationExercise;
    }

    public void setDurationExercise(int durationExercise) {
        this.durationExercise = durationExercise;
    }

    public int getIdProgram() {
        return idProgram;
    }

    public void setIdProgram(int idProgram) {
        this.idProgram = idProgram;
    }

    public int getTypeExercise() {
        return typeExercise;
    }

    public void setTypeExercise(int typeExercise) {
        this.typeExercise = typeExercise;
    }
}
