package com.example.thomas.guitartraining.presentation.navigator;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;

import com.example.thomas.guitartraining.R;
import com.example.thomas.guitartraining.di.PerActivity;
import com.example.thomas.guitartraining.presentation.component.navigator.ErrorRendererComponent;
import com.example.thomas.guitartraining.presentation.fragment.user.UserProgramCreationFragment;
import com.example.thomas.guitartraining.presentation.fragment.user.UserProgramDetailsFragment;

import javax.inject.Inject;

@PerActivity
public class UserProgramNavigator extends BaseNavigator {

    public static final int FRAGMENT_USER_PROGRAM_DETAILS = 1;
    public static final int FRAGMENT_USER_PROGRAM_EDITION = 2;

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
        // TODO: 21/09/2017 Change title toolbar
        activity.setTitle("A CHANGER");
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

    private void fragmentTransactionReplace(Fragment fragment) {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        fragmentTransaction.replace(R.id.activity_user_program_frame_layout, fragment, fragment.getTag());
        fragmentTransaction.commit();
    }
}
