package com.example.thomas.guitartraining.presentation.activity.listener;


import com.example.thomas.guitartraining.presentation.fragment.ui.view.viewmodel.ProgramViewModel;
import com.example.thomas.guitartraining.presentation.navigator.BaseNavigatorListener;

public interface UserProgramNavigatorListener extends BaseNavigatorListener {
    void requestDisplayProgramList();

    void launchProgram(String idProgram);

    void setUserProgramToolbar(String toolbarTitle);

    void displayUserProgramUpdate(ProgramViewModel programViewModel);
}
