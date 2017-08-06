package com.example.thomas.guitartraining.presentation.navigator;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;

import com.example.thomas.guitartraining.R;
import com.example.thomas.guitartraining.presentation.activity.ProgramActivity;
import com.example.thomas.guitartraining.presentation.component.navigator.ErrorRendererComponent;
import com.example.thomas.guitartraining.presentation.fragment.offline.OfflineProgramChoiceFragment;

import javax.inject.Inject;

/**
 * Navigator for the offline activity.
 */
public class OfflineNavigator extends BaseNavigator {

    public static final String ID_PROGRAM = "com.example.thomas.guitartraining.presentation.navigator.ID_PROGRAM";

    @Inject
    public OfflineNavigator(Activity activity, ErrorRendererComponent errorRendererComponent) {
        super(activity, errorRendererComponent, R.id.activity_offline_relative_layout);
    }

    public void launchOfflineProgramChoice(Activity activity) {
        Fragment offlineProgramChoiceFragment = OfflineProgramChoiceFragment.newInstance();
        activity.getFragmentManager().beginTransaction().add(R.id.activity_offline_frame_layout, offlineProgramChoiceFragment).commit();
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
