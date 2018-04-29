package com.example.thomas.guitartraining.presentation.navigator;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import com.example.thomas.guitartraining.R;
import com.example.thomas.guitartraining.presentation.activity.BaseActivity;
import com.example.thomas.guitartraining.presentation.activity.ProgramActivity;
import com.example.thomas.guitartraining.presentation.component.navigator.ErrorRendererComponent;
import com.example.thomas.guitartraining.presentation.fragment.offline.NotConnectedProgramChoiceFragment;

import javax.inject.Inject;

/**
 * Navigator for the offline activity.
 */
public class NotConnectedNavigator extends BaseNavigator {

    public static final String ID_PROGRAM = "com.example.thomas.guitartraining.presentation.navigator.ID_PROGRAM";

    private FragmentManager fragmentManager;

    @SuppressWarnings("WeakerAccess")
    @Inject
    public NotConnectedNavigator(BaseActivity activity, ErrorRendererComponent errorRendererComponent, FragmentManager fragmentManager) {
        super(activity, errorRendererComponent, R.id.activity_offline_relative_layout);
        this.fragmentManager = fragmentManager;
    }

    public void launchDefaultProgramChoice(Activity activity) {
        Fragment offlineProgramChoiceFragment = NotConnectedProgramChoiceFragment.newInstance();
        fragmentManager.beginTransaction().add(R.id.activity_not_connected_frame_layout, offlineProgramChoiceFragment).commit();
    }

    public void launchProgramActivity(Activity activity, int idProgram) {
        Intent toProgramActivity = new Intent(activity, ProgramActivity.class)
                .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        toProgramActivity.putExtra(ID_PROGRAM, idProgram);
        if (activity != null) {
            activity.startActivity(toProgramActivity);
        }
    }
}
