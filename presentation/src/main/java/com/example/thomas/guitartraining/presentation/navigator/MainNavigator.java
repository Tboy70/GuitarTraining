package com.example.thomas.guitartraining.presentation.navigator;

import android.app.Activity;
import android.app.Fragment;
import android.support.v4.app.FragmentActivity;

import com.example.thomas.guitartraining.R;
import com.example.thomas.guitartraining.presentation.fragment.AuthentificationChoiceFragment;
import com.example.thomas.guitartraining.presentation.fragment.GenericDialogFragment;
import com.example.thomas.guitartraining.presentation.fragment.ListUsersFragment;

/**
 * Navigator of the MainActivity.
 */
public class MainNavigator extends FragmentActivity {

    public MainNavigator() {}

    public void loadListUsersFragment(Activity activity) {
        Fragment listUsersFragment = ListUsersFragment.newInstance();

        activity.getFragmentManager().beginTransaction().add(R.id.main_activity_frame_layout, listUsersFragment).commit();
    }

    /**
     * Launch the authentification mode fragment.
     * @param activity The concerning activity.
     */
    public void launchAuthentificationModeChoiceFragment(Activity activity) {
        Fragment authentificationChoiceFragment = AuthentificationChoiceFragment.newInstance();

        activity.setContentView(R.layout.activity_main);
        activity.getFragmentManager().beginTransaction().add(R.id.main_activity_frame_layout, authentificationChoiceFragment).commit();
    }

    /**
     * Launch a dialog fragment.
     * @param activity The concerning activity.
     * @param dialogTitle The title of the dialog fragment.
     * @param dialogContent The content of the dialog fragment.
     */
    public void launchGenericDialogFragment(Activity activity, String dialogTitle, String dialogContent) {
        GenericDialogFragment genericDialogFragment = GenericDialogFragment.newInstance(dialogTitle, dialogContent, activity.getString(R.string.dialog_fragment_dismiss_button_text_about));
        genericDialogFragment.show(activity.getFragmentManager(), "DialogFragment");
    }
}
