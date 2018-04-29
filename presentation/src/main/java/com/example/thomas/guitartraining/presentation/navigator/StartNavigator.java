package com.example.thomas.guitartraining.presentation.navigator;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import com.example.thomas.guitartraining.R;
import com.example.thomas.guitartraining.di.PerActivity;
import com.example.thomas.guitartraining.presentation.activity.BaseActivity;
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

    private FragmentManager fragmentManager;

    @SuppressWarnings("WeakerAccess")
    @Inject
    public StartNavigator(BaseActivity activity, ErrorRendererComponent errorRendererComponent, FragmentManager fragmentManager) {
        super(activity, errorRendererComponent, R.id.activity_start_relative_layout);
        this.fragmentManager = fragmentManager;
    }

    /**
     * Launch the authentication mode fragment.
     *
     * @param activity The concerning activity.
     */
    public void launchAuthenticationModeChoiceFragment(Activity activity) {
        Fragment authenticationChoiceFragment = AuthenticationChoiceFragment.newInstance();
        fragmentManager.beginTransaction().add(R.id.activity_start_frame_layout, authenticationChoiceFragment).commit();
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
