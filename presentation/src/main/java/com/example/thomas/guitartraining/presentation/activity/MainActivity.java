package com.example.thomas.guitartraining.presentation.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.example.thomas.guitartraining.GuitarTrainingApplication;
import com.example.thomas.guitartraining.R;
import com.example.thomas.guitartraining.di.component.ActivityComponent;
import com.example.thomas.guitartraining.di.component.ApplicationComponent;
import com.example.thomas.guitartraining.di.component.DaggerActivityComponent;
import com.example.thomas.guitartraining.di.module.ActivityModule;
import com.example.thomas.guitartraining.presentation.navigator.MainNavigator;
import com.example.thomas.guitartraining.presentation.view.MainNavigatorListener;

import butterknife.ButterKnife;

/**
 * Main activity of the application.
 */
public class MainActivity extends AppCompatActivity implements MainNavigatorListener {

    private ActivityComponent activityComponent;
    private MainNavigator mainNavigator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        injectParameters();
        this.initializeInjector();
    }

    private void injectParameters() {
        mainNavigator = new MainNavigator();
    }

    private void initializeInjector() {
        this.activityComponent = DaggerActivityComponent.builder()
                .applicationComponent(getApplicationComponent())
                .activityModule(getActivityModule())
                .build();
    }

    private ApplicationComponent getApplicationComponent() {
        GuitarTrainingApplication app = GuitarTrainingApplication.application();
        return app.getApplicationComponent();
    }

    private ActivityModule getActivityModule() {
        return new ActivityModule(this);
    }

    public ActivityComponent getActivityComponent() {
        return activityComponent;
    }

    @Override
    protected void onStart() {
        super.onStart();

        loadAuthentificationChoice();

        Toolbar toolbar = (Toolbar) findViewById(R.id.main_activity_toolbar);
        setSupportActionBar(toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_activity_menu_toolbar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.main_activity_toolbar_about_icon:

                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void loadListUsers() {
        mainNavigator.loadListUsers(this);
    }

    public void loadAuthentificationChoice() {
        mainNavigator.loadAuthentificationChoice(this);
    }
}
