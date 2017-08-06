package com.example.thomas.guitartraining.presentation.presenter.program;

import com.example.thomas.guitartraining.di.PerActivity;
import com.example.thomas.guitartraining.presentation.fragment.program.EndProgramFragment;
import com.example.thomas.guitartraining.presentation.activity.listener.ProgramNavigatorListener;
import com.example.thomas.guitartraining.presentation.view.program.EndProgramView;

import javax.inject.Inject;

/**
 * Created by Thomas on 09/05/2017.
 */

@PerActivity
public class EndProgramPresenter {

    @SuppressWarnings({"unused", "FieldCanBeLocal"})
    private EndProgramView endProgramView;
    private ProgramNavigatorListener programNavigatorListener;

    @SuppressWarnings("WeakerAccess")
    @Inject
    public EndProgramPresenter() {
    }

    public void setEndProgramView(EndProgramFragment endProgramView) {
        this.endProgramView = endProgramView;
    }

    public void setProgramNavigatorListener(ProgramNavigatorListener programNavigatorListener) {
        this.programNavigatorListener = programNavigatorListener;
    }

    public void setToolbar(String toolbarTitle) {
        programNavigatorListener.setProgramToolbar(toolbarTitle);
    }
}
