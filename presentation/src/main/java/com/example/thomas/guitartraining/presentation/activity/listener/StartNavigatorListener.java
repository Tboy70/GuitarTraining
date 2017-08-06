package com.example.thomas.guitartraining.presentation.activity.listener;

import com.example.model.Text;
import com.example.thomas.guitartraining.presentation.navigator.BaseNavigatorListener;

/**
 * Interface implemented by the StartActivity.
 */
public interface StartNavigatorListener extends BaseNavigatorListener{

    void callDialogFragment(Text text);

    void launchOfflineActivity();

    void launchOnlineActivity();
}
