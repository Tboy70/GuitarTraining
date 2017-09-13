package com.example.model;

/**
 * Exercise model.
 */
public class Exercise {

    private int idExercise;
    private int durationExercise;
    private int idProgram;
    private int typeExercise;

    public Exercise(int idExercise, int durationExercise, int idProgram, int typeExercise) {
        this.idExercise = idExercise;
        this.durationExercise = durationExercise;
        this.idProgram = idProgram;
        this.typeExercise = typeExercise;
    }

    public Exercise() {}

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
