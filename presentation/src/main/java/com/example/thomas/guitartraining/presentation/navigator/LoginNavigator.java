package com.example.thomas.guitartraining.presentation.navigator;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import com.example.thomas.guitartraining.R;
import com.example.thomas.guitartraining.di.PerActivity;
import com.example.thomas.guitartraining.presentation.activity.BaseActivity;
import com.example.thomas.guitartraining.presentation.activity.UserPanelActivity;
import com.example.thomas.guitartraining.presentation.component.navigator.ErrorRendererComponent;
import com.example.thomas.guitartraining.presentation.fragment.user.ConnectionFragment;

import javax.inject.Inject;

@PerActivity
public class LoginNavigator extends BaseNavigator {

    private FragmentManager fragmentManager;

    @SuppressWarnings("WeakerAccess")
    @Inject
    public LoginNavigator(BaseActivity activity, ErrorRendererComponent errorRendererComponent, FragmentManager fragmentManager) {
        super(activity, errorRendererComponent, R.id.activity_online_relative_layout);
        this.fragmentManager = fragmentManager;
    }

    public void launchConnectionScreen(Activity activity) {
        Fragment connectionFragment = ConnectionFragment.newInstance();
        fragmentManager.beginTransaction().replace(R.id.activity_login_frame_layout, connectionFragment).commit();
    }

    public void launchUserPanelActivity(Activity activity) {
        Intent toUserPanelActivity = new Intent(activity, UserPanelActivity.class);
        if (activity != null) {
            activity.startActivity(toUserPanelActivity);
        }
    }
}
