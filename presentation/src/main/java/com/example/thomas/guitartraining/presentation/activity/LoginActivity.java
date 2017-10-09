package com.example.thomas.guitartraining.presentation.activity;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.thomas.guitartraining.R;
import com.example.thomas.guitartraining.presentation.navigator.LoginNavigator;
import com.example.thomas.guitartraining.presentation.presenter.activity.LoginPresenter;
import com.example.thomas.guitartraining.presentation.activity.listener.LoginNavigatorListener;

import javax.inject.Inject;

import butterknife.ButterKnife;

public class LoginActivity extends BaseActivity implements LoginNavigatorListener {

    @Inject
    LoginPresenter loginPresenter;
    @Inject
    LoginNavigator loginNavigator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getActivityComponent().inject(this);
        ButterKnife.bind(this);
    }

    @Override
    protected void onStart() {
        super.onStart();

        launchConnectionScreen();

        // TODO : Set toolbar.
        Toolbar toolbar = (Toolbar) findViewById(R.id.activity_login_toolbar);
        toolbar.setTitle(getString(R.string.toolbar_title_online_mode));
        toolbar.setTitleTextColor(ContextCompat.getColor(this, android.R.color.white));
        setSupportActionBar(toolbar);
    }

    @Override
    public void launchUserPanelActivity() {
        loginNavigator.launchUserPanelActivity(this);
    }

    @Override
    public void requestRenderError(Throwable throwable, int mode, View viewId) {
        loginNavigator.renderError(throwable, mode, viewId);
    }

    @Override
    public void requestRenderErrorString(String error, int mode, View viewId) {

    }

    private void launchConnectionScreen() {
        loginNavigator.launchConnectionScreen(this);
    }
}
