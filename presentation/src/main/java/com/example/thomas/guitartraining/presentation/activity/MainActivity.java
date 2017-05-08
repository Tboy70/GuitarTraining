package com.example.thomas.guitartraining.presentation.activity;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.example.model.Text;
import com.example.thomas.guitartraining.R;
import com.example.thomas.guitartraining.presentation.navigator.MainNavigator;
import com.example.thomas.guitartraining.presentation.presenter.MainPresenter;
import com.example.thomas.guitartraining.presentation.view.MainNavigatorListener;

import javax.inject.Inject;

import butterknife.ButterKnife;

/**
 * Main activity of the application.
 */
public class MainActivity extends BaseActivity implements MainNavigatorListener {

    // Injection via dagger.
    @Inject MainPresenter mainPresenter;

    private MainNavigator mainNavigator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getActivityComponent().inject(this);    // IMPORTANT !
        ButterKnife.bind(this);
        injectParameters();
    }

    private void injectParameters() {
        // TODO : See to inject the navigator.
        mainNavigator = new MainNavigator(this);
    }

    @Override
    protected void onStart() {
        super.onStart();

        launchAuthenticationModeChoice();

        Toolbar toolbar = (Toolbar) findViewById(R.id.main_activity_toolbar);
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
                mainPresenter.getAppInfoText();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void loadListUsers() {
        mainNavigator.loadListUsersFragment(this);
    }

    /**
     * Launch the dialog fragment.
     * @param text The text to be displayed by the dialog.
     */
    @Override
    public void callDialogFragment(Text text) {
        mainNavigator.launchGenericDialogFragment(this, getString(R.string.dialog_fragment_title_about), text.getContentText());
    }

    /**
     * Launch the first screen of the application --> Connection or not connected mode.
     */
    public void launchAuthenticationModeChoice() {
        mainNavigator.launchAuthenticationModeChoiceFragment(this);
    }

    /**
     * Launch the offline activity -> Without connection.
     */
    @Override
    public void launchOfflineActivity() {
        mainNavigator.launchOfflineActivity();
    }
}
