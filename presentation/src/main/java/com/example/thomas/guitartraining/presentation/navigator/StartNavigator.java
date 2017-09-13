package com.example.thomas.guitartraining.presentation.navigator;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;

import com.example.thomas.guitartraining.R;
import com.example.thomas.guitartraining.di.PerActivity;
import com.example.thomas.guitartraining.presentation.activity.NotConnectedActivity;
import com.example.thomas.guitartraining.presentation.activity.LoginActivity;
import com.example.thomas.guitartraining.presentation.component.navigator.ErrorRendererComponent;
import com.example.thomas.guitartraining.presentation.fragment.navigation.AuthenticationChoiceFragment;

import javax.inject.Inject;

/**
 * Navigator for the StartActivity.
 */
@PerActivity
public class StartNavigator extends BaseNavigator {

    @SuppressWarnings("WeakerAccess")
    @Inject
    public StartNavigator(Activity activity, ErrorRendererComponent errorRendererComponent) {
        super(activity, errorRendererComponent, R.id.activity_start_relative_layout);
    }

    /**
     * Launch the authentication mode fragment.
     *
     * @param activity The concerning activity.
     */
    public void launchAuthenticationModeChoiceFragment(Activity activity) {
        Fragment authenticationChoiceFragment = AuthenticationChoiceFragment.newInstance();
        activity.getFragmentManager().beginTransaction().add(R.id.activity_start_frame_layout, authenticationChoiceFragment).commit();
    }

    /**
     * Launch the not connected activity.
     *
     * @param activity Activity
     */
    public void launchNotConnectedActivity(Activity activity) {
        Intent toOfflineActivity = new Intent(activity, NotConnectedActivity.class);
        if (activity != null) {
            activity.startActivity(toOfflineActivity);
        }

        // To handle animations.
        if (activity != null) {
            activity.overridePendingTransition(R.anim.activity_in, R.anim.activity_out);
        }
    }

    public void launchLoginActivity(Activity activity) {
        Intent toLoginActivity = new Intent(activity, LoginActivity.class);
        if (activity != null) {
            activity.startActivity(toLoginActivity);
        }

        // To handle animations.
        if (activity != null) {
            activity.overridePendingTransition(R.anim.activity_in, R.anim.activity_out);
        }
    }
}
