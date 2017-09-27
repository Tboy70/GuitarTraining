package com.example.thomas.guitartraining.presentation.fragment.ui.view.viewmodel;

import com.example.model.Program;

public class ProgramViewModel {

    private Program program;

    public ProgramViewModel(Program program) {
        this.program = program;
    }

    public Program getProgram() {
        return program;
    }
}
