package com.example.thomas.guitartraining.presentation.fragment.ui.view.viewmodel;

import android.content.Context;

import com.example.model.Program;

public class ProgramViewModel {

    private Program program;
    private Context context;

    public ProgramViewModel(Program program, Context context) {
        this.program = program;
        this.context = context; 
    }

    public Program getProgram() {
        return program;
    }
}
