package com.example.thomas.guitartraining.presentation.view.program;

import com.example.model.Program;
import com.example.model.Text;

/**
 * Created by Thomas on 08/05/2017.
 */

public interface IntroProgramView {
    void updateUISuccess(Program program, Text text);

    void updateUIError();
}
