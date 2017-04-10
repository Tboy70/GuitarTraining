package com.example.thomas.guitartraining.presentation.navigator;

import android.app.Activity;
import android.app.Fragment;

import com.example.thomas.guitartraining.R;
import com.example.thomas.guitartraining.presentation.fragment.OfflineSessionChoiceFragment;

/**
 * Navigator for the offline activity.
 */
public class OfflineNavigator {

    public OfflineNavigator(){}

    public void launchOfflineProgramChoice(Activity activity) {
        Fragment offlineProgramChoiceFragment = OfflineSessionChoiceFragment.newInstance();
        //TODO : See this -> setContent() method in the right place.
        activity.setContentView(R.layout.activity_offline);
        activity.getFragmentManager().beginTransaction().add(R.id.offline_activity_frame_layout, offlineProgramChoiceFragment).commit();
    }
}
