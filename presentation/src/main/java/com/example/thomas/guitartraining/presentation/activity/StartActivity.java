package com.example.thomas.guitartraining.presentation.activity;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.model.Text;
import com.example.thomas.guitartraining.R;
import com.example.thomas.guitartraining.presentation.component.presenter.MaterialDialogComponent;
import com.example.thomas.guitartraining.presentation.navigator.StartNavigator;
import com.example.thomas.guitartraining.presentation.presenter.activity.StartPresenter;
import com.example.thomas.guitartraining.presentation.activity.listener.StartNavigatorListener;

import javax.inject.Inject;

import butterknife.ButterKnife;

/**
 * Main activity of the application.
 */
public class StartActivity extends BaseActivity implements StartNavigatorListener {

    @Inject
    StartPresenter startPresenter;

    @Inject
    StartNavigator startNavigator;

    private MaterialDialogComponent materialDialogComponent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        getActivityComponent().inject(this);
        ButterKnife.bind(this);
        injectParameters();
    }

    @Override
    protected void onStart() {
        super.onStart();

        launchAuthenticationModeChoice();

        Toolbar toolbar = (Toolbar) findViewById(R.id.activity_start_toolbar);
        toolbar.setTitle(getString(R.string.app_name));
        toolbar.setTitleTextColor(ContextCompat.getColor(this, android.R.color.white));
        setSupportActionBar(toolbar);
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
                startPresenter.getAppInfoText();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    /**
     * Launch the dialog fragment.
     *
     * @param text The text to be displayed by the dialog.
     */
    @Override
    public void callDialogFragment(Text text) {
        materialDialogComponent.showSingleDialog(
                this,
                getString(R.string.dialog_title_about),
                text.getContentText(),
                getString(R.string.dialog_fragment_lets_go),
                R.color.colorPrimary);
    }

    /**
     * Launch the offline activity -> Without connection.
     */
    @Override
    public void launchOfflineActivity() {
        startNavigator.launchOfflineActivity(this);
    }

    @Override
    public void launchOnlineActivity() {
        startNavigator.launchOnlineActivity(this);
    }

    @Override
    public void requestRenderError(Throwable e, int mode, View viewId) {}

    private void injectParameters() {
        this.materialDialogComponent = new MaterialDialogComponent(this);
    }

    /**
     * Launch the first screen of the application --> Connection or not connected mode.
     */
    private void launchAuthenticationModeChoice() {
        startNavigator.launchAuthenticationModeChoiceFragment(this);
    }
}
