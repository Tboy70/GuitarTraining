package com.example.data.entity;

import com.google.gson.annotations.SerializedName;

/**
 * Exercise entity mapping the JSON.
 */
// TODO : Rename Exercice to exercise in app and API and database !!
public class ExerciseEntity {

    @SerializedName("idExercice")
    private int idExercice;

    @SerializedName("durationExercice")
    private int durationExercice;

    @SerializedName("idProgram")
    private int idProgram;

    @SerializedName("typeExercice")
    private int typeExercice;

    public int getIdExercice() {
        return idExercice;
    }

    public void setIdExercice(int idExercice) {
        this.idExercice = idExercice;
    }

    public int getDurationExercice() {
        return durationExercice;
    }

    public void setDurationExercice(int durationExercice) {
        this.durationExercice = durationExercice;
    }

    public int getIdProgram() {
        return idProgram;
    }

    public void setIdProgram(int idProgram) {
        this.idProgram = idProgram;
    }

    public int getTypeExercice() {
        return typeExercice;
    }

    public void setTypeExercice(int typeExercice) {
        this.typeExercice = typeExercice;
    }
}
