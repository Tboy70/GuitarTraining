package com.example.data.entity;

/**
 * Exercise entity.
 */
public class ExerciseEntity {

    private String idExercise;
    private int durationExercise;
    private String idProgram;
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
