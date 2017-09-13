package com.example.thomas.guitartraining.presentation.navigator;

import android.app.Activity;
import android.view.View;

import com.example.thomas.guitartraining.presentation.component.navigator.ErrorRendererComponent;

public abstract class BaseNavigator {

    protected Activity activity;
    private ErrorRendererComponent errorRendererComponent;
    private int activityViewId;

    BaseNavigator(Activity activity, ErrorRendererComponent errorRendererComponent, int activityViewId) {
        this.activity = activity;
        this.errorRendererComponent = errorRendererComponent;
        this.activityViewId = activityViewId;
    }

    public void renderError(Throwable throwable, int mode, View view) {
        if (mode == ErrorRendererComponent.ERROR_DISPLAY_MODE_SNACKBAR) {
            if (view != null) {
                errorRendererComponent.displayErrorInFragmentView(throwable, activity, view);
            } else {
                errorRendererComponent.displayError(throwable, activity, activityViewId);
            }
        }
    }
}