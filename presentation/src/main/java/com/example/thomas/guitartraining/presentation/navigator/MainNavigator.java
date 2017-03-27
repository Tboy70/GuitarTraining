package com.example.thomas.guitartraining.presentation.navigator;

import android.app.Activity;
import android.app.Fragment;
import android.support.v4.app.FragmentActivity;

import com.example.thomas.guitartraining.R;
import com.example.thomas.guitartraining.presentation.fragment.ListUsersFragment;
import com.example.thomas.guitartraining.presentation.fragment.AuthentificationChoiceFragment;

/**
 * Navigator of the MainActivity.
 */
public class MainNavigator extends FragmentActivity {

    public MainNavigator() {}

    public void loadListUsers(Activity activity) {
        Fragment listUsersFragment = ListUsersFragment.newInstance();

        activity.getFragmentManager().beginTransaction().add(R.id.fragmentLayout, listUsersFragment).commit();
    }

    public void loadAuthentificationChoice(Activity activity) {
        Fragment authentificationChoiceFragment = AuthentificationChoiceFragment.newInstance();

        activity.getFragmentManager().beginTransaction().add(R.id.fragmentLayout, authentificationChoiceFragment).commit();
    }
}
