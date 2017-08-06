package com.example.thomas.guitartraining.presentation.navigator;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;

import com.example.thomas.guitartraining.R;
import com.example.thomas.guitartraining.di.PerActivity;
import com.example.thomas.guitartraining.presentation.activity.MainActivity;
import com.example.thomas.guitartraining.presentation.component.navigator.ErrorRendererComponent;
import com.example.thomas.guitartraining.presentation.fragment.user.LoginFragment;

import javax.inject.Inject;

@PerActivity
public class OnlineNavigator extends BaseNavigator {

    @Inject
    public OnlineNavigator(Activity activity, ErrorRendererComponent errorRendererComponent) {
        super(activity, errorRendererComponent, R.id.activity_online_relative_layout);
    }

    public void launchLoginScreen(Activity activity) {
        Fragment loginFragment = LoginFragment.newInstance();
        activity.getFragmentManager().beginTransaction().add(R.id.activity_online_frame_layout, loginFragment).commit();
    }

    public void launchMainActivity(Activity activity) {
        Intent toMainActivity = new Intent(activity, MainActivity.class);
        if (activity != null) {
            activity.startActivity(toMainActivity);
        }
    }
}
