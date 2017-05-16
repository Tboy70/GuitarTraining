package com.example.thomas.guitartraining.presentation.navigator;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;

import com.example.thomas.guitartraining.R;
import com.example.thomas.guitartraining.presentation.activity.ProgramActivity;
import com.example.thomas.guitartraining.presentation.fragment.OfflineProgramChoiceFragment;

/**
 * Navigator for the offline activity.
 */
public class OfflineNavigator {

    public static final String ID_PROGRAM = "com.example.thomas.guitartraining.presentation.navigator.ID_PROGRAM";

    public OfflineNavigator() {
    }

    public void launchOfflineProgramChoice(Activity activity) {
        Fragment offlineProgramChoiceFragment = OfflineProgramChoiceFragment.newInstance();
        //TODO : See this -> setContent() method in the right place.
        activity.setContentView(R.layout.activity_offline);
        activity.getFragmentManager().beginTransaction().add(R.id.offline_activity_frame_layout, offlineProgramChoiceFragment).commit();
    }

    public void launchProgramActivity(Activity activity, int idProgram) {
        Intent toProgramActivity = new Intent(activity, ProgramActivity.class);
        toProgramActivity.putExtra(ID_PROGRAM, idProgram);
        if (activity != null) {
            activity.startActivity(toProgramActivity);
        }
    }
}
