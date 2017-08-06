package com.example.model;

import java.util.List;

/**
 * Program model.
 */
public class Program {

    private int idProgram;
    private String nameProgram;
    private boolean defaultProgram;
    private int idUser;
    private List<Exercise> exercises;

    public Program(int idProgram, String nameProgram, boolean defaultProgram, int idUser, List<Exercise> exercises) {
        this.idProgram = idProgram;
        this.nameProgram = nameProgram;
        this.defaultProgram = defaultProgram;
        this.idUser = idUser;
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

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public List<Exercise> getExercises() {
        return exercises;
    }

    public void setExercises(List<Exercise> exercises) {
        this.exercises = exercises;
    }
}
