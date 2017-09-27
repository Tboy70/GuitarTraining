package com.example.model;

/**
 * Exercise model.
 */
public class Exercise {

    private String idExercise;
    private int durationExercise;
    private String idProgram;
    private int typeExercise;

    public Exercise(String idExercise, int durationExercise, String idProgram, int typeExercise) {
        this.idExercise = idExercise;
        this.durationExercise = durationExercise;
        this.idProgram = idProgram;
        this.typeExercise = typeExercise;
    }

    public Exercise() {}

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
