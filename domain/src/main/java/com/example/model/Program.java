package com.example.model;

import java.util.List;

/**
 * Program model.
 */
public class Program {

    private int idProgram;
    private String nameProgram;
    private boolean defaultProgram;
    private int userId;  // TODO : Rename userId EVERYWHERE ! --> Make convention of naming.
    private List<Exercise> exercises;

    public Program(int idProgram, String nameProgram, boolean defaultProgram, int userId, List<Exercise> exercises) {
        this.idProgram = idProgram;
        this.nameProgram = nameProgram;
        this.defaultProgram = defaultProgram;
        this.userId = userId;
        this.exercises = exercises;
    }

    public Program() {
    }

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

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public List<Exercise> getExercises() {
        return exercises;
    }

    public void setExercises(List<Exercise> exercises) {
        this.exercises = exercises;
    }
}
