package com.example.thomas.guitartraining.presentation.view.user;

import com.example.model.Program;

import java.util.List;

public interface UserProgramsListView {
    void displayProgramsList(List<Program> programs);

    void startRefresh();

    void stopRefresh();
}
