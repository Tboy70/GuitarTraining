package com.example.model;

import java.util.List;

/**
 * Program model.
 */
public class Program {

    private int idProgram;
    private String nameProgram;
    private boolean defaultProgram;
    private int userIdProgram;  // TODO : Rename userId EVERYWHERE ! --> Make convention of naming.
    private List<Exercise> exercises;

    public Program (int idProgram, String nameProgram, boolean defaultProgram, int userIdProgram, List<Exercise> exercises) {
        this.idProgram = idProgram;
        this.nameProgram = nameProgram;
        this.defaultProgram = defaultProgram;
        this.userIdProgram = userIdProgram;
        this.exercises = exercises;
    }

    public Program() {}

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

    public List<Exercise> getExercises() {
        return exercises;
    }

    public void setExercises(List<Exercise> exercises) {
        this.exercises = exercises;
    }
}
