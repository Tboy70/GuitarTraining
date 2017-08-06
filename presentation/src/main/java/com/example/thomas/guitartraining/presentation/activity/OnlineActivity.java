package com.example.thomas.guitartraining.presentation.activity;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.thomas.guitartraining.R;
import com.example.thomas.guitartraining.presentation.navigator.OnlineNavigator;
import com.example.thomas.guitartraining.presentation.presenter.activity.OnlinePresenter;
import com.example.thomas.guitartraining.presentation.activity.listener.OnlineNavigatorListener;

import javax.inject.Inject;

import butterknife.ButterKnife;

public class OnlineActivity extends BaseActivity implements OnlineNavigatorListener {

    @Inject
    OnlinePresenter onlinePresenter;

    @Inject
    OnlineNavigator onlineNavigator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_online);
        getActivityComponent().inject(this);
        ButterKnife.bind(this);
    }

    @Override
    protected void onStart() {
        super.onStart();

        launchLoginScreen();

        // TODO : Set toolbar.
        Toolbar toolbar = (Toolbar) findViewById(R.id.activity_online_toolbar);
        toolbar.setTitle(getString(R.string.toolbar_title_online_mode));
        toolbar.setTitleTextColor(ContextCompat.getColor(this, android.R.color.white));
        setSupportActionBar(toolbar);
    }

    @Override
    public void launchMainActivity() {
        onlineNavigator.launchMainActivity(this);
    }

    @Override
    public void requestRenderError(Throwable throwable, int mode, View viewId) {
        onlineNavigator.renderError(throwable, mode, viewId);
    }

    private void launchLoginScreen() {
        onlineNavigator.launchLoginScreen(this);
    }
}
