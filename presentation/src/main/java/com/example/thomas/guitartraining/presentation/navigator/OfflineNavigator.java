package com.example.thomas.guitartraining.presentation.navigator;

import android.app.Activity;
import android.app.Fragment;

import com.example.thomas.guitartraining.R;
import com.example.thomas.guitartraining.presentation.fragment.OfflineProgramChoiceFragment;
import com.example.thomas.guitartraining.presentation.fragment.OfflineTheoreticalProgramFragment;

/**
 * Navigator for the offline activity.
 */
public class OfflineNavigator {

    public OfflineNavigator(){}

    public void launchOfflineProgramChoice(Activity activity) {
        Fragment offlineProgramChoiceFragment = OfflineProgramChoiceFragment.newInstance();
        //TODO : See this -> setContent() method in the right place.
        activity.setContentView(R.layout.activity_offline);
        activity.getFragmentManager().beginTransaction().add(R.id.offline_activity_frame_layout, offlineProgramChoiceFragment).commit();
    }

    public void launchOfflineTheoreticalProgram(Activity activity) {
        Fragment offlineTheoreticalProgram = OfflineTheoreticalProgramFragment.newInstance();
        activity.getFragmentManager().beginTransaction().add(R.id.offline_activity_frame_layout, offlineTheoreticalProgram).commit();
    }
}
