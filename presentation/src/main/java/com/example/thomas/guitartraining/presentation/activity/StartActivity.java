package com.example.thomas.guitartraining.presentation.activity;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.thomas.guitartraining.R;
import com.example.thomas.guitartraining.presentation.activity.listener.StartNavigatorListener;
import com.example.thomas.guitartraining.presentation.navigator.StartNavigator;
import com.example.thomas.guitartraining.presentation.presenter.activity.StartPresenter;

import javax.inject.Inject;

import butterknife.ButterKnife;

/**
 * First launched activity of the application ~= UserPanelActivity
 */
public class StartActivity extends BaseActivity implements StartNavigatorListener {

    @Inject
    StartPresenter startPresenter;
    @Inject
    StartNavigator startNavigator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        ButterKnife.bind(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        getUserPrefIsConnected();
        setToolbar();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_activity_menu_toolbar, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.main_activity_toolbar_about_icon:
                // TODO : Display info text.
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void launchLoginActivity() {
        startNavigator.launchLoginActivity(this);
    }

    @Override
    public void launchNotConnectedActivity() {
        startNavigator.launchNotConnectedActivity(this);
    }

    @Override
    public void launchRightScreen(String idUser) {
        if (idUser == null || idUser.isEmpty()) {
            startNavigator.launchLoginActivity(this);
        } else {
            startNavigator.launchUserPanelActivity(this);
        }
    }

    @Override
    public void requestRenderError(Throwable e, int mode, View viewId) {
    }

    @Override
    public void requestRenderErrorString(String error, int mode, View viewId) {

    }

    private void getUserPrefIsConnected() {
        startPresenter.getUserPrefIsConnected();
        startNavigator.launchAuthenticationModeChoiceFragment(this);
    }

    private void setToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.activity_start_toolbar);
        toolbar.setTitle(getString(R.string.app_name));
        toolbar.setTitleTextColor(ContextCompat.getColor(this, android.R.color.white));
        setSupportActionBar(toolbar);
    }
}
