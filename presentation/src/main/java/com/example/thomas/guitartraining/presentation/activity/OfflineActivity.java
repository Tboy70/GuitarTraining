package com.example.thomas.guitartraining.presentation.activity;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.Toolbar;

import com.example.thomas.guitartraining.R;
import com.example.thomas.guitartraining.presentation.navigator.OfflineNavigator;
import com.example.thomas.guitartraining.presentation.presenter.OfflinePresenter;
import com.example.thomas.guitartraining.presentation.view.OfflineNavigatorListener;

import javax.inject.Inject;

import butterknife.ButterKnife;

/**
 * Activity for the offline mode.
 */
public class OfflineActivity extends BaseActivity implements OfflineNavigatorListener {

    @Inject
    OfflinePresenter offlinePresenter;

    private OfflineNavigator offlineNavigator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getActivityComponent().inject(this);
        ButterKnife.bind(this);
        injectParameters();
    }

    private void injectParameters() {
        offlineNavigator = new OfflineNavigator();
    }

    @Override
    protected void onStart() {
        super.onStart();

        launchOfflineSessionChoice();

        // TODO : Set toolbar.
        Toolbar toolbar = (Toolbar) findViewById(R.id.offline_activity_toolbar);
        toolbar.setTitle(getString(R.string.offline_toolbar_title));
        toolbar.setTitleTextColor(ContextCompat.getColor(this, android.R.color.white));
        setSupportActionBar(toolbar);
    }

    /**
     * Launch the offline session choice fragment.
     */
    private void launchOfflineSessionChoice() {
        offlineNavigator.launchOfflineProgramChoice(this);
    }

    @Override
    public void launchOfflineTheoreticalProgram() {
        offlineNavigator.launchOfflineTheoreticalProgram(this);
    }
}
