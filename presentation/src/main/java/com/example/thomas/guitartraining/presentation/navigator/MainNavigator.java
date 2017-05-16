package com.example.thomas.guitartraining.presentation.navigator;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;

import com.example.thomas.guitartraining.R;
import com.example.thomas.guitartraining.presentation.activity.OfflineActivity;
import com.example.thomas.guitartraining.presentation.fragment.AuthenticationChoiceFragment;
import com.example.thomas.guitartraining.presentation.fragment.ui.GenericDialogFragment;
import com.example.thomas.guitartraining.presentation.fragment.user.ListUsersFragment;

/**
 * Navigator of the MainActivity.
 */
public class MainNavigator extends FragmentActivity {

    //    private final Activity activity;
//
//    // TODO : To be reviewed --> Problem in application class.
    public MainNavigator() {
    }

//    public MainNavigator(Activity activity) {
//        this.activity = activity;
//    }

    public void loadListUsersFragment(Activity activity) {
        Fragment listUsersFragment = ListUsersFragment.newInstance();

        activity.getFragmentManager().beginTransaction().add(R.id.main_activity_frame_layout, listUsersFragment).commit();
    }

    /**
     * Launch the authentication mode fragment.
     *
     * @param activity The concerning activity.
     */
    public void launchAuthenticationModeChoiceFragment(Activity activity) {
        Fragment authenticationChoiceFragment = AuthenticationChoiceFragment.newInstance();

        activity.setContentView(R.layout.activity_main);
        activity.getFragmentManager().beginTransaction().add(R.id.main_activity_frame_layout, authenticationChoiceFragment).commit();
    }

    /**
     * Launch a dialog fragment.
     *
     * @param activity      The concerning activity.
     * @param dialogTitle   The title of the dialog fragment.
     * @param dialogContent The content of the dialog fragment.
     */
    public void launchGenericDialogFragment(Activity activity, String dialogTitle, String dialogContent) {
        GenericDialogFragment genericDialogFragment = GenericDialogFragment.newInstance(dialogTitle, dialogContent, activity.getString(R.string.dialog_fragment_dismiss_button_text_about));
        genericDialogFragment.show(activity.getFragmentManager(), "DialogFragment");
    }

    /**
     * Launch the offline activity.
     *
     * @param activity Activity
     */
    public void launchOfflineActivity(Activity activity) {
        Intent toOfflineActivity = new Intent(activity, OfflineActivity.class);
        if (activity != null) {
            activity.startActivity(toOfflineActivity);
        }
        // TODO : Handle error (activity = null).

        // To handle animations.
        // TODO : See how is it done on Amiltone project.
        if (activity != null) {
            activity.overridePendingTransition(R.anim.activity_in, R.anim.activity_out);
        }
    }
}
