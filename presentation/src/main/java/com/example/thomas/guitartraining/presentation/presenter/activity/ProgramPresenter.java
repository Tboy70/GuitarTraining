package com.example.thomas.guitartraining.presentation.presenter.activity;

import com.example.thomas.guitartraining.presentation.view.ProgramNavigatorListener;

import javax.inject.Inject;

/**
 * Created by amiltonedev_lt043 on 08/05/2017.
 */

public class ProgramPresenter {

    private ProgramNavigatorListener programNavigatorListener;

    @Inject
    public ProgramPresenter(ProgramNavigatorListener programNavigatorListener) {
        this.programNavigatorListener = programNavigatorListener;
    }
}
