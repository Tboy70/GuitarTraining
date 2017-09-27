package com.example.thomas.guitartraining.presentation.navigator;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;

import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;
import com.example.thomas.guitartraining.R;
import com.example.thomas.guitartraining.presentation.activity.UserPanelActivity;
import com.example.thomas.guitartraining.presentation.activity.UserProgramActivity;
import com.example.thomas.guitartraining.presentation.component.navigator.ErrorRendererComponent;
import com.example.thomas.guitartraining.presentation.fragment.user.UserProgramsListFragment;
import com.example.thomas.guitartraining.presentation.fragment.user.UserSongsFragment;

import javax.inject.Inject;

public class UserPanelNavigator extends BaseNavigator {

    // TODO : Do the same for others activity ?
    private FragmentManager fragmentManager;

    @SuppressWarnings("WeakerAccess")
    @Inject
    public UserPanelNavigator(Activity activity, ErrorRendererComponent errorRendererComponent) {
        super(activity, errorRendererComponent, R.id.activity_main_relative_layout);
    }

    public void setFragmentManager(FragmentManager fragmentManager) {
        this.fragmentManager = fragmentManager;
    }

    public void onBackPressed() {
        if (fragmentManager.getBackStackEntryCount() == 0) {
            showOnBackPressedDialog();
        } else {
            if (getCurrentFragment() instanceof UserProgramsListFragment) {
                activity.setTitle(R.string.navigation_drawer_programs);
                ((UserPanelActivity) activity).enabledBurger(true);
            } else if (getCurrentFragment() instanceof UserSongsFragment) {
                activity.setTitle(R.string.navigation_drawer_songs);
                ((UserPanelActivity) activity).enabledBurger(true);
            }
            fragmentManager.popBackStack();
        }
    }

    public void displayUserProgramsFragment() {
        fragmentTransactionReplace(UserProgramsListFragment.newInstance());
    }

    public void displayUserSongsFragment() {
        fragmentTransactionReplace(UserSongsFragment.newInstance());
    }

    public void displayUserProgramDetails(String programId) {
        activity.startActivity(UserProgramActivity.newInstance(activity, UserProgramNavigator.FRAGMENT_USER_PROGRAM_DETAILS, programId));
    }

    public void displayUserProgramCreation(String instructionId) {
        activity.startActivity(UserProgramActivity.newInstance(activity, UserProgramNavigator.FRAGMENT_USER_PROGRAM_EDITION, instructionId));
    }

    private void showOnBackPressedDialog() {
        int buttonColor = ContextCompat.getColor(activity, R.color.colorPrimary);

        new MaterialDialog.Builder(activity)
                .content(R.string.generic_dialog_on_back_pressed)
                .positiveText(android.R.string.yes)
                .onPositive(new MaterialDialog.SingleButtonCallback() {
                    @Override
                    public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                        activity.finish();
                    }
                })
                .negativeText(android.R.string.no)
                .positiveColor(buttonColor)
                .negativeColor(buttonColor)
                .show();
    }

    private Fragment getCurrentFragment() {
        return activity.getFragmentManager().findFragmentById(R.id.activity_user_panel_frame_layout);
    }

    private void fragmentTransactionAdd(Fragment fragment) {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        fragmentTransaction.setCustomAnimations(R.animator.slide_in_left, R.animator.slide_out_right, R.animator.slide_in_right, R.animator.slide_out_left);

        fragmentTransaction.add(R.id.activity_user_panel_frame_layout, fragment, fragment.getTag());
        fragmentTransaction.addToBackStack(fragment.getTag());
        fragmentTransaction.commit();
    }

    private void fragmentTransactionReplace(Fragment fragment) {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        fragmentTransaction.replace(R.id.activity_user_panel_frame_layout, fragment, fragment.getTag());
        fragmentTransaction.commit();
    }
}
