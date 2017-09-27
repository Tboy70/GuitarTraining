package com.example.model;

import java.util.List;

/**
 * Program model.
 */
public class Program {

    private String idProgram;
    private String nameProgram;
    private boolean defaultProgram;
    private String idUser;
    private List<Exercise> exercises;

    public Program(String idProgram, String nameProgram, boolean defaultProgram, String idUser, List<Exercise> exercises) {
        this.idProgram = idProgram;
        this.nameProgram = nameProgram;
        this.defaultProgram = defaultProgram;
        this.idUser = idUser;
        this.exercises = exercises;
    }

    public Program() {}

    public String getIdProgram() {
        return idProgram;
    }

    public void setIdProgram(String idProgram) {
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

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public List<Exercise> getExercises() {
        return exercises;
    }

    public void setExercises(List<Exercise> exercises) {
        this.exercises = exercises;
    }
}
