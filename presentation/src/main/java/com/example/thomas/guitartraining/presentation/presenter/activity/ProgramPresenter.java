package com.example.thomas.guitartraining.presentation.presenter.activity;

import android.app.Activity;

import com.example.thomas.guitartraining.R;
import com.example.thomas.guitartraining.presentation.component.presenter.MaterialDialogComponent;
import com.example.thomas.guitartraining.presentation.navigator.BaseNavigatorListener;
import com.example.thomas.guitartraining.presentation.activity.listener.ProgramNavigatorListener;

import javax.inject.Inject;

public class ProgramPresenter {

    private MaterialDialogComponent materialDialogComponent;

    @SuppressWarnings({"unused", "FieldCanBeLocal"})
    private ProgramNavigatorListener programNavigatorListener;

    @SuppressWarnings("WeakerAccess")
    @Inject
    public ProgramPresenter(BaseNavigatorListener baseNavigatorListener, MaterialDialogComponent materialDialogComponent) {
        if (baseNavigatorListener instanceof ProgramNavigatorListener) {
            this.programNavigatorListener = (ProgramNavigatorListener) baseNavigatorListener;
        }
        this.materialDialogComponent = materialDialogComponent;
    }

    public void displayQuitProgramDialogFragment(Activity activity) {
        materialDialogComponent.showConfirmationDialog(
                activity,
                activity.getString(R.string.generic_dialog_title_attention),
                activity.getString(R.string.generic_dialog_quit_confirmation),
                R.color.colorPrimary);
    }
}
