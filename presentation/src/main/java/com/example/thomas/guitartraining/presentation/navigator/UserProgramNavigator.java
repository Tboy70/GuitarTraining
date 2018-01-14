package com.example.thomas.guitartraining.presentation.navigator;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;

import com.example.thomas.guitartraining.R;
import com.example.thomas.guitartraining.di.PerActivity;
import com.example.thomas.guitartraining.presentation.activity.ProgramActivity;
import com.example.thomas.guitartraining.presentation.component.navigator.ErrorRendererComponent;
import com.example.thomas.guitartraining.presentation.fragment.ui.view.viewmodel.ProgramViewModel;
import com.example.thomas.guitartraining.presentation.fragment.user.UserProgramCreationFragment;
import com.example.thomas.guitartraining.presentation.fragment.user.UserProgramDetailsFragment;
import com.example.thomas.guitartraining.presentation.fragment.user.UserProgramUpdateFragment;

import javax.inject.Inject;

@PerActivity
public class UserProgramNavigator extends BaseNavigator {

    public static final int FRAGMENT_USER_PROGRAM_DETAILS = 1;
    public static final int FRAGMENT_USER_PROGRAM_EDITION = 2;
    private static final String ID_PROGRAM = "com.example.thomas.guitartraining.presentation.navigator.ID_PROGRAM";

    private FragmentManager fragmentManager;

    @SuppressWarnings("WeakerAccess")
    @Inject
    public UserProgramNavigator(Activity activity, ErrorRendererComponent errorRendererComponent) {
        super(activity, errorRendererComponent, R.id.activity_user_program_relative_layout);
    }

    public void setFragmentManager(FragmentManager fragmentManager) {
        this.fragmentManager = fragmentManager;
    }

    public void displayProgramDetailsFragment(String programId) {
        fragmentTransactionReplace(UserProgramDetailsFragment.newInstance(programId));
        activity.setTitle(activity.getString(R.string.toolbar_title_details_program));
    }

    public void displayUserProgramEditionFragment(String programId) {
        if (programId == null) {
            activity.setTitle(activity.getString(R.string.toolbar_title_user_program_creation));
            fragmentTransactionReplace(UserProgramCreationFragment.newInstance());
        } else {
            activity.setTitle(activity.getString(R.string.toolbar_title_user_program_edition));
            // TODO: 23/09/2017 Do the edition fragment.
        }
    }

    public void restoreUserPanelActivity() {
        fragmentManager.popBackStack();
        activity.finish();
    }

    public void requestLaunchProgram(String idProgram) {
        Intent toProgramActivity = new Intent(activity, ProgramActivity.class)
                .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        toProgramActivity.putExtra(ID_PROGRAM, Integer.valueOf(idProgram));
        if (activity != null) {
            activity.startActivity(toProgramActivity);
        }
    }

    public void requestUserProgramUpdate(ProgramViewModel programViewModel) {
        fragmentTransactionReplace(UserProgramUpdateFragment.newInstance(programViewModel));
    }

    private void fragmentTransactionReplace(Fragment fragment) {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        fragmentTransaction.replace(R.id.activity_user_program_frame_layout, fragment, fragment.getTag());
        fragmentTransaction.commit();
    }
}
