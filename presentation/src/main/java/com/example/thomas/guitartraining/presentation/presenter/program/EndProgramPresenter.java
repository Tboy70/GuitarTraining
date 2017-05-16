package com.example.thomas.guitartraining.presentation.presenter.program;

import com.example.thomas.guitartraining.di.PerActivity;
import com.example.thomas.guitartraining.presentation.fragment.program.EndProgramFragment;
import com.example.thomas.guitartraining.presentation.view.EndProgramView;
import com.example.thomas.guitartraining.presentation.view.ProgramNavigatorListener;

import javax.inject.Inject;

/**
 * Created by Thomas on 09/05/2017.
 */

@PerActivity
public class EndProgramPresenter {

    private EndProgramView endProgramView;
    private ProgramNavigatorListener programNavigatorListener;

    @Inject
    public EndProgramPresenter() {
    }

    public void setEndProgramView(EndProgramFragment endProgramView) {
        this.endProgramView = endProgramView;
    }

    public void setProgramNavigatorListener(ProgramNavigatorListener programNavigatorListener) {
        this.programNavigatorListener = programNavigatorListener;
    }
}
