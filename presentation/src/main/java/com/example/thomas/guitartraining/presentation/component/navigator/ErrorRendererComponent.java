package com.example.thomas.guitartraining.presentation.component.navigator;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.TextView;

import com.example.thomas.guitartraining.di.PerActivity;
import com.example.thomas.guitartraining.presentation.utils.ErrorUtils;

import javax.inject.Inject;

@PerActivity
public class ErrorRendererComponent {

    public  static final int ERROR_DISPLAY_MODE_SNACKBAR = 1;

    private Activity activity;

    @Inject
    public ErrorRendererComponent(Activity activity) {
        this.activity = activity;
    }

    public void displayErrorInFragmentView(Throwable throwable, Context context, View view) {
        if (view != null) {
            Snackbar snackbar = Snackbar.make(view, ErrorUtils.translateException(context.getApplicationContext(), throwable), Snackbar.LENGTH_LONG);
            snackbar.setActionTextColor(Color.WHITE);
            snackbar.getView().setBackgroundColor(ContextCompat.getColor(context, android.R.color.holo_red_light));
            View yourSnackBarView = snackbar.getView();
            TextView textView = (TextView) yourSnackBarView.findViewById(android.support.design.R.id.snackbar_text);
            textView.setMaxLines(3);
            snackbar.show();
        }
        throwable.printStackTrace();
    }

    public void displayErrorInFragmentView(String error, Context context, View view) {
        if (view != null) {
            Snackbar snackbar = Snackbar.make(view, error, Snackbar.LENGTH_LONG);
            snackbar.setActionTextColor(Color.WHITE);
            snackbar.getView().setBackgroundColor(ContextCompat.getColor(context, android.R.color.holo_red_light));
            View yourSnackBarView = snackbar.getView();
            TextView textView = (TextView) yourSnackBarView.findViewById(android.support.design.R.id.snackbar_text);
            textView.setMaxLines(3);
            snackbar.show();
        }
    }
    public void displayError(Throwable throwable, Activity activity, int activityViewId) {
        Snackbar snackbar = Snackbar.make(activity.findViewById(activityViewId), ErrorUtils.translateException(activity.getApplicationContext(), throwable), Snackbar.LENGTH_LONG);
        snackbar.setActionTextColor(Color.WHITE);
        snackbar.getView().setBackgroundColor(ContextCompat.getColor(activity, android.R.color.holo_red_light));
        View yourSnackBarView = snackbar.getView();
        TextView textView = (TextView) yourSnackBarView.findViewById(android.support.design.R.id.snackbar_text);
        textView.setMaxLines(3);
        snackbar.show();
        throwable.printStackTrace();
    }

    public void displayErrorString(String error, Activity activity, int activityViewId) {
        Snackbar snackbar = Snackbar.make(activity.findViewById(activityViewId), error, Snackbar.LENGTH_LONG);
        snackbar.setActionTextColor(Color.WHITE);
        snackbar.getView().setBackgroundColor(ContextCompat.getColor(activity, android.R.color.holo_red_light));
        View yourSnackBarView = snackbar.getView();
        TextView textView = (TextView) yourSnackBarView.findViewById(android.support.design.R.id.snackbar_text);
        textView.setMaxLines(3);
        snackbar.show();
    }
}
