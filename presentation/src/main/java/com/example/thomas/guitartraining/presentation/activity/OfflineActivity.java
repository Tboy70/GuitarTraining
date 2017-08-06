package com.example.thomas.guitartraining.presentation.activity;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.thomas.guitartraining.R;
import com.example.thomas.guitartraining.presentation.navigator.OfflineNavigator;
import com.example.thomas.guitartraining.presentation.presenter.activity.OfflinePresenter;
import com.example.thomas.guitartraining.presentation.activity.listener.OfflineNavigatorListener;

import javax.inject.Inject;

import butterknife.ButterKnife;

/**
 * Activity handling the offline mode.
 */
public class OfflineActivity extends BaseActivity implements OfflineNavigatorListener {

    @Inject
    OfflinePresenter offlinePresenter;

    @Inject
    OfflineNavigator offlineNavigator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_offline);
        getActivityComponent().inject(this);
        ButterKnife.bind(this);
    }

    @Override
    protected void onStart() {
        super.onStart();

        launchOfflineSessionChoice();

        // TODO : Set toolbar.
        Toolbar toolbar = (Toolbar) findViewById(R.id.activity_offline_toolbar);
        toolbar.setTitle(getString(R.string.toolbar_title_offline_mode));
        toolbar.setTitleTextColor(ContextCompat.getColor(this, android.R.color.white));
        setSupportActionBar(toolbar);
    }

    @Override
    public void launchProgramActivity(int idProgram) {
        offlineNavigator.launchProgramActivity(this, idProgram);
    }

    @Override
    public void requestRenderError(Throwable e, int mode, View viewId) {}

    /**
     * Launch the offline session choice fragment.
     */
    private void launchOfflineSessionChoice() {
        offlineNavigator.launchOfflineProgramChoice(this);
    }
}
