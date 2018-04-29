package com.example.thomas.guitartraining.presentation.activity;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.thomas.guitartraining.R;
import com.example.thomas.guitartraining.presentation.navigator.NotConnectedNavigator;
import com.example.thomas.guitartraining.presentation.presenter.activity.NotConnectedPresenter;
import com.example.thomas.guitartraining.presentation.activity.listener.NotConnectedNavigatorListener;

import javax.inject.Inject;

import butterknife.ButterKnife;

/**
 * Activity handling the offline mode.
 */
public class NotConnectedActivity extends BaseActivity implements NotConnectedNavigatorListener {

    @Inject
    NotConnectedPresenter notConnectedPresenter;
    @Inject
    NotConnectedNavigator notConnectedNavigator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_not_connected);
        ButterKnife.bind(this);
    }

    @Override
    protected void onStart() {
        super.onStart();

        launchDefaultProgramChoice();

        // TODO : Set toolbar.
        Toolbar toolbar = (Toolbar) findViewById(R.id.activity_not_connected_toolbar);
        toolbar.setTitle(getString(R.string.toolbar_title_not_connected_mode));
        toolbar.setTitleTextColor(ContextCompat.getColor(this, android.R.color.white));
        setSupportActionBar(toolbar);
    }

    @Override
    public void launchProgramActivity(int idProgram) {
        notConnectedNavigator.launchProgramActivity(this, idProgram);
    }

    @Override
    public void requestRenderError(Throwable e, int mode, View viewId) {
        // TODO ?
    }

    @Override
    public void requestRenderErrorString(String error, int mode, View viewId) {

    }

    private void launchDefaultProgramChoice() {
        notConnectedNavigator.launchDefaultProgramChoice(this);
    }
}
